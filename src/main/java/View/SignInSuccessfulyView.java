package View;

import Controller.ButtonBack;
import Controller.SignInSuccessfulyController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class SignInSuccessfulyView extends AView{

    @FXML
    public Button searchVacation;
    public Button manageMyUser;
    public Button myVacations;
    public Button createNewVacation;
    public Button approvalButton;
    public Button requestButton;
    public Button moneyRecievedButton;
    public Button back;
    public Button showAllVacation;
    public Button tradeButton;



    public void start(SignInSuccessfulyController.ButtonSearchVacation buttonSearchVacation,
                      SignInSuccessfulyController.ButtonManageMyUser buttonManageMyUser,
                      SignInSuccessfulyController.ButtonMyVacations buttonMyVacations,
                      SignInSuccessfulyController.ButtonCreateVacation buttonCreateVacation,
                      SignInSuccessfulyController.ButtonShowRequests buttonShowRequests,
                      SignInSuccessfulyController.ButtonShowApprovals buttonShowApprovals,
                      SignInSuccessfulyController.ButtonShowMoneyReceiving buttonShowMoneyReceiving,
                      SignInSuccessfulyController.ButtonShowAllVacations buttonShowAllVacations,
                      SignInSuccessfulyController.ButtonShowTradeRequests buttonShowTradeRequests){
        searchVacation.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED,buttonSearchVacation);
        manageMyUser.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED,buttonManageMyUser);
        myVacations.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED,buttonMyVacations);
        createNewVacation.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED,buttonCreateVacation);
        approvalButton.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED,buttonShowApprovals);
        requestButton.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED,buttonShowRequests);
        back.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED,new ButtonBack());
        showAllVacation.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED,buttonShowAllVacations);
        moneyRecievedButton.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED,buttonShowMoneyReceiving);
        tradeButton.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED,buttonShowTradeRequests);
        approvalButton.setVisible(false);
        requestButton.setVisible(false);
        moneyRecievedButton.setVisible(false);

    }
}
