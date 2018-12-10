package View;

import Controller.ViewVacationController;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.time.LocalDate;

public class ViewVacationDetailsView extends AView{
    @FXML
    public TextField stayingPlaceRanking;
    public TextField vacationType;
    public TextField ticketType1;
    public TextField ticketType2;
    public TextField ticketType3;
    public TextField ticketType4;
    public TextField ticketType5;
    public TextField numOfTickets;
    public Button requestOrderButton;
    public TextField departure_city;
    public DatePicker flight_date_1;
    public TextField departure_time_1;
    public TextField destination_time_1;
    public TextField airLineName_1;
    public TextField flight_number_1;
    public TextField flight_baggage_1;
    public TextField connection_1;
    public TextField destination_city;
    public DatePicker flight_date_2;
    public TextField departure_time_2;
    public TextField destination_time_2;
    public TextField airLineName_2;
    public TextField flight_number_2;
    public TextField flight_baggage_2;
    public TextField connection_2;
    public TextField price;
    public TextField staying_place_name;
    public CheckBox flightBack;

    public void start(ViewVacationController.ButtonRequestOrder requestOrder) {
        requestOrderButton.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, requestOrder);
    }

    public void showVacationDetails(String[] vacationDetails) {

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
        numOfTickets.setText(vacationDetails[14]);
        departure_city.setText(vacationDetails[15]);
        destination_city.setText(vacationDetails[16]);
        ticketType1.setText(vacationDetails[17].split(",")[0]);
        ticketType2.setText(vacationDetails[17].split(",")[1]);
        ticketType3.setText(vacationDetails[17].split(",")[2]);
        ticketType4.setText(vacationDetails[17].split(",")[3]);
        ticketType5.setText(vacationDetails[17].split(",")[4]);
        vacationType.setText(vacationDetails[18]);
        staying_place_name.setText(vacationDetails[19]);
        stayingPlaceRanking.setText(vacationDetails[20]);
        price.setText(vacationDetails[21]);
        connection_1.setText(vacationDetails[22]);
        connection_2.setText(vacationDetails[23]);
    }

}
