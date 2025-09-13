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
        ScheduledFlight sf1 = new ScheduledFlight("k3-256","KDEN",
                LocalDateTime.of(2025, 9, 12, 9, 15), "SYR",
                LocalDateTime.of(2025, 9, 12, 11, 30));

        sf1.setDaysOfWeek(Arrays.asList("Sunday", "Tuesday", "Friday"));

        ScheduledFlight sf2 = new ScheduledFlight("pp-49", "KLAX",
                (LocalDateTime.of(2025, 9, 12, 10, 45)),"BLR",
                LocalDateTime.of(2025, 9, 14, 2,25 ));

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