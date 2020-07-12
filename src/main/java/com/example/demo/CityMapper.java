package com.example.demo;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface CityMapper {

    @Select("SELECT * FROM CITY WHERE state = #{state}")
    City findByState(@Param("state") String state);

    @Select("SELECT * FROM CITY WHERE ID = #{id}")
    City findById(@Param("id") int id);

    @Insert("INSERT INTO CITY VALUES(NULL, #{cityName}, #{state}, NULL)")
    int insertCity(@Param("cityName") String cityName, @Param("state") String state);
}
