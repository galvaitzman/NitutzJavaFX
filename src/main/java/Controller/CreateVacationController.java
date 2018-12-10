package Controller;

import View.CreateVacationDetailsView;
import View.CreateVacationPaymentView;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;

public class CreateVacationController extends Controller {
    private CreateVacationDetailsView createVacationDetailsView;
    private CreateVacationPaymentView createVacationPaymentView;
    public CreateVacationController(){
        super("CreateVacationDetails.fxml");
        createVacationDetailsView = fxmlLoader.getController();
        createVacationDetailsView.start(new ButtonNumberOfTickets(),new ButtonMoveToPaymentMethod(), new ButtonFlightBack() );

    }

    @Override
    public void start() {
        window.show();
        window.setTitle("Create vacation");
    }

    public class ButtonNumberOfTickets implements EventHandler {
        @Override
        public void handle(Event event) {
           createVacationDetailsView.enableVacationType();

        }
    }
    public class ButtonMoveToPaymentMethod implements EventHandler {
        @Override
        public void handle(Event event) {
            try {
                if (!createVacationDetailsView.isValidDate()) return;
                else if (!createVacationDetailsView.isAllFieldsFull()) return;
                window.close();
                FXMLLoader fxmlLoaderPayment = new FXMLLoader();
                Parent rootOfPayment = fxmlLoaderPayment.load(getClass().getResource("/" + "CreateVacationPayment.fxml").openStream());
                Scene scenePayment = new Scene(rootOfPayment);
                Stage windowPayment = new Stage();
                windowPayment.setScene(scenePayment);
                createVacationPaymentView = fxmlLoaderPayment.getController();
                windowPayment.show();
                windowPayment.setTitle("Create vacation");
                createVacationPaymentView.start(new ButtonPostVacation(), new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
                        String paymentWay = createVacationPaymentView.paypalOrBank.getItems().get((Integer) number2).toString();
                        if (paymentWay.equals("Bank account")) {
                            createVacationPaymentView.account_number.setDisable(false);
                            createVacationPaymentView.bank_number.setDisable(false);
                            createVacationPaymentView.branch_number.setDisable(false);
                            createVacationPaymentView.paypal.setDisable(true);
                        } else {
                            createVacationPaymentView.paypal.setDisable(false);
                            createVacationPaymentView.account_number.setDisable(true);
                            createVacationPaymentView.bank_number.setDisable(true);
                            createVacationPaymentView.branch_number.setDisable(true);
                        }

                    }
                });

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public class ButtonPostVacation implements EventHandler {
        @Override
        public void handle(Event event) {
           try {
               if (createVacationPaymentView.paypalOrBank.getValue()!=null){
                   if (createVacationPaymentView.paypalOrBank.getValue().toString().equals("Bank account")){
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
                                String.valueOf(Integer.parseInt(createVacationPaymentView.account_number.getText())),
                                String.valueOf(Integer.parseInt(createVacationPaymentView.branch_number.getText())),
                                String.valueOf(Integer.parseInt(createVacationPaymentView.bank_number.getText())),
                               "");
                   }
                   else{
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
                               String.valueOf(Integer.parseInt(createVacationPaymentView.paypal.getText())));
                   }
               }
               else{
                   createVacationPaymentView.alert("Please choose Bank or Paypal");
               }
           }
           catch (NumberFormatException e){
               createVacationPaymentView.alert("Please fill all the requierd fields, only digits");
           }

        }
    }

    public class ButtonFlightBack implements EventHandler{
        @Override
        public void handle(Event event) {
            createVacationDetailsView.enableOrDisableFlightBackDetails();
        }
    }




}
