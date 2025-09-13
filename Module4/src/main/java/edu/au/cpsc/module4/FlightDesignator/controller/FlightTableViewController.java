package edu.au.cpsc.module4.FlightDesignator.controller;

import edu.au.cpsc.module4.FlightDesignator.model.ScheduledFlight;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.time.LocalDateTime;

public class FlightTableViewController {

    @FXML
    private TableView<ScheduledFlight> flightList;

    @FXML
    private TableColumn<ScheduledFlight, String> flightDesignatorCol;

    @FXML
    private TableColumn<ScheduledFlight, String> departureAirportCol;

    @FXML
    private TableColumn<ScheduledFlight, String> arrivalAirportCol;

    @FXML
    private TableColumn<ScheduledFlight, LocalDateTime> arrivalTimeCol;

    @FXML
    private TableColumn<ScheduledFlight, LocalDateTime> departureTimeCol;


    private static ScheduledFlight flight;

    public void initialize() {

        flightList.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        flightDesignatorCol.setMaxWidth(Double.MAX_VALUE);
        departureAirportCol.setMaxWidth(Double.MAX_VALUE);
        arrivalAirportCol.setMaxWidth(Double.MAX_VALUE);
        arrivalTimeCol.setMaxWidth(Double.MAX_VALUE);
        departureTimeCol.setMaxWidth(Double.MAX_VALUE);

        flightList.setItems(FXCollections.observableList(ScheduledFlight.demoFlights()));
        flightList.getSelectionModel().selectedItemProperty().addListener(event -> listSelectionChanged());

        flightDesignatorCol.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getFlightDesignator()));
        flightDesignatorCol.setCellFactory(col -> new PopulateTableCell<>());

        departureAirportCol.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getDepartureAirportIdent()));
        departureAirportCol.setCellFactory(col -> new PopulateTableCell<>());

        arrivalAirportCol.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getArrivalAirportIdent()));
        arrivalAirportCol.setCellFactory(col -> new PopulateTableCell<>());

        arrivalTimeCol.setCellValueFactory(cellData ->
                new SimpleObjectProperty<>(cellData.getValue().getArrivalTime()));
        arrivalTimeCol.setCellFactory(col -> new PopulateTableCell<>());

        departureTimeCol.setCellValueFactory(cellData ->
                new SimpleObjectProperty<>(cellData.getValue().getDepartureTime()));
        departureTimeCol.setCellFactory(col -> new PopulateTableCell<>());
    }

    private void listSelectionChanged(){

        ScheduledFlight selectedFlight = flightList.getSelectionModel().getSelectedItem();
        if(selectedFlight == null) {
//            clear fields
            return;
        }
//       otherwide populate the right fields
    }

static class PopulateTableCell<R, C> extends TableCell<R, C>{
        @Override
    protected void updateItem(C item, boolean empty){

            super.updateItem(item,empty);

            if(empty || item == null){
                setText(null);
                setGraphic(null);
            }else {
                setText(item.toString());
            }

        }
}
}
