package com.AnO.PatentTrademarkManager.classes

import java.time.LocalDateTime
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Reminder(@GeneratedValue @Id val id: UUID?=null,
                    val instruction_ref:UUID?=null,
                    val reminder_creation_time: LocalDateTime = LocalDateTime.now(),
                    val reminder_date_time: LocalDateTime?=null,
                    val is_matured: Boolean?=false,
                    val reminder_message_title:String?=null,
                    val reminder_message_body:String?=null)