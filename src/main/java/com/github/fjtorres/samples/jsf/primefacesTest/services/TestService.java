package com.github.fjtorres.samples.jsf.primefacesTest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.fjtorres.samples.jsf.primefacesTest.mappers.UserMapper;

@Service
public class TestService {

   private final UserMapper mapper;

   @Autowired
   public TestService(UserMapper pMapper) {

      this.mapper = pMapper;
   }

   @Transactional(readOnly = true)
   public void test() {

      mapper.getUserEmail(1L);
   }
}
