package com.samal.conference.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;


/**
 * @author Aliaksandr Samal
 */
@Controller
public class GreetingController
{
  @GetMapping("greeting")
  public String greeting(Map<String, Object> model)
  {
    // test Sonar commit
    model.put("message", "Hello Alexander!");
    return "greeting";
  }
}
