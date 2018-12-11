package Controller;

import Model.AModel;
import View.AfterSignInView;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.WindowEvent;

public class AfterSignInController extends Controller {
    private AfterSignInView afterSignInView;//



    public AfterSignInController(){
        super("UserManagment.fxml");
        afterSignInView = fxmlLoader.getController();
        afterSignInView.start(new ButtonUpdateMyUserClickedHandler(),new ButtonSearchUserClickedHandler(),new ButtonDeleteClickedHandler());
        window.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                if (userModel.getCurrent_user().getUser_name().equals("")) {
                    window.close();
                    mainController.activeInitialController();
                }
            }
        });

    }
    @Override
    public void start() {
        window.setTitle("Vacation4U");
        window.show();

        if (userModel.getCurrent_user().getUser_name().equals(""))
        {
            afterSignInView.deleteMyUserButton.setVisible(false);
            afterSignInView.updateMyUserButton.setVisible(false);
            afterSignInView.userNameLable.setText("Guest");

        }
        else {
            afterSignInView.deleteMyUserButton.setVisible(true);
            afterSignInView.updateMyUserButton.setVisible(true);
            afterSignInView.userNameLable.setText(userModel.getCurrent_user().getUser_name());
        }
        //afterSignInView.updateMyUserButton = (Button)root.lookup("#updateMyUserButton");
        //afterSignInView.searchUserButton = (Button)root.lookup("#searchUserButton");
        //afterSignInView.deleteMyUserButton = (Button)root.lookup("#deleteMyUserButton");



    }


    public class ButtonUpdateMyUserClickedHandler implements EventHandler {
        @Override
        public void handle(Event event) {
            //window.close();
            mainController.activeUpdateController();
        }
    }

    public class ButtonSearchUserClickedHandler implements EventHandler{
        @Override
        public void handle(Event event) {
            //window.close();
            mainController.activeSearchController();
        }
    }

    public class ButtonDeleteClickedHandler implements EventHandler{
        @Override
        public void handle(Event event) {
            //window.close();
            userModel.delete(userModel.getCurrent_user().getUser_name());
            window.close();
            mainController.activeInitialController();
            afterSignInView.showAlert("The user has been deleted");
        }
    }

    public String getCurrentUser(){
        return userModel.getCurrent_user().getUser_name() ;
    }
}
