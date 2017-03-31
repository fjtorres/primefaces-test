package com.github.fjtorres.samples.jsf.primefacesTest.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import com.github.fjtorres.samples.jsf.primefacesTest.model.Person;

@Component
public interface PersonMapper {
   
   @Results(id = "personResult", value = {
         @Result(property = "id", column = "id", id = true),
         @Result(property = "firstName", column = "first_name"),
         @Result(property = "lastName", column = "last_name"),
         @Result(property = "birthDate", column = "birth_date")
       })
   @Select("SELECT * FROM PERSONS")
   List<Person> getPersons();
   
   @Results(value = {
         @Result(property = "id", column = "id", id = true),
         @Result(property = "firstName", column = "first_name"),
         @Result(property = "lastName", column = "last_name"),
         @Result(property = "birthDate", column = "birth_date")
       })
   @Select("SELECT * FROM PERSONS where ID = #{personId}")
   Person getPerson(@Param("personId") Long personId);

   @Insert("INSERT INTO PERSONS (FIRST_NAME, LAST_NAME, BIRTH_DATE) VALUES (#{person.firstName}, #{person.lastName}, #{person.birthDate})")
   void insert(@Param("person") Person person);

   @Delete("DELETE FROM PERSONS WHERE ID = #{personId}")
   void delete(@Param("personId") Long personId);

   @Update("UPDATE PERSONS set FIRST_NAME = #{person.firstName}, LAST_NAME = #{person.lastName}, BIRTH_DATE = #{person.birthDate} where ID = #{person.id}")
   void update(@Param("person") Person pPerson);
}
