package com.clarence.fightreservation.entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Reservation extends AbstractEntity{
	
	@Column(name = "CHECKED_IN")
	private Boolean checkedIn;
	
	@Column(name = "NUMBER_OF_BAGS")
	private int numberofBags;
	
	@OneToOne
	private Passenger passenger;
	@OneToOne
	private Flight flight;
	
	@Column(name = "CREATED")
	private Timestamp created;
	
	public Boolean getCheckedIn() {
		return checkedIn;
	}
	public void setCheckedIn(Boolean checkedIn) {
		this.checkedIn = checkedIn;
	}
	public int getNumberofBags() {
		return numberofBags;
	}
	public void setNumberofBags(int numberofBags) {
		this.numberofBags = numberofBags;
	}
	public Passenger getPassenger() {
		return passenger;
	}
	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	public Timestamp getCreated() {
		return created;
	}
	public void setCreated(Timestamp created) {
		this.created = created;
	}
	
	@Override
	public String toString() {
		return "Reservation [checkedIn=" + checkedIn + ", numberofBags=" + numberofBags + ", passenger=" + passenger
				+ ", flight=" + flight + ", created=" + created + "]";
	}
	
}
