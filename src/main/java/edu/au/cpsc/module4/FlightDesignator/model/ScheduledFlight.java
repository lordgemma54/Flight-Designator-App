package edu.au.cpsc.module4.FlightDesignator.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ScheduledFlight implements Serializable {

    private String flightDesignator;
    private String departureAirportIdent;
    private java.time.LocalDateTime departureTime;
    private String arrivalAirportIdent;
    private java.time.LocalDateTime arrivalTime;
    private HashSet<String> daysOfWeek;

    public static ScheduledFlight sf01;
    public static ScheduledFlight sf02;

    public static List<ScheduledFlight> demoFlights() {
        List<ScheduledFlight> flights = new ArrayList<>();
        sf01 = new ScheduledFlight("k3-256","KDEN",
                LocalDateTime.of(2025, 9, 12, 9, 15), "SYR",
                LocalDateTime.of(2025, 9, 12, 11, 30));

        sf02 = new ScheduledFlight("pp-49", "KLAX",
                (LocalDateTime.of(2025, 9, 12, 10, 45)),"BLR",
                LocalDateTime.of(2025, 9, 14, 2,25 ));

        flights.add(sf01);
        flights.add(sf02);
        return flights;
    }

    public ScheduledFlight(String flightDesignator, String depAirport, LocalDateTime depTime, String arrAirport, LocalDateTime arrTime ) {
        setFlightDesignator(flightDesignator);
        setDepartureAirportIdent(depAirport);
        setDepartureTime(depTime);
        setArrivalAirportIdent(arrAirport);
        setArrivalTime(arrTime);
    }
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

    @Override
    public String toString() {
        return "ScheduledFlight{" +
                "flightDesignator='" + flightDesignator + '\'' +
                ", departureAirportIdent='" + departureAirportIdent + '\'' +
                ", departureTime=" + departureTime +
                ", arrivalAirportIdent='" + arrivalAirportIdent + '\'' +
                ", arrivalTime=" + arrivalTime +
                ", daysOfWeek=" + daysOfWeek +
                '}';
    }
}
