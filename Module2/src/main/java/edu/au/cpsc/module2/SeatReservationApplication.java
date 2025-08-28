package edu.au.cpsc.module2;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public class SeatReservationApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
//
//      FXMLLoader fxmlLoader = new FXMLLoader(SeatReservationApplication.class.getResource("hello-view.fxml"));
        BorderPane borderPane = new BorderPane();

        Label flightDesignator = new Label("Flight designator:");
        flightDesignator.setFont(new Font("Arial", 14));
        Label flightDate = new Label("Flight date");
        Label firstName = new Label("First name");
        Label lastName = new Label("Last name");
        Label bags = new Label("Bags");
        Label flyingWithInfant = new Label("Flying with infant?");
        Label numberOfPassengers = new Label("Number of passengers:");
        VBox labels = new VBox(flightDesignator, flightDate, firstName, lastName,
                bags, flyingWithInfant, numberOfPassengers);
        borderPane.setLeft(labels);

        Button save = new Button("Save");
        Button cancel = new Button("Cancel");
        HBox bottomButtons = new HBox(save, cancel);
        borderPane.setBottom( bottomButtons);
        bottomButtons.setAlignment( Pos.BOTTOM_RIGHT);
        bottomButtons.setSpacing(5);

        TextField fltDesignator = new TextField();
        DatePicker fltDate = new DatePicker();
        TextField fName = new TextField();
        TextField lName = new TextField();
        TextField numBags = new TextField();
        TextField numPassengers = new TextField("0");
        VBox textFields = new VBox(fltDesignator, fltDate, fName,
        lName, numBags, numPassengers);
        borderPane.setRight(textFields);



        Scene scene = new Scene(borderPane, 300, 350);
        stage.setTitle("Rahul Venkatesh's seat reservation App");
        stage.setScene(scene);
        stage.show();
    }
}
