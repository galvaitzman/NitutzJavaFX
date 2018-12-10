package View;
import Controller.CreateVacationController;

import Controller.UpdateVacationDetailsController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class UpdateVacationDetailsView  extends AView{
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

//
    public void start(UpdateVacationDetailsController.ButtonNumberOfTickets numberOfTicketsButton,
                      UpdateVacationDetailsController.ButtonUpdate moveToPaymentMethod,
                      UpdateVacationDetailsController.ButtonFlightBack flightBackButton) {
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

        departure_time_2.setDisable(true);
        destination_time_2.setDisable(true);
        airLineName_2.setDisable(true);
        flight_number_2.setDisable(true);
        flight_baggage_2.setDisable(true);
        connection2.setDisable(true);
        departure_time_2.setText("");
        destination_time_2.setText("");
        airLineName_2.setText("");
        flight_number_2.setText("");
        flight_baggage_2.setText("");
        connection2.setValue("");

        staying_place_name.setText("none");
        stayingPlaceRanking.setValue("1");




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
        if (ld1==null || ld2==null  ||  (LocalDate.from(ld1).until(LocalDate.now(), ChronoUnit.DAYS) >= 0 ||
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
        if (flightBack.isSelected() && (departure_time_2.getText().equals("") ||
                destination_time_2.getText().equals("") ||
                airLineName_2.getText().equals("") ||
                flight_number_2.getText().equals("") ||
                flight_baggage_2.getText().equals("") ||
                (connection2.getValue() == null || connection2.getValue().toString().equals("")))){
            alert("mandatory fields missing");
            return false;
        }
        return true;
    }

    public void enableOrDisableFlightBackDetails(){
        if (departure_time_2.isDisable()) {
            departure_time_2.setDisable(false);
            destination_time_2.setDisable(false);
            airLineName_2.setDisable(false);
            flight_number_2.setDisable(false);
            flight_baggage_2.setDisable(false);
            connection2.setDisable(false);
        }
        else {
            departure_time_2.setDisable(true);
            destination_time_2.setDisable(true);
            airLineName_2.setDisable(true);
            flight_number_2.setDisable(true);
            flight_baggage_2.setDisable(true);
            connection2.setDisable(true);
        }
    }

    public void setTxtFields(String [] vacationDetails){
        airLineName_1.setText(vacationDetails[2]);
        airLineName_2.setText(vacationDetails[3]);
        departure_time_1.setText(vacationDetails[4]);
        destination_time_1.setText(vacationDetails[5]);
        departure_time_2.setText(vacationDetails[6]);
        destination_time_2.setText(vacationDetails[7]);
        flight_number_1.setText(vacationDetails[8]);
        flight_number_2.setText(vacationDetails[9]);
        flight_date_1.setValue(LocalDate.parse(vacationDetails[10]));
        flight_date_2.setValue(LocalDate.parse(vacationDetails[11]));
        flight_baggage_1.setText(vacationDetails[12]);
        flight_baggage_2.setText(vacationDetails[13]);
        numberOfTickets.setValue(vacationDetails[14]);
        departure_city.setText(vacationDetails[15]);
        destination_city.setText(vacationDetails[16]);
        ticketType1.setValue(vacationDetails[17].split(",")[0]);
        ticketType2.setValue(vacationDetails[17].split(",")[1]);
        ticketType3.setValue(vacationDetails[17].split(",")[2]);
        ticketType4.setValue(vacationDetails[17].split(",")[3]);
        ticketType5.setValue(vacationDetails[17].split(",")[4]);
        vacationType.setValue(vacationDetails[18]);
        staying_place_name.setText(vacationDetails[19]);
        stayingPlaceRanking.setValue(vacationDetails[20]);
        price.setText(vacationDetails[21]);
        connection1.setValue(vacationDetails[22]);
        connection2.setValue(vacationDetails[23]);
        sellAllTickets.setValue(vacationDetails[24]);
        if (!departure_time_2.getText().equals("")){
            flightBack.setSelected(true);
            departure_time_2.setDisable(false);
            destination_time_2.setDisable(false);
            airLineName_2.setDisable(false);
            flight_number_2.setDisable(false);
            flight_baggage_2.setDisable(false);
            connection2.setDisable(false);
        }


    }
}
