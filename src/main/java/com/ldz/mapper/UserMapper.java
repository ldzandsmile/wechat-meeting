package com.ldz.mapper;

import com.ldz.model.User;

public interface UserMapper {
	//查询管理员
	User selectUserByName(String name);
	
	
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}