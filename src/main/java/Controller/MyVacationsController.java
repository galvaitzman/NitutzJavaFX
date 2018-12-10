package Controller;

import Model.Vacation;
import View.MyVacationsView;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableView;

public class MyVacationsController extends Controller {
    private MyVacationsView myVacationsView;
    public MyVacationsController(){
        super("MyVacations.fxml");
        myVacationsView = fxmlLoader.getController();
        myVacationsView.start(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                if(myVacationsView.tableViewShowVacations.getSelectionModel().getSelectedItem() != null)
                {
                    TableView.TableViewSelectionModel selectionModel = myVacationsView.tableViewShowVacations.getSelectionModel();
                    Vacation selectedVacation = (Vacation) selectionModel.getSelectedItem();
                    vacationModel.setCurrentVacation(selectedVacation);
                    window.close();

                }
            }
        });
    }
    @Override
    public void start() {
        myVacationsView.showVacations(vacationModel.getCurrentListOfVacations());
        window.show();
    }
}
