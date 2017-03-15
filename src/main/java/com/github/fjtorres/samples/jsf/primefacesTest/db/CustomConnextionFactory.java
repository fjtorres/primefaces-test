package com.github.fjtorres.samples.jsf.primefacesTest.db;

import javax.naming.NamingException;
import javax.sql.DataSource;

public class CustomConnextionFactory {

   
   public DataSource getDataSource(String name) throws NamingException {
      return ConnectionFactory.getDataSource(name);
   }

}
