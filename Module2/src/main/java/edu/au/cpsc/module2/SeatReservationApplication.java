package edu.au.cpsc.module2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class SeatReservationApplication extends Application {
//    SeatReservation seatReservation = new SeatReservation();

    @Override
    public void start(Stage stage) throws IOException {
//        seatReservation.setFlightDesignator("Kauai");
//        seatReservation.setFlightDate(LocalDate.of(2025, 8, 29));
//        seatReservation.setFirstName("Rahul");
//        seatReservation.setLastName("Venkatesh");
//        seatReservation.setNumberOfBags(2);
//        seatReservation.makeNotFlyingWithInfant();
//        seatReservation.makeFlyingWithTravelInsurance();


//      FXMLLoader fxmlLoader = new FXMLLoader(SeatReservationApplication.class.getResource("hello-view.fxml"));
        GridPane gridPane = new GridPane();
        VBox root = new VBox();
        HBox bottomButtons = new HBox();

        Label flightDesignator = new Label("Flight designator:");
        gridPane.add(flightDesignator, 0, 0);
//        flightDesignator.setFont(new Font("Arial", 14));
        TextField fltDesignator = new TextField();
        gridPane.add(fltDesignator, 1, 0);

        Label flightDate = new Label("Flight date");
        gridPane.add(flightDate, 0, 1);
        DatePicker fltDate = new DatePicker();
        gridPane.add(fltDate, 1, 1);

        Label firstName = new Label("First name");
        gridPane.add(firstName, 0, 2);
        TextField fName = new TextField();
        gridPane.add(fName, 1, 2);

        Label lastName = new Label("Last name");
        gridPane.add(lastName, 0, 3);
        TextField lName = new TextField();
        gridPane.add(lName, 1, 3);

        Label bags = new Label("Bags");
        gridPane.add(bags, 0, 4);
        TextField numBags = new TextField();
        gridPane.add(numBags, 1, 4);

        Label flyingWithInfant = new Label("Flying with infant?");
        gridPane.add(flyingWithInfant, 0, 5);
        CheckBox withInfant = new CheckBox();
        gridPane.add(withInfant, 1, 5);

        Label numberOfPassengers = new Label("Number of passengers:");
        gridPane.add(numberOfPassengers, 0, 6);
        TextField numPassengers = new TextField("0");
        gridPane.add(numPassengers, 1, 6);

        Label flyingWithTravelInsurance = new Label("Flying with travel insurance");
        gridPane.add(flyingWithTravelInsurance, 0, 7);
        CheckBox travelInsurance = new CheckBox();
        gridPane.add(travelInsurance, 1, 7);

        Button save = new Button("Save");
        Button cancel = new Button("Cancel");
        bottomButtons.getChildren().addAll(save, cancel);
        bottomButtons.setAlignment( Pos.BOTTOM_CENTER);

        root.getChildren().addAll(gridPane, bottomButtons);

        root.setPadding(new Insets(10, 10, 10, 10));
        bottomButtons.setPadding(new Insets(10,10,10,10));
        Scene scene = new Scene(root);
        stage.setTitle("Rahul Venkatesh's seat reservation App");
        stage.setScene(scene);
        stage.show();
    }
//    private void updateUI() {
//        fltDesignator.setText(seatReservation.getFlightDesignator());
//        fltDate.setText(seatReservation.getFlightDate());
//        fName.setText(seatReservation.getFirstName());
//        lName.setText(seatReservation.getLastName());
//        numBags.setText(seatReservation.getNumberOfBags());





//    }
}
