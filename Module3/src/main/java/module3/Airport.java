package module3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
 * Module 3 - Airport Application
 * Rahul Venkatesh
 * rzv0040@auburn.edu
 * 9/3/2025
 * App that displays Airport location and weather information
 * */
public class Airport {

    private String ident;
    private String type;
    private String name;
    private Integer elevationFt;
    private String continent;
    private String isoCountry;
    private String isoRegion;
    private String municipality;
    private String gpsCode;
    private String localCode;
    private String iataCode;
    private double coordinatesLat;
    private double coordinatesLong;





    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getIdent() {
        return ident;
    }

    public void setIdent(String ident) {
        this.ident = ident;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getElevationFt() {
        return elevationFt;
    }

    public void setElevationFt(Integer elevationFt) {
        this.elevationFt = elevationFt;
    }

    public String getIsoCountry() {
        return isoCountry;
    }

    public void setIsoCountry(String isoCountry) {
        this.isoCountry = isoCountry;
    }

    public String getIsoRegion() {
        return isoRegion;
    }

    public void setIsoRegion(String isoRegion) {
        this.isoRegion = isoRegion;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public String getGpsCode() {
        return gpsCode;
    }

    public void setGpsCode(String gpsCode) {
        this.gpsCode = gpsCode;
    }

    public String getLocalCode() {
        return localCode;
    }

    public void setLocalCode(String localCode) {
        this.localCode = localCode;
    }

    public String getIataCode() {
        return iataCode;
    }

    public void setIataCode(String iataCode) {
        this.iataCode = iataCode;
    }

    public double getCoordinatesLat() {
        return coordinatesLat;
    }

    public void setCoordinatesLat(double coordinatesLat) {
        this.coordinatesLat = coordinatesLat;
    }

    public double getCoordinatesLong() {
        return coordinatesLong;
    }

    public void setCoordinatesLong(double coordinatesLong) {
        this.coordinatesLong = coordinatesLong;
    }

  public static List<Airport> readAll() throws IOException {
     List<Airport> airportList = new ArrayList<>();

    try (InputStream inputStream = Airport.class.getResourceAsStream("/airport-codes.csv");
    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {

        String header = reader.readLine();


        String line;
        while((line = reader.readLine()) != null) {
            String [] columns = line.split(",", -1);

            if(columns.length >= 13) {
                Airport airport = new Airport();

                airport.setIdent(columns[0].trim());
                airport.setType(columns[1].trim());
                airport.setName(columns[2].trim());

                if(!columns[3].trim().isEmpty()) {
                    airport.setElevationFt(Integer.parseInt(columns[3].trim()));
                }else {
                    airport.setElevationFt(0);
                }
                airport.setContinent(columns[4].trim());
                airport.setIsoCountry(columns[5].trim());
                airport.setIsoRegion(columns[6].trim());
                airport.setMunicipality(columns[7].trim());
                airport.setGpsCode(columns[8].trim());
                airport.setIataCode(columns[9].trim());
                airport.setLocalCode(columns[10].trim());

                if(!columns[11].trim().isEmpty()) {
                    airport.setCoordinatesLat(Double.parseDouble(columns[11].trim()));
                }

                if(!columns[12].trim().isEmpty()) {
                    airport.setCoordinatesLat(Double.parseDouble(columns[12].trim()));
                }
                airportList.add(airport);
            }

        }
    }
    return airportList;
  }
  @Override
    public String toString() {
        return "[ident= " + getIdent() + "/type= " + getType() + "/name= " + getName()
            + "/elevationFt=" + getElevationFt() + "/continent= " + getContinent() + "/isoCountry= " + getIsoCountry()
                + "/isoRegion= " + getIsoRegion() + "/municipality= " + getMunicipality() + "/gpsCode= " + getGpsCode()
                + "/iataCode= " + getIataCode() + "/localCode= " + getLocalCode() + "/coordinates= " + getCoordinatesLat()
                + "/" + getCoordinatesLong() + "]";
     }
}
