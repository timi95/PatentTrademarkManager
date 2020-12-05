package com.AnO.PatentTrademarkManager.classes.Actions.TrademarkActions

import com.AnO.PatentTrademarkManager.intefaces.Action
import com.fasterxml.jackson.annotation.JsonTypeName
import java.time.LocalDateTime
import javax.persistence.Entity

@Entity
@JsonTypeName("reclassification")
data class ReclassificationAction(

        val date_reclassification_instruction: LocalDateTime?=null,
        val date_abj_instructed_reclassify: LocalDateTime?=null,
        val reclassification_status: String?=null,
        val date_publication_of_reclassification: LocalDateTime?=null,
        val journal_pg_reclassification: String?=null,): Action()

/*
T_reclassification_action:any = {
    date_reclassification_instruction:
    date_abj_instructed_reclassify:
    reclassification_status:
    date_publication_of_reclassification:
    journal_pg_reclassification:
};
 */