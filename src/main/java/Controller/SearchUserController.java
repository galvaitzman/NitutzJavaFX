package Controller;

import View.SearchView;
import javafx.event.Event;
import javafx.event.EventHandler;

import java.util.List;

public class SearchUserController extends Controller {

    SearchView searchView;

    public SearchUserController(){
        super("Search.fxml");
        searchView = fxmlLoader.getController();
        searchView.start(new ButtonSearchUserClickedHandler());
    }
    @Override
    public void start(){
        window.show();
        window.setTitle("Search For User");
        searchView.usernameTextBox.setText("");
        //signUpView.signUpButton = (Button)root.lookup("#signUpButton");

    }

    public class ButtonSearchUserClickedHandler implements EventHandler{
        @Override
        public void handle(Event event) {
            List<String> list = userModel.searchUserByUserName(searchView.usernameTextBox.getText());
            if (!list.isEmpty()){
               searchView.setTxtFields(list.get(2),list.get(3),list.get(4),list.get(5),list.get(6));
            }
            else{

                searchView.setTxtFields("","","","","");
                searchView.errorUsernameLable.setVisible(true);
            }
        }
    }

    public class ButtonClearDataClickedHandler implements EventHandler{
        @Override
        public void handle(Event event) {

        }
    }
}
