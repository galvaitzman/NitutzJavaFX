package Controller;

import java.util.Stack;

public class MainController{

    Controller initialController = new InitialController();
    Controller signUpController = new SignUpController();
    Controller afterSignInController = new AfterSignInController();
    Controller searchController = new SearchUserController();
    Controller updateController = new UpdateController();
    Controller createVacationController = new CreateVacationController();
    Controller searchVacationController = new SearchVacationController();
    Controller currentController = initialController;
    Controller searchResultController = new SearchResultController();
    Controller signInSuccessfulyController = new SignInSuccessfulyController();
    Controller myVacationsController = new MyVacationsController();
    Controller buyingVacationPaypalOrVisaPaymentController = new BuyingVacationPaypalOrVisaPaymentController();
    Controller viewVacationController = new ViewVacationController();
    Controller updateVacationDetailsController = new UpdateVacationDetailsController();
    Controller showRequestsController = new ShowRequestsController();
    Controller showApprovalsController = new ShowApprovalsController();
    Controller theMoneyWasRecievedApprovalContoller = new TheMoneyWasRecievedApprovalContoller();
    Stack <Controller> controllers = new Stack<Controller>();

    public MainController (){
        Controller.setMainController(this);
        Controller.setMainUserModel();
        Controller.setMainVacationModel();
        Controller.setMainOrderModel();
        ButtonBack.setMainConroller(this);
        initialController.start();
        controllers.push(currentController);
    }

    public void activeAfterSignInContoller(){

        controllers.push(currentController);
        currentController = afterSignInController;
        currentController.start();
    }

    public void activeSignUpContoller(){
        controllers.push(currentController);
        currentController = signUpController;
        signUpController.start();
    }

    public void activeUpdateController(){
        controllers.push(currentController);
        currentController = updateController;
        updateController.start();
    }

    public void activeSearchController(){
        controllers.push(currentController);
        currentController = searchController;
        searchController.start();
    }


    public  void activeInitialController(){
        controllers.push(currentController);
        currentController = initialController;
        initialController.start();
    }

    public  void activeSearchResultContoller(){
        controllers.push(currentController);
        currentController = searchResultController;
        searchResultController.start();
    }

    public void activeSignInSuccessfuly(){
        controllers.push(currentController);
        currentController = signInSuccessfulyController;
        signInSuccessfulyController.start();
    }

    public void activaSearchVacationController(){
        controllers.push(currentController);
        currentController = searchVacationController;
        searchVacationController.start();
    }

    public void activeCreateVacationController(){
        controllers.push(currentController);
        currentController = createVacationController;
        createVacationController.start();
    }

    public void activeUpdateVacationController(){
        controllers.push(currentController);
        currentController = updateVacationDetailsController;
        updateVacationDetailsController.start();
    }

    public void activeShowRequestsController(){
        controllers.push(currentController);
        currentController = showRequestsController;
        showRequestsController.start();
    }

    public void activeShowApprovalsController(){
        controllers.push(currentController);
        currentController = showApprovalsController;
        showApprovalsController.start();
    }

    public void activeViewVacationController(){
        controllers.push(currentController);
        currentController = viewVacationController;
        viewVacationController.start();
    }
    public void activeYesOrNoForRequestController(){

    }
    public void activeMyVacationsController(){
        controllers.push(currentController);
        currentController = myVacationsController;
        myVacationsController.start();
    }

    public void activeBuyingVacationPaypalOrVisaPaymentController(){
        controllers.push(currentController);
        currentController = buyingVacationPaypalOrVisaPaymentController;
        buyingVacationPaypalOrVisaPaymentController.start();
    }

    public void goBackToPreviousController(){
        currentController = controllers.pop();
        currentController.start();
    }

    public void activeTheMoneyWasRecievedApprovalContoller(){
        controllers.push(currentController);
        currentController =  theMoneyWasRecievedApprovalContoller;
        theMoneyWasRecievedApprovalContoller.start();

    }
    public void closeWindow(){
        currentController.window.close();
    }

}
