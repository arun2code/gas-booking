package com.gasbooking.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gasbooking.model.GasBooking;

@Service
public interface BookingService {

	public List<GasBooking> findAll();
	
	public GasBooking book(GasBooking request);
	
	public List<GasBooking> findByUserAccountNumber(String userAccountNumber);
}
