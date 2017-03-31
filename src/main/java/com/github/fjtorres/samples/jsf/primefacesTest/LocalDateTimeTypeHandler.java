package com.github.fjtorres.samples.jsf.primefacesTest;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

@MappedTypes(LocalDateTime.class)
public class LocalDateTimeTypeHandler extends BaseTypeHandler<LocalDateTime> {

   @Override
   public void setNonNullParameter(PreparedStatement pPs, int pI, LocalDateTime pParameter, JdbcType pJdbcType)
         throws SQLException {

      pPs.setTimestamp(pI, Timestamp.from(pParameter.toInstant(ZoneOffset.UTC)));
   }

   @Override
   public LocalDateTime getNullableResult(ResultSet pRs, String pColumnName) throws SQLException {
      return convertDate(pRs.getString(pColumnName));
   }

   @Override
   public LocalDateTime getNullableResult(ResultSet pRs, int pColumnName) throws SQLException {

      return convertDate(pRs.getString(pColumnName));
   }

   @Override
   public LocalDateTime getNullableResult(CallableStatement pCs, int pColumnIndex) throws SQLException {
      return convertDate(pCs.getString(pColumnIndex));
   }

   private LocalDateTime convertDate(String date) {

      if (date == null || date.trim().isEmpty()) {
         return null;
      }

      return LocalDateTime.parse(date);
   }

}
