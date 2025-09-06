package module3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AirportApplication extends Application {


    @Override
    public void start(Stage stage) throws IOException {

        Airport.readAll();
        FXMLLoader fxmlLoader = new FXMLLoader(AirportApplication.class.getResource("Main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);



        stage.setTitle("Rahul Venkateshs Airport Mapview App");
        stage.setScene(scene);
        stage.setMinWidth(900);
        stage.setMinHeight(600);
        stage.show();
    }
}
