package View;

import Controller.MainController;
import javafx.application.Application;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
     new MainController();
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


    public static void createNewTableOrder() {
        // SQLite connection string
        String url = "jdbc:sqlite:Vacation4U.db";
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS Orders(\n"
                + "	order_id INTEGER NOT NULL PRIMARY KEY,\n"
                + "	user_name_buyer varchar(255) NOT NULL ,\n"
                + "	user_name_seller varchar(255) NOT NULL,\n"
                + "	vacation_id INTEGER NOT NULL,\n"
                + "	number_of_tickets varchar(255) NOT NULL,\n"
                + "	order_status varchar(255) NOT NULL,\n"
                + "	last_update varchar(255) NOT NULL\n"
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


    public static void createNewTableTrade() {
        // SQLite connection string
        String url = "jdbc:sqlite:Vacation4U.db";
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS Trades(\n"
                + "	trade_id INTEGER NOT NULL PRIMARY KEY,\n"
                + "	user_name_buyer varchar(255) NOT NULL ,\n"
                + "	vacation_id_buyer INTEGER NOT NULL,\n"
                + "	user_name_seller varchar(255) NOT NULL,\n"
                + "	vacation_id_seller INTEGER NOT NULL,\n"
                + "	trade_status varchar(255) NOT NULL,\n"
                + "	last_update varchar(255) NOT NULL\n"
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

    public static void main(String[] args) {
       // createNewTable();
        launch(args);
    }


}
