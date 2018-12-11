package View;

import Controller.ShowApprovalsController;
import Model.Order;
import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class ShowApprovalsView {
    @FXML
    public TableView tableViewShowApprovals;//
    public TableColumn colSeller;
    public TableColumn colVacationID;
    public Button backButton;

    public void start(ShowApprovalsController.ButtonBackClickedHandler backButtonClicked,
                      ChangeListener changeListener){
        backButton.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED,backButtonClicked);
        tableViewShowApprovals.getSelectionModel().selectedItemProperty().addListener(changeListener);
    }

    public void showApprovals (List<Order> listOfOrders) {
        tableViewShowApprovals.getItems().clear();
        colSeller.setCellValueFactory(new PropertyValueFactory<Order, String>("user_name_seller"));
        colVacationID.setCellValueFactory(new PropertyValueFactory<Order, String>("Vacation_id"));
        for(int i=0; i<listOfOrders.size(); i++)
        {
            tableViewShowApprovals.getItems().add(listOfOrders.get(i));
        }

    }
}
