package com.sathish.mobileapp.service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sathish.mobileapp.model.User;
import com.sathish.mobileapp.response.UserRest;
import com.sathish.mobileapp.shared.Utils;

@Service
public class UserServiceImpl implements UserService {
		
	
	Utils util;
	
	@Autowired
	public UserServiceImpl(Utils util) {
		this.util = util;
	}
	Map<String,User> map=new HashMap<>();
	@Override
	public User createUser(UserRest userRest) {
		User user = new User();
		user.setFirstName(userRest.getFirstName());
		user.setLastName(userRest.getLastName());
		user.setEmail(userRest.getEmail());
		String userId=util.generateUserId();
		user.setUserId(userId);
		
		if(map==null) 
		{
			map=new HashMap<>();
		}
		map.put(userId, user);
		return user;
	}

}
