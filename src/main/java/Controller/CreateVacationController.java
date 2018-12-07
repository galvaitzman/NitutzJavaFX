package Controller;

import View.CreateVacationView;

public class CreateVacationController extends Controller {
    private CreateVacationView createVacationView;
    public CreateVacationController(){
        super("CreateVacation2.fxml");
        createVacationView = fxmlLoader.getController();
        //createVacationView.start(new ButtonSignInClickedHandler(),new ButtonSignUpClickedHandler(),new ButtonSignInAsGuestClickedHandler());
    }

    @Override
    public void start() {
        window.show();
        window.setTitle("Create vacation");
    }
}
