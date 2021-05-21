package com.shivam.railways;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.shivam.railways.entity.Passenger;
import com.shivam.railways.entity.Train;
import com.shivam.railways.repository.PassengerRepo;
import com.shivam.railways.repository.TrainRepo;
import com.shivam.railways.service.BookingService;
import com.shivam.railways.service.PassengerService;
import com.shivam.railways.service.PassengerServiceImpl;
import com.shivam.railways.service.TrainService;
import com.shivam.railways.service.TrainServiceImpl;

@SpringBootApplication
public class RailwayManagementSystemApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(RailwayManagementSystemApplication.class, args);

		TrainRepo trainRepo = context.getBean(TrainRepo.class);
		Scanner scanner = new Scanner(System.in);
		PassengerRepo passengerRepo = context.getBean(PassengerRepo.class);
		PassengerService passengerService = context.getBean(PassengerService.class);
		BookingService bookingService = context.getBean(BookingService.class);
		TrainService trainService = new TrainServiceImpl();
		boolean repeat = false;
		do {

			switch (menu()) {
			case 1:
				trainService.add(trainRepo);
				break;
			case 2:
				//
				Iterable<Train> trains = trainService.findAll(trainRepo);
				display(trains);
				break;
			case 3:
				// add passenger
				System.out.println("Enter userId in form of Integer");
				long userId = Long.parseLong(scanner.nextLine());
				System.out.println("Enter User Name");
				String userName = scanner.nextLine();

				Passenger passenger = passengerService.add(passengerRepo, userId, userName);
				break;
			case 4:
				// print all the trains between souce and destination.
				// Book ticket for user based on train id and user id.
				System.out.println("Enter source");
				String source = scanner.nextLine();
				System.out.println("Enter destination");
				String destination = scanner.nextLine();
				List<Train> trains1 = trainService.findBetweenSourceAndDestination(source, destination, trainRepo);
				display(trains1);
				System.out.println("Enter trainid");
				long trainId = Integer.parseInt(scanner.nextLine());
				System.out.println("Enter passengerid");
				long passengerId = Integer.parseInt(scanner.nextLine());
				try {
					bookingService.bookTicket(trainRepo, passengerRepo, trainId, passengerId);
					System.out.println("Ticket booked");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;

			case 5:
				System.out.println("Enter trainid");
				long trainId1 = Long.parseLong(scanner.nextLine());
				List<Passenger> passengers = new TrainServiceImpl().showPassengerDetails(trainRepo, trainId1);
				passengerService.display(passengers);
			default:
				System.out.println("Enter correct choice");

			}
			System.out.println("Enter true to continue");
			repeat = Boolean.parseBoolean(scanner.nextLine());
			break;
		} while (repeat);
	}

	static int menu() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter 1 to add train");
		System.out.println("Enter 2 to show all trains");
		System.out.println("Enter 3 to add passenger");
		System.out.println("Enter 4 for booking");
		System.out.println("Ener 5 to to show passengers for given trainid");
		return Integer.parseInt(scanner.nextLine());
	}

	static void display(Iterable<Train> train) {
		for (Train object : train) {
			System.out.println(object);
		}

	}

	static void display(List<Object> objects) {
		for (Object obj : objects) {
			System.out.println(objects);
		}
	}

}
