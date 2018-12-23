package Controller;

import Model.Vacation;
import View.MyVacationsToTradeView;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableView;

public class MyVacationsToTradeController extends Controller{
    private MyVacationsToTradeView myVacationsToTradeView;
    public MyVacationsToTradeController(){
        super("MyVacationsToTrade.fxml");
        myVacationsToTradeView = fxmlLoader.getController();
        myVacationsToTradeView.start( new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                if(myVacationsToTradeView.tableViewShowVacationsToTrade.getSelectionModel().getSelectedItem() != null)
                {
                    TableView.TableViewSelectionModel selectionModel = myVacationsToTradeView.tableViewShowVacationsToTrade.getSelectionModel();
                    Vacation selectedVacation = (Vacation) selectionModel.getSelectedItem();
                    tradeModel.insertTradeToDB(vacationModel.getCurrentVacation().getUser_name(),Integer.parseInt(vacationModel.getCurrentVacation().getVacation_ID()),Integer.parseInt(selectedVacation.getVacation_ID()));
                    vacationModel.setCurrentVacation(selectedVacation);
                    window.close();
                    mainController.goBackToPreviousController();

                }
            }
        });
    }
    @Override
    public void start() {
        myVacationsToTradeView.showVacationsToTrade(vacationModel.getCurrentListOfVacations());
        window.setTitle("My Vacations to trade");
        window.show();
    }



}
