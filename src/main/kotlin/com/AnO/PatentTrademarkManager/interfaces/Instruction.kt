package com.AnO.PatentTrademarkManager.intefaces

import com.AnO.PatentTrademarkManager.classes.Instructions.Patent
import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import java.util.*
import javax.persistence.*

@Entity
@JsonTypeInfo(use= JsonTypeInfo.Id.NAME, include= JsonTypeInfo.As.PROPERTY, property="type_id")
@JsonSubTypes(
        JsonSubTypes.Type(value = Patent::class, name ="patent"),)
abstract class Instruction(
        @Id @GeneratedValue open val id: UUID?=null,
        open val type_id:String?=null,
        @OneToMany(fetch = FetchType.LAZY, cascade = arrayOf(CascadeType.ALL))
        open val action_list: MutableList<Action>?=null)