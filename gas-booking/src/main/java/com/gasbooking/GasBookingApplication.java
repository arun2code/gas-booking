package com.gasbooking;

import java.util.Date;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.gasbooking.model.GasBooking;
import com.gasbooking.repo.BookingRepo;

@SpringBootApplication
//@ComponentScan("com.gasbooking.model")
public class GasBookingApplication {

	@Autowired
	BookingRepo repo;
	
	public static void main(String[] args) {
		SpringApplication.run(GasBookingApplication.class, args);
	}
	
	@Bean
	InitializingBean sendDatabase() {
	    return () -> {
	    	repo.save(new GasBooking("1", "ACC01", new Date(System.currentTimeMillis()),  "Noida", "Y", "abc@gmail.com"));
	    	repo.save(new GasBooking("2", "ACC02", new Date(System.currentTimeMillis()), "faridabad", "Y", "abc@gmail.com"));
	    	repo.save(new GasBooking("3", "ACC03", new Date(System.currentTimeMillis()), "Delhi", "Y", "abc@gmail.com"));
	    };
	}
	
}
