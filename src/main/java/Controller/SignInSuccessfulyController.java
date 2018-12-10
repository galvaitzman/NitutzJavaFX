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
                new ButtonCreateVacation());
    }
    @Override
    public void start() {
        if (userModel.getCurrent_user().getUser_name().equals("")){
            signInSuccessfulyView.myVacations.setVisible(false);
            signInSuccessfulyView.manageMyUser.setVisible(false);
            signInSuccessfulyView.createNewVacation.setVisible(false);
        }

        window.show();
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
}
