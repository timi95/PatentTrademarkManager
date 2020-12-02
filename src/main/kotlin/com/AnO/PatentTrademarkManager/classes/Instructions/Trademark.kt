package com.AnO.PatentTrademarkManager.classes.Instructions

import com.AnO.PatentTrademarkManager.intefaces.Instruction
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Trademark(@Id @GeneratedValue override val id:Long):Instruction()