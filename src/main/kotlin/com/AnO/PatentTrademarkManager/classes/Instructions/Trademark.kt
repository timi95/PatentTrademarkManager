package com.AnO.PatentTrademarkManager.classes.Instructions

import com.AnO.PatentTrademarkManager.intefaces.Action
import com.AnO.PatentTrademarkManager.intefaces.Instruction
import com.fasterxml.jackson.annotation.JsonTypeName
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Entity
@JsonTypeName("trademark")
data class Trademark(
        @Id @GeneratedValue override val id: UUID?=null,
        override val type_id:String?=null,

        val applicable_official_fee: LocalDateTime?=null,
        val applicable_service_charge: String?=null,
        val trademark_class: String?=null,
        val clerk_responsible: String?=null,
        val clients_email_address: String?=null,
        val clients_id: String?=null,
        val clients_address: String?=null,
        val clients_contact_person: String?=null,
        val client_ref_no: String?=null,
        val correspondence_date:LocalDateTime?=null,
        val current_instruction: String?=null,
        val current_status: String?=null,
        val date_instruction_received: LocalDateTime?=null,
        val date_current_instruction: LocalDateTime?=null,
        val date_completed_job_received: LocalDateTime?=null,
        val date_incoming_abj_schedule: LocalDateTime?=null,
        val date_outgoing_abj_schedule: LocalDateTime?=null,
        val filing_receipt: String?=null,
        val goods: String?=null,
        val incentive_due_clerk: String?=null,
        val lawyer_responsible: String?=null,
        val month_incoming_schedule: String?=null,
        val month_outgoing_schedule: String?=null,
        val name_of_client: String?=null,
        val name_of_proprietor: String?=null,
        val official_fee_ctc: String?=null,
        val official_fee_late_renewal_penalty: String?=null,
        val official_fee_merger: String?=null,
        val official_fee_registered_user: String?=null,
        val our_ref_no: String?=null,
        val proprietors_address: String?=null,
        val quicktellers_fee: String?=null,
        val registration_no: String?=null,
        val trademark_description: String?=null,

        @OneToMany(fetch = FetchType.LAZY, cascade = arrayOf(CascadeType.ALL))
        override val action_list: MutableList<Action>?=null):Instruction()

/*
T_profile:any = {
    applicable_official_fee:
    applicable_service_charge:
    trademark_class:
    clerk_responsible:
    clients_email_address:
    clients_id:
    clients_address:
    clients_contact_person:
    client_ref_no:
    correspondence_date:
    current_instruction:
    current_status:
    date_instruction_received:
    date_current_instruction:
    date_completed_job_received:
    date_incoming_abj_schedule:
    date_outgoing_abj_schedule:
    filing_receipt:
    goods:
    incentive_due_clerk:
    lawyer_responsible:
    month_incoming_schedule:
    month_outgoing_schedule:
    name_of_client:
    name_of_proprietor:
    official_fee_ctc:
    official_fee_late_renewal_penalty:
    official_fee_merger:
    official_fee_registered_user:
    our_ref_no:
    proprietors_address:
    quicktellers_fee:
    registration_no:
    trademark_description:
};
 */