package edu.au.cpsc.module2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class SeatReservationApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(SeatReservationApplication.class.getResource("hello-view.fxml"));
        StackPane root = new StackPane();
        Scene scene = new Scene(root, 500, 700);
        stage.setTitle("Rahul Venkatesh's seat reservation App");
        stage.setScene(scene);
        stage.show();
    }
}
