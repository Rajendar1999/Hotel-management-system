package com.jsp.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsp.hotel.dao.HotelDao;
import com.jsp.hotel.entity.Hotel;


@Controller
public class HotelController {
	
	@Autowired
	HotelDao hotelDao;
	
	@RequestMapping("/hotelPage")
	public String getHotelPage(Model model) {
		model.addAttribute("hotelinfo", new Hotel());
		return "AddHotel";
	}
	
	@RequestMapping("/hotelRegister")
	public void hotelInformation(Hotel hotel) {
		//System.out.println(hotel);
		hotelDao.hotelRegistration(hotel);
		
	}
	
	@RequestMapping("/hotelInformation")
	@ResponseBody
	public String hotelInfo() {
		List<Hotel> allHotels = hotelDao.selectAllHotels("Hyderabad");
		return allHotels+"";
	}
	
	@RequestMapping("/findHotel")
	public String getHotelByUsingCity(String city , Model model) {
		List<Hotel> list = hotelDao.selectAllHotels(city);
		model.addAttribute("listOfHotels",list);
		//System.out.println("Hotel Information"+list);
		return "ListOfHotels";
	}
	
	
	
}
