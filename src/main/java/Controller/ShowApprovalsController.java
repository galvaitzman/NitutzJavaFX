package Controller;

import Model.Order;
import Model.Vacation;
import View.ShowApprovalsView;
import View.ShowRequestsView;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableView;

public class ShowApprovalsController extends Controller {
    private ShowApprovalsView showApprovalsView;

    public ShowApprovalsController() {
        super("ShowApprovals.fxml");
        showApprovalsView = fxmlLoader.getController();
        showApprovalsView.start(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                if (showApprovalsView.tableViewShowApprovals.getSelectionModel().getSelectedItem() != null) {
                    TableView.TableViewSelectionModel selectionModel = showApprovalsView.tableViewShowApprovals.getSelectionModel();
                    Order selectedOrder = (Order) selectionModel.getSelectedItem();
                    ordersModel.setCurrentOrder(selectedOrder);
                    window.close();
                    mainController.activeBuyingVacationPaypalOrVisaPaymentController();
                }
            }
        });
    }

    @Override
    public void start() {
        showApprovalsView.showApprovals(ordersModel.getOrdersInCaseBuyer());//
        window.show();//
    }
}
