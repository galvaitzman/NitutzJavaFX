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
                new ButtonCreateVacation(), new ButtonShowRequests(), new ButtonShowApprovals(),
                new ButtonShowMoneyReceiving(), new ButtonShowAllVacations(), new ButtonShowTradeRequests(), new ButtonShowApprovedfOrRejectedTrades());
    }
    @Override
    public void start() {

        window.show();
        if (userModel.getCurrent_user().getUser_name().equals("")){
            signInSuccessfulyView.myVacations.setVisible(false);
            signInSuccessfulyView.manageMyUser.setVisible(false);
            signInSuccessfulyView.createNewVacation.setVisible(false);
        }
        else {
            signInSuccessfulyView.myVacations.setVisible(true);
            signInSuccessfulyView.manageMyUser.setVisible(true);
            signInSuccessfulyView.createNewVacation.setVisible(true);
        }
        if (ordersModel.getOrdersInCaseSeller("waiting for approval of purchase offer").size()>0 && !userModel.getCurrent_user().getUser_name().equals("")){
            signInSuccessfulyView.requestButton.setVisible(true);
            signInSuccessfulyView.alert("You have new purchase requests for your vacations");
        }
        else{
            signInSuccessfulyView.requestButton.setVisible(false);
        }
        if (ordersModel.getOrdersInCaseBuyer().size()>0 && !userModel.getCurrent_user().getUser_name().equals("")){
            signInSuccessfulyView.approvalButton.setVisible(true);
            signInSuccessfulyView.alert("You have new approvals for your vacation purchases requests");
        }
        else{
            signInSuccessfulyView.approvalButton.setVisible(false);
        }
        if (ordersModel.getOrdersInCaseSeller("waiting for payment").size()>0 && !userModel.getCurrent_user().getUser_name().equals("")){
            signInSuccessfulyView.moneyRecievedButton.setVisible(true);
            signInSuccessfulyView.alert("Please approve receiving the money for your vacation");
        }
        else{
            signInSuccessfulyView.moneyRecievedButton.setVisible(false);
        }
        if (tradeModel.getTradesInCaseSeller().size()>0 && !userModel.getCurrent_user().getUser_name().equals("")){

            signInSuccessfulyView.tradeButton.setVisible(true);
            signInSuccessfulyView.alert("You have new requests for trade for your vacations");
        }
        else{
            signInSuccessfulyView.tradeButton.setVisible(false);
        }
        if (tradeModel.getTradesInCaseBuyer().size()>0 && !userModel.getCurrent_user().getUser_name().equals("")){
            signInSuccessfulyView.approvedfOrRejectedTradeButton.setVisible(true);
            signInSuccessfulyView.alert("You have new updates for your requests to trades");
        }
        else{
            signInSuccessfulyView.approvedfOrRejectedTradeButton.setVisible(false);
        }



    }

    public class ButtonSearchVacation implements EventHandler{
        @Override
        public void handle(Event event) {
            window.close();
            window.setTitle("Vacation4U");
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
            mainController.activeMyVacationsController();//
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

    public class ButtonShowAllVacations implements EventHandler{
        @Override
        public void handle(Event event) {
            window.close();
            vacationModel.searchAllVacation();
            mainController.activeSearchResultContoller();
        }
    }


    public class ButtonShowMoneyReceiving implements EventHandler{
        @Override
        public void handle(Event event) {
            window.close();
            mainController.activeTheMoneyWasRecievedApprovalContoller();
        }
    }

    public class ButtonShowTradeRequests implements EventHandler{
        @Override
        public void handle(Event event) {
            window.close();
            mainController.activeShowTradesControllers();
        }
    }


    public class ButtonShowApprovedfOrRejectedTrades implements EventHandler{
        @Override
        public void handle(Event event) {
            window.close();
            mainController.activeButtonShowApprovedfOrRejectedTradesController();
        }
    }


}
