package Controller;

import Model.AModel;
import Model.UserModel;

public abstract class AUserController extends Controller {
    protected static UserModel userModel;
    public static void setMainModel (){
        userModel = new UserModel();
    }

    public AUserController(String fxml){
        super(fxml);
    }
}
