public class SeatReservation {
    private String flightDesignator;
    private java.time.localDate flightDate;
    private String firstName;
    private String lastName;

    public String getFlightDesignator() {
        return flightDesignator;
    }

    public void setFlightDesignator(String fd) {
        flightDesignator = fd;
    }

    public java.time.localDate getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(java.time.localDate date) {
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

    public String toString() {
        

    }
}