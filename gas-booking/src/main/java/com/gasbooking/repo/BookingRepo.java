package com.gasbooking.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gasbooking.model.GasBooking;

@Transactional
@Repository
public interface BookingRepo extends JpaRepository<GasBooking, String>{

	
}
