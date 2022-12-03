package com.app.registration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.registration.model.Users;
import com.app.registration.repository.RegistrationRepository;

@Service
public class RegistrationService {
	

	@Autowired
	private RegistrationRepository repo;
	
	public Users saveUser(Users users) {
		
		return repo.save(users);
	}
	public Users fetchUserByEmailId(String email) {
		return repo.findByEmailId(email);
	}
	public Users fetchUserByEmailIdAndPasssword(String email,String password) {
		return repo.findByEmailIdAndPassword(email, password);
	}
}
