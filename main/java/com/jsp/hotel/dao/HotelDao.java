package com.jsp.hotel.dao;

import java.util.List;

import com.jsp.hotel.entity.Hotel;

public interface HotelDao {
	void hotelRegistration(Hotel hotel);
	List<Hotel> selectAllHotels(String city);
}
