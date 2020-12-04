package com.AnO.PatentTrademarkManager.classes.Actions.PatentActions

import com.AnO.PatentTrademarkManager.intefaces.Action
import com.fasterxml.jackson.annotation.JsonTypeName
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Entity
@JsonTypeName("search")
data class SearchAction(
        private val type_id: String?=null,
        override var instruction_ref: UUID?=null,

        val search_status: String?=null,
        val reported_to_client: String?=null,
        val date_reported_to_client: LocalDateTime?=null,
        val clerk_searching: String?=null): Action()


/*
SearchAction {
search_status:
reported_to_client:
date_reported_to_client:
clerk_searching:
}
*/