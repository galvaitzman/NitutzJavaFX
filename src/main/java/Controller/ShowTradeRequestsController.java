package Controller;

import Model.Trade;
import View.ShowTradeRequestsView;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;

public class ShowTradeRequestsController extends Controller{
    private ShowTradeRequestsView showTradeRequestsView;
    public ShowTradeRequestsController(){
        setFxmlLoader("ShowTradeRequests.fxml");
        showTradeRequestsView = fxmlLoader.getController();
        showTradeRequestsView.start(new ChangeListener() {
        @Override
        public void changed(ObservableValue observable, Object oldValue, Object newValue) {
            if(showTradeRequestsView.tableViewShowTradeRequests.getSelectionModel().getSelectedItem() != null)
            {
                TableView.TableViewSelectionModel selectionModel = showTradeRequestsView.tableViewShowTradeRequests.getSelectionModel();
                Trade selectedTrade = (Trade) selectionModel.getSelectedItem();
                tradeModel.setCurrentTrade(selectedTrade);
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Confirm Trade?" , ButtonType.YES, ButtonType.NO);
                alert.showAndWait();

                if (alert.getResult() == ButtonType.YES) {
                    tradeModel.updateTradeStatus(selectedTrade.getTrade_id(),"Approved");
                    vacationModel.updateVacationStatus(selectedTrade.getVacation_id_buyer(),"done");
                    vacationModel.updateVacationStatus(selectedTrade.getVacation_id_seller(),"done");
                   // tradeModel.changeStatusForAllTradesAfterShowedToTheSellerAndApproved();
                    tradeModel.CancleAllTradesContainIdVacation(selectedTrade.getVacation_id_buyer());
                    tradeModel.CancleAllTradesContainIdVacation(selectedTrade.getVacation_id_seller());

                    ordersModel.cancleAllVacationIdWhenApproveTrade(selectedTrade.getVacation_id_buyer(),selectedTrade.getVacation_id_seller());
                }
                else{
                    tradeModel.updateTradeStatus(selectedTrade.getTrade_id(),"Rejected");
                }
                window.close();
                mainController.goBackToPreviousController();
            }
        }
    });
}
    @Override
    public void start() {
        showTradeRequestsView.showTradeRequests(tradeModel.getTradesInCaseSeller());
        window.show();
    }
}
