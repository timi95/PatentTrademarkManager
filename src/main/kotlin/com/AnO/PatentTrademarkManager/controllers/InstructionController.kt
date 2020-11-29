package com.AnO.PatentTrademarkManager.controllers


import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
//import io.swagger.annotations.Api
import org.springframework.web.bind.annotation.RequestMapping


@RestController
@RequestMapping("/Instruction")
//@Api(value = "Instruction", description = "Rest API for Instructions", tags = arrayOf("User API"))
class InstructionController {


  @GetMapping("/start")
  fun start(): String {
    println("Start method called")
    return "Hello World"
  }


}
