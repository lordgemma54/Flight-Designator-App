package edu.au.cpsc.module4.FlightDesignator.controller;

import javafx.fxml.FXML;

public class MainController {
    @FXML
    private FlightTableViewController flightTableViewController;

    @FXML
    private FlightDetailViewController flightDetailViewController;

    @FXML
    public void initialize() {
        flightTableViewController.setDetailViewController(flightDetailViewController);
    }
}
