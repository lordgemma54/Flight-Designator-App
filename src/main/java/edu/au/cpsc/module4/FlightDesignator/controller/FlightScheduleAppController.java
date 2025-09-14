package edu.au.cpsc.module4.FlightDesignator.controller;

import edu.au.cpsc.module4.FlightDesignator.data.Db;
import javafx.fxml.FXML;

public class FlightScheduleAppController {

    @FXML
    private FlightTableViewController flightTableViewController;

    @FXML
    private FlightDetailViewController flightDetailViewController;

    @FXML
    public void initialize() {
        flightTableViewController.showFlights(Db.getDatabase().getScheduledFlights());
        flightTableViewController.onFlightSelectionChanged(
                event -> flightDetailViewController.showFlight(event.getScheduledFlight()));
//        flightTableViewController.setDetailViewController(flightDetailViewController);

//    flightTableView.addEventHandler(FlightTableViewController.FlightTableEvent.FLIGHT_SELECTED,
//            event -> flightDetailViewController.showFlight(event.getScheduledFlight()));
    }
}
