package com.clarence.fightreservation.services;

import com.clarence.fightreservation.dtto.ReservationRequest;
import com.clarence.fightreservation.entities.Reservation;

public interface ReservationService {
	 
	public Reservation bookFlight(ReservationRequest reservationRequest);

}
