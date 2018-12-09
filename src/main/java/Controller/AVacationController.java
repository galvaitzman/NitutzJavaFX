package Controller;

import Model.AModel;
import Model.VacationModel;

public abstract class AVacationController extends Controller {

    protected static VacationModel vacationModel;

    public static void setMainModel (){
        vacationModel = new VacationModel();
    }

    public AVacationController(String fxml){
        super(fxml);
    }
}
