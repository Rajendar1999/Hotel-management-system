package com.jsp.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.jsp.hotel.entity.UserInformation;

public interface UserRepository extends JpaRepository<UserInformation, Integer> {

	UserInformation findByEmailidAndPassword(String emailid, String password);
	
	
}
