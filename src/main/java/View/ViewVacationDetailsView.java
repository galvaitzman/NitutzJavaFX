package View;

import Controller.ButtonBack;
import Controller.ViewVacationController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ViewVacationDetailsView extends AView{
    @FXML
    public Label ticket1;
    public Label ticket2;
    public Label ticket3;
    public Label ticket4;
    public Label ticket5;
    public TextField stayingPlaceRanking;
    public TextField vacationType;
    public TextField ticketType1;
    public TextField ticketType2;
    public TextField ticketType3;
    public TextField ticketType4;
    public TextField ticketType5;
    public TextField numOfTickets;
    public TextField departure_city;
    public TextField flight_date_1;
    public TextField departure_time_1;
    public TextField destination_time_1;
    public TextField airLineName_1;
    public TextField flight_number_1;
    public TextField flight_baggage_1;
    public TextField connection_1;
    public TextField destination_city;
    public TextField flight_date_2;
    public TextField departure_time_2;
    public TextField destination_time_2;
    public TextField airLineName_2;
    public TextField flight_number_2;
    public TextField flight_baggage_2;
    public TextField connection_2;
    public TextField price;
    public TextField staying_place_name;
    public Button requestOrderButton;
    public Button back;
    public Button signInButton;
    public Label label1;
    public Label label2;

    public void start(ViewVacationController.ButtonRequestOrder requestOrder, ViewVacationController.ButtonSignIn buttonSignIn) {
        requestOrderButton.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, requestOrder);
        signInButton.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED,buttonSignIn);
        back.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED,new ButtonBack());
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
        flight_date_1.setText(vacationDetails[10]);
        flight_date_2.setText(vacationDetails[11]);
        flight_baggage_1.setText(vacationDetails[12]);
        flight_baggage_2.setText(vacationDetails[13]);
        numOfTickets.setText(vacationDetails[14]);
        departure_city.setText(vacationDetails[15]);
        destination_city.setText(vacationDetails[16]);
        ticketType1.setVisible(false);
        ticketType2.setVisible(false);
        ticketType3.setVisible(false);
        ticketType4.setVisible(false);
        ticketType5.setVisible(false);
        ticket1.setVisible(false);
        ticket2.setVisible(false);
        ticket3.setVisible(false);
        ticket4.setVisible(false);
        ticket5.setVisible(false);
        if (Integer.parseInt(vacationDetails[14]) > 0) {
            ticket1.setVisible(true);
            ticketType1.setVisible(true);
            ticketType1.setText(vacationDetails[17].split(",")[0]);
        }
        if (Integer.parseInt(vacationDetails[14]) > 1) {
            ticket2.setVisible(true);
            ticketType2.setVisible(true);
            ticketType2.setText(vacationDetails[17].split(",")[1]);
        }
        if (Integer.parseInt(vacationDetails[14]) > 2) {
            ticket3.setVisible(true);
            ticketType3.setVisible(true);
            ticketType3.setText(vacationDetails[17].split(",")[2]);
        }
        if (Integer.parseInt(vacationDetails[14]) > 3) {
            ticket4.setVisible(true);
            ticketType4.setVisible(true);
            ticketType4.setText(vacationDetails[17].split(",")[3]);
        }
        if (Integer.parseInt(vacationDetails[14]) > 4) {
            ticket5.setVisible(true);
            ticketType5.setVisible(true);
            ticketType5.setText(vacationDetails[17].split(",")[4]);
        }
        vacationType.setText(vacationDetails[18]);
        staying_place_name.setText(vacationDetails[19]);
        stayingPlaceRanking.setText(vacationDetails[20]);
        price.setText(vacationDetails[21]);
        connection_1.setText(vacationDetails[22]);
        connection_2.setText(vacationDetails[23]);
    }

}
