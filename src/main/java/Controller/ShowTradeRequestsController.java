package Controller;

import Model.Order;
import View.ShowTradeRequestsView;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;

public class ShowTradeRequestsController extends Controller{
    private ShowTradeRequestsView showTradeRequestsView;
    public ShowTradeRequestsController(){
       super("ShowTradeRequests.fxml");
        showTradeRequestsView = fxmlLoader.getController();
        showTradeRequestsView.start(new ChangeListener() {
        @Override
        public void changed(ObservableValue observable, Object oldValue, Object newValue) {
            if(showTradeRequestsView.tableViewShowTradeRequests.getSelectionModel().getSelectedItem() != null)
            {
                TableView.TableViewSelectionModel selectionModel = showTradeRequestsView.tableViewShowTradeRequests.getSelectionModel();
                Order selectedOrder = (Order) selectionModel.getSelectedItem();
                ordersModel.setCurrentOrder(selectedOrder);

                //  mainController.activeYesOrNoForRequestController();
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Confirm request?" , ButtonType.YES, ButtonType.NO);
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
        showTradeRequestsView.showTradeRequests(ordersModel.getOrdersInCaseSeller("waiting for approval of purchase offer"));
        window.show();
    }
}
