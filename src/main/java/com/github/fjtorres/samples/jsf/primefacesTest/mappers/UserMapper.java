package com.github.fjtorres.samples.jsf.primefacesTest.mappers;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper {

   @Select("SELECT email FROM user WHERE id = #{userId}")
   String getUserEmail(@Param("userId") Long userId);
}
