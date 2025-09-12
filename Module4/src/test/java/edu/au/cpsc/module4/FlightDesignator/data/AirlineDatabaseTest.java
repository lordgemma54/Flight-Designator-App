package edu.au.cpsc.module4.FlightDesignator.data;

import edu.au.cpsc.module4.FlightDesignator.model.ScheduledFlight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AirlineDatabaseTest {
    AirlineDatabase airlineDatabase;
    ScheduledFlight sf1;
    ScheduledFlight sf2;



    @BeforeEach
    void setup(){
        airlineDatabase = new AirlineDatabase();

        sf1 = new ScheduledFlight();
        sf1.setFlightDesignator("k3-256");
        sf1.setDepartureAirportIdent("KDEN");
        sf1.setDepartureTime(LocalDateTime.of(2025, 9, 12, 9, 15));
        sf1.setArrivalAirportIdent("SYR");
        sf1.setDaysOfWeek(Arrays.asList("Sunday", "Tuesday", "Friday"));

        sf2 = new ScheduledFlight();
        sf2.setFlightDesignator("pp-49");
        sf2.setDepartureAirportIdent("KLAX");
        sf2.setDepartureTime(LocalDateTime.of(2025, 9, 12, 9, 15));
        sf2.setArrivalAirportIdent("BLR");
        sf2.setDaysOfWeek(Arrays.asList("Monday", "Thursday"));

        airlineDatabase.addScheduledFlight(sf1);
        airlineDatabase.addScheduledFlight(sf2);



    }
    @Test
    void addFlightToDatabase(){
        assertEquals(2,airlineDatabase.getScheduledFlights().size());
    }

    @Test
    void removeFlightFromDatabase(){
        airlineDatabase.removeScheduledFlight(sf1);
        assertEquals(1, airlineDatabase.getScheduledFlights().size());
    }

    @Test
    void flightContainedInDatabase(){
        assertTrue(airlineDatabase.getScheduledFlights().contains(sf1));
    }
}