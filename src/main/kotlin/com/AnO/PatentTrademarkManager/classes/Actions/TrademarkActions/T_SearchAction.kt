package com.AnO.PatentTrademarkManager.classes.Actions.TrademarkActions

import com.AnO.PatentTrademarkManager.intefaces.Action
import java.time.LocalDateTime

data class T_SearchAction(
        val date_instruction: LocalDateTime?=null,
        val date_instruction_concluded: LocalDateTime?=null,
        val date_outgoing_abuja_schedule: LocalDateTime?=null,
        val date_incoming_abuja_schedule: LocalDateTime?=null,

//        val clerk_searching: String?=null,
        val conflicting_mark: String?=null,
        val date_of_search_report: LocalDateTime?=null,
//        val date_reported_to_client: LocalDateTime?=null,
        val official_search_fee: String?=null,
//        val reported_to_client: String?=null,
//        val search_instruction_date: LocalDateTime?=null,
        val search_status: String?=null,
        val search_type: String?=null,): Action()

/*
T_search_action:any = {
    clerk_searching:
    conflicting_mark:
    date_of_search_report:
    date_reported_to_client:
    official_search_fee:
    reported_to_client:
    search_instruction_date:
    search_status:
    search_type:
};
 */