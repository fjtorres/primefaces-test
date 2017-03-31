package com.github.fjtorres.samples.jsf.primefacesTest.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.github.fjtorres.samples.jsf.primefacesTest.dto.TestDto;

@FacesConverter("testConverter")
public class TestDtoConverter implements Converter {

   @Override
   public Object getAsObject(FacesContext pContext, UIComponent pComponent, String pValue) {

      return TestDto.FIXED_DATA.get(Long.valueOf(pValue));
   }
   
   @Override
   public String getAsString(FacesContext pContext, UIComponent pComponent, Object pValue) {

      return ((TestDto)pValue).getId().toString();
   }
}
