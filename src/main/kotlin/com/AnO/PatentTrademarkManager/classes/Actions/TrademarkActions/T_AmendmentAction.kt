package com.AnO.PatentTrademarkManager.classes.Actions.TrademarkActions

import com.AnO.PatentTrademarkManager.intefaces.Action
import com.fasterxml.jackson.annotation.JsonTypeName
import java.time.LocalDateTime
import java.util.*
import javax.persistence.Entity

@Entity
@JsonTypeName("amendment")
data class T_AmendmentAction(
        private val type_id:String?=null,
        override var instruction_ref: UUID?=null,

        val date_instruction: LocalDateTime?=null,
        val date_instruction_concluded: LocalDateTime?=null,
        val date_outgoing_abuja_schedule: LocalDateTime?=null,
        val date_incoming_abuja_schedule: LocalDateTime?=null,

//        val date_amendment_instruction_received: LocalDateTime?=null,
        val nature_of_amendment:String?=null,
//        val amending_clerk:String?=null,
//        val date_amending_clerk_instructed: LocalDateTime?=null,
        val status_of_amendment:String?=null,
//        val date_amendment_received: LocalDateTime?=null
): Action()

/*
T_amendment_action:any = {
        amendment_instruction_date:
        date_amendment_instruction_received:
        nature_of_amendment:
        date_amending_clerk_instructed:
        status_of_amendment:
        date_amendment_received: ""
};
 */