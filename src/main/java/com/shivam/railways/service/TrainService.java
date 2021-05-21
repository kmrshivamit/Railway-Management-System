package com.shivam.railways.service;

import java.util.List;

import com.shivam.railways.entity.Passenger;
import com.shivam.railways.entity.Train;
import com.shivam.railways.repository.TrainRepo;

public interface TrainService {
	Train add(TrainRepo repo);

	Iterable<Train> findAll(TrainRepo repo);

	List<Train> findBetweenSourceAndDestination(String source, String destination, TrainRepo trainRepo);

	List<Passenger> showPassengerDetails(TrainRepo trainRepo, long trainId1);
}
