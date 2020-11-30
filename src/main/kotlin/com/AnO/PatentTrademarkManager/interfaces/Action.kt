package com.AnO.PatentTrademarkManager.intefaces

import javax.persistence.*

@Entity
abstract class Action(@Id @GeneratedValue open val id:Long?=null)