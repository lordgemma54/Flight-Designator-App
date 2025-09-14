module edu.au.cpsc.module4.FlightDesignator {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
//    requires edu.au.cpsc.module4.FlightDesignator;


    opens edu.au.cpsc.module4.FlightDesignator to javafx.fxml;
    exports edu.au.cpsc.module4.FlightDesignator;
    exports edu.au.cpsc.module4.FlightDesignator.controller;
    opens edu.au.cpsc.module4.FlightDesignator.controller to javafx.fxml;
    exports edu.au.cpsc.module4.FlightDesignator.model;
    opens edu.au.cpsc.module4.FlightDesignator.model to javafx.fxml;
}