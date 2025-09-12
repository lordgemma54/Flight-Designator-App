package edu.au.cpsc.module4.FlightDesignator.model;

import java.time.LocalDate;
import java.util.HashSet;

public class ScheduledFlight {
    private String flightDesignator;
    private String departureAirportIdent;
    private java.time.LocalDate departureTime;
    private String arrivalAirportIdent;
    private java.time.LocalDate arrivalTime;
    private HashSet<String> daysOfWeek;

    public String getFlightDesignator() {
        return flightDesignator;
    }

    public void setFlightDesignator(String flightDesignator) {
        if(flightDesignator == null) {
            throw new IllegalArgumentException();
        }
        this.flightDesignator = flightDesignator;
    }

    public String getDepartureAirportIdent() {
        return departureAirportIdent;
    }

    public void setDepartureAirportIdent(String departureAirportIdent) {
        if( departureAirportIdent == null) {
            throw new IllegalArgumentException();
        }
        this.departureAirportIdent = departureAirportIdent;
    }

    public LocalDate getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDate departureTime) {
        if( departureTime == null) {
            throw new IllegalArgumentException();
        }
        this.departureTime = departureTime;
    }

    public String getArrivalAirportIdent() {
        return arrivalAirportIdent;
    }

    public void setArrivalAirportIdent(String arrivalAirportIdent) {
        if( arrivalAirportIdent == null) {
            throw new IllegalArgumentException();
        }
        this.arrivalAirportIdent = arrivalAirportIdent;
    }

    public LocalDate getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDate arrivalTime) {
        if( arrivalTime == null) {
            throw new IllegalArgumentException();
        }
        this.arrivalTime = arrivalTime;
    }

    public HashSet<String> getDaysOfWeek() {
        return daysOfWeek;
    }

    public void setDaysOfWeek(HashSet<String> daysOfWeek) {
        if( daysOfWeek == null) {
            throw new IllegalArgumentException();
        }
        this.daysOfWeek = daysOfWeek;
    }
}
