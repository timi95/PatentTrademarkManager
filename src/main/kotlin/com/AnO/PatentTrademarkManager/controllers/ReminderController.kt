package com.AnO.PatentTrademarkManager.controllers

import com.AnO.PatentTrademarkManager.services.ReminderService
import io.swagger.annotations.Api
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


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

}