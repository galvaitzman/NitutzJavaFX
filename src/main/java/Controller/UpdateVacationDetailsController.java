package Controller;

import View.UpdateVacationDetailsView;
import javafx.event.Event;
import javafx.event.EventHandler;
import java.util.List;

public class UpdateVacationDetailsController extends Controller {

    private UpdateVacationDetailsView updateVacationDetailsView;

    public UpdateVacationDetailsController() {
        super("UpdateVacationDetails.fxml");
        updateVacationDetailsView = fxmlLoader.getController();
        updateVacationDetailsView.start(new ButtonNumberOfTickets(),new ButtonUpdate(), new ButtonFlightBack());
    }

    @Override
    public void start() {
        window.show();
        window.setTitle("Update Vacation");
        updateVacationDetailsView.setTxtFields(vacationModel.getCurrentVacation().getVacation_details());

    }

    public class ButtonUpdate implements EventHandler {
        @Override
        public void handle(Event event) {
                if (!updateVacationDetailsView.isValidDate()) return;
                else if (!updateVacationDetailsView.isAllFieldsFull()) return;

                window.close();
        }
    }
    public class ButtonNumberOfTickets implements EventHandler {
        @Override
        public void handle(Event event) {
            updateVacationDetailsView.enableVacationType();

        }
    }
    public class ButtonFlightBack implements EventHandler{
        @Override
        public void handle(Event event) {
            updateVacationDetailsView.enableOrDisableFlightBackDetails();
        }
    }
}

