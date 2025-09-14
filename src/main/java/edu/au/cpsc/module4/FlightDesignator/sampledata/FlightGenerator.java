package edu.au.cpsc.module4.FlightDesignator.sampledata;

import edu.au.cpsc.module4.FlightDesignator.data.Db;
import edu.au.cpsc.module4.FlightDesignator.model.ScheduledFlight;

import java.time.LocalDateTime;

public class FlightGenerator {
    public static void main(String[] args) {
        ScheduledFlight sf01 = new ScheduledFlight("k3-256","KDEN",
                LocalDateTime.of(2025, 9, 12, 9, 15), "SYR",
                LocalDateTime.of(2025, 9, 12, 11, 30));

        ScheduledFlight sf02 = new ScheduledFlight("pp-49", "KLAX",
                (LocalDateTime.of(2025, 9, 12, 10, 45)),"BLR",
                LocalDateTime.of(2025, 9, 14, 2,25 ));

        Db.getDatabase().addScheduledFlight(sf01);
        Db.getDatabase().addScheduledFlight(sf02);

        Db.saveDatabase();
    }
}
