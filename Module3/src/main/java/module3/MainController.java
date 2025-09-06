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
        webView.getEngine().load("https://www.windy.com/?" + foundAirport.getCoordinatesLong()
                + "," + foundAirport.getCoordinatesLat() + ",12");
        System.out.println(foundAirport.getCoordinatesLong() + "///" + foundAirport.getCoordinatesLat());
    }

    @FXML
    protected void onIdentEnterPressed() {
        String identCodeValue = ident.getText().trim().toUpperCase();
        for(Airport a : Airport.airportList) {
            if(a.getIdent().equalsIgnoreCase(identCodeValue)) {
                foundAirport = a;
                ifFoundByIdent(foundAirport);
                return;
            }
        }
    }

    private void ifFoundByIdent(Airport airport) {
        iataCode.setText(foundAirport.getIataCode());
        localCode.setText(foundAirport.getLocalCode());
        type.setText(foundAirport.getType());
        name.setText(foundAirport.getName());
        elevation.setText(String.valueOf(foundAirport.getElevationFt()));
        country.setText(foundAirport.getIsoCountry());
        region.setText(foundAirport.getIsoRegion());
        municipality.setText(foundAirport.getMunicipality());
    }

    @FXML
    protected void onIataEnterPressed() {
        String iataCodeValue = iataCode.getText().trim().toUpperCase();
        System.out.println(iataCodeValue);
    }

    @FXML
    protected void onLocalCodeEnterPressed() {
        String localCodeValue = localCode.getText().trim().toUpperCase();
        System.out.println(localCodeValue);
    }

//    private codeSearch(String searchInput) {

    //    use optionals so i dont return null?

//        this.ident = searchInput if from identField.getText();
//        this.iata - searchInput if from iataField.getText();
//        this.localCode = searchInput if from localCodeField.getText();
//
//        if(code is from ident) {
//            search airport.getIdent();
//            ifFoundByIdent();
//        } else if {
//            search airport.getIataCode();
//        } else if {
//            search airport.getLocalCode();
//        } else{
//            return some message here;
//        }
//    }
//
//    private void ifFoundByIdent(String code){
//        populate the fields here;
//        update webView with coordinates;
//    }
//
//    public void ifFoundByIata(String code) {
//        populate the fields here;
//        update webView with coordinates;
//    }
//
//    public void ifFoundByLocalCode(String code) {
//        populate the fields here;
//        update webView with coordinates;
//    }

    public void initialize() {
        webView.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

//        webView.prefWidthProperty().bind(borderPaneParent.widthProperty());
//        webView.prefHeightProperty().bind(borderPaneParent.heightProperty());


    }
}
