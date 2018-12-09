package Controller;

import View.AfterSignInView;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.WindowEvent;

public class AfterSignInController extends AUserController {
    private AfterSignInView afterSignInView;//
    private String currentUser="";


    public AfterSignInController(){
        super("AfterSignIn.fxml");
        afterSignInView = fxmlLoader.getController();
        afterSignInView.start(new ButtonUpdateMyUserClickedHandler(),new ButtonSearchUserClickedHandler(),new ButtonDeleteClickedHandler());
        window.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                if (currentUser.equals("")) {
                    window.close();
                    mainController.activeInitialController();
                }
            }
        });

    }
    @Override
    public void start() {
        window.show();
        window.setTitle("Vacation4U");

        if (currentUser.equals(""))
        {
            afterSignInView.deleteMyUserButton.setVisible(false);
            afterSignInView.updateMyUserButton.setVisible(false);
            afterSignInView.userNameLable.setText("Guest");

        }
        else {
            afterSignInView.deleteMyUserButton.setVisible(true);
            afterSignInView.updateMyUserButton.setVisible(true);
            afterSignInView.userNameLable.setText(currentUser);
        }
        //afterSignInView.updateMyUserButton = (Button)root.lookup("#updateMyUserButton");
        //afterSignInView.searchUserButton = (Button)root.lookup("#searchUserButton");
        //afterSignInView.deleteMyUserButton = (Button)root.lookup("#deleteMyUserButton");



    }

    public void setCurrentUser(String currentUser){
        this.currentUser=currentUser;
    }

    public class ButtonUpdateMyUserClickedHandler implements EventHandler {
        @Override
        public void handle(Event event) {
            //window.close();
            mainController.activeUpdateController(afterSignInView.userNameLable.getText());
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
            userModel.delete(currentUser);
            window.close();
            mainController.activeInitialController();
            afterSignInView.showAlert("The user has been deleted");
        }
    }

    public String getCurrentUser(){
        return currentUser;
    }
}
