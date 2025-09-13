package edu.au.cpsc.module4.FlightDesignator;
/*
* Module 4 Flight Schedule Application
* Rahul Venkatesh
* rzv0040@auburn.edu
* Flight Schedule
* */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FlightScheduleApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(FlightScheduleApplication.class.getResource("/view/main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Rahul Venkatesh's Flight Designator App");
        stage.setScene(scene);
        stage.setMinWidth(720);
        stage.setMinHeight(400);
        stage.show();
    }
}
