public class SeatReservation {
   
   private String flightDesignator;
   private java.time.LocalDate flightDate;
   private String firstName = null;
   private String lastName = null;

   public String getFlightDesignator() {
      return flightDesignator;
   }

   public void setFlightDesignator(String fd) {
      if (fd.length() < 4 || fd.length() >6) {
         throw new IllegalArgumentException();
      }
      flightDesignator = fd;
     
   }

   public java.time.LocalDate getFlightDate() {
      return flightDate;
   }

   public void setFlightDate(java.time.LocalDate date) {
      flightDate = date;
   } 

   public String getFirstName() {
      return firstName;
   }

   public void setFirstName(String fn) {
      firstName = fn;
   }

   public String getLastName() {
      return lastName;
   }

   public void setLastName(String ln) {
      lastName = ln;
   }

   @Override
   public String toString() {
      return "Seat Reservation {flightDesignator=" + flightDesignator + 
             ", " + "flightDate=" + flightDate +
             ", " + "firstName=" + firstName + 
             ", " + "lastName=" + lastName + "}";
   }
}