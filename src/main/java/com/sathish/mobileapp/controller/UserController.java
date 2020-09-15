package com.sathish.mobileapp.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
//import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sathish.mobileapp.Exception.UserException;
import com.sathish.mobileapp.model.User;
import com.sathish.mobileapp.response.UserRest;
import com.sathish.mobileapp.service.UserService;
import com.sathish.mobileapp.updateUserModel.UpdateUser;

@RestController
@RequestMapping("/users")
public class UserController {
	
	
	Map<String,User> map=new HashMap<>();
	
	
	@Autowired
	UserService userService;
	
	@GetMapping(path="/user/{userId}",produces = {MediaType.APPLICATION_JSON_VALUE
			,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<User> getUser(@PathVariable("userId") String id) {
//		User user = new User();
//		user.setFirstName("sathish");
//		user.setLastName("r");
//		user.setEmail("sathish@gmail.com");
//		user.setUserId(id);
//		return new ResponseEntity<User>(user,HttpStatus.ACCEPTED);
		/* FOR CHECKING NULL POINTER EXCEPTION CALLING*/
//		String n = null;
//		int length = n.length();
		/* to check whether custom exception is thrown or not*/
//		if(true) {
//			throw new UserException("UserException is thrown");
//		}
		if(map.containsKey(id)) {
			return new ResponseEntity<User>(map.get(id),HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping(path="/user",produces = {MediaType.APPLICATION_JSON_VALUE
			,MediaType.APPLICATION_XML_VALUE}
	,consumes = {MediaType.APPLICATION_JSON_VALUE
			,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<User> createUser( @RequestBody UserRest userRest) {
		User user = userService.createUser(userRest);
		
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
	@PutMapping(path="/{userId}",produces = {MediaType.APPLICATION_JSON_VALUE
			,MediaType.APPLICATION_XML_VALUE}
	,consumes = {MediaType.APPLICATION_JSON_VALUE
			,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<User> updateUser(@PathVariable String userId,@RequestBody UpdateUser user) {
		
		User oldUser = map.get(userId);
		oldUser.setFirstName(user.getFirstName());
		oldUser.setLastName(user.getLastName());
		map.put(userId, oldUser);
		return new ResponseEntity<User>(oldUser,HttpStatus.OK);
		
		
	}
	
	@DeleteMapping()
	public ResponseEntity<User> deleteUser(@RequestParam("id") String userId) {
		User user=new User();
		if(map.containsKey(userId)) {
			map.remove(userId);
		}
		return new ResponseEntity<>(user,HttpStatus.ACCEPTED);
	}
	
	@GetMapping()
	public String getUser(@RequestParam(value="page",defaultValue="1")int page, 
			@RequestParam(value="limit",defaultValue="2")int limit,
			@RequestParam(value="sort", required=false,defaultValue="sort")String sort){
		return "page "+page+" limit "+limit+" sort "+sort;
	}
	
}
