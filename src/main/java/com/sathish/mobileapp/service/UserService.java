package com.sathish.mobileapp.service;

import com.sathish.mobileapp.model.User;
import com.sathish.mobileapp.response.UserRest;

public interface UserService {
	
	User createUser(UserRest userRest);

}
