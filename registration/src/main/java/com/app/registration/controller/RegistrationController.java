package com.app.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.app.registration.model.Users;
import com.app.registration.service.RegistrationService;

@RestController
public class RegistrationController {

	@Autowired
	private RegistrationService service;
	
	@PostMapping("/registeruser")
	public Users registerUser(@RequestBody Users users) throws Exception {
		String tempEmailId=users.getEmailId();
		if (tempEmailId != null && !"".equals(tempEmailId)) {
			
			Users userobj =service.fetchUserByEmailId(tempEmailId);
		    
			if (userobj != null) {
				throw new Exception("user with "+tempEmailId+" is already exist");
				
			}
		}
		Users userobj =null;
		userobj=service.saveUser(users);
		return userobj;
	}
@PostMapping("/login")
	public Users loginUser(@RequestBody Users users) throws Exception {
		String tempEmailId=users.getEmailId();
		String tempPass=users.getPassword();
		Users userObj=null;
		if(tempEmailId != null && tempPass != null) {
			service.fetchUserByEmailIdAndPasssword(tempEmailId, tempPass);
		}
		if (userObj == null) {
			throw new Exception("Bad credentials");
			
		}
		return userObj;
	}
}
