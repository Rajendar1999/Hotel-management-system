package com.jsp.hotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jsp.hotel.entity.Payment;

@Controller
public class PaymentController {
	
	@RequestMapping("/takingpaymentDetails")
	public void takingPaymentdetails(Payment payment) {
		System.out.println(payment);
	}
	
}
