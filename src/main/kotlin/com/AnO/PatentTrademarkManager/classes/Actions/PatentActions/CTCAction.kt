package com.AnO.PatentTrademarkManager.classes.Actions.PatentActions

import com.AnO.PatentTrademarkManager.intefaces.Action
import com.fasterxml.jackson.annotation.JsonTypeName
import java.time.LocalDateTime
import javax.persistence.Entity

@Entity
@JsonTypeName("ctc")
class CTCAction(
        val application_no: String?=null,
        val ctc_required: String?=null,
        val date_applied_for_ctc: LocalDateTime?=null,
        val ctc_procurement_status: String?=null,
        val patent_registration_no: String?=null,
        val clerk_responsible: String?=null): Action()

/*
CTCAction {
application_no:
patent_registration_no:
ctc_required:
date_applied_for_ctc:
ctc_procurement_status:
clerk_responsible:
}
 */