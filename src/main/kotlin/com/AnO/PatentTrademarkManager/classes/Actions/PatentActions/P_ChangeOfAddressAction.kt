package com.AnO.PatentTrademarkManager.classes.Actions.PatentActions

import com.AnO.PatentTrademarkManager.intefaces.Action
import com.fasterxml.jackson.annotation.JsonTypeName
import java.time.LocalDateTime
import java.util.*
import javax.persistence.Entity

@Entity
@JsonTypeName("change_of_address")
data class P_ChangeOfAddressAction(
        private val type_id:String?=null,
        override var instruction_ref: UUID?=null,

        val new_address_of_patentee: String?=null,
        val status_change_of_address: String?=null,
        val date_instruction: LocalDateTime?=null,
        val date_instruction_concluded: LocalDateTime?=null,
        val date_outgoing_abuja_schedule: LocalDateTime?=null,
        val date_incoming_abuja_schedule: LocalDateTime?=null,): Action()

/*
ChangeOfAddressAction {
change_of_address_instruction_date:
change_of_address_instruction_month:
new_address_of_patentee:
clerk_of_change_of_address:
status_change_of_address:
date_received_change_of_address_certificate:
}
*/