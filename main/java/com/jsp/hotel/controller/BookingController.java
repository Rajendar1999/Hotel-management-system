package com.jsp.hotel.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.hotel.dao.BookingDao;
import com.jsp.hotel.entity.Booking;
import com.jsp.hotel.entity.Hotel;
import com.jsp.hotel.entity.UserInformation;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class BookingController {
	
	@Autowired
	BookingDao bookingDao;
	
	@RequestMapping("/takinghotelInformation")
	public String bookingPage(Hotel hotel,HttpServletRequest request) {
		request.getSession().setAttribute("hotelInformation", hotel);
		//System.out.println(hotel);
		
		return "NoOfDaysAndRooms";
	}
	@RequestMapping("/getBookingdetails")
	public ModelAndView getBookingDetails(Booking booking, HttpServletRequest request,Model model,ModelAndView modelAndView) {
		UserInformation userInformation =(UserInformation) request.getSession().getAttribute("userlogininfo");
		Hotel hotel =(Hotel) request.getSession().getAttribute("hotelInformation");
		if (booking.getBookingdate().isAfter(LocalDate.now()) || booking.getBookingdate().isEqual(LocalDate.now())) {
			booking.setFirstname(userInformation.getFirstname());
			booking.setLastname(userInformation.getLastname());
			booking.setEmailid(userInformation.getEmailid());
			booking.setMobilenumber(userInformation.getMobilenumber());
			booking.setHotelname(hotel.getHotelname());
			booking.setPrice(booking.getNoofrooms() * hotel.getPrice() * booking.getNoofdays());
			 System.out.println(booking);
			model.addAttribute("total", booking);
			model.addAttribute("price", booking.getPrice());
//			bookingDao.registerBooking(booking);
			modelAndView.setViewName("AfterHotelPayment");
			return modelAndView;
		} else {
			modelAndView.setViewName("NoOfDaysAndRooms");
			modelAndView.addObject("msg", "Invalid Date");
			return modelAndView;
		}
	}
	
}
