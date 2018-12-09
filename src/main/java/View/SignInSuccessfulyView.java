package View;

import Controller.SignInSuccessfulyController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.awt.*;

public class SignInSuccessfulyView {

    @FXML
    public Button searchVacation;
    public Button manageMyUser;
    public Button myVacations;
    public Button createNewVacation;

    public void start(SignInSuccessfulyController.ButtonSearchVacation buttonSearchVacation,
                      SignInSuccessfulyController.ButtonManageMyUser buttonManageMyUser,
                      SignInSuccessfulyController.ButtonMyVacations buttonMyVacations,
                      SignInSuccessfulyController.ButtonCreateVacation buttonCreateVacation){
        searchVacation.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED,buttonSearchVacation);
        manageMyUser.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED,buttonManageMyUser);
        myVacations.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED,buttonMyVacations);
        createNewVacation.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED,buttonCreateVacation);

    }
}
