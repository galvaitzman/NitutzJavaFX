package Controller;

import Model.Order;
import View.ShowApprovalsView;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.TableView;

public class ShowApprovalsController extends Controller {
    private ShowApprovalsView showApprovalsView;

    public ShowApprovalsController() {
        super("ShowApprovals.fxml");
        showApprovalsView = fxmlLoader.getController();
        showApprovalsView.start(new ButtonBackClickedHandler(), new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                if (showApprovalsView.tableViewShowApprovals.getSelectionModel().getSelectedItem() != null) {
                    TableView.TableViewSelectionModel selectionModel = showApprovalsView.tableViewShowApprovals.getSelectionModel();
                    Order selectedOrder = (Order) selectionModel.getSelectedItem();
                    ordersModel.setCurrentOrder(selectedOrder);
                    vacationModel.setCurrentVacation(vacationModel.searchVacationByVacationID(selectedOrder.getVacation_id()));
                    window.close();
                    mainController.activeBuyingVacationPaypalOrVisaPaymentController();
                }
            }
        });
    }

    @Override
    public void start() {
        showApprovalsView.showApprovals(ordersModel.getOrdersInCaseBuyer());//
        window.setTitle("Vacation Approvals");
        window.show();//
    }

    public class ButtonBackClickedHandler implements EventHandler {
        @Override
        public void handle(Event event) {
            window.close();
            mainController.activeSignInSuccessfuly();
        }
    }
}
