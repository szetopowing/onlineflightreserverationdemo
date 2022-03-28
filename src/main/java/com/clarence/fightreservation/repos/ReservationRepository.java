package com.clarence.fightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.clarence.fightreservation.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
