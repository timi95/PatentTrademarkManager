package com.AnO.controllers.StartController

import org.springframework.stereotype.Controller

import org.springframework.web.bind.annotation.GetMapping

@Controller
class StartController {

  @GetMapping("/")
  fun start(): String {
    return "Hello World"
  }

}