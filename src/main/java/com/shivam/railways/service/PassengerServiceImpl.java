package com.shivam.railways.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.shivam.railways.entity.Passenger;
import com.shivam.railways.repository.PassengerRepo;
@Transactional
@Component
public class PassengerServiceImpl implements PassengerService {

	@Override
	public Passenger add(PassengerRepo passengerRepo, long userId, String userName) {

		return passengerRepo.save(new Passenger(userId, userName));
	}

	@Override
	public void display(List<Passenger> passengers) {
		// TODO Auto-generated method stub

		for (Passenger passenger : passengers) {
			System.out.println(passenger);
		}

	}

}
