package edu.au.cpsc.module4.FlightDesignator.controller;

import edu.au.cpsc.module4.FlightDesignator.model.ScheduledFlight;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class FlightDetailViewController {

    @FXML
    private TextField flightDesignator, departureAirportIdent, arrivalAirportIdent, arrivalTime, departureTime;

    @FXML
    private TableView<ScheduledFlight> flights;
}
