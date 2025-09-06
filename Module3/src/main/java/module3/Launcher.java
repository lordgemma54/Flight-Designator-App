package module3;

import java.io.IOException;
import java.util.List;

public class Launcher {
    public static void main(String[] args) {
//        Application.launch(AirportApplication.class, args);
        try {
            Airport airportTest = new Airport();
            List<Airport> test = airportTest.readAll();

            for(Airport ap : test) {
                System.out.println(ap);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

