package View;

import Controller.ButtonBack;
import Model.Trade;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class ShowApprovedOrRejectedTradesView extends AView{
    @FXML
    public TableView tableViewShowApprovedOrRejectedTrades;
    public TableColumn colSeller;
    public TableColumn colVacationIdSeller;
    public TableColumn colVacationIdBuyer;
    public TableColumn colStatus;

    public Button back;

    public void start(){
        back.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED,new ButtonBack());
    }

    public void ShowApprovedOrRejectedTradesFunction (List<Trade> listOfTrades) {
        tableViewShowApprovedOrRejectedTrades.getItems().clear();
        colSeller.setCellValueFactory(new PropertyValueFactory<Trade, String>("user_name_seller"));
        colVacationIdSeller.setCellValueFactory(new PropertyValueFactory<Trade, String>("vacation_id_seller"));
        colVacationIdBuyer.setCellValueFactory(new PropertyValueFactory<Trade, String>("vacation_id_buyer"));
        colStatus.setCellValueFactory(new PropertyValueFactory<Trade, String>("trade_status"));


        for(int i=0; i<listOfTrades.size(); i++)
        {
            tableViewShowApprovedOrRejectedTrades.getItems().add(listOfTrades.get(i));
        }

    }
}
