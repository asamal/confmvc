package com.samal.conference.controller;

import com.samal.conference.model.Registration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


/**
 * @author Aliaksandr Samal
 */
@Controller
public class RegistrationController
{
  @GetMapping("registration")
  public String getRegistration(@ModelAttribute("registration") Registration model)
  {
    return "registration";
  }


  @PostMapping("registration")
  public String addRegistration(@ModelAttribute("registration") Registration model)
  {
    System.out.println("Registration: " + model.getName());
    return "redirect:registration";
  }
}
