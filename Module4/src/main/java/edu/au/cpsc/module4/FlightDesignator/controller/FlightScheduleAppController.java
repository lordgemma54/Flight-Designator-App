package edu.au.cpsc.module4.FlightDesignator.controller;

import edu.au.cpsc.module4.FlightDesignator.data.Db;
import edu.au.cpsc.module4.FlightDesignator.model.ScheduledFlight;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;

public class FlightScheduleAppController {

    @FXML
    private FlightTableViewController flightTableViewController;

    @FXML
    private FlightDetailViewController flightDetailViewController;

    @FXML
    private Button updateButton;

    @FXML
    private Button newButton;

    @FXML
    private Button deleteButton;

    private ScheduledFlight flightBeingEdited;

    private boolean flightBeingEditedIsNew;

    @FXML
    public void initialize() {
        flightTableViewController.showFlights(Db.getDatabase().getScheduledFlights());

        flightTableViewController.onFlightSelectionChanged(
                event -> showSelectedFlight(event.getScheduledFlight()));
        showSelectedFlight(null);

//        flightTableViewController.setDetailViewController(flightDetailViewController);

//    flightTableView.addEventHandler(FlightTableViewController.FlightTableEvent.FLIGHT_SELECTED,
//            event -> flightDetailViewController.showFlight(event.getScheduledFlight()));
    }





    private void showSelectedFlight(ScheduledFlight selectedFlight) {
        LocalTime defaultTime = LocalTime.now();
        String formattedDefaultTime = defaultTime.format(FlightDetailViewController.dtFmt);
        flightDetailViewController.showFlight(selectedFlight);
        flightBeingEdited = selectedFlight == null ? new ScheduledFlight("", "", LocalTime.parse(formattedDefaultTime, FlightDetailViewController.dtFmt),"",
                LocalTime.parse(formattedDefaultTime, FlightDetailViewController.dtFmt),new HashSet<String>(List.of(""))) : selectedFlight;
        flightBeingEditedIsNew = selectedFlight == null;
        updateButton.setText(flightBeingEditedIsNew ? "Add" : "Update");
}

    @FXML
    protected void updateButtonAction() {
        flightDetailViewController.updateFlight(flightBeingEdited);

        if(flightBeingEditedIsNew) {
            Db.getDatabase().addScheduledFlight(flightBeingEdited);
        } else {
            flightDetailViewController.updateFlight(flightBeingEdited);
            Db.getDatabase().updateScheduledFlight(flightBeingEdited);
        }
        Db.saveDatabase();
        flightTableViewController.showFlights(Db.getDatabase().getScheduledFlights());
        flightTableViewController.select(flightBeingEdited);
    }

    @FXML
    protected void newButtonAction(){
       flightTableViewController.select(null);
    }

    @FXML
    protected void deleteButtonAction() {
        if(flightBeingEditedIsNew) {
            flightTableViewController.select(null);
        } else {
            Db.getDatabase().removeScheduledFlight(flightBeingEdited);
            Db.saveDatabase();
            flightTableViewController.showFlights(Db.getDatabase().getScheduledFlights());

        }
    }
}
