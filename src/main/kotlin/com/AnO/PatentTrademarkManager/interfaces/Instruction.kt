package com.AnO.PatentTrademarkManager.interfaces

import com.AnO.PatentTrademarkManager.classes.Image
import com.AnO.PatentTrademarkManager.classes.Profiles.Patent
import com.AnO.PatentTrademarkManager.classes.Profiles.Trademark
import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import java.util.*
import javax.persistence.*

@Entity
@JsonTypeInfo(use= JsonTypeInfo.Id.NAME, include= JsonTypeInfo.As.PROPERTY, property="type_id")
@JsonSubTypes(
        JsonSubTypes.Type(value = Patent::class, name ="patent"),
        JsonSubTypes.Type(value = Trademark::class, name ="trademark"),)
abstract class Instruction(
        @Id @GeneratedValue open val id: UUID?=null,
        open val type_id:String?=null,
        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = false)
        open val action_list: MutableList<Action>?= mutableListOf(),
        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = false)
        open val image_list: MutableList<Image>?=mutableListOf())