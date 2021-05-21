package com.shivam.railways.entity;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import net.bytebuddy.dynamic.loading.ClassReloadingStrategy.Strategy;

@Entity

public class Passenger {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;
	private String userName;
	@ManyToMany
	private List<Train> trains=new LinkedList<>();

	public Passenger() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Passenger(long userId, String userName) {
		super();
		this.userId = userId;
		this.userName = userName;

	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<Train> getTrains() {
		return trains;
	}

	public void setTrains(LinkedList<Train> trains) {
		this.trains = trains;
	}

	@Override
	public String toString() {
		return "Passenger [userId=" + userId + ", userName=" + userName+  "]";
	}

}
