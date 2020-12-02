package com.AnO.PatentTrademarkManager.classes.Actions.PatentActions

import com.AnO.PatentTrademarkManager.intefaces.Action
import com.fasterxml.jackson.annotation.JsonTypeName
import java.time.LocalDateTime
import javax.persistence.Entity

@Entity
@JsonTypeName("search_action")
data class AmendmentAction(
        val type_id:String?="amendment_action",
        val date_amendment_instruction_received: LocalDateTime?=null,
        val nature_of_amendment:String?=null,
        val amending_clerk:String?=null,
        val date_amending_clerk_instructed:LocalDateTime?=null,
        val status_of_amendment:String?=null,
        val date_amendment_received: LocalDateTime?=null): Action()