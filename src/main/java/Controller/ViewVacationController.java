package Controller;

import View.ViewVacationDetailsView;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewVacationController extends Controller {
    private ViewVacationDetailsView viewVacationDetailsView;
    public ViewVacationController(){
        super("ViewVacationDetails.fxml");
        viewVacationDetailsView = fxmlLoader.getController();
    }

    @Override
    public void start() {
        window.show();
        window.setTitle("Create vacation");
    }

    public class ButtonNumberOfTickets implements EventHandler {
        @Override
        public void handle(Event event) {
            viewVacationDetailsView.enableVacationType();

        }
    }

    public class ButtonFlightBack implements EventHandler{
        @Override
        public void handle(Event event) {
            viewVacationDetailsView.enableOrDisableFlightBackDetails();
        }
    }




}
