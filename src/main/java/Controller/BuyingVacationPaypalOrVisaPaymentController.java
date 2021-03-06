package Controller;

import View.BuyingVacationPaypalOrVisaPaymentView;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class BuyingVacationPaypalOrVisaPaymentController extends Controller {

    private BuyingVacationPaypalOrVisaPaymentView buyingVacationPaypalOrVisaPaymentView;
    public BuyingVacationPaypalOrVisaPaymentController(){
        super("BuyingVacationPaypalOrVisaPayment.fxml");
        buyingVacationPaypalOrVisaPaymentView = fxmlLoader.getController();
        buyingVacationPaypalOrVisaPaymentView.start(new ButtonPurchaseVacation(), new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
                String paymentWay = buyingVacationPaypalOrVisaPaymentView.paypalOrVisa.getItems().get((Integer) number2).toString();
                if (paymentWay.equals("Paypal account")) {
                    buyingVacationPaypalOrVisaPaymentView.id_buyer.setDisable(true);
                    buyingVacationPaypalOrVisaPaymentView.three_digits_behind.setDisable(true);
                    buyingVacationPaypalOrVisaPaymentView.card_number.setDisable(true);
                    buyingVacationPaypalOrVisaPaymentView.paypal_account.setDisable(false);
                    buyingVacationPaypalOrVisaPaymentView.paypal_password.setDisable(false);

                } else {
                    buyingVacationPaypalOrVisaPaymentView.id_buyer.setDisable(false);
                    buyingVacationPaypalOrVisaPaymentView.three_digits_behind.setDisable(false);
                    buyingVacationPaypalOrVisaPaymentView.card_number.setDisable(false);
                    buyingVacationPaypalOrVisaPaymentView.paypal_account.setDisable(true);
                    buyingVacationPaypalOrVisaPaymentView.paypal_password.setDisable(true);
                }
            }
        });
    }
    @Override
    public void start() {
        window.setTitle("Payment");
        window.show();
        buyingVacationPaypalOrVisaPaymentView.total_amount.setText(vacationModel.getCurrentVacation().getPrice());
    }

    public class ButtonPurchaseVacation implements EventHandler{
        @Override
        public void handle(Event event) {
            vacationModel.updateVacationStatus(Integer.parseInt(vacationModel.getCurrentVacation().getVacation_ID()),"done");
            ordersModel.updateOrderStatus(ordersModel.getCurrentOrder().getOrder_id(),"done");

            Alert alert = new Alert(Alert.AlertType.INFORMATION, "The vacation was successfully acquired" , ButtonType.OK);
            alert.showAndWait();

            vacationModel.setCurrentVacation(null);
            ordersModel.setCurrentOrder(null);
            window.close();
            mainController.activeSignInSuccessfuly();
        }
    }
}
