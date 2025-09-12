package edu.au.cpsc.module4.FlightDesignator.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class FlightDetailViewController {

    @FXML
    private TextField flightDesignator, departureAirportIdent, arrivalAirportIdent, arrivalTime, departureTime;

    @FXML
    private TableView<ScheduledFlights> flights;
}
