package com.jsp.hotel.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.hotel.dao.UserInformationDao;
import com.jsp.hotel.entity.UserInformation;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class UserController {
	@Autowired
	UserInformationDao userInformationDao;
	
	@RequestMapping("/userDetails")
	public String returnExamplePAge(Model model) {
		
		model.addAttribute("userinfo", new UserInformation());
		return "AddUsers";
	}
	
	@RequestMapping("/registration")
	public String userDetails(UserInformation userInformation) {
		
		 userInformationDao.userRegistration(userInformation);
		
		return "Login";
	}
	
	@RequestMapping("userLoginreq")
	public String userlogin() {
		return "Login";
	}
	@RequestMapping("/returnSeachByCityPage")
	public String returnSearchCityPage(HttpServletRequest request) {
		UserInformation userInformation =(UserInformation)request.getSession().getAttribute("userlogininfo");
		request.getSession().setAttribute("userlogininfo", userInformation);
		return "SearchByCity";
		
	}
	
	@RequestMapping("/userLogin")
	//@ResponseBody
	private ModelAndView userloginInfo(String emailid,String password,HttpServletRequest request,ModelAndView modelAndView) {
		
//		String emailid="banothrajendar200@gmail.com";
//		String password="12345";
		
		UserInformation information = userInformationDao.userLogin(emailid, password);
		request.getSession().setAttribute("userlogininfo", information);
		if (information!=null) {
			modelAndView.setViewName("SearchByCity");
			return modelAndView;
		} else {
			modelAndView.setViewName("Login");
			modelAndView.addObject("msg", "Invalid Details");
			return modelAndView;
			
		}
	}
	
}
