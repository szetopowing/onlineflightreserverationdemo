package com.clarence.fightreservation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clarence.fightreservation.dtto.ReservationUpdateRequest;
import com.clarence.fightreservation.entities.Reservation;
import com.clarence.fightreservation.repos.ReservationRepository;

@RestController
@CrossOrigin
public class ReservationRestController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationRestController.class);
	
	@Autowired
	ReservationRepository reservationRepository;
	
	@RequestMapping("/reservations/{id}")
	public Reservation findReservation(@PathVariable("id") Long id) {
		LOGGER.info("inside findReservation for id = " + id);
		return reservationRepository.findById(id).get();
	}
	
	@RequestMapping("/reservations")
	public Reservation updateReservation(@RequestBody ReservationUpdateRequest reservationUpdateRequest){
		LOGGER.info("inside updateReservation for request = " + reservationUpdateRequest);
		Reservation reservation = reservationRepository.getById(reservationUpdateRequest.getId());
		reservation.setCheckedIn(reservationUpdateRequest.getCheckedIn());
		reservation.setNumberofBags(reservationUpdateRequest.getNumberOfBags());
		LOGGER.info("Saving Reservation");
		return reservationRepository.save(reservation);
	}
 
}
