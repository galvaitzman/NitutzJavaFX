package View;

import Model.Order;
import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class ShowRequestsView {
    @FXML
    public TableView tableViewShowRequests;
    public TableColumn colBuyer;
    public TableColumn colVacationID;

    public void start(ChangeListener changeListener){
        tableViewShowRequests.getSelectionModel().selectedItemProperty().addListener(changeListener);
    }

    public void showRequests (List<Order> listOfOrders) {
        tableViewShowRequests.getItems().clear();
        colBuyer.setCellValueFactory(new PropertyValueFactory<Order, String>("user_name_buyer"));
        colVacationID.setCellValueFactory(new PropertyValueFactory<Order, Integer>("Vacation_id"));
        for(int i=0; i<listOfOrders.size(); i++)
        {
            tableViewShowRequests.getItems().add(listOfOrders.get(i));
        }

    }
}
