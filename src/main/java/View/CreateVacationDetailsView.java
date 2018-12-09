package View;
import Controller.CreateVacationController;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CreateVacationDetailsView  extends AView{
    @FXML
    public ChoiceBox sellAllTickets;
    public ChoiceBox stayingPlaceRanking;
    public ChoiceBox vacationType;
    public ChoiceBox ticketType1;
    public ChoiceBox ticketType2;
    public ChoiceBox ticketType3;
    public ChoiceBox ticketType4;
    public ChoiceBox ticketType5;
    public ChoiceBox numberOfTickets;
    public Button moveToPaymentMethodButton;
    public TextField departure_city;
    public DatePicker flight_date_1;
    public TextField departure_time_1;
    public TextField destination_time_1;
    public TextField airLineName_1;
    public TextField flight_number_1;
    public TextField flight_baggage_1;
    public ChoiceBox connection1;
    public TextField destination_city;
    public DatePicker flight_date_2;
    public TextField departure_time_2;
    public TextField destination_time_2;
    public TextField airLineName_2;
    public TextField flight_number_2;
    public TextField flight_baggage_2;
    public ChoiceBox connection2;
    public TextField price;
    public TextField staying_place_name;
    public CheckBox flightBack;


    public void start(CreateVacationController.ButtonNumberOfTickets numberOfTicketsButton,
                      CreateVacationController.ButtonMoveToPaymentMethod moveToPaymentMethod,
                      CreateVacationController.ButtonFlightBack flightBackButton) {
        ticketType1.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, numberOfTicketsButton);
        moveToPaymentMethodButton.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, moveToPaymentMethod);
        flightBack.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED,flightBackButton);
        ObservableList<String> sellAllTicketsItems = FXCollections.observableArrayList();
        ObservableList<String> vacationTypeItems = FXCollections.observableArrayList();
        ObservableList<String> rankingOfStayingPlaceItems = FXCollections.observableArrayList();
        ObservableList<String> ticketTypeItems = FXCollections.observableArrayList();
        ObservableList<String> connectionItems = FXCollections.observableArrayList();
        sellAllTicketsItems.add("Yes");
        sellAllTicketsItems.add("No");
        sellAllTickets.setItems(sellAllTicketsItems);
        vacationTypeItems.add("Urban");
        vacationTypeItems.add("Exotic");
        vacationType.setItems(vacationTypeItems);
        rankingOfStayingPlaceItems.add("5");
        rankingOfStayingPlaceItems.add("4");
        rankingOfStayingPlaceItems.add("3");
        rankingOfStayingPlaceItems.add("2");
        rankingOfStayingPlaceItems.add("1");
        stayingPlaceRanking.setItems(rankingOfStayingPlaceItems);
        numberOfTickets.setItems(rankingOfStayingPlaceItems);
        ticketTypeItems.add("Adult");
        ticketTypeItems.add("Child");
        ticketTypeItems.add("Baby");
        connection2.setValue("");
        ticketType1.setItems(ticketTypeItems);
        ticketType2.setItems(ticketTypeItems);
        ticketType3.setItems(ticketTypeItems);
        ticketType4.setItems(ticketTypeItems);
        ticketType5.setItems(ticketTypeItems);
        ticketType2.setValue("Adult");
        ticketType3.setValue("Adult");
        ticketType4.setValue("Adult");
        ticketType5.setValue("Adult");
        numberOfTickets.setValue("1");
        connectionItems.add("Connection");
        connectionItems.add("Direct");
        connection1.setItems(connectionItems);
        connection2.setItems(connectionItems);
        flight_date_2.setDisable(true);
        departure_time_2.setDisable(true);
        destination_time_2.setDisable(true);
        airLineName_2.setDisable(true);
        flight_number_2.setDisable(true);
        flight_baggage_2.setDisable(true);
        connection2.setDisable(true);

    }

    public void enableVacationType() {
        int numOfTickets = Integer.parseInt(numberOfTickets.getValue().toString());
        if (numOfTickets >= 2) ticketType2.setDisable(false);
        if (numOfTickets >= 3) ticketType3.setDisable(false);
        if (numOfTickets >= 4) ticketType4.setDisable(false);
        if (numOfTickets == 5) ticketType5.setDisable(false);
    }

    public boolean isValidDate() {
        LocalDate ld1 = flight_date_1.getValue();
        LocalDate ld2 = flight_date_2.getValue();
        if (ld1 == null || (ld1!=null && LocalDate.from(ld1).until(LocalDate.now(), ChronoUnit.DAYS) >= 0)){
            alert("illegal dates");
            return false;
        }
        else if (ld2!=null && (LocalDate.from(ld1).until(LocalDate.now(), ChronoUnit.DAYS) >= 0 ||
                LocalDate.from(ld2).until(LocalDate.now(), ChronoUnit.DAYS) >= 0 ||
                LocalDate.from(ld2).until(LocalDate.from(ld1),ChronoUnit.DAYS) >=0)) {
            alert("illegal dates");
            return false;
        }
        return true;
    }

    public boolean isAllFieldsFull() {
        if (sellAllTickets.getValue() == null ||
                stayingPlaceRanking.getValue() == null ||
                vacationType.getValue() == null ||
                ticketType1.getValue() == null ||
                departure_city.getText().equals("") ||
                departure_time_1.getText().equals("") ||
                destination_time_1.getText().equals("") ||
                airLineName_1.getText().equals("") ||
                flight_number_1.getText().equals("") ||
                flight_baggage_1.getText().equals("") ||
                destination_city.getText().equals("") ||
                price.getText().equals("") ||
                staying_place_name.getText().equals("") ||
                connection1.getValue() == null) {
            alert("mandatory fields missing");
            return false;
        }
        if (flight_date_2.getValue() == null &&
            departure_time_2.getText().equals("") &&
                    destination_time_2.getText().equals("") &&
                    airLineName_2.getText().equals("") &&
                    flight_number_2.getText().equals("") &&
                    flight_baggage_2.getText().equals("") &&
                (connection2.getValue() == null || connection2.getValue().toString().equals(""))) {
            return true;
        }
        else if ((flight_date_2.getValue() != null ||
                !departure_time_2.getText().equals("") ||
                !destination_time_2.getText().equals("") &&
                !airLineName_2.getText().equals("") &&
                !flight_number_2.getText().equals("") &&
                !flight_baggage_2.getText().equals("") &&
                !(connection2.getValue() == null || connection2.getValue().toString().equals("")))){

        }
        return true;
    }

    public void enableOrDisableFlightBackDetails(){
        if (flight_date_2.isDisable()) {
            flight_date_2.setDisable(false);
            departure_time_2.setDisable(false);
            destination_time_2.setDisable(false);
            airLineName_2.setDisable(false);
            flight_number_2.setDisable(false);
            flight_baggage_2.setDisable(false);
            connection2.setDisable(false);
        }
        else {
            flight_date_2.setDisable(true);
            departure_time_2.setDisable(true);
            destination_time_2.setDisable(true);
            airLineName_2.setDisable(true);
            flight_number_2.setDisable(true);
            flight_baggage_2.setDisable(true);
            connection2.setDisable(true);
        }
    }
}
