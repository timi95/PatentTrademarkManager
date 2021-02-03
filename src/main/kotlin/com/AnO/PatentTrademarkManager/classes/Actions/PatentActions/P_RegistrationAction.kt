package com.AnO.PatentTrademarkManager.classes.Actions.PatentActions

import com.AnO.PatentTrademarkManager.intefaces.Action
import com.fasterxml.jackson.annotation.JsonTypeName
import java.time.LocalDateTime
import java.util.*
import javax.persistence.Entity

@Entity
@JsonTypeName("registration")
data class P_RegistrationAction(
        private val type_id: String?=null,
        override var instruction_ref: UUID?=null,

        val date_instruction: LocalDateTime?=null,
        val date_instruction_concluded: LocalDateTime?=null,
        val date_outgoing_abuja_schedule: LocalDateTime?=null,
        val date_incoming_abuja_schedule: LocalDateTime?=null,

        val convention_priority_ref_1: String?=null,
        val convention_priority_date_1: LocalDateTime?=null,
        val convention_priority_ref_2: String?=null,
        val convention_priority_date_2: LocalDateTime?=null,
        val convention_priority_ref_3: String?=null,
        val convention_priority_date_3: LocalDateTime?=null,
        val PCT_ref_no: String?=null,
        val PCT_filing_date: LocalDateTime?=null,
        val filling_deadline_date: LocalDateTime?=null,
        val application_no: String?=null,
        val patent_registration_filing_date: LocalDateTime?=null,
        val registration_status: String?=null,
        val acknowledgement_status: String?=null,
        val acceptance_date: LocalDateTime?=null,
        val cert_procurement_date: LocalDateTime?=null,
        val patent_registration_no: String?=null,
        val official_fee_registration: String?=null,): Action()
