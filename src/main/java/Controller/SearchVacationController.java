package Controller;

import View.SearchVacationView;
import javafx.event.Event;
import javafx.event.EventHandler;

public class SearchVacationController extends AVacationController {

    SearchVacationView searchVacationView;
    public SearchVacationController(){
        super("SearchVacation.fxml");
        searchVacationView = fxmlLoader.getController();
        searchVacationView.start(new ButtonSearchVacation());
    }
    @Override
    public void start() {
        window.setTitle("Search Vacation");
        window.show();
    }

    public class ButtonSearchVacation implements EventHandler {
        @Override
        public void handle(Event event) {
            if (!searchVacationView.isValidDate()) return;
            if (!searchVacationView.isOneFieldsFull()) return;

        }
    }
}
