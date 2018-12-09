package View;

import Model.VacationModel;
import javafx.application.Application;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
       // new MainController();
        /*

        primaryStage.setScene(new Scene(root,382,249));
        primaryStage.show();
       // UserModel mm = new UserModel();
       // mc = new MainController(mm);
       // mv = new SignUpView();
        initialView = fxmlLoader.getController();
        mainModel = new UserModel();
        initialController = new AfterSignInController(initialView,mainModel) ;*/
        //FXMLLoader fxmlLoader = new FXMLLoader();
        //Parent root = fxmlLoader.load(getClass().getResource("MainViewForm.fxml"));
        //Scene scene = new Scene(root);
        //primaryStage.setScene(scene);
        //primaryStage.show();
        //InitialView initialView = fxmlLoader.getController();
        //initialController.signInPress();

        /**
         * this is the line befor the part B just the one line
         */
        // MainController mainController = new MainController();


        //Part B
        /**
         * Vacation
         */
        VacationModel vacationModel = new VacationModel();
        // createNewTableVacation();
      //  vacationModel.current_user.setUser_name("dan");
       // vacationModel.current_user.set_User_type("exceptional");
       // vacationModel.updateVacationStatus(3,"in order");
     //    vacationModel.insertVacationToDB("elal","arkia","17:00","18:00","19:00", "20:00","12","13","10/04/1993","14/04/1993","","",2,"from","eilat","child","fun","","","700","","","sure","","","","");
      //   vacationModel.insertVacationToDB("elal","arkia","17:00","18:00","19:00", "20:00","12","13","18/04/1993","24/4/1993","","",1,"beer sheva","eilat","child","fun","","","700","","","sure","","","","");
         //vacationModel.updateVacation(3,"elal","arkia","17:00","18:00","19:00", "20:00","12","13","18/04/1993","24/4/1993","","",1,"beer sheva","eilat","child","fun","","","700","","","sure","","","","xxxxxxxx");
        // vacationModel.updateVacationStatus(3,"בוטלה");
        // vacationModel.deleteVacation(2);
        //  vacationModel.current_user = "gal";
        //  vacationModel.searchVacationsByUser_Id();
        //  UserModel.current_user.setUser_name("gal");
        //  vacationModel.searchVacationsByUser_Id();

        //   List<Vacation> l =  vacationModel.searchVacationsByParameters("","","from","");
       // List<Vacation> l = ((VacationModel) vacationModel).searchVacationsByParameters("", "", "from", "eilat");
       // System.out.println( vacationModel.deleteVacation(1));

      //  List<Vacation> l =  vacationModel.searchVacationsByParameters("","","from","");
      //  List<Vacation> l =  vacationModel.searchVacationsByParameters("10/04/1993","","from","");

        System.out.println("gal");

        /**
         * Users
         */
/*       createNewTableUser();
        UserModel mainModel = new UserModel();
       mainModel.createUser("gal","123","18/04/1993","gal","vaitzman","beer-sheva","g@gmail.com");
        mainModel.createUser("gal2","123","18/04/1993","gal","vaitzman","beer-sheva","g@gmail.com");
        mainModel.createUser("gal3","123","18/04/1993","gal","vaitzman","beer-sheva","g@gmail.com");*/

    }






    public static void createNewTableVacation() {
        // SQLite connection string
        String url = "jdbc:sqlite:Vacation4U.db";
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS Vacation(\n"
                + "	vacation_ID INTEGER NOT NULL PRIMARY KEY,\n"
                + "	user_name varchar(255) NOT NULL ,\n"
                + "	airline_name1 varchar(255) NOT NULL,\n"
                + "	airline_name2 varchar(255) NOT NULL,\n"
                + "	departure_time_1 varchar(255) NOT NULL,\n"
                + "	destination_time_1 varchar(255) NOT NULL,\n"
                + "	departure_time_2 varchar(255) NOT NULL,\n"
                + "	destination_time_2 varchar(255) NOT NULL,\n"
                + "	flight_number_1 varchar(255) NOT NULL,\n"
                + "	flight_number_2 varchar(255) NOT NULL,\n"
                + "	flight_date_1 varchar(255) NOT NULL,\n"
                + "	flight_date_2 varchar(255) NOT NULL,\n"
                + "	flight_baggage_1 varchar(255) NOT NULL,\n"
                + "	flight_baggage_2 varchar(255) NOT NULL,\n"
                + "	number_of_tickets INTEGER NOT NULL,\n"
                + "	departure_city varchar(255) NOT NULL,\n"
                + "	destination_city varchar(255) NOT NULL,\n"
                + "	tickets_type varchar(255) NOT NULL,\n"
                + "	vacation_type varchar(255) NOT NULL,\n"
                + "	stying_place_name varchar(255) ,\n"
                + "	stying_place_rank varchar(255) ,\n"
                + "	price varchar(255) NOT NULL,\n"
                + "	connection1 varchar(255) ,\n"
                + "	connection2 varchar(255) ,\n"
                + "	sell_all_tickets varchar(255) NOT NULL,\n"
                + "	bank_acount_number varchar(255) ,\n"
                + "	number_snif varchar(255) ,\n"
                + "	bank_number varchar(255) ,\n"
                + "	paypal varchar(255) ,\n"
                + "	status varchar(255) NOT NULL,\n"
                + "	post_type varchar(255) NOT NULL\n"
                + ");" ;

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
            System.out.println("the table created");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void createNewTableUser() {
        // SQLite connection string
        String url = "jdbc:sqlite:Vacation4U.db";

        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS Users(\n"
                + "	User_name varchar(255) NOT NULL PRIMARY KEY,\n"
                + "	Password varchar(255) NOT NULL,\n"
                + "	Birth_day varchar(255) NOT NULL,\n"
                + "	First_name varchar(255) NOT NULL,\n"
                + "	Last_name varchar(255) NOT NULL,\n"
                + "	City varchar(255) NOT NULL,\n"
                + "	Email varchar(255) NOT NULL,\n"
                + "	User_type varchar(255) NOT NULL\n"
                //  + "	Picture BLOB NOT NULL,\n"
                + ");" ;


        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
            System.out.println("the table created");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

/*
    private static Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:Vacation4U.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

  /*
    public static void insertUser(String User_name, String Password, String Birth_day, String First_name, String Last_name, String City,String Email) {
        String sql = "INSERT INTO Users(User_name,Password,Birth_day,First_name,Last_name,City,Email) VALUES(?,?,?,?,?,?,?)";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, User_name);
            pstmt.setString(2, Password);
            pstmt.setString(3, Birth_day);
            pstmt.setString(4, First_name);
            pstmt.setString(5, Last_name);
            pstmt.setString(6, City);
            pstmt.setString(7, Email);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
       // createNewTable();
        launch(args);
    }
    */

}
