package module3;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.web.WebView;

public class HelloController {
    @FXML
    public TextField iataCode;
    @FXML
    public TextField localCode;
    @FXML
    public TextField type;
    @FXML
    public TextField name;
    @FXML
    public TextField elevation;
    @FXML
    public TextField country;
    @FXML
    public TextField region;
    @FXML
    public TextField municipality;
    @FXML
    private Label welcomeText;
    @FXML
    public TextField ident;
    @FXML
    public Button searchButton;
    @FXML
    private WebView webView;

    Airport searchAirport = new Airport();

    @FXML
    protected void onSearchButtonAction() {
        webView.getEngine().load("https://www.windy.com/?" + searchAirport.getCoordinatesLong()
                + "," + searchAirport.getCoordinatesLat() + ",12");
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}
