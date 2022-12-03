package com.app.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.app.registration.model.Users;

public interface RegistrationRepository extends JpaRepository<Users, Integer>{

	public Users findByEmailId(String email);
	public Users findByEmailIdAndPassword(String email,String password);


}
