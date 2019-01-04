package Controller;

import View.SearchVacationView;
import javafx.event.Event;
import javafx.event.EventHandler;

public class SearchVacationController extends Controller {

    SearchVacationView searchVacationView;
    public SearchVacationController(){
        setFxmlLoader("SearchVacation.fxml");
        searchVacationView = fxmlLoader.getController();
        searchVacationView.start(new ButtonBackClickedHandler(), new ButtonSearchVacation());
    }
    @Override
    public void start() {
        window.setTitle("Search For Vacations");
        window.show();
    }

    public class ButtonSearchVacation implements EventHandler {
        @Override
        public void handle(Event event) {
            if (!searchVacationView.isValidDate()) return;
            if (!searchVacationView.isOneFieldsFull()) return;
            String departDate;
            String returnDate;
            if (searchVacationView.departDate.getValue() == null) departDate="";
            else departDate = searchVacationView.departDate.getValue().toString();
            if (searchVacationView.returnDate.getValue() == null) returnDate="";
            else returnDate = searchVacationView.returnDate.getValue().toString();
            vacationModel.searchVacationsByParameters(departDate,returnDate,
            searchVacationView.from.getText(),searchVacationView.to.getText());
            mainController.activeSearchResultContoller();
            window.close();
        }
    }

    public class ButtonBackClickedHandler implements EventHandler {
        @Override
        public void handle(Event event) {
            window.close();
            mainController.activeSignInSuccessfuly();
        }
    }

}
