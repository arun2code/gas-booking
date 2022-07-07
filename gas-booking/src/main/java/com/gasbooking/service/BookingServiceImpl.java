package com.gasbooking.service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gasbooking.model.GasBooking;
import com.gasbooking.repo.BookingRepo;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingRepo repo;
	
	public List<GasBooking> findAll() {
		
		return repo.findAll();
	}
	
	public GasBooking getBookingByUserId(String userId) {
		
		return null;
		
	}
	
	public String addBooking(GasBooking book) {
		
		return "";
	}

	@Override
	public GasBooking book(GasBooking request) {
		try {
			return repo.save(request);
		}
		catch(Exception exp) {
			return null;
		}
	}

	@Override
	public List<GasBooking> findByUserAccountNumber(String userAccountNumber) {
		List<GasBooking> list = repo.findAll();
		return list.stream().filter(e -> 
		e.getUserAccountNumber() != null 
		&& e.getUserAccountNumber().equals(userAccountNumber)).collect(Collectors.toList());
	}
	
	
}
