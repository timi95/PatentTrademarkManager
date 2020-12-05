package com.AnO.PatentTrademarkManager.classes.Actions.TrademarkActions

import com.AnO.PatentTrademarkManager.intefaces.Action
import com.fasterxml.jackson.annotation.JsonTypeName
import java.time.LocalDateTime
import javax.persistence.Entity

@Entity
@JsonTypeName("registration")
data class RegistrationAction(

        val acceptance_date: LocalDateTime?=null,
        val acceptance_facilitation_sent: String?=null,
        val acknowledgement_date: LocalDateTime?=null,
        val acknowledgement_facilitation_sent: String?=null,
        val application_no: String?=null,
        val trademark_class: String?=null,
        val clerk_registering: String?=null,
        val colour_limitation: String?=null,
        val date_acceptance_facilitation_sent: LocalDateTime?=null,
        val date_acknowledgement_facilitation_sent: LocalDateTime?=null,
        val date_of_registration_instruction: LocalDateTime?=null,
        val date_of_registration_instruction_received: LocalDateTime?=null,
        val date_registration_cert_facilitation_sent: LocalDateTime?=null,
        val date_sent_for_publication: LocalDateTime?=null,
        val date_abj_instructed_for_registration: LocalDateTime?=null,
        val goods: String?=null,
        val journal_date: LocalDateTime?=null,
        val journal_no: String?=null,
        val journal_page: String?=null,
        val journal_vol: String?=null,
        val official_fee_registration: String?=null,
        val publication: String?=null,
        val registration_status: String?=null,
        val registration_filing_month: String?=null,
        val registration_no: String?=null,
        val registraion_cert_facilitation_sent: String?=null,
        val tm_registration_filing_date: LocalDateTime?=null ): Action()

/*
T_registration_action:any = {
    acceptance_date:
    acceptance_facilitation_sent:
    acknowledgement_date:
    acknowledgement_facilitation_sent:
    application_no:
    trademark_class:
    clerk_registering:
    colour_limitation:
    date_acceptance_facilitation_sent:
    date_acknowledgement_facilitation_sent:
    date_of_registration_instruction:
    date_of_registration_instruction_received:
    date_registration_cert_facilitation_sent:
    date_sent_for_publication:
    date_abj_instructed_for_registration:
    goods:
    journal_date:
    journal_no:
    journal_page:
    journal_vol:
    official_fee_registration:
    publication:
    registration_status:
    registration_filing_month:
    registration_no:
    registraion_cert_facilitation_sent:
    tm_registration_filing_date: ""
};
 */