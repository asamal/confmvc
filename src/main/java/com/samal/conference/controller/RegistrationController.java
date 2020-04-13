package com.samal.conference.controller;

import com.samal.conference.model.Registration;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;


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
  public String addRegistration(@Valid @ModelAttribute("registration") Registration model, BindingResult result)
  {
    if (result.hasErrors()) {
      System.out.println("There were errors");
      return "registration";
    }
    System.out.println("Registration: " + model.getName());
    return "redirect:registration";
  }
}
