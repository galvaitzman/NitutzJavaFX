package Controller;

import Model.Order;
import Model.Vacation;
import View.ShowRequestsView;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableView;

public class ShowRequestsController extends Controller {
    private ShowRequestsView showRequestsView;
    public ShowRequestsController(){
        super("ShowRequests.fxml");
        showRequestsView = fxmlLoader.getController();
        showRequestsView.start(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                if(showRequestsView.tableViewShowRequests.getSelectionModel().getSelectedItem() != null)
                {
                    TableView.TableViewSelectionModel selectionModel = showRequestsView.tableViewShowRequests.getSelectionModel();
                    Order selectedOrder = (Order) selectionModel.getSelectedItem();
                    ordersModel.setCurrentOrder(selectedOrder);
                    window.close();
                    mainController.activeYesOrNoForRequestController();
                }
            }
        });
    }
    @Override
    public void start() {
        showRequestsView.showRequests(ordersModel.getOrdersInCaseSeller());
        window.show();
    }


}
