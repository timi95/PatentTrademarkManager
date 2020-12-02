package com.AnO.PatentTrademarkManager.controllers


import com.AnO.PatentTrademarkManager.classes.Actions.PatentActions.SearchAction
import com.AnO.PatentTrademarkManager.classes.Instructions.Patent
import com.AnO.PatentTrademarkManager.services.InstructionService
import io.swagger.annotations.Api
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Sort
import org.springframework.web.bind.annotation.*

@Api(value = "Instruction",
description = "Rest API for Instructions",
tags = ["Instruction"])
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
  fun getPatent(@PathVariable id: Long) =
          this.instructionService.getPatent(id)

  @PostMapping("/patent")
  fun createPatent(@RequestBody patent: Patent) =
          this.instructionService.createPatent(patent)

  @PutMapping("/patent/{id}")
  fun updatePatent(@PathVariable id:Long, @RequestBody patent: Patent) =
          this.instructionService.updatePatent(id,patent)

  @DeleteMapping("/patent/{id}")
  fun deletePatent(@PathVariable id: Long) =
          this.instructionService.deletePatent(id)

  @PutMapping("/patent/{id}/search-action")
  fun applySearchAction(@PathVariable id: Long, @RequestBody searchAction: SearchAction) =
          this.instructionService.applySearchAction(id, searchAction)
}
