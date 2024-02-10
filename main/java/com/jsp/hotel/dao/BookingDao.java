package com.jsp.hotel.dao;

import java.util.List;

import com.jsp.hotel.entity.Booking;

public interface BookingDao {
	void registerBooking(Booking booking);
	List<Booking> selectAllUsersBookings();
}
