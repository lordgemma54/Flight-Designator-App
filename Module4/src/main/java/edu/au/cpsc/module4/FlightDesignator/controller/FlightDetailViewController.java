package edu.au.cpsc.module4.FlightDesignator.controller;

import edu.au.cpsc.module4.FlightDesignator.model.ScheduledFlight;
import javafx.event.Event;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.GridPane;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashSet;

public class FlightDetailViewController {

    @FXML
    public GridPane flightDetailView;

    @FXML
    private TextField flightDesignator, departureAirportIdent, arrivalAirportIdent, arrivalTime, departureTime;

    @FXML
    private ToggleButton sunToggleButton, monToggleButton, tueToggleButton, wedToggleButton, thuToggleButton, friToggleButton, satToggleButton;

    @FXML
    private TableView<ScheduledFlight> flights;

    public static final DateTimeFormatter dtFmt = DateTimeFormatter.ofPattern("HH:mm");

    private HashSet<String> days = new HashSet<>();


    public void showFlight(ScheduledFlight selectedFlight) {
//
        if (selectedFlight == null) {
            flightDesignator.clear();
            departureAirportIdent.clear();
            arrivalAirportIdent.clear();
            arrivalTime.clear();
            departureTime.clear();

            sunToggleButton.setSelected(false);
            monToggleButton.setSelected(false);
            tueToggleButton.setSelected(false);
            wedToggleButton.setSelected(false);
            thuToggleButton.setSelected(false);
            friToggleButton.setSelected(false);
            satToggleButton.setSelected(false);

            return;
        }
        flightDesignator.setText(selectedFlight.getFlightDesignator());
        departureAirportIdent.setText(selectedFlight.getDepartureAirportIdent());
        arrivalAirportIdent.setText(selectedFlight.getArrivalAirportIdent());

        arrivalTime.setText(selectedFlight.getArrivalTime().format(dtFmt));
        departureTime.setText(selectedFlight.getDepartureTime().format(dtFmt));

        updateToggleButtons(selectedFlight.getDaysOfWeek());
    }

    private void updateToggleButtons(HashSet<String> days) {
        sunToggleButton.setSelected(days.contains("U"));
        monToggleButton.setSelected(days.contains("M"));
        tueToggleButton.setSelected(days.contains("T"));
        wedToggleButton.setSelected(days.contains("W"));
        thuToggleButton.setSelected(days.contains("R"));
        friToggleButton.setSelected(days.contains("F"));
        satToggleButton.setSelected(days.contains("S"));

    }

    public void updateFlight(ScheduledFlight scheduledFlight) {
        scheduledFlight.setFlightDesignator(flightDesignator.getText());
        scheduledFlight.setDepartureAirportIdent(departureAirportIdent.getText());
        scheduledFlight.setArrivalAirportIdent(arrivalAirportIdent.getText());

        String departureTimeString = departureTime.getText();
        String arrivalTimeString = arrivalTime.getText();

       try {
           if (departureTimeString != null && !departureTimeString.trim().isEmpty()) {
               scheduledFlight.setDepartureTime(LocalTime.parse(departureTimeString, dtFmt));
           }
           if (arrivalTimeString != null && !arrivalTimeString.trim().isEmpty()) {
               scheduledFlight.setArrivalTime(LocalTime.parse(arrivalTimeString, dtFmt));
           }
       }catch (DateTimeParseException e) {
        departureTime.setText("invalid time format");
       }

//        HashSet<String> selectedDaysValidation = new HashSet<>(getSelectedDays());
//        if(!selectedDaysValidation.isEmpty()) {
//            scheduledFlight.setDaysOfWeek(getSelectedDays());
//        }
        HashSet<String> updatedDays = new HashSet<>();
        if (sunToggleButton.isSelected()) updatedDays.add("U");
        if (monToggleButton.isSelected()) updatedDays.add("M");
        if (tueToggleButton.isSelected()) updatedDays.add("T");
        if (wedToggleButton.isSelected()) updatedDays.add("W");
        if (thuToggleButton.isSelected()) updatedDays.add("R");
        if (friToggleButton.isSelected()) updatedDays.add("F");
        if (satToggleButton.isSelected()) updatedDays.add("S");

        scheduledFlight.setDaysOfWeek(updatedDays);
    }

    @FXML
    protected void sunButtonAction() {
        if(sunToggleButton.isSelected()) {
            days.add("U");
        } else {
            days.remove("U");
        }
    }

    @FXML
    protected void monButtonAction() {
        if(monToggleButton.isSelected()) {
            days.add("M");
        } else {
            days.remove("M");
        }
    }

    @FXML
    protected void tueButtonAction() {
        if(tueToggleButton.isSelected()) {
            days.add("T");
        } else {
            days.remove("T");
        }
    }

    @FXML
    protected void wedButtonAction() {
        if(wedToggleButton.isSelected()) {
            days.add("W");
        } else {
            days.remove("W");
        }
    }

    @FXML
    protected void thuButtonAction() {
        if(thuToggleButton.isSelected()) {
            days.add("R");
        } else {
            days.remove("R");
        }
    }

    @FXML
    protected void friButtonAction() {
        if(friToggleButton.isSelected()) {
            days.add("F");
        } else {
            days.remove("F");
        }
    }

    @FXML
    protected void satButtonAction() {
        if(satToggleButton.isSelected()) {
            days.add("S");
        } else {
            days.remove("S");
        }
    }

    private HashSet<String> getSelectedDays(){
        return days;
    }
//    private void toggleButtonPressed() {
//        ScheduledFlight selectedFlight = flightDetailView.getSelectionModel().getSelectedItem();
//        FlightDetailEvent event = new FlightDetailEvent(FlightDetailEvent.TOGGLE_BUTTON_PRESSED,
//                selectedFlight);
//        //TODO fire an event here
//    }

    public static class FlightDetailEvent extends Event {
        public static final EventType<FlightDetailViewController.FlightDetailEvent> ANY = new EventType<>(Event.ANY, "ANY");

        public static final EventType<FlightDetailViewController.FlightDetailEvent> TOGGLE_BUTTON_PRESSED = new EventType<>(ANY, "TOGGLE_BUTTON_PRESSED");

        private ScheduledFlight selectedFlight;

        public FlightDetailEvent(EventType<? extends Event> eventType, ScheduledFlight selectedFlight) {
            super(eventType);
            this.selectedFlight = selectedFlight;
        }

        public ScheduledFlight getScheduledFlight() {
            return selectedFlight;
        }
    }
}
