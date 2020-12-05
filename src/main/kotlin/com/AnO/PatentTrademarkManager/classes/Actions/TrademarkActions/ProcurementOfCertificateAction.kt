package com.AnO.PatentTrademarkManager.classes.Actions.TrademarkActions

import com.AnO.PatentTrademarkManager.intefaces.Action
import com.fasterxml.jackson.annotation.JsonTypeName
import java.time.LocalDateTime
import javax.persistence.Entity

@Entity
@JsonTypeName("procurement_of_certificate")
data class ProcurementOfCertificateAction(
        val date_procurement_instructed: LocalDateTime?=null,
        val application_no: String?=null,
        val trademark_description:String?=null,
        val journal_no:String?=null,
        val journal_vol:String?=null,
        val journal_date:LocalDateTime?=null,
        val journal_page:String?=null,
        val date_clerk_instructed_to_procure:LocalDateTime?=null,
        val cert_procurement_status:String?=null,
        val date_registration_certificate:LocalDateTime?=null,
        val registration_no:String?=null,
        val official_fee_certificate_issuance:String?=null): Action()

/*
T_certificate_procurement_action:any = {
date_procurement_instructed:
application_no:
trademark_description:
journal_no:
journal_vol:
journal_date:
journal_page:
date_clerk_instructed_to_procure:
cert_procurement_status:
date_registration_certificate:
registration_no:
official_fee_certificate_issuance:
};
 */