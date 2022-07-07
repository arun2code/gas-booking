package com.gasbooking.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import com.gasbooking.model.GasBooking;
import com.gasbooking.service.BookingService;

@Controller
public class GasBookingController {

	@Autowired
	private BookingService service;

	@GetMapping("/")
	public String index(Model model) {

		return "index";
	}
	
	@GetMapping("/searchBooking")
	public String searchBooking() {
		return "searchBooking";
	}

	@GetMapping("/bookings")
	public ModelAndView getBookings() {

		List<GasBooking> bookings = service.findAll();

		Map<String, Object> params = new HashMap<>();
		params.put("bookings", bookings);

		return new ModelAndView("bookings", params);
	}

	
	@GetMapping("/bookings/{userAccountNumber}")
	public ModelAndView getBookingByAccount(@PathVariable String userAccountNumber, Model model) {

		List<GasBooking> bookings = service.findByUserAccountNumber(userAccountNumber);

		
		Map<String, Object> params = new HashMap<>();
		params.put("bookings", bookings);

		return new ModelAndView("bookings", params);
	}

	

	
	/////////For Theme
	@GetMapping("/bookCylinder")
	public String greetingForm(Model model) {
		model.addAttribute("bookCylinder", new GasBooking());
		return "bookCylinder";
	}

	@PostMapping("/bookCylinder")
	public String book(@ModelAttribute GasBooking request, Model model) {
		request.setBookingDate(new Date(System.currentTimeMillis()));
		request.setIsDelivered("N");
		
		//request.setId("ss");
		GasBooking resp = service.book(request);
		if(resp != null) {
			model.addAttribute("bookCylinder", resp);
			return "result";
		}
		return "error";
	}
	
	
	
	/////for swagger
	
	@GetMapping("/bookingstest")
	public List<GasBooking> getBookingsTest() {

		List<GasBooking> bookings = service.findAll();

		return bookings;
	}
	
	@PostMapping("/bookCylinderTest")
	public GasBooking makeBooking(@RequestBody GasBooking request) {

		return service.book(request);
	}
}
