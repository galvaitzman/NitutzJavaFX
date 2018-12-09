package View;

import Model.Vacation;
import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;
import java.util.TreeMap;

public class SearchResultView {
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
        Vacation v = new Vacation();
        v.vacation_details= new String[]{"","","elal","arkia","17:00","18:00","19:00", "20:00","12","13","1993-04-18","1994-04-24","","","2","tlv","jerusalem","child","fun","","","700","","","sure","","","","","",""};
        colFrom.setCellValueFactory(new PropertyValueFactory<Vacation,String>("From"));
        colTo.setCellValueFactory(new PropertyValueFactory<Vacation,String>("To"));
        colDepartureDate.setCellValueFactory(new PropertyValueFactory<Vacation,String>("DepartureDate"));
        colReturnDate.setCellValueFactory(new PropertyValueFactory<Vacation,String>("ReturnDate"));
        colPrice.setCellValueFactory(new PropertyValueFactory<Vacation,String>("Price"));



        //for(int i=0; i<listOfVacations.size(); i++)
        //{
            /*String [] term = listOfVacations.get(0).vacation_details;
            String tf= term[0];*/
        tableViewShowVacations.getItems().add(v);

        //}
    }

}





