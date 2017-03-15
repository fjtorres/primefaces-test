package com.github.fjtorres.samples.jsf.primefacesTest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.fjtorres.samples.jsf.primefacesTest.mappers2.OtherMapper;

@Service
public class TestService2 {

   private final OtherMapper mapper;
   
   @Autowired
   public TestService2(OtherMapper pMapper) {
      
      this.mapper = pMapper;
   }
   
   @Transactional(readOnly = true, transactionManager="transactionManager2")
   public void test() {

      mapper.getUserEmail(1L);
   }
}
