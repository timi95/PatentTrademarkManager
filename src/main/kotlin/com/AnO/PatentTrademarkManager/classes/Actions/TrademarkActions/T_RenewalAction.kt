package com.AnO.PatentTrademarkManager.classes.Actions.TrademarkActions

import com.AnO.PatentTrademarkManager.intefaces.Action
import com.fasterxml.jackson.annotation.JsonTypeName
import java.time.LocalDateTime
import javax.persistence.Entity

@Entity
@JsonTypeName("renewal")
data class T_RenewalAction(

        val date_instruction: LocalDateTime?=null,
        val date_instruction_concluded: LocalDateTime?=null,
        val date_outgoing_abuja_schedule: LocalDateTime?=null,
        val date_incoming_abuja_schedule: LocalDateTime?=null,

//        val date_renewal_cert_facilitation_sent: LocalDateTime?=null,
//        val date_abj_instructed_renewal: LocalDateTime?=null,
//        val date_renew_cert_received: LocalDateTime?=null,
//        val next_renewal_due_date: LocalDateTime?=null,
//        val next_renewal_due_month: String?=null,
        val official_fee_renewal: String?=null,
//        val renewal_cert_facilitation_sent: String?=null,
        val renewal_due_date: LocalDateTime?=null,
//        val renewal_due_month: String?=null,
//        val renewal_instruction_date: LocalDateTime?=null,
//        val renewal_instruction_month: String?=null,
        val renewal_status: String?=null): Action()

/*
T_renewal_action:any = {
    date_renewal_cert_facilitation_sent:
    dt_abj_instructed_renewal:
    dt_renew_cert_received:
    next_renewal_due_date:
    next_renewal_due_month:
    official_fee_renewal:
    renewal_cert_facilitation_sent:
    renewal_due_date:
    renewal_due_month:
    renewal_instruction_date:
    renewal_instruction_month:
    renewal_status:
};
 */