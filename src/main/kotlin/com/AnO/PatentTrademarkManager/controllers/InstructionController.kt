package com.AnO.PatentTrademarkManager.controllers


import com.AnO.PatentTrademarkManager.classes.Patent
import com.AnO.PatentTrademarkManager.services.InstructionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
//import io.swagger.annotations.Api


@RestController
@RequestMapping("/Instruction")
//@Api(value = "Instruction", description = "Rest API for Instructions", tags = arrayOf("User API"))
class InstructionController {
  @Autowired
  lateinit var instructionService:InstructionService

  @GetMapping("/start")
  fun start(): String {
    println("Start method called")
    return "Hello World"
  }

  @GetMapping("/patent")
  fun getAllPatents() =
          this.instructionService.getPatents()

  @GetMapping("/patent/{id}")
  fun getPatent(@RequestParam id: Long) =
          this.instructionService.getPatent(id)

  @PostMapping("/patent")
  fun createPatent(@RequestBody patent: Patent) =
          this.instructionService.createPatent(patent)

  @PutMapping("/patent/{id}")
  fun updatePatent(@RequestParam id:Long, @RequestBody patent: Patent) =
          this.instructionService.updatePatent(id,patent)

  @DeleteMapping("/patent/{id}")
  fun deletePatent(@RequestParam id: Long) =
          this.instructionService.deletePatent(id)

}
