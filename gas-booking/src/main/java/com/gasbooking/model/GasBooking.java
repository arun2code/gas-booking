package com.gasbooking.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "gasbooking")
public class GasBooking {

	@GeneratedValue(generator = "booking-id-gen")
	@GenericGenerator(name = "booking-id-gen", parameters = @Parameter(name = "prefix", value = "GB"),
	strategy = "com.gasbooking.model.StringSequenceIdGenerator")
	@Id
	//@GeneratedValue(strategy=GenerationType.SEQUENCE)
	//@SequenceGenerator(name="honeySequence",sequenceName="HONEY_SEQ")
	private String id;

	private String userAccountNumber;
	private Date bookingDate;
	private String location;
	private String isDelivered;
	private String email;

	public GasBooking() {
		super();
	}

	public GasBooking(String id, String userAccountNumber, Date bookingDate, String location, String isDelivered,
			String email) {
		super();
		this.id = id;
		this.userAccountNumber = userAccountNumber;
		this.bookingDate = bookingDate;
		this.location = location;
		this.isDelivered = isDelivered;
		this.email = email;
	}

}
