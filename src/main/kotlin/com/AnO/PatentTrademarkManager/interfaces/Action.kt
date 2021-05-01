package com.AnO.PatentTrademarkManager.interfaces

import com.AnO.PatentTrademarkManager.classes.Actions.PatentActions.*
import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import java.util.*

import javax.persistence.*


/*
this works for this type info structure
 {
"action": "search_action"
}*/
@Entity
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.PROPERTY, property="type_id")
@JsonSubTypes(
        JsonSubTypes.Type(value = P_SearchAction::class, name ="search"),
        JsonSubTypes.Type(value = P_RenewalAction::class, name ="renewal"),
        JsonSubTypes.Type(value = P_RegistrationAction::class, name ="registration"),
        JsonSubTypes.Type(value = P_ProcurementOfCertificateAction::class, name ="procurement"),
        JsonSubTypes.Type(value = P_CTCAction::class, name ="ctc"),
        JsonSubTypes.Type(value = P_ChangeOfNameAction::class, name ="change-name"),
        JsonSubTypes.Type(value = P_ChangeOfAddressAction::class, name ="change-address"),
        JsonSubTypes.Type(value = P_AssignmentMergerAction::class, name ="assignment-merger"),
        JsonSubTypes.Type(value = P_AmendmentAction::class, name ="amendment"),)
abstract class Action(@Id @GeneratedValue open val id:UUID?=null,
                      open var instruction_ref: UUID?=null)

/* concrete action types

Patent Action Types

    'search',
    'renewal',
    'registration',
    'procurement',
    'ctc',
    'change-name',
    'change-address',
    'assignment-merger',
    "amendment",

Trademark Action Types





*/