package com.ldz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ldz.mapper.UserMapper;
import com.ldz.model.User;

@Service
public class UserService {
	@Autowired
	private UserMapper userMapper;

	public void insertSelective(User user) {
		this.userMapper.insertSelective(user);
	}
	
	//查询管理员
	public boolean selectUserByName(User user){
		if(user.getName() != null || "".equals(user.getName())){
			user = this.userMapper.selectUserByName(user.getName());
			if(user == null){
				return false;
			}
		} else {
			return false;
		}
		return true;
	}
	

}