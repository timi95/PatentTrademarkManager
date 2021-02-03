package com.AnO.PatentTrademarkManager.classes.Actions.PatentActions

import com.AnO.PatentTrademarkManager.intefaces.Action
import com.fasterxml.jackson.annotation.JsonTypeName
import java.time.LocalDateTime
import java.util.*
import javax.persistence.Entity

@Entity
@JsonTypeName("renewal")
data class P_RenewalAction(
        private val type_id: String?=null,
        override var instruction_ref: UUID?=null,

        val date_instruction: LocalDateTime?=null,
        val date_instruction_concluded: LocalDateTime?=null,
        val date_outgoing_abuja_schedule: LocalDateTime?=null,
        val date_incoming_abuja_schedule: LocalDateTime?=null,

//        val date_registration_instruction_received: LocalDateTime?=null,
//        val month_registration_instruction_received: String?=null,
//        val clerk_registration: String?=null,
//        val date_abuja_instructed_for_registration: LocalDateTime?=null,
//        val convention_priority_ref_1: String?=null,
//        val convention_priority_date_1: LocalDateTime?=null,
//        val convention_priority_ref_2: String?=null,
//        val convention_priority_date_2: LocalDateTime?=null,
//        val convention_priority_ref_3: String?=null,
//        val convention_priority_date_3: LocalDateTime?=null,
        val renewal_due_date: LocalDateTime?=null,

//        val PCT_ref_no: String?=null,
//        val PCT_filling_date: LocalDateTime?=null,
        val application_no: String?=null,
//        val patent_registration_filling_date: LocalDateTime?=null,
//        val registration_filling_month: String?=null,
//        val registration_status: String?=null,
//        val acknowledgement_status: String?=null,
//        val acceptance_date: LocalDateTime?=null,
        val cert_procurement_date: LocalDateTime?=null,
//        val cert_procurement_month: String?=null,
        val patent_registration_no: String?=null,
//        val correspondence_date: LocalDateTime?=null,
//        val date_of_instruction: LocalDateTime?=null,
//        val clients_contact_person: String?=null,
        val official_fee_renewal: String?=null): Action()

/*
RenewalAction {
date_registration_instruction_received:
month_registration_instruction_received:
clerk_registration:
date_abuja_instructed_for_registration:
convention_priority_ref_1:
convention_priority_date_1:
convention_priority_ref_2:
convention_priority_date_2:
convention_priority_ref_3:
convention_priority_date_3:
PCT_ref_no:
PCT_filling_date:
filling_deadline:
application_no:
patent_registration_filling_date:
registration_filling_month:
registration_status:
acknowledgement_status:
acceptance_date:
cert_procurement_date:
cert_procurement_month:
patent_registration_no:
correspondence_date:
date_of_instruction:
clients_contact_person:
official_fee_registration:
}
 */