package com.shivam.railways.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.shivam.railways.entity.Passenger;
import com.shivam.railways.entity.Train;

public interface PassengerRepo extends JpaRepository<Passenger,Long> {

}
