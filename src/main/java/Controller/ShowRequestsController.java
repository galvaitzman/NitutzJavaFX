package Controller;

import Model.Order;
import Model.Vacation;
import View.ShowRequestsView;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;

public class ShowRequestsController extends Controller {
    private ShowRequestsView showRequestsView;
    public ShowRequestsController(){
        super("ShowRequests.fxml");
        showRequestsView = fxmlLoader.getController();
        showRequestsView.start(new ButtonBackClickedHandler(), new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                if(showRequestsView.tableViewShowRequests.getSelectionModel().getSelectedItem() != null)
                {
                    TableView.TableViewSelectionModel selectionModel = showRequestsView.tableViewShowRequests.getSelectionModel();
                    Order selectedOrder = (Order) selectionModel.getSelectedItem();
                    ordersModel.setCurrentOrder(selectedOrder);
                  //  window.close();
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
                    mainController.goBackToPreviousController();
                }
            }
        });
    }
    @Override
    public void start() {
        showRequestsView.showRequests(ordersModel.getOrdersInCaseSeller());
        window.setTitle("Vacation Requests");
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
