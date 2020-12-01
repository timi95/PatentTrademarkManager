package com.AnO.PatentTrademarkManager.intefaces

import com.AnO.PatentTrademarkManager.classes.Patent
import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import javax.persistence.*

@Entity
@JsonTypeInfo(use= JsonTypeInfo.Id.NAME, include= JsonTypeInfo.As.PROPERTY, property="type_id")
@JsonSubTypes(
        JsonSubTypes.Type(value = Patent::class, name ="patent"),)
abstract class Instruction(@Id @GeneratedValue open val id:Long?=null)