package com.clarence.fightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.clarence.fightreservation.entities.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
