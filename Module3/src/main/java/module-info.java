module edu.au.cpsc.airportApplication {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;


    opens module3 to javafx.fxml;
    exports module3;
}