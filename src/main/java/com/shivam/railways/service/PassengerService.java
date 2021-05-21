package com.shivam.railways.service;

import java.util.List;

import com.shivam.railways.entity.Passenger;
import com.shivam.railways.repository.PassengerRepo;

public interface PassengerService {
	
	Passenger add(PassengerRepo passengerRepo ,long userId,String userName);

	void display(List<Passenger> passengers);


}
