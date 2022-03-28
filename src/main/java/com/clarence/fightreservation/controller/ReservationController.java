package com.clarence.fightreservation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.clarence.fightreservation.dtto.ReservationRequest;
import com.clarence.fightreservation.entities.Flight;
import com.clarence.fightreservation.entities.Reservation;
import com.clarence.fightreservation.repos.FlightRepository;
import com.clarence.fightreservation.services.ReservationService;

@Controller
public class ReservationController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Reservation.class);

	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	ReservationService reservationService;
	
	@RequestMapping("/showCompleteReservation")
	public String showCompleteReservation(@RequestParam("flightId") Long flightId, ModelMap modelMap) {
		LOGGER.info("inside showCompleteReservation , flight id:" + flightId);
		Flight flight = flightRepository.findById(flightId).get();
		modelMap.addAttribute("flight", flight);
		return "completeReservation";
	}
	
	@RequestMapping("/reservationConfirmation")
	public String reservationConfirmation() {
		return null;
	}
	
	@PostMapping(value="/completeReservation")
	public String completeReservation(ReservationRequest reservationRequest, ModelMap modelMap) {
		LOGGER.info("inside completeReservation , reservationRequest:" + reservationRequest);
		Reservation reservation = reservationService.bookFlight(reservationRequest);
		modelMap.addAttribute("msg", "Reservation created successfully and the id is " + reservation.getId());
		return "reservationConfirmation";
	}
	
}
