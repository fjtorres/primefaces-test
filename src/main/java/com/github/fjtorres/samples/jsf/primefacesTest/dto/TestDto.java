package com.github.fjtorres.samples.jsf.primefacesTest.dto;

import java.util.HashMap;
import java.util.Map;

public class TestDto {

   public static final Map<Long, TestDto> FIXED_DATA;
   
   static {
      FIXED_DATA = new HashMap<>();
      FIXED_DATA.put(1L, new TestDto(1L, "First"));
      FIXED_DATA.put(2L, new TestDto(2L, "Second"));
   }
   
   private Long id;
   
   private String description;

   public TestDto() {
      
   }
   
   public TestDto(Long pId, String pDescription) {
      id = pId;
      description = pDescription;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long pId) {
      id = pId;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String pDescription) {
      description = pDescription;
   }
   
   
}
