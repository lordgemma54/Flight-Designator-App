package edu.au.cpsc.module4.FlightDesignator.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;

public class ScheduledFlight implements Serializable {
    private String flightDesignator;
    private String departureAirportIdent;
    private java.time.LocalDateTime departureTime;
    private String arrivalAirportIdent;
    private java.time.LocalDateTime arrivalTime;
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

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
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

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        if( arrivalTime == null) {
            throw new IllegalArgumentException();
        }
        this.arrivalTime = arrivalTime;
    }

    public HashSet<String> getDaysOfWeek() {
        return daysOfWeek;
    }

    public void setDaysOfWeek(List<String> daysOfWeek) {
        if( daysOfWeek == null) {
            throw new IllegalArgumentException();
        }
        this.daysOfWeek = new HashSet<>(daysOfWeek);
    }
}
