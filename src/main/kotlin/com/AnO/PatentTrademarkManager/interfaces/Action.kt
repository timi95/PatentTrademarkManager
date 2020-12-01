package com.AnO.PatentTrademarkManager.intefaces

import com.AnO.PatentTrademarkManager.classes.Actions.SearchAction
import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import com.fasterxml.jackson.databind.annotation.JsonDeserialize

import javax.persistence.*


/*
this works for this type info structure
 {
"action": "search_action"
}*/
@Entity
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.PROPERTY, property="type_id")
@JsonSubTypes(
        JsonSubTypes.Type(value = SearchAction::class, name ="search_action"),)
abstract class Action(@Id @GeneratedValue open val id:Long?=null,
                      open val instruction_id: Long?=null)