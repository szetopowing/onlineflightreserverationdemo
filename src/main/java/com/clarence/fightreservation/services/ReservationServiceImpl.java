package com.clarence.fightreservation.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.clarence.fightreservation.dtto.ReservationRequest;
import com.clarence.fightreservation.entities.Flight;
import com.clarence.fightreservation.entities.Passenger;
import com.clarence.fightreservation.entities.Reservation;
import com.clarence.fightreservation.repos.FlightRepository;
import com.clarence.fightreservation.repos.PassengerRepository;
import com.clarence.fightreservation.repos.ReservationRepository;
import com.clarence.fightreservation.util.EmailUtil;
import com.clarence.fightreservation.util.PDFGeneratorUtil;

@Service
public class ReservationServiceImpl implements ReservationService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationServiceImpl.class);
	
	@Value("${com.clarence.flightreservation.itinerary.dirpath}")
	private String ITINERARY_DIR;
	
	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	PassengerRepository passengerRepository;
	
	@Autowired
	ReservationRepository reservationRepository;
	
	@Autowired
	PDFGeneratorUtil pfdGeneratorUtil;
	
	@Autowired
	EmailUtil emailUtil;
	
	@Override
	@Transactional
	public Reservation bookFlight(ReservationRequest reservationRequest) {
		
		LOGGER.info("Inside bookFlight");
		//Make Payment
		
		Long flightId = reservationRequest.getFlightId();
		LOGGER.info("Fetch flight for flight id =" + flightId);
		Flight flight = flightRepository.getById(flightId);
		
		Passenger passenger = new Passenger();
		passenger.setFirstName(reservationRequest.getPassengerFirstName());
		passenger.setLastName(reservationRequest.getPassengerLastName());
		passenger.setEmail(reservationRequest.getPassengerEmail());
		passenger.setPhone(reservationRequest.getPassengerPhone());
		LOGGER.info("Saving the passenger:" + passenger);
		Passenger savedPassenger = passengerRepository.save(passenger);
		
		Reservation reservation = new Reservation();
	    reservation.setPassenger(savedPassenger);
	    reservation.setFlight(flight);
	    reservation.setCheckedIn(false);
	    LOGGER.info("Saving the reservation : " + reservation);
	    Reservation savedreservation = reservationRepository.save(reservation);
	    
	    String filePath = ITINERARY_DIR + savedreservation.getId() + ".pdf";
	    LOGGER.info("Generating the itinerary pdf");
	    pfdGeneratorUtil.generateItinerary(reservation, filePath );
	    LOGGER.info("Sending the itinerary email");
	    emailUtil.sendItinerary(passenger.getEmail(), filePath);
		return reservation;
	}

}
