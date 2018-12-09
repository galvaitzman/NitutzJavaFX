package View;

import Controller.CreateVacationController;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class CreateVacationPaymentView extends AView{
    @FXML
    public Button postVacation;
    public volatile ChoiceBox paypalOrBank;
    public TextField bank_number;
    public TextField branch_number;
    public TextField account_number;
    public TextField paypal;
    public void start(CreateVacationController.ButtonPostVacation buttonPostVacation,
                      ChangeListener changeListener){
        paypalOrBank.getSelectionModel().selectedIndexProperty().addListener(changeListener);
        postVacation.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED,buttonPostVacation);
        ObservableList<String> bankOtrPaypalItems = FXCollections.observableArrayList();
        bankOtrPaypalItems.add("Bank account");
        bankOtrPaypalItems.add("Paypal account");
        paypalOrBank.setItems(bankOtrPaypalItems);
    }


}
