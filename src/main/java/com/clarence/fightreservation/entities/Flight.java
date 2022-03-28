package com.clarence.fightreservation.entities;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Flight extends AbstractEntity{
	
	@Column(name = "FLIGHT_NUMBER")
	private String fightNumer;
	
	@Column(name = "OPERATING_AIRLINES")
	private String operatingAirlines;
	
	@Column(name = "DEPARTURE_CITY")
	private String departureCity;
	
	@Column(name = "ARRIVAL_CITY")
	private String arrivalCity;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	
	@Column(name = "DATE_OF_DEPARTURE")
	private Date  dateOfDeparture;
	
	@Column(name = "ESTIMATED_DEPARTURE_TIME")
	private Timestamp estimatedDepartureTime;
	
	public String getFightNumer() {
		return fightNumer;
	}
	public void setFightNumer(String fightNumer) {
		this.fightNumer = fightNumer;
	}
	public String getOperatingAirlines() {
		return operatingAirlines;
	}
	public void setOperatingAirlines(String operatingAirlines) {
		this.operatingAirlines = operatingAirlines;
	}
	public String getDepartureCity() {
		return departureCity;
	}
	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}
	public String getArrivalCity() {
		return arrivalCity;
	}
	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}
	public Date getDateOfDeparture() {
		return dateOfDeparture;
	}
	public void setDateOfDeparture(Date dateOfDeparture) {
		this.dateOfDeparture = dateOfDeparture;
	}
	public Timestamp getEstimatedDepartureTime() {
		return estimatedDepartureTime;
	}
	public void setEstimatedDepartureTime(Timestamp estimatedDepartureTime) {
		this.estimatedDepartureTime = estimatedDepartureTime;
	}
	
	@Override
	public String toString() {
		return "Flight [fightNumer=" + fightNumer + ", operatingAirlines=" + operatingAirlines + ", departureCity="
				+ departureCity + ", arrivalCity=" + arrivalCity + ", dateOfDeparture=" + dateOfDeparture
				+ ", estimatedDepartureTime=" + estimatedDepartureTime + "]";
	}
	
}
