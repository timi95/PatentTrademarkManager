package com.AnO.PatentTrademarkManager.classes.Actions

import com.AnO.PatentTrademarkManager.classes.Patent
import com.AnO.PatentTrademarkManager.intefaces.Action
import com.fasterxml.jackson.annotation.JsonTypeName
import javax.persistence.*

@Entity
@JsonTypeName("search_action")
data class SearchAction(override val instruction_id:Long?=null): Action()