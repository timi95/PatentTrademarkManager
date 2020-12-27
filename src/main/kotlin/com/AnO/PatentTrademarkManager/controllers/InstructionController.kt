package com.AnO.PatentTrademarkManager.controllers


import com.AnO.PatentTrademarkManager.classes.Actions.PatentActions.*
import com.AnO.PatentTrademarkManager.classes.Instructions.Patent
import com.AnO.PatentTrademarkManager.intefaces.Instruction
import com.AnO.PatentTrademarkManager.services.InstructionService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiParam
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Sort
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
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
          instructionService
                  .getPatents(page, size, direction=Sort.DEFAULT_DIRECTION, sort_property="id")

  @GetMapping("/patent/{id}")
  fun getPatent(@PathVariable id: UUID) =
          instructionService.getPatent(id)

  @PostMapping("/patent")
  fun createPatent(@RequestBody patent: Patent) =
          instructionService.createPatent(patent)

  @PutMapping("/patent/{id}")
  fun updatePatent(@PathVariable id:UUID, @RequestBody patent: Patent) =
          instructionService.updatePatent(id,patent)

  @DeleteMapping("/patent/{id}")
  fun deletePatent(@PathVariable id: UUID) =
          instructionService.deletePatent(id)

  @PutMapping("/patent/{id}/search-action")
  fun applySearchAction(@PathVariable id: UUID, @RequestBody pAction: P_SearchAction) =
          instructionService.applyPSearchAction(id, pAction)

  @PutMapping("/patent/{id}/assignment-merger-action")
  fun applyPAssignmentMergerAction(@PathVariable id: UUID, @RequestBody pAction: P_AssignmentMergerAction) =
          instructionService.applyPAssignmentMergerAction(id, pAction)

  @PutMapping("/patent/{id}/change-of-address-action")
  fun applyPChangeOfAddressAction(@PathVariable id: UUID, @RequestBody pAction: P_ChangeOfAddressAction) =
          instructionService.applyPChangeOfAddressAction(id, pAction)

  @PutMapping("/patent/{id}/change-of-name-action")
  fun applyPChangeOfNameAction(@PathVariable id: UUID, @RequestBody pAction: P_ChangeOfNameAction) =
          instructionService.applyPChangeOfNameAction(id, pAction)
  
  @PutMapping("/patent/{id}/ctc-action")
  fun applyPCTCAction(@PathVariable id: UUID, @RequestBody pAction: P_CTCAction) =
          instructionService.applyPCTCAction(id, pAction)

  @PutMapping("/patent/{id}/procurement-of-certificate-action")
  fun applyPProcurementOfCertificateAction(@PathVariable id: UUID, @RequestBody pAction: P_ProcurementOfCertificateAction) =
          instructionService.applyPProcurementOfCertificateAction(id, pAction)

  @PutMapping("/patent/{id}/registration-action")
  fun applyPRegistrationAction(@PathVariable id: UUID, @RequestBody pAction: P_RegistrationAction) =
          instructionService.applyPRegistrationAction(id, pAction)

  @PutMapping("/patent/{id}/renewal-action")
  fun applyPRenewalAction(@PathVariable id: UUID, @RequestBody pAction: P_RenewalAction) =
          instructionService.applyPRenewalAction(id, pAction)

  @GetMapping("/image/{id}")
  fun retrieveImageById(@PathVariable id: UUID) =
          instructionService.retrieveImageById(id)

  @GetMapping("/image")
  fun retrieveImageByName(@RequestParam name: String) =
          instructionService.retrieveImageByName(name)

  @PostMapping("/patent/{id}/image", consumes = arrayOf(MediaType.MULTIPART_FORM_DATA_VALUE))
  fun addPImage(@PathVariable id: UUID, @RequestPart multipartFile: MultipartFile) =
          instructionService.addPImage(id, multipartFile)

  @DeleteMapping("/image/{id}")
  fun deleteImage(@PathVariable id:UUID) =
          instructionService.deleteImage(id)

  @DeleteMapping("/image")
  fun deleteImageByName(@RequestParam fileName: String) =
          instructionService.deleteImageByName(fileName)

}
