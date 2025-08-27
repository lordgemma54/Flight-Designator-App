/* Project: Module 2
* Author: Rahul Venaktesh
* Email: rzv0040@auburn.edu
* Date: 08-27-2025
* Description: Flight Reservation App
* */
package edu.au.cpsc.module2;
import java.lang.IllegalArgumentException;


public class SeatReservation {
   
   private String flightDesignator;
   private java.time.LocalDate flightDate;
   private String firstName = null;
   private String lastName = null;
   private int numberOfBags;
   private boolean flyingWithInfant;
   private boolean flyingWithTravelInsurance;

    //---------------Getters and Setters--------------

    //---------------FlightDesignator--------------

    public String getFlightDesignator() {
      return flightDesignator;
   }

   public void setFlightDesignator(String fd) {
      if (fd == null){
         throw new IllegalArgumentException("flight designator cannot be null");
      }
      if (fd.length() < 4 || fd.length() >6) {
         throw new IllegalArgumentException();
      }
      this.flightDesignator = fd;
   }

   //---------------Infant--------------
    public boolean isFlyingWithInfant() {
        return flyingWithInfant;
    }

    public void makeFlyingWithInfant() {
        flyingWithInfant = true;
    }

    public void makeNotFlyingWithInfant() {
        flyingWithInfant = false;
    }
    //---------------Insurance--------------
    public boolean hasTravelInsurance() {
        return flyingWithTravelInsurance;
    }

    public void makeFlyingWithTravelInsurance() {
        flyingWithTravelInsurance = true;
    }

    public void makeNotFlyingWithTravelInsurance() {
        flyingWithTravelInsurance = false;
    }
    //---------------bags--------------

    public void setNumberOfBags(int numBags) {
       numberOfBags = numBags;
   }

   public int getNumberOfBags(){
       return numberOfBags;
   }

    //---------------Time--------------

    public void setFlightDate(java.time.LocalDate date) {
      flightDate = date;
   }

    public java.time.LocalDate getFlightDate() {
        return flightDate;
    }

    //---------------Names--------------
    public String getFirstName() {
      return firstName;
   }


   public void setFirstName(String fn) {
       if(fn.length() < 2 || fn.length() > 15) {
           throw new IllegalArgumentException();
       }
      firstName = fn;
   }


   public String getLastName() {
      return lastName;
   }


   public void setLastName(String ln) {
       if(ln.length() < 2 || ln.length() > 15) {
           throw new IllegalArgumentException();
       }
      lastName = ln;
   }

    //---------------ToString--------------

    @Override
   public String toString() {
      return "SeatReservation{flightDesignator=" + flightDesignator + 
             "," + "flightDate=" + flightDate +
             "," + "firstName=" + firstName + 
             "," + "lastName=" + lastName +
              "," + "numberOfBags=" + numberOfBags +
              "," + "flyingWithInfant=" + flyingWithInfant +
              "," + "flyingWithTravelInsurance=" + flyingWithTravelInsurance+ "}";
   }
}