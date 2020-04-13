package com.samal.conference.model;

import javax.validation.constraints.NotEmpty;


/**
 * @author Aliaksandr Samal
 */
public class Registration
{
  @NotEmpty
  private String name;


  public String getName()
  {
    return name;
  }


  public void setName(String name)
  {
    this.name = name;
  }
}
