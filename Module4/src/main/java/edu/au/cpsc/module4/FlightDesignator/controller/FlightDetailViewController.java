package edu.au.cpsc.module4.FlightDesignator.controller;

import edu.au.cpsc.module4.FlightDesignator.model.ScheduledFlight;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FlightDetailViewController {

    @FXML
    public GridPane flightDetailView;

    @FXML
    private TextField flightDesignator, departureAirportIdent, arrivalAirportIdent, arrivalTime, departureTime;

    @FXML
    private TableView<ScheduledFlight> flights;

    public void showFlight(ScheduledFlight selectedFlight){

        if(selectedFlight == null) {
           flightDesignator.clear();
            departureAirportIdent.clear();
            arrivalAirportIdent.clear();
            arrivalTime.clear();
            departureTime.clear();
            return;
        }
        flightDesignator.setText(selectedFlight.getFlightDesignator());
        departureAirportIdent.setText(selectedFlight.getDepartureAirportIdent());
        arrivalAirportIdent.setText(selectedFlight.getArrivalAirportIdent());

        DateTimeFormatter dtFmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        arrivalTime.setText(selectedFlight.getArrivalTime().format(dtFmt));
        departureTime.setText(selectedFlight.getDepartureTime().format(dtFmt));
    }

    public void updateFlight(ScheduledFlight scheduledFlight) {
        scheduledFlight.setFlightDesignator(flightDesignator.getText());
        scheduledFlight.setDepartureAirportIdent(departureAirportIdent.getText());
        scheduledFlight.setArrivalAirportIdent(arrivalAirportIdent.getText());
        scheduledFlight.setDepartureTime(LocalDateTime.parse(departureTime.getText()));
        scheduledFlight.setArrivalTime(LocalDateTime.parse(arrivalTime.getText()));
    }
}
