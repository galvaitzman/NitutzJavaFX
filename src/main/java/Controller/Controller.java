package Controller;

import Model.OrdersModel;
import Model.TradeModel;
import Model.UserModel;
import Model.VacationModel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public abstract class Controller{

    protected static MainController mainController;
    protected static UserModel userModel;
    protected static VacationModel vacationModel;
    protected static OrdersModel ordersModel;
    protected static TradeModel tradeModel;
    protected Stage window = new Stage();
    Parent root = null;
    FXMLLoader fxmlLoader = new FXMLLoader();
    Scene scene;

    public static void setMainUserModel (){
        userModel = new UserModel();
    }
    public static void setMainController (MainController other){
        mainController = other;
    }
    public static void setMainOrderModel (){ordersModel = new OrdersModel(); }
    public static void setMainVacationModel (){ vacationModel = new VacationModel(); }
    public static void setMainTradeModel (){ tradeModel = new TradeModel(); }

    public abstract void start();

    public Controller(String fxml){
        try {
            root = fxmlLoader.load(getClass().getResource("/" + fxml).openStream());
            scene = new Scene (root);
            window.setScene(scene);
        }
        catch (IOException e){
            e.printStackTrace();}
    }

}
