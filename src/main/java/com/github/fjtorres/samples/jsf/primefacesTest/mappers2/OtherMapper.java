package com.github.fjtorres.samples.jsf.primefacesTest.mappers2;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface OtherMapper {

   @Select("SELECT email FROM user WHERE id = #{userId}")
   String getUserEmail(@Param("userId") Long userId);
}
