package com.AnO.PatentTrademarkManager.services

import com.AnO.PatentTrademarkManager.classes.Reminder
import com.AnO.PatentTrademarkManager.repositories.ReminderRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import java.util.*

@Service
class ReminderService {
    @Autowired
    lateinit var reminderRepository: ReminderRepository

    private fun pageRequest(page: Int?,
                            size: Int?,
                            direction: Sort.Direction,
                            sort_property: String): PageRequest =
            PageRequest.of(page!!, size!!, Sort.by(direction, sort_property))

//    Reminder CRUD
    fun createReminder(reminder: Reminder): Reminder {
    try {
        return reminderRepository.save(reminder) }
        catch (e:Exception){throw(e)}
    }

    fun getReminders(page: Int? = 1,
                     size: Int? = 10,
                     direction: Sort.Direction,
                     sort_property: String): Page<Reminder> =
            try { reminderRepository.findAll(pageRequest(page, size, direction, sort_property))}
            catch (e:Exception){throw e}

    fun getReminder(id: UUID) =
            try { reminderRepository.findById(id).get() }
            catch (e:Exception){throw e}

    fun updateReminder(reminder: Reminder) =
            try { reminderRepository.save(reminder.copy(id = reminder.id)) }
            catch (e: Exception){throw e}

    fun deleteReminder(id: UUID) =
            try { reminderRepository.deleteById(id) }
            catch (e: Exception){ throw e}

}