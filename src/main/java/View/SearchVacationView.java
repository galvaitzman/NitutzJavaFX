package View;

import Controller.ButtonBack;
import Controller.SearchVacationController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class SearchVacationView extends AView {

    @FXML
    public DatePicker departDate;
    public DatePicker returnDate;
    public TextField from;
    public TextField to;
    public Button searchButton;
    public Button back;

    public void start (SearchVacationController.ButtonBackClickedHandler backButtonClicked,
            SearchVacationController.ButtonSearchVacation buttonSearchVacation){
        back.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED,new ButtonBack());
        searchButton.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED,buttonSearchVacation);
        from.setText("");
        to.setText("");
        from.requestFocus();
    }

    public boolean isOneFieldsFull(){
        if (departDate.getValue() == null && returnDate.getValue() == null && from.getText().equals("") && to.getText().equals("")){
            alert("Please insert at least one criterion");
            return false;
        }
        return true;
    }

    public boolean isValidDate() {
        LocalDate ld1 = departDate.getValue();
        LocalDate ld2 = returnDate.getValue();
        if (ld1!=null && ld2!=null){
            if ( LocalDate.from(ld1).until(LocalDate.now(), ChronoUnit.DAYS) >= 0 ||
                    LocalDate.from(ld2).until(LocalDate.now(), ChronoUnit.DAYS) >= 0 ||
                    LocalDate.from(ld2).until(LocalDate.from(ld1),ChronoUnit.DAYS) >=0) {
                alert("Illegal dates");
                return false;
            }
        }

        else if (ld1!=null){
            if ( LocalDate.from(ld1).until(LocalDate.now(), ChronoUnit.DAYS) >= 0){
                alert("Illegal dates");
                return false;
            }
        }
        else if (ld2!=null){
            if ( LocalDate.from(ld2).until(LocalDate.now(), ChronoUnit.DAYS) >= 0){
                alert("Illegal dates");
                return false;
            }
        }
        return true;
    }
}
