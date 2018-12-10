package View;

import Model.Vacation;
import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class SearchResultView extends AView {
    @FXML
    public TableView tableViewShowVacations;
    public TableColumn colFrom;
    public TableColumn colTo;
    public TableColumn colDepartureDate;
    public TableColumn colReturnDate;
    public TableColumn colPrice;

    public void start(ChangeListener changeListener){
        tableViewShowVacations.getSelectionModel().selectedItemProperty().addListener(changeListener);
    }

    public void showVacations (List<Vacation> listOfVacations){

        colFrom.setCellValueFactory(new PropertyValueFactory<Vacation,String>("Departure_city"));
        colTo.setCellValueFactory(new PropertyValueFactory<Vacation,String>("Destination_city"));
        colDepartureDate.setCellValueFactory(new PropertyValueFactory<Vacation,String>("Flight_date_1"));
        colReturnDate.setCellValueFactory(new PropertyValueFactory<Vacation,String>("Flight_date_2"));
        colPrice.setCellValueFactory(new PropertyValueFactory<Vacation,String>("Price"));




        for(int i=0; i<listOfVacations.size(); i++)
        {

        tableViewShowVacations.getItems().add(listOfVacations.get(i));

        }
    }

}





