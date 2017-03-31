package com.github.fjtorres.samples.jsf.primefacesTest.model;

import java.util.Date;

import com.github.fjtorres.samples.jsf.primefacesTest.dto.EGender;

public class Person {

   private Long id;
   
   private String firstName;
   
   private String lastName;
   
   private Date birthDate;
   
   private EGender gender;

   public Long getId() {
      return id;
   }

   public void setId(Long pId) {
      id = pId;
   }

   public String getFirstName() {
      return firstName;
   }

   public void setFirstName(String pFirstName) {
      firstName = pFirstName;
   }

   public String getLastName() {
      return lastName;
   }

   public void setLastName(String pLastName) {
      lastName = pLastName;
   }

   public Date getBirthDate() {
      return birthDate;
   }

   public void setBirthDate(Date pBirthDate) {
      birthDate = pBirthDate;
   }

   public EGender getGender() {
      return gender;
   }

   public void setGender(EGender pGender) {
      gender = pGender;
   }
}
