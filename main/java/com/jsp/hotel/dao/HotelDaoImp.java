package com.jsp.hotel.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.hotel.entity.Hotel;
import com.jsp.hotel.repository.HotelRepository;
@Component
public class HotelDaoImp implements HotelDao {
	
	@Autowired
	HotelRepository hotelRepository;
	
	@Override
	public void hotelRegistration(Hotel hotel) {
		
		Hotel hotel1 = hotelRepository.save(hotel);
	}

	@Override
	public List<Hotel> selectAllHotels(String city) {
		
		return hotelRepository.findByCity(city);
	}

}
