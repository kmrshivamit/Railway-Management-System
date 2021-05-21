package com.shivam.railways.service;

import com.shivam.railways.repository.PassengerRepo;
import com.shivam.railways.repository.TrainRepo;

public interface BookingService {
	
	boolean bookTicket(TrainRepo trainRepo,PassengerRepo passengerRepo,long trainId,long passengerId) throws Exception;
	

}
