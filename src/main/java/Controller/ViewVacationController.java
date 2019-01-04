package Controller;

import Model.AModel;
import View.ViewVacationDetailsView;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class ViewVacationController extends Controller {
    private ViewVacationDetailsView viewVacationDetailsView;
    public ViewVacationController(){
        setFxmlLoader("ViewVacationDetails.fxml");
        viewVacationDetailsView = fxmlLoader.getController();
        viewVacationDetailsView.start(new ButtonRequestOrder(), new ButtonSignIn(), new ButtonTradeVacation());
    }

    @Override
    public void start() {
        window.show();
        window.setTitle("View Vacation Offer");
        viewVacationDetailsView.showVacationDetails(vacationModel.getCurrentVacation().getVacation_details());
        if (userModel.getCurrent_user().getUser_name().equals("")){
            viewVacationDetailsView.requestOrderButton.setVisible(false);
            viewVacationDetailsView.label1.setVisible(true);
            viewVacationDetailsView.label2.setVisible(true);
            viewVacationDetailsView.signInButton.setVisible(true);
        }
        else{
            viewVacationDetailsView.requestOrderButton.setVisible(true);
            viewVacationDetailsView.label1.setVisible(false);
            viewVacationDetailsView.label2.setVisible(false);
            viewVacationDetailsView.signInButton.setVisible(false);
        }

    }

    public class ButtonRequestOrder implements EventHandler {
        @Override
        public void handle(Event event) {
            String sellerId = vacationModel.getCurrentVacation().getVacation_details()[1];
            String vacationId = vacationModel.getCurrentVacation().getVacation_details()[0];
            String numOfTickets = vacationModel.getCurrentVacation().getVacation_details()[14];
            if(sellerId.equals(AModel.current_user.getUser_name()))
            {
                Alert alertRequestError = new Alert(Alert.AlertType.INFORMATION, "You can not purchase you own vacation!", ButtonType.OK);
                alertRequestError.show();
            }
            else {
                ordersModel.insertOrderToDB(sellerId, Integer.parseInt(vacationId), numOfTickets);
                Alert alertRequestSubmitted = new Alert(Alert.AlertType.INFORMATION, "Your request has been submitted!", ButtonType.OK);
                window.close();
                mainController.activeSearchResultContoller();
                alertRequestSubmitted.show();
            }
        }
    }

    public class ButtonSignIn implements EventHandler{
        @Override
        public void handle(Event event) {
            window.close();
            mainController.activeInitialController();
        }
    }
    public class ButtonTradeVacation implements EventHandler{
        @Override
        public void handle(Event event) {
            String sellerId = vacationModel.getCurrentVacation().getVacation_details()[1];
            if(sellerId.equals(AModel.current_user.getUser_name())){
                Alert alertRequestError = new Alert(Alert.AlertType.INFORMATION, "You can not trade with you own vacation!", ButtonType.OK);
                alertRequestError.show();
            }
            else {
                window.close();
                mainController.activeMyVacationToTradeController();
            }
        }
    }


}
