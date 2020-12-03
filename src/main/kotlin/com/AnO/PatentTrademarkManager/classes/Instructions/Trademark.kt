package com.AnO.PatentTrademarkManager.classes.Instructions

import com.AnO.PatentTrademarkManager.intefaces.Action
import com.AnO.PatentTrademarkManager.intefaces.Instruction
import java.util.*
import javax.persistence.*

@Entity
data class Trademark(
        @Id @GeneratedValue override val id: UUID?=null,
        override val type_id:String?=null,
        @OneToMany(fetch = FetchType.LAZY, cascade = arrayOf(CascadeType.ALL))
        override val action_list: MutableList<Action>?=null):Instruction()