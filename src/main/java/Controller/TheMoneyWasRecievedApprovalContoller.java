package Controller;

import Model.Order;
import View.TheMoneyWasRecievedApprovalView;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;

public class TheMoneyWasRecievedApprovalContoller extends Controller{
    private TheMoneyWasRecievedApprovalView theMoneyWasRecievedApprovalView;
    public TheMoneyWasRecievedApprovalContoller(){
        super("TheMoneyWasRecievedApproval.fxml");
        theMoneyWasRecievedApprovalView = fxmlLoader.getController();
        theMoneyWasRecievedApprovalView.start(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                if(theMoneyWasRecievedApprovalView.tableViewShowMoneyReceived.getSelectionModel().getSelectedItem() != null)
                {
                    TableView.TableViewSelectionModel selectionModel = theMoneyWasRecievedApprovalView.tableViewShowMoneyReceived.getSelectionModel();
                    Order selectedOrder = (Order) selectionModel.getSelectedItem();
                    ordersModel.setCurrentOrder(selectedOrder);

                    //  mainController.activeYesOrNoForRequestController();
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Did you got the money for this vacation?" , ButtonType.YES, ButtonType.NO);
                    alert.showAndWait();

                    if (alert.getResult() == ButtonType.YES) {
                        ordersModel.cancleAllVacationIdWhenApproveOrder(selectedOrder.getOrder_id(),selectedOrder.getVacation_id());
                        vacationModel.updateVacationStatus(selectedOrder.getVacation_id(),"in order");
                    }
                    else{
                        ordersModel.updateOrderStatus(selectedOrder.getOrder_id(),"canceled");
                    }
                    window.close();
                    mainController.goBackToPreviousController();
                }
            }
        });
    }
    @Override
    public void start() {
        theMoneyWasRecievedApprovalView.showApprovalsForMoneyRecieved(ordersModel.getOrdersInCaseSeller("waiting for payment"));
        window.show();
    }


}
