package com.AnO.PatentTrademarkManager.intefaces

import javax.persistence.*

@Entity
abstract class Instruction(@Id @GeneratedValue open val id:Long?=null)