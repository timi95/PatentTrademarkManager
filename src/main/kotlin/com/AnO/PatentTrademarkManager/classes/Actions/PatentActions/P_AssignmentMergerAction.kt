package com.AnO.PatentTrademarkManager.classes.Actions.PatentActions

import com.AnO.PatentTrademarkManager.intefaces.Action
import com.fasterxml.jackson.annotation.JsonTypeName
import java.time.LocalDateTime
import java.util.*
import javax.persistence.Entity

@Entity
@JsonTypeName("assignment_merger")
data class P_AssignmentMergerAction(
        private val type_id:String?=null,
        override var instruction_ref: UUID?=null,

        val date_instruction: LocalDateTime?=null,
        val date_instruction_concluded: LocalDateTime?=null,
        val date_outgoing_abuja_schedule: LocalDateTime?=null,
        val date_incoming_abuja_schedule: LocalDateTime?=null,
        val status_assignment_registrations:String?=null,
        val assignor:String?=null,
        val assignor_address:String?=null,
        val assignee:String?=null,
        val assignee_address:String?=null,
        val official_fee_assignment:String?=null, ): Action()

/*
AssignmentMergerAction {
assignment_instruction_date:
assignment_instruction_month:
date_abuja_instructed_assignment:
clerk_assignment:
status_assignment_registrations:
assignor:
assignor_address:
assignee:
assignee_address:
date_assignment_certificate_received:
}


 */