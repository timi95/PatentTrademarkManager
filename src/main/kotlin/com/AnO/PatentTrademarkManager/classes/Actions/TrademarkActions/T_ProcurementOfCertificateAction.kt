package com.AnO.PatentTrademarkManager.classes.Actions.TrademarkActions

import com.AnO.PatentTrademarkManager.intefaces.Action
import com.fasterxml.jackson.annotation.JsonTypeName
import java.time.LocalDateTime
import javax.persistence.Entity

@Entity
@JsonTypeName("procurement_of_certificate")
data class T_ProcurementOfCertificateAction(

        val date_instruction: LocalDateTime?=null,
        val date_instruction_concluded: LocalDateTime?=null,
        val date_outgoing_abuja_schedule: LocalDateTime?=null,
        val date_incoming_abuja_schedule: LocalDateTime?=null,

        val application_no: String?=null,
        val trademark_description:String?=null,
        val journal_no:String?=null,
        val journal_vol:String?=null,
        val journal_date:LocalDateTime?=null,
        val journal_page:String?=null,
        val cert_procurement_status:String?=null,
        val date_of_registration_certificate:LocalDateTime?=null,
        val registration_no:String?=null,
        val official_fee_certificate_issuance:String?=null): Action()
