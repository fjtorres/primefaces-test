package com.github.fjtorres.samples.jsf.primefacesTest.db;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionFactory {
   private static Context context;

   public static DataSource getDataSource(String name) throws NamingException {
      return (DataSource) context.lookup("jdbc/" + name);
   }

   public static Connection getConnection(String name) throws NamingException, SQLException {
      DataSource ds = getDataSource(name);
      if (ds == null) {
         throw new SQLException("DataSource no encontrado: " + name);
      }
      return ds.getConnection();
   }

   static {
      try {
         context = new InitialContext();
         System.out.println("CONTEXTO INICIAL CARGADO");
         context = (Context) context.lookup("java:/comp/env");
         System.out.println("SUBCONTEXTO DE ENTORNO CARGADO");
      } catch (Throwable localThrowable) {
      }
   }
}
