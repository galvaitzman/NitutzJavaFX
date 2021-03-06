package View;

import Controller.ButtonBack;
import Model.Vacation;
import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class MyVacationsToTradeView {
    @FXML
    public TableView tableViewShowVacationsToTrade;
    public TableColumn colFrom;
    public TableColumn colTo;
    public TableColumn colDepartureDate;
    public TableColumn colReturnDate;
    public TableColumn colPrice;
    public TableColumn colVacationID;
    public Button back;
    public void start(ChangeListener changeListener){
        tableViewShowVacationsToTrade.getSelectionModel().selectedItemProperty().addListener(changeListener);
        back.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED,new ButtonBack());
    }

    public void showVacationsToTrade (List<Vacation> listOfVacations){

        tableViewShowVacationsToTrade.getItems().clear();
        colFrom.setCellValueFactory(new PropertyValueFactory<Vacation,String>("Departure_city"));
        colTo.setCellValueFactory(new PropertyValueFactory<Vacation,String>("Destination_city"));
        colDepartureDate.setCellValueFactory(new PropertyValueFactory<Vacation,String>("Flight_date_1"));
        colReturnDate.setCellValueFactory(new PropertyValueFactory<Vacation,String>("Flight_date_2"));
        colPrice.setCellValueFactory(new PropertyValueFactory<Vacation,String>("Price"));
        colVacationID.setCellValueFactory(new PropertyValueFactory<Vacation,String>("Vacation_ID"));

        for(int i = 0; i < listOfVacations.size(); i++)
        {
            tableViewShowVacationsToTrade.getItems().add(listOfVacations.get(i));
        }
    }
}
