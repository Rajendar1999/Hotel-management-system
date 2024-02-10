package com.jsp.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.hotel.entity.Hotel;
import java.util.List;


public interface HotelRepository extends JpaRepository<Hotel, Integer> {
	List<Hotel> findByCity(String city);
}
