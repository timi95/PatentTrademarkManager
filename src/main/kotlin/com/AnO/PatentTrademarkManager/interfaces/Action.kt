package com.AnO.PatentTrademarkManager.intefaces

import com.AnO.PatentTrademarkManager.classes.Actions.PatentActions.P_SearchAction
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
        JsonSubTypes.Type(value = P_SearchAction::class, name ="search_action"),)
abstract class Action(@Id @GeneratedValue open val id:UUID?=null,
                      open var instruction_ref: UUID?=null,
                      @ManyToOne(cascade = arrayOf(CascadeType.ALL))
                      @JoinColumn(name = "patent_id")
                      val patent: Patent?=null)

/* concrete action types

Patents








Trademark





*/