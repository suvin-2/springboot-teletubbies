package com.project.teletubbies.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface TbMapper {

    int getUserCount (Map<String, Object> params);

    Map<String, Object> getUserInfo (Map<String, Object> params);

}
