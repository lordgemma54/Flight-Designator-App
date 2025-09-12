package edu.au.cpsc.module4.FlightDesignator.data;

import edu.au.cpsc.module4.FlightDesignator.model.ScheduledFlight;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AirlineDatabaseIOTest {
    @Test
    void writeToDatabaseTest() throws IOException, ClassNotFoundException {
        AirlineDatabase database = new AirlineDatabase();
        ScheduledFlight sf1 = new ScheduledFlight();
        sf1.setFlightDesignator("k3-256");
        sf1.setDepartureAirportIdent("KDEN");
        sf1.setDepartureTime(LocalDateTime.of(2025, 9, 12, 9, 15));
        sf1.setArrivalAirportIdent("SYR");
        sf1.setDaysOfWeek(Arrays.asList("Sunday", "Tuesday", "Friday"));

        ScheduledFlight sf2 = new ScheduledFlight();
        sf2.setFlightDesignator("pp-49");
        sf2.setDepartureAirportIdent("KLAX");
        sf2.setDepartureTime(LocalDateTime.of(2025, 9, 12, 9, 15));
        sf2.setArrivalAirportIdent("BLR");
        sf2.setDaysOfWeek(Arrays.asList("Monday", "Thursday"));

        database.addScheduledFlight(sf1);
        database.addScheduledFlight(sf2);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        AirlineDatabaseIO.save(database, out);

        ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
        AirlineDatabase databaseFromStream = AirlineDatabaseIO.load(in);

        assertEquals(2, databaseFromStream.getScheduledFlights().size());

    }
}