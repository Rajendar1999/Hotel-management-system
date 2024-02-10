package com.jsp.hotel.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.hotel.entity.UserInformation;
import com.jsp.hotel.repository.UserRepository;

@Component
public class UserInformationDaoImp implements UserInformationDao {
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public void userRegistration(UserInformation userInformation) {
		UserInformation information = userRepository.save(userInformation);
		
	}

	@Override
	public UserInformation userLogin(String emailid, String password) {
		return userRepository.findByEmailidAndPassword(emailid, password);
	}

}
