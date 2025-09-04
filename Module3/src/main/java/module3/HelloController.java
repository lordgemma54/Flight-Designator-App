package module3;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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
    private Label welcomeText;
    @FXML
    private TextField ident;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}
