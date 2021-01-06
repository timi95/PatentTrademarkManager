package com.AnO.PatentTrademarkManager.services

import com.AnO.PatentTrademarkManager.classes.Reminder
import com.AnO.PatentTrademarkManager.classes.Utility.Utility.pageRequest
import com.AnO.PatentTrademarkManager.repositories.ReminderRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Sort
import org.springframework.http.codec.ServerSentEvent
import org.springframework.scheduling.annotation.Async
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter
import reactor.core.publisher.Flux
import reactor.core.publisher.toMono
import java.io.IOException
import java.time.Duration
import java.time.LocalDateTime
import java.time.LocalTime
import java.util.*
import javax.xml.bind.JAXBElement


@Service
@EnableScheduling
class ReminderService {

    var emitters: MutableList<SseEmitter> = mutableListOf()
    @Autowired
    lateinit var reminderRepository: ReminderRepository

//    Reminder CRUD
    fun createReminder(reminder: Reminder): Reminder {
    try {
        return reminderRepository.save(reminder) }
        catch (e: Exception){throw(e)}
    }

    fun getReminders(page: Int? = 1,
                     size: Int? = 10,
                     direction: Sort.Direction,
                     sort_property: String): Page<Reminder> =
            try { reminderRepository.findAll(pageRequest(page, size, direction, sort_property))}
            catch (e: Exception){throw e}

    fun getReminder(id: UUID) =
            try { reminderRepository.findById(id).get() }
            catch (e: Exception){throw e}

    fun updateReminder(id: UUID, reminder: Reminder) =
            try { reminderRepository.save(reminder.copy(id = id)) }
            catch (e: Exception){throw e}

    fun deleteReminder(id: UUID) =
            try { reminderRepository.deleteById(id) }
            catch (e: Exception){ throw e}


    //Streams

    fun remindersEvent(): Flux<ServerSentEvent<List<Reminder>>>? {
        return Flux.interval(Duration.ofSeconds(5))
                .map { sequence: Long ->
                    remindersMatured()
                    ServerSentEvent.builder<List<Reminder>>()
                            .id(sequence.toString())
                            .event("periodic-event")
                            .data(reminderRepository.findAll())
                            .build()
                }
    }

    private fun remindersMatured(){
        reminderRepository.findAll().map {
            if(!it.is_matured!! || it.reminder_date_time!!.isBefore(LocalDateTime.now())){
                reminderRepository.save(it.copy(is_matured = true))
            }
        }
    }

    companion object {
        val subscribers: MutableSet<SseEmitter> = hashSetOf()
    }
    fun subscribe(subscriber: SseEmitter): SseEmitter {
        subscribers.add(subscriber)
        println("subscription called! $subscriber")
        return subscriber
    }

    fun notifySubscribers(reminder: Reminder) {
        try {
            subscribers.forEach { subscriber ->
                subscriber.send(reminder)
                subscriber.onError { error ->
                    println("Seems the subscriber has already dropped out. Remove it from the list")
                    subscriber.completeWithError(error)
                    subscribers.remove(subscriber)
                }
            }
        } catch (ioException: IOException) { throw  ioException }
    }

    @Async
    @Scheduled(fixedRate = 1500)
    fun checkReminders(){
        val reminders = reminderRepository.findAll()
        reminders.forEach {
            if (LocalDateTime.now().isAfter(it.reminder_date_time) && !it.is_matured!!){
                notifySubscribers(it)
                println("matured reminders notified! ${it.reminder_date_time}")
                reminderRepository.save(it.copy(is_matured = true))
                println("matured reminders saved!")
            }
        }
    }
}