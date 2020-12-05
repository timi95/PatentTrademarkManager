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

/*
T_profile:any = {
    "applicable_official_fee":
    "applicable_service_charge":
    "trademark_class":
    "clerk_responsible":
    "clients_email_address":
    "clients_id":
    "clients_address":
    "clients_contact_person":
    "client_ref_no":
    "correspondence_date":
    "current_instruction":
    "current_status":
    "date_instruction_received":
    "date_current_instruction":
    "date_completed_job_received":
    "date_incoming_abj_schedule":
    "date_outgoing_abj_schedule":
    "filing_receipt":
    "goods":
    "incentive_due_clerk":
    "lawyer_responsible":
    "month_incoming_schedule":
    "month_outgoing_schedule":
    "name_of_client":
    "name_of_proprietor":
    "official_fee_ctc":
    "official_fee_late_renewal_penalty":
    "official_fee_merger":
    "official_fee_registered_user":
    "our_ref_no":
    "proprietors_address":
    "quicktellers_fee":
    "registration_no":
    "trademark_description":
};
 */