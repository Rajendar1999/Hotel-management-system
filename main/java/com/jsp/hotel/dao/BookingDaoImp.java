package com.jsp.hotel.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.hotel.entity.Booking;
import com.jsp.hotel.repository.BookingRepositiry;
@Component
public class BookingDaoImp implements BookingDao {
	
	@Autowired
	BookingRepositiry bookingRepositiry;
	
	@Override
	public void registerBooking(Booking booking) {

		Booking booking1 = bookingRepositiry.save(booking);
		
	}

	@Override
	public List<Booking> selectAllUsersBookings() {
		return bookingRepositiry.findAll();
	}

}
