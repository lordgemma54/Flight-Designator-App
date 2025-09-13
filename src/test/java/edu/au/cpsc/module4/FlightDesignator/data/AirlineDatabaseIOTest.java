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
        ScheduledFlight sf1 = new ScheduledFlight("k3-256","KDEN",
                LocalDateTime.of(2025, 9, 12, 9, 15), "SYR",
                LocalDateTime.of(2025, 9, 12, 11, 30));

        sf1.setDaysOfWeek(Arrays.asList("Sunday", "Tuesday", "Friday"));

        ScheduledFlight sf2 = new ScheduledFlight("pp-49", "KLAX",
                (LocalDateTime.of(2025, 9, 12, 10, 45)),"BLR",
                LocalDateTime.of(2025, 9, 14, 2,25 ));

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