package com.AnO.PatentTrademarkManager.classes

import com.AnO.PatentTrademarkManager.intefaces.Action
import com.AnO.PatentTrademarkManager.intefaces.Instruction
import java.time.LocalDateTime
import javax.persistence.Entity


/*
* our_reference_number:
client_id:
clients_reference_number:
curent_instruction:
date_of_instruction:
name_of_client:
clients_address:
clients_contact_person:
name_of_patentee:
patentees_address:
date_instruction_received:
lawyer_responsible:
invention_description:
patent_registration_number:
convention_country:
current_status:*/
@Entity
data class Patent(
    val id:Int,

    val our_reference_number: String,
    val client_id:String,
    val clients_reference_number:String,
    val curent_instruction:String,
    val date_of_instruction: LocalDateTime,
    val name_of_client:String,
    val clients_address: String,
    val clients_contact_person:String,
    val name_of_patentee:String,
    val patentees_address:String,
    val date_instruction_received: LocalDateTime,
    val lawyer_responsible:String,
    val invention_description:String,
    val patent_registration_number:String,
    val convention_country:String,
    val current_status:String,
    val certificate_procurement_due_date:LocalDateTime,
    val month_certificate_procurement_due:String,
    val date_outgoing_abuja_schedule:LocalDateTime,
    val date_incoming_abuja_schedule:LocalDateTime,
    val date_completed_job_received: LocalDateTime,
    val official_fee: String,
    val facilitation: String,
    val incentive_due_clerk: String,
    val clerk_responsible: String,
    val month_incoming_abuja_schedule: String,
    val month_outgoing_abuja_schedule: String,
    val filing_receipt_status: String,
    val applicable_service_charge: String,
    val quickteller_fee: String ):Instruction