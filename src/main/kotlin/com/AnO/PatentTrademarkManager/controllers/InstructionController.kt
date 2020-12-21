package com.AnO.PatentTrademarkManager.controllers


import com.AnO.PatentTrademarkManager.classes.Actions.PatentActions.*
import com.AnO.PatentTrademarkManager.classes.Instructions.Patent
import com.AnO.PatentTrademarkManager.intefaces.Instruction
import com.AnO.PatentTrademarkManager.services.InstructionService
import io.swagger.annotations.Api
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Sort
import org.springframework.web.bind.annotation.*
import java.util.*

@Api(value = "Instruction",
description = "Rest API for Instructions",
tags = ["Instruction"])
@CrossOrigin(origins = arrayOf("http://localhost:4200"))
@RestController
@RequestMapping("/Instruction")
class InstructionController {
  @Autowired
  lateinit var instructionService:InstructionService

  @GetMapping("/start")
  fun start(): String {
    println("Start method called")
    return "Hello World"
  }


  @GetMapping("/patent")
  fun getAllPatents(@RequestParam(defaultValue = "0") page:Int,
                    @RequestParam(defaultValue = "10") size:Int,
                    @RequestParam direction:Sort.Direction?,
                    @RequestParam(defaultValue = "id") sort_property:String?) =
          this.instructionService
                  .getPatents(page, size, direction=Sort.DEFAULT_DIRECTION, sort_property="id")

  @GetMapping("/patent/{id}")
  fun getPatent(@PathVariable id: UUID) =
          this.instructionService.getPatent(id)

//  @ApiResponses(value = [
//    ApiResponse(code = 200, message = "SUCCESS", response = Patent::class),
//  ])
  @PostMapping("/patent")
  fun createPatent(@RequestBody patent: Patent) =
          this.instructionService.createPatent(patent)

  @PutMapping("/patent/{id}")
  fun updatePatent(@PathVariable id:UUID, @RequestBody patent: Patent) =
          this.instructionService.updatePatent(id,patent)

  @DeleteMapping("/patent/{id}")
  fun deletePatent(@PathVariable id: UUID) =
          this.instructionService.deletePatent(id)

  @PutMapping("/patent/{id}/search-action")
  fun applySearchAction(@PathVariable id: UUID, @RequestBody pAction: P_SearchAction) =
          this.instructionService.applyPSearchAction(id, pAction)

  @PutMapping("/patent/{id}/assignment-merger-action")
  fun applyPAssignmentMergerAction(@PathVariable id: UUID, @RequestBody pAction: P_AssignmentMergerAction) =
          this.instructionService.applyPAssignmentMergerAction(id, pAction)

  @PutMapping("/patent/{id}/change-of-address-action")
  fun applyPChangeOfAddressAction(@PathVariable id: UUID, @RequestBody pAction: P_ChangeOfAddressAction) =
          this.instructionService.applyPChangeOfAddressAction(id, pAction)

  @PutMapping("/patent/{id}/change-of-name-action")
  fun applyPChangeOfNameAction(@PathVariable id: UUID, @RequestBody pAction: P_ChangeOfNameAction) =
          this.instructionService.applyPChangeOfNameAction(id, pAction)
  
  @PutMapping("/patent/{id}/ctc-action")
  fun applyPCTCAction(@PathVariable id: UUID, @RequestBody pAction: P_CTCAction) =
          this.instructionService.applyPCTCAction(id, pAction)

  @PutMapping("/patent/{id}/procurement-of-certificate-action")
  fun applyPProcurementOfCertificateAction(@PathVariable id: UUID, @RequestBody pAction: P_ProcurementOfCertificateAction) =
          this.instructionService.applyPProcurementOfCertificateAction(id, pAction)

  @PutMapping("/patent/{id}/registration-action")
  fun applyPRegistrationAction(@PathVariable id: UUID, @RequestBody pAction: P_RegistrationAction) =
          this.instructionService.applyPRegistrationAction(id, pAction)

  @PutMapping("/patent/{id}/renewal-action")
  fun applyPRenewalAction(@PathVariable id: UUID, @RequestBody pAction: P_RenewalAction) =
          this.instructionService.applyPRenewalAction(id, pAction)
}
