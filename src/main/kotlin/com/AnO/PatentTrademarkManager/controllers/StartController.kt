package com.AnO.PatentTrademarkManager.controllers

import org.springframework.stereotype.Controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class StartController {

  @GetMapping("/start")
  fun start(): String {
    println("Hello Kotlin I guess this is the start")
    return "Hello World"
  }


}