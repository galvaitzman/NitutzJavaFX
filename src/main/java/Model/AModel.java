package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class AModel {
    public static User current_user = new User() ;
    protected List<Vacation> currentListOfVacations = new ArrayList<>();
    protected Vacation currentVacation;
    protected List<Order> currentListOfOrdersBuyer = new ArrayList<>();
    protected List<Order> currentListOfOrdersSeller = new ArrayList<>();
    protected List<Trade> currentListOfTradesBuyer = new ArrayList<>();
    protected List<Trade> currentListOfTradesSeller = new ArrayList<>();
    protected Order currentOrder;
    protected Trade currentTrade;
    protected Connection connect() {
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

    public User getCurrent_user() {
        return current_user;
    }

    public void setCurrent_user(User current_user) {
        AModel.current_user = current_user;
    }

    public List<Vacation> getCurrentListOfVacations() {
        return currentListOfVacations;
    }
    public List<Order> getCurrentListOfOrderBuyer() {
        return currentListOfOrdersBuyer;
    }

    public void setCurrentListOfOrders(List<Order> currentListOfOrdersBuyer) {
        this.currentListOfOrdersBuyer = currentListOfOrdersBuyer;
    }
    public List<Order> getCurrentListOfOrdersSeller() {
        return currentListOfOrdersSeller;
    }

    public void setCurrentListOfOrdersSeller(List<Order> currentListOfOrdersSeller) {
        this.currentListOfOrdersSeller = currentListOfOrdersSeller;
    }

    public void setCurrentListOfVacations(List<Vacation> currentListOfVacations) {
        this.currentListOfVacations = currentListOfVacations;
    }

    public Vacation getCurrentVacation() {
        return currentVacation;
    }

    public void setCurrentVacation(Vacation currentVacation) {
        this.currentVacation = currentVacation;
    }
    public void setCurrentOrder(Order currentOrder) {
        this.currentOrder = currentOrder;
    }

    public Order getCurrentOrder(){return  this.currentOrder;}

    public Trade getCurrentTrade(){ return this.currentTrade;}
    public void setCurrentTrade(Trade currentTrade){this.currentTrade = currentTrade;}

}
