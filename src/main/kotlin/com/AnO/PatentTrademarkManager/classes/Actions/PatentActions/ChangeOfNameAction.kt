package com.AnO.PatentTrademarkManager.classes.Actions.PatentActions

import com.AnO.PatentTrademarkManager.intefaces.Action
import com.fasterxml.jackson.annotation.JsonTypeName
import java.time.LocalDateTime
import java.util.*
import javax.persistence.Entity

@Entity
@JsonTypeName("change_of_name")
data class ChangeOfNameAction(
        private val type_id:String?=null,
        override var instruction_ref: UUID?=null,

        val change_of_name_instruction_date: LocalDateTime?=null,
        val change_of_name_instruction_month: String?=null,
        val new_name_of_patentee: String?=null,
        val clerk_for_change_of_name: String?=null,
        val status_of_change_of_name: String?=null,
        val date_received_change_of_name_certificate: LocalDateTime?=null): Action()

/*
ChangeOfNameAction {
change_of_name_instruction_date:
change_of_name_instruction_month:
new_name_of_patentee:
clerk_for_change_of_name:
status_of_change_of_name:
date_received_change_of_name_certificate:
}
*/