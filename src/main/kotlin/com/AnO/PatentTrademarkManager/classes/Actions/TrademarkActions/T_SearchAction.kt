package com.AnO.PatentTrademarkManager.classes.Actions.TrademarkActions

import com.AnO.PatentTrademarkManager.intefaces.Action
import java.time.LocalDateTime

data class T_SearchAction(
        val date_instruction: LocalDateTime?=null,
        val date_instruction_concluded: LocalDateTime?=null,
        val date_outgoing_abuja_schedule: LocalDateTime?=null,
        val date_incoming_abuja_schedule: LocalDateTime?=null,

        val conflicting_mark: String?=null,
        val date_of_search_report: LocalDateTime?=null,
        val official_search_fee: String?=null,
        val search_status: String?=null,
        val search_type: String?=null,): Action()