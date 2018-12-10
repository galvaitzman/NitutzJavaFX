package View;

import Controller.CreateVacationController;
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
    public volatile ChoiceBox paypalOrVisa;
    public TextField id_bayer;
    public TextField card_number;
    public TextField three_digits_behind;
    public TextField paypal;
    public TextField total_amount;
//    need to change the controller to baying
    public void start(CreateVacationController.ButtonPostVacation buttonPostVacation,ChangeListener changeListener){
        paypalOrVisa.getSelectionModel().selectedIndexProperty().addListener(changeListener);
        confirm.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED,buttonPostVacation);
        ObservableList<String> paypalOrViseItems = FXCollections.observableArrayList();
        paypalOrViseItems.add("Paypal account");
        paypalOrViseItems.add("Visa account");
        paypalOrVisa.setItems(paypalOrViseItems);
    }
}
