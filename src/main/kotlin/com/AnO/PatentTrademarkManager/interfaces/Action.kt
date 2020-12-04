package com.AnO.PatentTrademarkManager.intefaces

import com.AnO.PatentTrademarkManager.classes.Actions.PatentActions.SearchAction
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
        JsonSubTypes.Type(value = SearchAction::class, name ="search_action"),)
abstract class Action(@Id @GeneratedValue open val id:UUID?=null, open var instruction_ref: UUID?=null)

/* concrete action types

Patents








Trademark

T_amendment_action:any = {
        ammendement_instruction_date:
        date_ammendement_instruction_received:
        nature_of_amendment:
        date_amending_clerk_instructed:
        status_of_amendment:
        date_amendment_received: ""
};
T_assignment_merger_action: any = {
    assignment_instruction_date:
    assignment_instruction_month:
    assignee:
    assignee_address:
    assignor:
    assignor_address:
    clerk_assigning:
    date_abuja_instructed_assignment:
    date_assignment_certificate_received:
    date_facillitation_assignment_cert_sent:
    date_facillitation_assignment_cert_sent_sent:
    official_fee_assignment:
    status_assignment_registrations:
}
T_certificate_procurement_action:any = {
    date_procurement_instructed:
    application_no:
    trademark_description:
    journal_no:
    journal_vol:
    journal_date:
    journal_page:
    date_clerk_instructed_to_procure:
    cert_procurement_status:
    date_registration_certificate:
    registration_no:
    official_fee_certificate_issuance:
  };
T_change_name_address_action:any = {
    change_of_address_instruction_date: '',
    change_of_name_instruction_date: '',
    date_received_change_of_address_certificate: '',
    date_received_change_of_name_certificate: '',
    new_address_of_pptr:
    new_name_of_pptr:
    official_fee_change_name:
    official_fee_change_address:
    status_change_of_name:
    status_change_of_address:
};
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
T_reclassification_action:any = {
    date_reclassification_instruction:
    date_abj_instructed_reclassify:
    reclassification_status:
    date_publication_of_reclassification:
    journal_pg_reclassification:
};
T_registration_action:any = {
    acceptance_date:
    acceptance_facilitation_sent:
    acknowledgement_date:
    acknowledgement_facilitation_sent:
    application_no:
    trademark_class:
    clerk_registering:
    colour_limitation:
    date_acceptance_facilitation_sent:
    date_acknowledgement_facilitation_sent:
    date_of_registration_instruction:
    date_of_registration_instruction_received:
    date_registration_cert_facilitation_sent:
    date_sent_for_publication:
    date_abj_instructed_for_registration:
    goods:
    journal_date:
    journal_no:
    journal_page:
    journal_vol:
    official_fee_registration:
    publication:
    registration_status:
    registration_filing_month:
    registration_no:
    registraion_cert_facilitation_sent:
    tm_registration_filing_date: ""
};
T_renewal_action:any = {
    date_renewal_cert_facilitation_sent:
    dt_abj_instructed_renewal:
    dt_renew_cert_received:
    next_renewal_due_date:
    next_renewal_due_month:
    official_fee_renewal:
    renewal_cert_facilitation_sent:
    renewal_due_date:
    renewal_due_month:
    renewal_instruction_date:
    renewal_instruction_month:
    renewal_status:
};
T_search_action:any = {
    clerk_searching:
    conflicting_mark:
    date_of_search_report:
    date_reported_to_client:
    official_search_fee:
    reported_to_client:
    search_instruction_date:
    search_status:
    search_type:
};

*/