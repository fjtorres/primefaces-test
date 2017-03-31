package com.github.fjtorres.samples.jsf.primefacesTest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.github.fjtorres.samples.jsf.primefacesTest.services.PersonService;
import com.github.fjtorres.samples.jsf.primefacesTest.services.TestService2;

@Controller
@Scope("request")
public class TestController {

   @Autowired
   private PersonService service;
   
   @Autowired
   private TestService2 service2;
   
   private String radioSelection;
   
   public String home() {

      return "home";
   }

   public String other() {

      return "other";
   }
   
   public String getRadioSelection() {
      return radioSelection;
   }
   
   public void setRadioSelection(String pRadioSelection) {
      radioSelection = pRadioSelection;
   }
}
