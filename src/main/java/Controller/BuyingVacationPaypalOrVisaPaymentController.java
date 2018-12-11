package Controller;

import View.BuyingVacationPaypalOrVisaPaymentView;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.event.EventHandler;

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
        window.show();
        buyingVacationPaypalOrVisaPaymentView.total_amount.setText(vacationModel.getCurrentVacation().getPrice());
    }

    public class ButtonPurchaseVacation implements EventHandler{
        @Override
        public void handle(Event event) {

        }
    }
}
