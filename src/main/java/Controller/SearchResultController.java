package Controller;

import Model.Vacation;
import View.SearchResultView;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableView;

public class SearchResultController extends Controller {
    SearchResultView searchResultView;
    public SearchResultController(){
        super("SearchResult.fxml");
         searchResultView = fxmlLoader.getController();
         searchResultView.start(new ChangeListener() {
             @Override
             public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                 if(searchResultView.tableViewShowVacations.getSelectionModel().getSelectedItem() != null)
                 {
                     TableView.TableViewSelectionModel selectionModel = searchResultView.tableViewShowVacations.getSelectionModel();
                     Vacation selectedVacation = (Vacation) selectionModel.getSelectedItem();
                     vacationModel.setCurrentVacation(selectedVacation);
                     window.close();
                     mainController.activeViewVacationController();
                 }
             }
         });
    }
    @Override
    public void start() {
        searchResultView.showVacations(vacationModel.getCurrentListOfVacations());
        window.show();
    }
}
