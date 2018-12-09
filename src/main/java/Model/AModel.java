package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class AModel {
    public static User current_user ;
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
}
