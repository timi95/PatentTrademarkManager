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
import org.springframework.stereotype.Service
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter
import reactor.core.publisher.Flux
import java.time.Duration
import java.time.LocalDateTime
import java.time.LocalTime
import java.util.*
import javax.xml.bind.JAXBElement


@Service
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

    private fun remindersMatured(): List<Reminder> {
        var maturedReminders = mutableListOf<Reminder>()
        GlobalScope.launch {
            reminderRepository.findAll().forEach {
                if(!it.is_matured!! && it.reminder_date_time!!.isBefore(LocalDateTime.now())){
                    maturedReminders.add(reminderRepository.save(it.copy(is_matured = true)))
                } }
        }

        return maturedReminders
    }

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

    fun subscribeEvent(): SseEmitter {
        val emitter = SseEmitter(Long.MAX_VALUE)
        try {
            emitter.send{SseEmitter.event().name("INIT")}
        } catch (e: Exception){
            throw e
            emitter.onError{ emitters.remove(emitter) }
        }
        emitter.onCompletion{ emitters.remove(emitter) }
        emitter.onTimeout { emitters.remove(emitter) }
        emitters.add(emitter)
        return emitter
    }

    fun dispatchEvent(reminder: Reminder){
        emitters.forEach {
            try {
              it.send{SseEmitter.event()
                      .name("reminder-event")
                      .data(reminder)}
            } catch (e: Exception){
                throw e
                emitters.remove(it)
            }
        }
    }

    fun reminderAnalysis(){
        while (true){

        }
    }
}