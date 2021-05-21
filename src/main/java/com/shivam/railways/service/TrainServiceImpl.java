package com.shivam.railways.service;

import java.util.List;
import java.util.Scanner;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.shivam.railways.entity.Passenger;
import com.shivam.railways.entity.Train;
import com.shivam.railways.repository.TrainRepo;

@Transactional
@Component
public class TrainServiceImpl implements TrainService {
	@Override
	public Train add(TrainRepo trainRepo) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter train name");
		String trainName = scanner.nextLine();
		System.out.println("Enter source");
		String source = scanner.nextLine();
		System.out.println("Enter destination");
		String destination = scanner.nextLine();
		System.out.println("Enter distence");
		float distence = scanner.nextFloat();
		System.out.println("Number of seats");
		int numberOfSeats = scanner.nextInt();
		Train entity = new Train(trainName, source, destination, distence, numberOfSeats);
		System.out.println(entity.getDestination());
		trainRepo.save(entity);
		return entity;
	}

	@Override
	public Iterable<Train> findAll(TrainRepo trainRepo) {
		return trainRepo.findAll();
	}

	@Override
	public List<Train> findBetweenSourceAndDestination(String source, String destination, TrainRepo trainRepo) {
		return trainRepo.findBySourceAndDestination(source, destination);

	}

	
	public List<Passenger> showPassengerDetails(TrainRepo trainRepo, long trainId1) {
		System.out.println("hiii");
		trainRepo.getOne(trainId1);
		List<Train> trains=trainRepo.findAll();
	Train train=null;
	List<Passenger> list=null;
		for(Train t:trains)
			if(t.getTrainId()==trainId1)
				list=t.getPassengers();
		
		
	return list;
	}
}
