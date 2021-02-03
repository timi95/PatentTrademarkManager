package com.AnO.PatentTrademarkManager.classes.Actions.TrademarkActions

import com.AnO.PatentTrademarkManager.intefaces.Action
import com.fasterxml.jackson.annotation.JsonTypeName
import java.time.LocalDateTime
import javax.persistence.Entity

@Entity
@JsonTypeName("reclassification")
data class T_ReclassificationAction(

        val date_instruction: LocalDateTime?=null,
        val date_instruction_concluded: LocalDateTime?=null,
        val date_outgoing_abuja_schedule: LocalDateTime?=null,
        val date_incoming_abuja_schedule: LocalDateTime?=null,

        val reclassification_status: String?=null,
        val journal_no:String?=null,
        val journal_vol:String?=null,
        val journal_date:LocalDateTime?=null,
        val journal_page:String?=null,): Action()
