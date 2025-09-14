package edu.au.cpsc.module4.FlightDesignator.controller;

import edu.au.cpsc.module4.FlightDesignator.model.ScheduledFlight;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.transformation.SortedList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;

public class FlightTableViewController {

    @FXML
    private TableView<ScheduledFlight> flightListTableView;

    @FXML
    private TableColumn<ScheduledFlight, String> flightDesignatorCol, departureAirportCol, arrivalAirportCol, daysOfWeekCol;

    @FXML
    private TableColumn<ScheduledFlight, LocalTime> arrivalTimeCol, departureTimeCol;


//    private FlightDetailViewController flightDetailViewController;

//    private static ScheduledFlight flight;

    public void initialize() {

        flightListTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
//        flightDesignatorCol.setMaxWidth(Double.MAX_VALUE);
//        departureAirportCol.setMaxWidth(Double.MAX_VALUE);
//        arrivalAirportCol.setMaxWidth(Double.MAX_VALUE);
//        arrivalTimeCol.setMaxWidth(Double.MAX_VALUE);
//        departureTimeCol.setMaxWidth(Double.MAX_VALUE);

//        flightListTableView.getSelectionModel().selectedItemProperty().addListener(event -> tableSelectionChanged());
//
        flightDesignatorCol.setCellValueFactory(new PropertyValueFactory<ScheduledFlight, String>("flightDesignator"));

        departureAirportCol.setCellValueFactory(new PropertyValueFactory<ScheduledFlight, String>("departureAirportIdent"));
        departureAirportCol.setCellFactory(col -> new TableCell<ScheduledFlight, String>(){
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if(empty || item == null){
                    setText(null);
                }else  {
                    setText(item.toUpperCase());
                }
            }
        });

        arrivalAirportCol.setCellValueFactory(new PropertyValueFactory<ScheduledFlight, String>("arrivalAirportIdent"));
        arrivalAirportCol.setCellFactory(col -> new TableCell<ScheduledFlight, String>(){
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if(empty || item == null){
                    setText(null);
                }else  {
                    setText(item.toUpperCase());
                }
            }
        });

//        departureTimeCol.setCellValueFactory(cellData -> {
//                LocalDateTime dt = cellData.getValue().getDepartureTime();
//                return new SimpleStringProperty(dt != null ? dtFmt.format(dt) : "");
//                });
//
//        arrivalTimeCol.setCellValueFactory(cellData -> {
//            LocalDateTime dt = cellData.getValue().getArrivalTime();
//            return new SimpleStringProperty(dt != null ? dtFmt.format(dt) : "");
//        });

        departureTimeCol.setCellValueFactory(new PropertyValueFactory<ScheduledFlight, LocalTime>("departureTime"));
        arrivalTimeCol.setCellValueFactory(new PropertyValueFactory<ScheduledFlight, LocalTime>("arrivalTime"));
//        daysOfWeekCol.setCellValueFactory(new PropertyValueFactory<ScheduledFlight, String>("daysOfWeek"));

        daysOfWeekCol.setCellValueFactory(cellData ->
        {HashSet<String> days = cellData.getValue().getDaysOfWeek();
        return new SimpleStringProperty(daysOfWeekFormatted(days));
        });

        flightListTableView.getSelectionModel().selectedItemProperty().addListener(c -> tableSelectionChanged());
    }


    private String daysOfWeekFormatted(HashSet<String> days) {
        StringBuilder sb = new StringBuilder();
        String forcedOrder = "UMTWRFS";
        for(char c : forcedOrder.toCharArray()) {
            if(days.contains(String.valueOf(c))){
                sb.append(c).append(" ");
            }
        }
        return sb.toString().toUpperCase().trim();
    }

public void showFlights(List<ScheduledFlight> flights) {
    SortedList<ScheduledFlight> sortedFlights = new SortedList<>(
            FXCollections.observableList(flights));
    flightListTableView.setItems(sortedFlights);
    sortedFlights.comparatorProperty().bind(flightListTableView.comparatorProperty());
    flightListTableView.refresh();
}



public void onFlightSelectionChanged(EventHandler<FlightTableEvent> handler) {
    flightListTableView.addEventHandler(FlightTableViewController.FlightTableEvent.FLIGHT_SELECTED, handler);
}


    private void tableSelectionChanged(){
        ScheduledFlight selectedFlight = flightListTableView.getSelectionModel().getSelectedItem();
        FlightTableEvent event = new FlightTableEvent(FlightTableEvent.FLIGHT_SELECTED, selectedFlight);
        flightListTableView.fireEvent(event);
    }


    public void select(ScheduledFlight selectedFlight) {
        flightListTableView.getSelectionModel().select(selectedFlight);
    }


    public static class FlightTableEvent extends Event {
        public static final EventType<FlightTableEvent> ANY = new EventType<>(Event.ANY,"ANY");

        public static final EventType<FlightTableEvent> FLIGHT_SELECTED = new EventType<>(ANY, "FLIGHT_SELECTED");

        private ScheduledFlight selectedFlight;

        public FlightTableEvent(EventType<? extends Event> eventType, ScheduledFlight selectedFlight) {
            super(eventType);
            this.selectedFlight = selectedFlight;
        }

        public ScheduledFlight getScheduledFlight() {
            return selectedFlight;
        }
    }

//static class PopulateTableCell<R, C> extends TableCell<R, C> {
//        @Override
//    protected void updateItem(C item, boolean empty){
//
//            super.updateItem(item,empty);
//
//            if(empty || item == null){
//                setText(null);
//                setGraphic(null);
//            }else {
//                setText(item.toString());
//            }
//        }
//}

}


//          googles solution for setting each cell
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
//
//---------------------------------------------------------------------------------------------
