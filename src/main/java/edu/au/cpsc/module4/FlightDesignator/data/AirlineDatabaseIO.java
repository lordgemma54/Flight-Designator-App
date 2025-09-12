package edu.au.cpsc.module4.FlightDesignator.data;

import java.io.*;

public class AirlineDatabaseIO {
    public static final File DEFAULT_FILE = new File ("Flights.dat");

    public static void save(AirlineDatabase database, OutputStream stream) throws IOException {
        ObjectOutputStream outStream = new ObjectOutputStream(stream);
        outStream.writeObject(database);
    }

    public static AirlineDatabase load(InputStream stream) throws IOException, ClassNotFoundException {
        ObjectInputStream inStream = new ObjectInputStream(stream);
        return (AirlineDatabase) inStream.readObject();
    }
}
