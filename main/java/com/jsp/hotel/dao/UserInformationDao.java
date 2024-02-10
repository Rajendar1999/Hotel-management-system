package com.jsp.hotel.dao;

import com.jsp.hotel.entity.UserInformation;

public interface UserInformationDao {
	void userRegistration(UserInformation userInformation);
	UserInformation userLogin(String emailid,String password);
}
