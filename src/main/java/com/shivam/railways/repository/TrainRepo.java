package com.shivam.railways.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.shivam.railways.entity.Passenger;
import com.shivam.railways.entity.Train;

public interface TrainRepo extends JpaRepository<Train, Long> {

	List<Train> findBySourceAndDestination(String source,String destnation);
	
	
     
}
