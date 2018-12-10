package View;

import Controller.BuyingVacationPaypalOrVisaPaymentController;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class BuyingVacationPaypalOrVisaPaymentView extends AView{
    @FXML
    public Button confirm;
    public ChoiceBox paypalOrVisa;
    public TextField id_buyer;
    public TextField card_number;
    public TextField three_digits_behind;
    public TextField paypal_account;
    public TextField total_amount;
    public TextField paypal_password;
//    need to change the controller to baying
    public void start(BuyingVacationPaypalOrVisaPaymentController.ButtonPurchaseVacation buttonPurchaseVacation, ChangeListener changeListener){
        paypalOrVisa.getSelectionModel().selectedIndexProperty().addListener(changeListener);
        confirm.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED,buttonPurchaseVacation);
        ObservableList<String> paypalOrViseItems = FXCollections.observableArrayList();
        paypalOrViseItems.add("Paypal account");
        paypalOrViseItems.add("Visa account");
        paypalOrVisa.setItems(paypalOrViseItems);
        total_amount.setEditable(false);

    }
}
