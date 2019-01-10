package Controller;

import Model.Vacation;
import View.MyVacationsView;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.TableView;

public class MyVacationsController extends Controller {
    private MyVacationsView myVacationsView;
    public MyVacationsController(){
        super("MyVacations.fxml");
        myVacationsView = fxmlLoader.getController();
        myVacationsView.start(new ButtonBackClickedHandler(), new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                if(myVacationsView.tableViewShowVacations.getSelectionModel().getSelectedItem() != null)
                {
                    TableView.TableViewSelectionModel selectionModel = myVacationsView.tableViewShowVacations.getSelectionModel();
                    Vacation selectedVacation = (Vacation) selectionModel.getSelectedItem();
                    vacationModel.setCurrentVacation(selectedVacation);
                    window.close();
                    mainController.activeUpdateVacationController();
                }
            }
        });
    }
    @Override
    public void start() {
        myVacationsView.showVacations(vacationModel.getCurrentListOfVacations());
        window.setTitle("My Vacations");
        window.show();
    }

    public class ButtonBackClickedHandler implements EventHandler {
        @Override
        public void handle(Event event) {
            window.close();
            mainController.activeSignInSuccessfuly();
        }
    }

}
