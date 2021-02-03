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

        val renewal_due_date: LocalDateTime?=null,
        val application_no: String?=null,
        val cert_procurement_date: LocalDateTime?=null,
        val patent_registration_no: String?=null,
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