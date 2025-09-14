package edu.au.cpsc.module4.FlightDesignator.sampledata;

import edu.au.cpsc.module4.FlightDesignator.data.AirlineDatabase;
import edu.au.cpsc.module4.FlightDesignator.data.Db;
import edu.au.cpsc.module4.FlightDesignator.model.ScheduledFlight;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;

public class FlightGenerator {
    public static void main(String[] args) {
        AirlineDatabase db = new AirlineDatabase();
        Db.saveDatabase();

        ScheduledFlight sf01 = new ScheduledFlight("k3-256","KDEN",
                LocalTime.of( 9, 15), "SYR",
                LocalTime.of(11, 30), new HashSet<String>(List.of("M", "W", "F")));

        ScheduledFlight sf02 = new ScheduledFlight("pp-49", "KLAX",
                (LocalTime.of( 10, 45)),"BLR",
                LocalTime.of( 2,25 ), new HashSet<String>(List.of("U", "T", "R")));

        Db.getDatabase().addScheduledFlight(sf01);
        Db.getDatabase().addScheduledFlight(sf02);

        Db.saveDatabase();
    }
}
