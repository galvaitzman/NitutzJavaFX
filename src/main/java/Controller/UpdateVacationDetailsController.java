package Controller;

import View.UpdateVacationDetailsView;
import javafx.event.Event;
import javafx.event.EventHandler;

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
                String[] updateVacation = vacationModel.getCurrentVacation().getVacation_details();
                vacationModel.updateVacation(Integer.parseInt(updateVacation[0]), updateVacation[2], updateVacation[3], updateVacation[4],
                            updateVacation[5], updateVacation[6], updateVacation[7], updateVacation[8], updateVacation[9],
                            updateVacation[10], updateVacation[11], updateVacation[12], updateVacation[13], Integer.parseInt(updateVacation[14]),
                            updateVacation[15], updateVacation[16], updateVacation[17], updateVacation[18], updateVacation[19],
                            updateVacation[20], updateVacation[21], updateVacation[22], updateVacation[23],updateVacation[24],
                            updateVacation[25], updateVacation[26], updateVacation[27], updateVacation[28]);
                updateVacationDetailsView.alert("Updated successfully");
                window.close();
                mainController.activeMyVacationsController();
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

