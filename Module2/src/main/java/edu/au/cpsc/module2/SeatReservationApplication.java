package edu.au.cpsc.module2;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class SeatReservationApplication extends Application {
    SeatReservation seatReservation;
    TextField fltDesignator;
    DatePicker fltDate;
    TextField fName;
    TextField lName;
    TextField numBags;
    TextField numPassengers;
    CheckBox withInfant;
    CheckBox travelInsurance;
    @Override
    public void start(Stage stage) throws IOException {

        seatReservation = new SeatReservation();

//        ------------default values ---------------
        seatReservation.setFlightDesignator("Flight");
        seatReservation.setFlightDate(LocalDate.now());
        seatReservation.setFirstName("First Name");
        seatReservation.setLastName("Last Name");
        seatReservation.setNumberOfBags(0);
        seatReservation.makeNotFlyingWithInfant();
        seatReservation.makeFlyingWithTravelInsurance();

        GridPane gridPane = new GridPane();
        BorderPane root = new BorderPane();
        HBox bottomButtons = new HBox();

        Label flightDesignator = new Label("Flight designator:");
        gridPane.add(flightDesignator, 0, 0);
        fltDesignator = new TextField();
        gridPane.add(fltDesignator, 1, 0);

        Label flightDate = new Label("Flight date");
        gridPane.add(flightDate, 0, 1);
        fltDate = new DatePicker();
        gridPane.add(fltDate, 1, 1);

        Label firstName = new Label("First name");
        gridPane.add(firstName, 0, 2);
        fName = new TextField();
        gridPane.add(fName, 1, 2);

        Label lastName = new Label("Last name");
        gridPane.add(lastName, 0, 3);
        lName = new TextField();
        gridPane.add(lName, 1, 3);

        Label bags = new Label("Bags");
        gridPane.add(bags, 0, 4);
        numBags = new TextField();
        gridPane.add(numBags, 1, 4);

        Label flyingWithInfant = new Label("Flying with infant?");
        gridPane.add(flyingWithInfant, 0, 5);
        withInfant = new CheckBox();
        withInfant.setOnAction(new CheckBoxHandler());
        gridPane.add(withInfant, 1, 5);

        Label numberOfPassengers = new Label("Number of passengers:");
        gridPane.add(numberOfPassengers, 0, 6);
        numPassengers = new TextField("0");
        numPassengers.setEditable(false);
        numPassengers.setText("1");
        gridPane.add(numPassengers, 1, 6);

        Label flyingWithTravelInsurance = new Label("Flying with travel insurance");
        gridPane.add(flyingWithTravelInsurance, 0, 7);
        travelInsurance = new CheckBox();
        gridPane.add(travelInsurance, 1, 7);

        Button save = new Button("Save");
        save.setOnAction(new SaveButtonClickHandler());

        Button cancel = new Button("Cancel");
        cancel.setOnAction(new CancelButtonClickHandler());

        bottomButtons.getChildren().addAll(save, cancel);
        bottomButtons.setAlignment( Pos.BOTTOM_CENTER);

        root.setCenter(gridPane);
        root.setBottom(bottomButtons);

        root.setPadding(new Insets(10, 10, 10, 10));
        bottomButtons.setPadding(new Insets(10,10,10,10));


        Scene scene = new Scene(root);
        stage.setTitle("Rahul Venkatesh's Seat Reservation App");
        stage.setScene(scene);

        updateUI();
        stage.show();
    }

    private void setInstanceFields() throws IllegalArgumentException{

        if(fltDesignator.getText().isEmpty()) {
            throw new IllegalArgumentException("Please enter a flight code");
        }
        if (fltDesignator.getText().length() < 4 || fltDesignator.getText().length() > 6) {
            throw new IllegalArgumentException("Flight Codes must be between 4 and 6 characters in length!");
        }
        if(fName.getText().isEmpty()) {
            throw new IllegalArgumentException("Please enter a first name");
        }
        if(lName.getText().isEmpty()) {
            throw new IllegalArgumentException("Please enter a last name");
        }
        if(numBags.getText().isEmpty() || Integer.parseInt(numBags.getText()) < 0) {
            throw new IllegalArgumentException("Please enter a valid number of bags");
        }

        seatReservation.setFlightDesignator(fltDesignator.getText());
        seatReservation.setFlightDate(fltDate.getValue());
        seatReservation.setFirstName(fName.getText());
        seatReservation.setLastName(lName.getText());
        seatReservation.setNumberOfBags(Integer.parseInt(numBags.getText()));

        if(withInfant.isSelected()) {
            seatReservation.makeFlyingWithInfant();
        }else {
            seatReservation.makeNotFlyingWithInfant();
        }

        if(travelInsurance.isSelected()) {
            seatReservation.makeFlyingWithTravelInsurance();
        }else {
            seatReservation.makeNotFlyingWithTravelInsurance();
        }
    }

    private void updateUI() {
        fltDesignator.setText(seatReservation.getFlightDesignator());
        fltDate.setValue(seatReservation.getFlightDate());
        fName.setText(seatReservation.getFirstName());
        lName.setText(seatReservation.getLastName());
        numBags.setText(String.valueOf(seatReservation.getNumberOfBags()));
    }

    class CheckBoxHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            if (withInfant.isSelected()){
                numPassengers.setText("2");
            } else {
                numPassengers.setText("1");
            }
        }
    }

    class SaveButtonClickHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
           try {
               setInstanceFields();
               System.out.println(seatReservation.toString());
               Platform.exit();
           } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
           }
        }
    }

    class CancelButtonClickHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            System.out.println("Cancel clicked");
            Platform.exit();
        }
    }
}
