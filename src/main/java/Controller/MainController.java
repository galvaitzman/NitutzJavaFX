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
    Stack <Controller> controllers = new Stack<Controller>();

    public MainController (){
        Controller.setMainController(this);
        Controller.setMainUserModel();
        Controller.setMainVacationModel();
        initialController.start();
        //searchVacationController.start();
        //createVacationController.start();
        //currentController.start();
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


    public void activeMyVacationsContoller(){
        System.out.println("is working");
    }

}
