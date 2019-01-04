package Controller;

import View.CreateVacationDetailsView;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.event.EventHandler;

public class CreateVacationController extends Controller {
    private CreateVacationDetailsView createVacationDetailsView;
    public CreateVacationController(){
        setFxmlLoader("CreateVacationDetails.fxml");
        createVacationDetailsView = fxmlLoader.getController();
        createVacationDetailsView.start(new ButtonCreateVacation(), new ButtonFlightBack(), new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
                int numOfTickets = Integer.parseInt(createVacationDetailsView.numberOfTickets.getItems().get((Integer) number2).toString());
                createVacationDetailsView.ticketType1.setVisible(false);
                createVacationDetailsView.ticketType2.setVisible(false);
                createVacationDetailsView.ticketType3.setVisible(false);
                createVacationDetailsView.ticketType4.setVisible(false);
                createVacationDetailsView.ticketType5.setVisible(false);
                createVacationDetailsView.ticket1.setVisible(false);
                createVacationDetailsView.ticket2.setVisible(false);
                createVacationDetailsView.ticket3.setVisible(false);
                createVacationDetailsView.ticket4.setVisible(false);
                createVacationDetailsView.ticket5.setVisible(false);
                if (numOfTickets > 0) {
                    createVacationDetailsView.ticket1.setVisible(true);
                    createVacationDetailsView.ticketType1.setVisible(true);
                }
                if (numOfTickets > 1) {
                    createVacationDetailsView.ticket2.setVisible(true);
                    createVacationDetailsView.ticketType2.setVisible(true);
                }
                if (numOfTickets > 2) {
                    createVacationDetailsView.ticket3.setVisible(true);
                    createVacationDetailsView.ticketType3.setVisible(true);
                }
                if (numOfTickets > 3) {
                    createVacationDetailsView.ticket4.setVisible(true);
                    createVacationDetailsView.ticketType4.setVisible(true);
                }
                if (numOfTickets > 4) {
                    createVacationDetailsView.ticket5.setVisible(true);
                    createVacationDetailsView.ticketType5.setVisible(true);
                }

            }
        });

    }

    @Override
    public void start() {
        window.setTitle("Create Vacation");
        window.show();
    }


    public class ButtonCreateVacation implements EventHandler {
        @Override
        public void handle(Event event) {
                if (!createVacationDetailsView.isValidDate()) return;
                else if (!createVacationDetailsView.isAllFieldsFull()) return;
            vacationModel.insertVacationToDB(createVacationDetailsView.airLineName_1.getText(),
                    createVacationDetailsView.airLineName_2.getText(),
                    createVacationDetailsView.departure_time_1.getText(),
                    createVacationDetailsView.destination_time_1.getText(),
                    createVacationDetailsView.departure_time_2.getText(),
                    createVacationDetailsView.destination_time_2.getText(),
                    createVacationDetailsView.flight_number_1.getText(),
                    createVacationDetailsView.flight_number_2.getText(),
                    createVacationDetailsView.flight_date_1.getValue().toString(),
                    createVacationDetailsView.flight_date_2.getValue().toString(),
                    createVacationDetailsView.flight_baggage_1.getText(),
                    createVacationDetailsView.flight_baggage_2.getText(),
                    Integer.parseInt(createVacationDetailsView.numberOfTickets.getValue().toString()),
                    createVacationDetailsView.departure_city.getText(),
                    createVacationDetailsView.destination_city.getText(),
                    createVacationDetailsView.ticketType1.getValue().toString()+","+
                            createVacationDetailsView.ticketType2.getValue().toString()+","+
                            createVacationDetailsView.ticketType3.getValue().toString()+","+
                            createVacationDetailsView.ticketType4.getValue().toString()+","+
                            createVacationDetailsView.ticketType5.getValue().toString(),
                    createVacationDetailsView.vacationType.getValue().toString(),
                    createVacationDetailsView.staying_place_name.getText(),
                    createVacationDetailsView.stayingPlaceRanking.getValue().toString(),
                    createVacationDetailsView.price.getText(),
                    createVacationDetailsView.connection1.getValue().toString(),
                    createVacationDetailsView.connection2.getValue().toString(),
                    createVacationDetailsView.sellAllTickets.getValue().toString(),
                    "",
                    "",
                    "",
                    "");
            createVacationDetailsView.alert("Vacation added successfuly");
            window.close();
            mainController.goBackToPreviousController();
        }
    }



    public class ButtonFlightBack implements EventHandler{
        @Override
        public void handle(Event event) {
            createVacationDetailsView.enableOrDisableFlightBackDetails();
        }
    }




}
