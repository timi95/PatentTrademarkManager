package com.AnO.PatentTrademarkManager.classes.Actions

import com.AnO.PatentTrademarkManager.classes.Patent
import com.AnO.PatentTrademarkManager.intefaces.Action
import javax.persistence.*

@Entity
data class SearchAction(@Id @GeneratedValue val id: Long?=null,
        @ManyToOne val patent:Patent?=null): Action