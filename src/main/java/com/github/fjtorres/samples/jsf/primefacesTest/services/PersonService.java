package com.github.fjtorres.samples.jsf.primefacesTest.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.fjtorres.samples.jsf.primefacesTest.mappers.PersonMapper;
import com.github.fjtorres.samples.jsf.primefacesTest.model.Person;

@Service("personService")
public class PersonService {

   private final PersonMapper mapper;

   @Autowired
   public PersonService(PersonMapper pMapper) {

      this.mapper = pMapper;
   }

   @Transactional(readOnly = true)
   public List<Person> findAll() {

      return mapper.getPersons();
   }

   @Transactional(readOnly = true)
   public Person findOne(Long identifier) {

      return mapper.getPerson(identifier);
   }

   @Transactional
   public void save(Person person) {

      if (person.getId() == null) {
         mapper.insert(person);
      } else {
         mapper.update(person);
      }
   }

   @Transactional
   public void delete(Long personId) {
      
      mapper.delete(personId);
   }

   @Transactional(propagation = Propagation.REQUIRES_NEW)
   public void otherProcess() {

      Person p = new Person();
      p.setBirthDate(new Date());
      p.setFirstName("FIRST NAME");
      p.setLastName("LAST NAME");

      mapper.insert(p);

      throw new RuntimeException("INTERNA");
   }
}
