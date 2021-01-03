package com.AnO.PatentTrademarkManager.controllers

import com.AnO.PatentTrademarkManager.classes.Reminder
import com.AnO.PatentTrademarkManager.services.ReminderService
import io.swagger.annotations.Api
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Sort
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import java.time.Duration
import java.time.LocalTime
import java.util.*


@Api(value = "Reminder",
        description = "Rest API for Reminders",
        tags = ["Reminder"])
@CrossOrigin(origins = arrayOf("http://localhost:4200"))
@RestController
@RequestMapping("/Reminder")
class ReminderController {
    @Autowired
    lateinit var reminderService: ReminderService

//    Reminder CRUD
    @PostMapping("/reminder")
    fun createReminder(@RequestBody reminder: Reminder) =
            reminderService.createReminder(reminder)

    @GetMapping("/reminder/{id}")
    fun getReminder(@PathVariable id: UUID) =
            reminderService.getReminder(id)

    @GetMapping("/reminder")
    fun getReminders(@RequestParam(defaultValue = "0") page:Int,
                     @RequestParam(defaultValue = "10") size:Int,
                     @RequestParam direction: Sort.Direction?,
                     @RequestParam(defaultValue = "id") sort_property:String?) =
            reminderService.getReminders(page, size, direction=Sort.DEFAULT_DIRECTION, sort_property="id")

    @PutMapping("/reminder/{id}")
    fun updateReminder(@PathVariable id: UUID, @RequestBody reminder: Reminder) =
            reminderService.updateReminder(id, reminder)

    @DeleteMapping("/reminder/{id}")
    fun deleteReminder(@PathVariable id: UUID) =
            reminderService.deleteReminder(id)

    @GetMapping("/reminder-sse")
    fun remindersEvent() =
            reminderService.remindersEvent()


}