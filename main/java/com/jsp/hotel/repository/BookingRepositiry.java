package com.jsp.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.hotel.entity.Booking;

public interface BookingRepositiry extends JpaRepository<Booking, Integer> {

}
