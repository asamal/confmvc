package com.samal.conference.controller;

import com.samal.conference.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author Aliaksandr Samal
 */
@RestController
public class UserController
{
  @GetMapping("/user")
  public User getUser(@RequestParam(name = "firstname", defaultValue = "Aliaksandr") String firstname,
                      @RequestParam(name = "lastname", defaultValue = "Samal") String lastname,
                      @RequestParam(name = "age", defaultValue = "36") int age)
  {
    User user = new User();
    user.setFirstname(firstname);
    user.setLastname(lastname);
    user.setAge(age);
    return user;
  }


  @PostMapping("/user")
  public User postUser(User user)
  {
    System.out.println("Firstname: " + user.getFirstname());
    return user;
  }
}
