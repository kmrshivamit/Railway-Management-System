package com.shivam.railways.entity;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GeneratorType;

import net.bytebuddy.implementation.bind.annotation.Default;

@Entity

public class Train {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long trainId;
	@Column(name = "train_name")
	String trainName;
	String source;
	String destination;
	float distence;
	@Column(name = "number_of_seats")
	int numberOfSeats;
	@ManyToMany(mappedBy = "trains", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	List<Passenger> passengers = new LinkedList<>();

	public Train() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Train(String trainName, String source, String destination, float distence, int numberOfSeats) {
		super();
		this.trainName = trainName;
		this.source = source;
		this.destination = destination;
		this.distence = distence;
		this.numberOfSeats = numberOfSeats;
	}
	public long getTrainId() {
		return trainId;
	}
	public void setTrainId(int trainId) {
		this.trainId = trainId;
	}

	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public float getDistence() {
		return distence;
	}

	public void setDistence(float distence) {
		this.distence = distence;
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public List<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(LinkedList<Passenger> passengers) {
		this.passengers = passengers;
	}

	@Override
	public String toString() {
		return "Train [trainId=" + trainId + ", trainName=" + trainName + ", source=" + source + ", destination="
				+ destination + ", distence=" + distence + ", numberOfSeats=" + numberOfSeats + "]";
	}
}
