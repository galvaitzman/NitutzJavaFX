package View;

import Controller.ButtonBack;
import Model.Order;
import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class TheMoneyWasRecievedApprovalView extends AView{
    @FXML
    public TableView tableViewShowMoneyReceived;
    public TableColumn colBuyer;
    public TableColumn colVacationID;
    public Button back;

    public void start(ChangeListener changeListener){
        tableViewShowMoneyReceived.getSelectionModel().selectedItemProperty().addListener(changeListener);
        back.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED,new ButtonBack());
    }

    public void showApprovalsForMoneyRecieved (List<Order> listOfOrders) {
        tableViewShowMoneyReceived.getItems().clear();
        colBuyer.setCellValueFactory(new PropertyValueFactory<Order, String>("user_name_buyer"));
        colVacationID.setCellValueFactory(new PropertyValueFactory<Order, Integer>("Vacation_id"));
        for(int i=0; i<listOfOrders.size(); i++)
        {
            tableViewShowMoneyReceived.getItems().add(listOfOrders.get(i));
        }

    }
}
