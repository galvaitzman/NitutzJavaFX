package View;

import Controller.ButtonBack;
import Model.Order;
import Model.Trade;
import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class ShowTradeRequestsView {
    @FXML
    public TableView tableViewShowTradeRequests;
    public TableColumn colBuyer;
    public TableColumn colVacationIDBuyer;
    public TableColumn colVacationIDSeller;
    public Button back;

    public void start(ChangeListener changeListener){
        tableViewShowTradeRequests.getSelectionModel().selectedItemProperty().addListener(changeListener);
        back.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED,new ButtonBack());
    }

    public void showTradeRequests (List<Order> listOfTradeRequests) {
        tableViewShowTradeRequests.getItems().clear();
        colBuyer.setCellValueFactory(new PropertyValueFactory<Trade, String>("user_name_buyer"));
        colVacationIDBuyer.setCellValueFactory(new PropertyValueFactory<Trade, Integer>("vacation_id_buyer"));
        colVacationIDSeller.setCellValueFactory(new PropertyValueFactory<Trade, Integer>("vacation_id_seller"));
        for(int i=0; i<listOfTradeRequests.size(); i++)
        {
            tableViewShowTradeRequests.getItems().add(listOfTradeRequests.get(i));
        }

    }
}
