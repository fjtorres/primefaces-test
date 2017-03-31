package com.github.fjtorres.samples.jsf.primefacesTest.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.github.fjtorres.samples.jsf.primefacesTest.dto.EGender;
import com.github.fjtorres.samples.jsf.primefacesTest.dto.TestDto;
import com.github.fjtorres.samples.jsf.primefacesTest.model.Person;
import com.github.fjtorres.samples.jsf.primefacesTest.services.PersonService;

@ManagedBean
@ViewScoped
public class PersonController {

   private List<EGender> genders = Arrays.asList(EGender.values());
   
   private List<TestDto> testList;
   
   @ManagedProperty("#{personService}")
   private PersonService service;

   private Long personId;

   private Person person = new Person();

   private List<Person> list;
   
   private TestDto testSelected;

   public void loadPerson() {
      
      if (personId != null) {
         person = service.findOne(personId);
      }
      
      testList = TestDto.FIXED_DATA.entrySet().stream().map(e -> e.getValue()).collect(Collectors.toList());
   }
   
   public void loadList() {

      list = service.findAll();
   }
   
   public String save() {

      service.save(getPerson());
      
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success operation", null));
      
      return "list?faces-redirect=true";
   }
   
   public String delete() {

      service.delete(getPersonId());
      
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success operation", null));
      
      return "list?faces-redirect=true";
   }

   public Person getPerson() {
      return person;
   }

   public void setPerson(Person pPerson) {
      person = pPerson;
   }

   public Long getPersonId() {
      return personId;
   }

   public void setPersonId(Long pPersonId) {
      personId = pPersonId;
   }

   public List<Person> getList() {
      return list;
   }

   public void setList(List<Person> pList) {
      list = pList;
   }

   public PersonService getService() {
      return service;
   }

   public void setService(PersonService pService) {
      service = pService;
   }

   public List<EGender> getGenders() {
      return genders;
   }

   public void setGenders(List<EGender> pGenders) {
      genders = pGenders;
   }

   public List<TestDto> getTestList() {
      return testList;
   }

   public void setTestList(List<TestDto> pTestList) {
      testList = pTestList;
   }

   public TestDto getTestSelected() {
      return testSelected;
   }

   public void setTestSelected(TestDto pTestSelected) {
      testSelected = pTestSelected;
   }
   
   

}
