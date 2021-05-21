package com.shivam.railways.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.shivam.railways.entity.Passenger;
import com.shivam.railways.entity.Train;
import com.shivam.railways.repository.PassengerRepo;
import com.shivam.railways.repository.TrainRepo;
@Transactional
@Component
public class BookingServiceImpl implements BookingService {

	@Override
	public boolean bookTicket(TrainRepo trainRepo, PassengerRepo passengerRepo, long trainId, long passengerId) throws Exception {
		// TODO Auto-generated method stub

		boolean trainExists = trainRepo.existsById(trainId);
		if (trainExists == false)
			throw new Exception("The train does not exists by the given id");
		Train train = trainRepo.getOne(trainId);
		if (!passengerRepo.existsById(passengerId))
			throw new Exception("The passenger does not exists");
		Passenger passenger = passengerRepo.getOne(passengerId);
	train.getPassengers().add(passenger);
		trainRepo.save(train);
		passenger.getTrains().add(train);
		passengerRepo.save(passenger);
		return true;

	}

}
