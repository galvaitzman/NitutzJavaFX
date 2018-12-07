package Controller;

import Model.MainModel;

import java.util.Stack;

public class MainController{

    Controller initialController = new InitialController();
    Controller signUpController = new SignUpController();
    Controller afterSignInController = new AfterSignInController();
    Controller searchController = new SearchController();
    Controller updateController = new UpdateController();
    Controller createVacationController = new CreateVacationController();
    Controller currentController = initialController;
    Stack <Controller> controllers = new Stack<Controller>();

    public MainController (){
        Controller.setMainController(this);
        Controller.setMainModel(new MainModel());
        createVacationController.start();
        //currentController.start();
        controllers.push(currentController);
    }

    public void activeAfterSignInContoller(String user_name){
        ((AfterSignInController)afterSignInController).setCurrentUser(user_name);
        controllers.push(currentController);
        currentController = afterSignInController;
        currentController.start();
    }

    public void activeSignUpContoller(){
        controllers.push(currentController);
        currentController = signUpController;
        signUpController.start();
    }

    public void activeUpdateController(String userName){
        controllers.push(currentController);
        currentController = updateController;
        ((UpdateController)updateController).setCurrentUser(userName);
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

}
