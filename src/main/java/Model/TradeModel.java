package Model;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class TradeModel extends AModel {

    
    public void insertTradeToDB(String user_name_seller, int vacation_id_seller, int vacation_id_buyer){

        String sql_trade_id = "SELECT max(trade_id) FROM Trades";
        int trade_id = 0;
        String last_update  = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());

        try (Connection conn1 = connect();
             Statement stmt = conn1.createStatement();
             ResultSet rs = stmt.executeQuery(sql_trade_id)) {
            if (rs.getObject(1) != null)
                trade_id = Integer.parseInt(rs.getObject(1).toString()) + 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return;
        }
        String sql = "INSERT INTO Trades(trade_id," +
                "user_name_buyer," +
                "vacation_id_buyer,"+
                "user_name_seller," +
                "vacation_id_seller," +
                "trade_status,"+
                "last_update) VALUES(?,?,?,?,?,?,?)";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, trade_id);
            pstmt.setString(2, current_user.getUser_name());
            pstmt.setInt(3, vacation_id_buyer);
            pstmt.setString(4, user_name_seller);
            pstmt.setInt(5, vacation_id_seller);
            pstmt.setString(6, "waiting for approval of trade offer");
            pstmt.setString(7, last_update);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void updateTradeStatus(int trade_id, String trade_status) {
        String sql = "UPDATE Trades SET trade_status=?, last_update=? WHERE trade_id= ?";
        String last_update  = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            // set the corresponding param
            pstmt.setString(1, trade_status);
            pstmt.setString(2, last_update);
            pstmt.setInt(3, trade_id);
            // update
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    private int trade_id;

    private String user_name_buyer;
    private int vacation_id_buyer;
    private String user_name_seller;
    private int vacation_id_seller;
    private String trade_status;
    private String last_update;

    public void CancleAllTradesContainIdVacation(int vacation_id){
        String sql = "UPDATE Trades SET trade_status = ? WHERE  vacation_id_buyer = ? OR vacation_id_seller = ? ";
        try (Connection conn = this.connect();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, "canceled");
            statement.setInt(2, vacation_id);
            statement.setInt(3, vacation_id);

            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }


    public List<Trade> getTradesInCaseBuyer()
    {
        List<Trade> tradeArrayList = new ArrayList<>();
        String sql = "SELECT * from Trades where user_name_buyer = ? AND trade_status = ? OR trade_status = ? ORDER BY vacation_id_buyer";
        try (Connection conn = this.connect();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, current_user.getUser_name());
            statement.setString(2, "Approved");
            statement.setString(3, "Rejected");
            ResultSet rs = statement.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int colCount = rsmd.getColumnCount();
            while (rs.next()) {
                String [] temp = new String[7];
                for (int col = 1; col <= colCount; col++) {
                    Object value = rs.getObject(col);
                    if (value != null) {
                        temp[col-1] = value.toString();
                    }
                }
                tradeArrayList.add(new Trade(Integer.parseInt(temp[0]) ,temp[1],Integer.parseInt(temp[2]),temp[3],Integer.parseInt(temp[4]),temp[5],temp[6]));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        currentListOfTradesBuyer.clear();
        currentListOfTradesBuyer = tradeArrayList;
        return tradeArrayList;
    }

    public List<Trade> getTradesInCaseSeller()
    {
        List<Trade> tradeArrayList = new ArrayList<>();
        String sql = "SELECT * from Trades where user_name_seller = ? AND trade_status = ? ORDER BY vacation_id_seller";
        try (Connection conn = this.connect();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, current_user.getUser_name());
            statement.setString(2, "waiting for approval of trade offer");
            ResultSet rs = statement.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int colCount = rsmd.getColumnCount();
            while (rs.next()) {
                String [] temp = new String[7];
                for (int col = 1; col <= colCount; col++) {
                    Object value = rs.getObject(col);
                    if (value != null) {
                        temp[col-1] = value.toString();
                    }
                }
                tradeArrayList.add(new Trade(Integer.parseInt(temp[0]) ,temp[1],Integer.parseInt(temp[2]),temp[3],Integer.parseInt(temp[4]),temp[5],temp[6]));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        currentListOfTradesSeller.clear();
        currentListOfTradesSeller = tradeArrayList;
        return tradeArrayList;
    }



    public void changeStatusForAllTradesAfterShowedToTheBuyer()
    {
        String sql = "UPDATE Trades SET trade_status = ? WHERE user_name_buyer = ? AND trade_status = ? ";
        try (Connection conn = this.connect();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, "Approved close");
            statement.setString(2, current_user.getUser_name());
            statement.setString(3, "Approved");

            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        String sql2 = "UPDATE Trades SET trade_status = ? WHERE user_name_buyer = ? AND trade_status = ? ";
        try (Connection conn = this.connect();
             PreparedStatement statement = conn.prepareStatement(sql2)) {
            statement.setString(1, "Rejected close");
            statement.setString(2, current_user.getUser_name());
            statement.setString(3, "Rejected");

            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
/*
    public void changeStatusForAllTradesAfterShowedToTheSellerAndApproved(){
        String sql = "UPDATE Trades SET trade_status = ? WHERE user_name_seller = ? AND trade_status = ? ";
        try (Connection conn = this.connect();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, "Rejected close");
            statement.setString(2, current_user.getUser_name());
            statement.setString(3, "waiting for approval of trade offer");
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
*/
}
