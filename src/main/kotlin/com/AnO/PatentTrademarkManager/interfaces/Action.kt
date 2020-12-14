package com.AnO.PatentTrademarkManager.intefaces

import com.AnO.PatentTrademarkManager.classes.Actions.PatentActions.*
import com.AnO.PatentTrademarkManager.classes.Instructions.Patent
import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import java.util.*

import javax.persistence.*


/*
this works for this type info structure
 {
"action": "search_action"
}*/
@Entity
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.PROPERTY, property="type_id")
@JsonSubTypes(
        JsonSubTypes.Type(value = P_SearchAction::class, name ="P_search_action"),
        JsonSubTypes.Type(value = P_AssignmentMergerAction::class, name ="P_assignment_merger"),
        JsonSubTypes.Type(value = P_AmendmentAction::class, name ="P_amendment_action"),
        JsonSubTypes.Type(value = P_CTCAction::class, name ="P_ctc"),
        JsonSubTypes.Type(value = P_RenewalAction::class, name ="P_renewal"),)
abstract class Action(@Id @GeneratedValue open val id:UUID?=null,
                      open var instruction_ref: UUID?=null,
                      @ManyToOne(cascade = arrayOf(CascadeType.ALL))
                      @JoinColumn(name = "patent_id")
                      val patent: Patent?=null)

/* concrete action types

Patents








Trademark





*/