package module3;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.web.WebView;

public class MainController{
    @FXML
    public TextField ident;
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
    public Button searchButton;
    @FXML
    private WebView webView;

    Airport foundAirport;

    @FXML
    protected void onSearchButtonAction() {
        if(!ident.getText().isEmpty()) {
            if (findAirportByIdent(ident.getText().trim().toUpperCase())) {
                ifFoundByIdent(foundAirport);
                onSearchButtonAction(foundAirport);
            } else {
                ident.clear();
                ident.setPromptText("Invalid Code");
            }
        } else if(!iataCode.getText().isEmpty()) {
            if (findAirportByIata(iataCode.getText().trim().toUpperCase())) {
                ifFoundByIata(foundAirport);
                onSearchButtonAction(foundAirport);
            } else {
                iataCode.clear();
                iataCode.setPromptText("Invalid Code");
            }
        } else if(!localCode.getText().isEmpty()) {
            if (findAirportByLocalCode(localCode.getText().trim().toUpperCase())) {
                ifFoundByLocalCode(foundAirport);
                onSearchButtonAction(foundAirport);
            } else {
                localCode.clear();
                localCode.setPromptText("Invalid Code");
            }
        }else{
            ident.setPromptText("--Enter a Code--");
            iataCode.setPromptText("--Enter a Code--");
            localCode.setPromptText("--Enter a Code--");
        }
    }

    @FXML
    protected void onSearchButtonAction(Airport foundAirport) {
        webView.getEngine().load("https://www.windy.com/?" + foundAirport.getCoordinatesLong()
                + "," + foundAirport.getCoordinatesLat() + ",12");
    }

    @FXML
    protected void onIdentEnterPressed() {

        if (findAirportByIdent(ident.getText().trim().toUpperCase())) {
            onSearchButtonAction(foundAirport);
            ifFoundByIdent(foundAirport);
        } else {
            ident.clear();
            ident.setPromptText("Invalid Code");
        }
    }

    @FXML
    protected void onIataEnterPressed() {
        if(findAirportByIata(iataCode.getText().trim().toUpperCase())) {
            onSearchButtonAction(foundAirport);
            ifFoundByIata(foundAirport);
        }else {
            iataCode.clear();
            iataCode.setPromptText("Invalid Code");
        }
    }

    @FXML
    protected void onLocalCodeEnterPressed() {
        if(findAirportByLocalCode(localCode.getText().trim().toUpperCase())) {
            onSearchButtonAction(foundAirport);
            ifFoundByLocalCode(foundAirport);
        } else {
            localCode.clear();
            localCode.setPromptText("Invalid Code");
        }
    }

    private boolean findAirportByIdent(String code) {
        for(Airport a : Airport.airportList) {
            if(a.getIdent().equalsIgnoreCase(code)) {
                foundAirport = a;
                return true;
            }
        }return false;
    }

    private void ifFoundByIdent(Airport foundAirport) {
        iataCode.setText(foundAirport.getIataCode());
        localCode.setText(foundAirport.getLocalCode());
        setOtherFields(foundAirport);
    }

    private boolean findAirportByIata(String code) {
        for(Airport a : Airport.airportList) {
            if(a.getIataCode().equalsIgnoreCase(code)) {
                foundAirport = a;
                return true;
            }
        }return false;
    }

    private void ifFoundByIata(Airport foundAirport) {
        ident.setText(foundAirport.getIdent());
        localCode.setText(foundAirport.getLocalCode());
        setOtherFields(foundAirport);
    }

    private boolean findAirportByLocalCode(String code) {
        for(Airport a : Airport.airportList) {
            if(a.getLocalCode().equalsIgnoreCase(code)) {
                foundAirport = a;
                return true;
            }
        }return false;
    }

    private void ifFoundByLocalCode(Airport foundAirport) {
        ident.setText(foundAirport.getIdent());
        iataCode.setText(foundAirport.getIataCode());
        setOtherFields(foundAirport);
    }

    private void setOtherFields(Airport foundAirport) {
        type.setText(foundAirport.getType());
        name.setText(foundAirport.getName());
        elevation.setText(String.valueOf(foundAirport.getElevationFt()));
        country.setText(foundAirport.getIsoCountry());
        region.setText(foundAirport.getIsoRegion());
        municipality.setText(foundAirport.getMunicipality());
    }

    public void initialize() {
        webView.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    }
}
