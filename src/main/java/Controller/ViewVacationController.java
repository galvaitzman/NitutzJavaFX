package Controller;

import View.ViewVacationDetailsView;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class ViewVacationController extends Controller {
    private ViewVacationDetailsView viewVacationDetailsView;
    public ViewVacationController(){
        super("ViewVacationDetails.fxml");
        viewVacationDetailsView = fxmlLoader.getController();
        viewVacationDetailsView.start(new ButtonRequestOrder());
    }

    @Override
    public void start() {
        window.show();
        window.setTitle("View Vacation Offer");
        viewVacationDetailsView.showVacationDetails(vacationModel.getCurrentVacation().getVacation_details());
    }

    public class ButtonRequestOrder implements EventHandler {
        @Override
        public void handle(Event event) {
            String sellerId = vacationModel.getCurrentVacation().getVacation_details()[1];
            String vacationId = vacationModel.getCurrentVacation().getVacation_details()[0];
            String numOfTickets = vacationModel.getCurrentVacation().getVacation_details()[14];
            ordersModel.insertOrderToDB(sellerId, Integer.parseInt(vacationId), numOfTickets);
            Alert alertRequestSubmitted = new Alert(Alert.AlertType.INFORMATION, "Your request has been submitted!", ButtonType.OK);
            alertRequestSubmitted.show();
            window.close();
            mainController.activeSearchResultContoller();
        }
    }


}
