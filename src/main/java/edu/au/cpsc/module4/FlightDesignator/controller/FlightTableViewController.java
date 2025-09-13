package edu.au.cpsc.module4.FlightDesignator.controller;

import edu.au.cpsc.module4.FlightDesignator.model.ScheduledFlight;
import javafx.collections.FXCollections;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDateTime;

public class FlightTableViewController {

    @FXML
    private TableView<ScheduledFlight> flightListTableView;

    @FXML
    private TableColumn<ScheduledFlight, String> flightDesignatorCol, departureAirportCol, arrivalAirportCol;

    @FXML
    private TableColumn<ScheduledFlight, LocalDateTime> arrivalTimeCol, departureTimeCol;

    @FXML
    private FlightDetailViewController flightDetailViewController;

    private static ScheduledFlight flight;

    public void initialize() {

        flightListTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        flightDesignatorCol.setMaxWidth(Double.MAX_VALUE);
        departureAirportCol.setMaxWidth(Double.MAX_VALUE);
        arrivalAirportCol.setMaxWidth(Double.MAX_VALUE);
        arrivalTimeCol.setMaxWidth(Double.MAX_VALUE);
        departureTimeCol.setMaxWidth(Double.MAX_VALUE);

        flightListTableView.setItems(FXCollections.observableList(ScheduledFlight.demoFlights()));
        flightListTableView.getSelectionModel().selectedItemProperty().addListener(event -> tableSelectionChanged());

        flightDesignatorCol.setCellValueFactory(new PropertyValueFactory<ScheduledFlight, String>("flightDesignator"));
        departureAirportCol.setCellValueFactory(new PropertyValueFactory<ScheduledFlight, String>("departureAirportIdent"));
        arrivalAirportCol.setCellValueFactory(new PropertyValueFactory<ScheduledFlight, String>("arrivalAirportIdent"));
        departureTimeCol.setCellValueFactory(new PropertyValueFactory<ScheduledFlight, LocalDateTime>("departureTime"));
        arrivalTimeCol.setCellValueFactory(new PropertyValueFactory<ScheduledFlight, LocalDateTime>("arrivalTime"));

        SortedList<ScheduledFlight> sortedFlights = new SortedList<>(
                FXCollections.observableList(ScheduledFlight.demoFlights()));

        flightListTableView.setItems(sortedFlights);
        sortedFlights.comparatorProperty().bind(flightListTableView.comparatorProperty());
        flightListTableView.getSelectionModel().selectedItemProperty().addListener(c -> tableSelectionChanged());


//        flightDesignatorCol.setCellValueFactory(cellData ->
//                new SimpleStringProperty(cellData.getValue().getFlightDesignator()));
//        flightDesignatorCol.setCellFactory(col -> new PopulateTableCell<>());
//
//        departureAirportCol.setCellValueFactory(cellData ->
//                new SimpleStringProperty(cellData.getValue().getDepartureAirportIdent()));
//        departureAirportCol.setCellFactory(col -> new PopulateTableCell<>());
//
//        arrivalAirportCol.setCellValueFactory(cellData ->
//                new SimpleStringProperty(cellData.getValue().getArrivalAirportIdent()));
//        arrivalAirportCol.setCellFactory(col -> new PopulateTableCell<>());
//
//        arrivalTimeCol.setCellValueFactory(cellData ->
//                new SimpleObjectProperty<>(cellData.getValue().getArrivalTime()));
//        arrivalTimeCol.setCellFactory(col -> new PopulateTableCell<>());
//
//        departureTimeCol.setCellValueFactory(cellData ->
//                new SimpleObjectProperty<>(cellData.getValue().getDepartureTime()));
//        departureTimeCol.setCellFactory(col -> new PopulateTableCell<>());
    }

    public void setDetailViewController(FlightDetailViewController flightDetailViewController) {
        this.flightDetailViewController = flightDetailViewController;
    }
    
    private void tableSelectionChanged(){

        ScheduledFlight selectedFlight = flightListTableView.getSelectionModel().getSelectedItem();
        flightDetailViewController.showFlight(selectedFlight);
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
