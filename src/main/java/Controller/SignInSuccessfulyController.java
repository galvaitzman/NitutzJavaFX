package Controller;

import View.SignInSuccessfulyView;
import javafx.event.Event;
import javafx.event.EventHandler;

public class SignInSuccessfulyController extends Controller {
    SignInSuccessfulyView signInSuccessfulyView;
    public SignInSuccessfulyController(){
        super("SignInSuccessfuly.fxml");
        signInSuccessfulyView = fxmlLoader.getController();
        signInSuccessfulyView.start(new ButtonSearchVacation(), new ButtonManageMyUser(), new ButtonMyVacations(),
                new ButtonCreateVacation(), new ButtonShowRequests(), new ButtonShowApprovals());
    }
    @Override
    public void start() {
        window.show();
        if (userModel.getCurrent_user().getUser_name().equals("")){
            signInSuccessfulyView.myVacations.setVisible(false);
            signInSuccessfulyView.manageMyUser.setVisible(false);
            signInSuccessfulyView.createNewVacation.setVisible(false);
        }
        if (ordersModel.getOrdersInCaseSeller().size()>0){
            signInSuccessfulyView.requestButton.setVisible(true);
            signInSuccessfulyView.alert("You have new requests for purchasing your vacations");
        }
        else{
            signInSuccessfulyView.requestButton.setVisible(false);
        }
        if (ordersModel.getOrdersInCaseBuyer().size()>0){
            signInSuccessfulyView.approvalButton.setVisible(true);
            signInSuccessfulyView.alert("You have new approvals for your vacation purchases requests");
        }
        else{
            signInSuccessfulyView.approvalButton.setVisible(false);
        }

    }

    public class ButtonSearchVacation implements EventHandler{
        @Override
        public void handle(Event event) {
            window.close();
            mainController.activaSearchVacationController();
        }
    }

    public class ButtonManageMyUser implements EventHandler{
        @Override
        public void handle(Event event) {
            window.close();
            mainController.activeAfterSignInContoller();
        }
    }

    public class ButtonMyVacations implements EventHandler{
        @Override
        public void handle(Event event) {
            vacationModel.searchVacationsByUser_Id();
            window.close();
            mainController.activeMyVacationsController();
        }
    }

    public class ButtonCreateVacation implements EventHandler{
        @Override
        public void handle(Event event) {
            window.close();
            mainController.activeCreateVacationController();
        }
    }

    public class ButtonShowRequests implements EventHandler{
        @Override
        public void handle(Event event) {
            window.close();
            mainController.activeShowRequestsController();
        }
    }

    public class ButtonShowApprovals implements EventHandler{
        @Override
        public void handle(Event event) {
            window.close();
            mainController.activeShowApprovalsController();
        }
    }
}
