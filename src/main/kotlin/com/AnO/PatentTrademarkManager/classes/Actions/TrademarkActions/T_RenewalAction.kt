package com.AnO.PatentTrademarkManager.classes.Actions.TrademarkActions

import com.AnO.PatentTrademarkManager.interfaces.Action
import com.fasterxml.jackson.annotation.JsonTypeName
import java.time.LocalDateTime
import java.util.*
import javax.persistence.Entity

@Entity
@JsonTypeName("renewal")
data class T_RenewalAction(
        private val type_id:String?=null,
        override var instruction_ref: UUID?=null,

        val date_instruction: LocalDateTime?=null,
        val date_instruction_concluded: LocalDateTime?=null,
        val date_outgoing_abuja_schedule: LocalDateTime?=null,
        val date_incoming_abuja_schedule: LocalDateTime?=null,

        val official_fee_renewal: String?=null,
        val renewal_due_date: LocalDateTime?=null,
        val renewal_status: String?=null): Action()