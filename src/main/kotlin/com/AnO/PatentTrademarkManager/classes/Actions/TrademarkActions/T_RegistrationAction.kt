package com.AnO.PatentTrademarkManager.classes.Actions.TrademarkActions

import com.AnO.PatentTrademarkManager.interfaces.Action
import com.fasterxml.jackson.annotation.JsonTypeName
import java.time.LocalDateTime
import java.util.*
import javax.persistence.Entity

@Entity
@JsonTypeName("registration")
data class T_RegistrationAction(
        private val type_id:String?=null,
        override var instruction_ref: UUID?=null,

        val date_instruction: LocalDateTime?=null,
        val date_instruction_concluded: LocalDateTime?=null,
        val date_outgoing_abuja_schedule: LocalDateTime?=null,
        val date_incoming_abuja_schedule: LocalDateTime?=null,

        val acceptance_date: LocalDateTime?=null,
        val acknowledgement_date: LocalDateTime?=null,
        val application_no: String?=null,
        val trademark_class: String?=null,
        val colour_limitation: String?=null,
        val date_sent_for_publication: LocalDateTime?=null,
        val goods: String?=null,
        val journal_date: LocalDateTime?=null,
        val journal_no: String?=null,
        val journal_page: String?=null,
        val journal_vol: String?=null,
        val official_fee_registration: String?=null,
        val registration_status: String?=null,
        val registration_no: String?=null,
        val registration_filing_date: LocalDateTime?=null,
        val trademark_description: String?=null,): Action()