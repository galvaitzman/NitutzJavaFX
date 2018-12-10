package Model;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class OrdersModel extends AModel{


    public void insertOrderToDB(String user_name_seller, int vacation_id, String number_of_tickets){

        String sql_order_id = "SELECT max(order_id) FROM Orders";
        int order_id = 0;
        String last_update  = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());

        try (Connection conn1 = connect();
             Statement stmt = conn1.createStatement();
             ResultSet rs = stmt.executeQuery(sql_order_id)) {
            if (rs.getObject(1) != null)
                order_id = Integer.parseInt(rs.getObject(1).toString()) + 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return;
        }

        String sql = "INSERT INTO Orders(order_id," +
                "user_name_buyer," +
                "user_name_seller," +
                "vacation_id," +
                "number_of_tickets,"+
                "order_status,"+
                "last_update) VALUES(?,?,?,?,?,?,?)";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, order_id);
            pstmt.setString(2, current_user.getUser_name());
            pstmt.setString(3, user_name_seller);
            pstmt.setInt(4, vacation_id);
            pstmt.setString(5, number_of_tickets);
            pstmt.setString(6, "waiting for approval of purchase offer");
            pstmt.setString(7, last_update);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }



    public List<String> searchOrferByOrderID(int order_id) {
        String sql = "SELECT * from Orders where order_id = ?";
        List<String> OrdersDetails = new ArrayList<String>();
        try (Connection conn = this.connect();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, order_id);
            ResultSet rs = statement.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int colCount = rsmd.getColumnCount();
            while (rs.next()) {
                for (int col = 1; col <= colCount; col++) {
                    Object value = rs.getObject(col);
                    if (value != null) {
                        OrdersDetails.add(value.toString());
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return OrdersDetails;
    }


    public void updateOrderStatus(int order_id, String order_status) {
            String sql = "UPDATE Orders SET order_status=?, last_update=? WHERE order_id= ?";
            String last_update  = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            try (Connection conn = this.connect();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
                // set the corresponding param
                pstmt.setString(1, order_status);
                pstmt.setString(2, last_update);
                pstmt.setInt(3, order_id);
                // update
                pstmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
    }

    public List<Order> getOrdersInCaseBuyer()
    {
        List<Order> orderArrayList = new ArrayList<>();
        String sql = "SELECT * from Orders where user_name_buyer = ? AND order_status = ? ORDER BY vacation_id";
        try (Connection conn = this.connect();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, current_user.getUser_name());
            statement.setString(2, "waiting for payment");
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
                orderArrayList.add(new Order(temp[0] ,temp[1],temp[2],Integer.parseInt(temp[3]),temp[4],temp[5],temp[6]));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        currentListOfOrders.clear();
        currentListOfOrders = orderArrayList;
        return orderArrayList;

    }

    public List<Order> getOrdersInCaseSeller()
    {
        List<Order> orderArrayList = new ArrayList<>();
        String sql = "SELECT * from Orders where user_name_seller = ? AND order_status = ? ORDER BY vacation_id";
        try (Connection conn = this.connect();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, current_user.getUser_name());
            statement.setString(2, "waiting for approval of purchase offer");
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
                orderArrayList.add(new Order(temp[0] ,temp[1],temp[2],Integer.parseInt(temp[3]),temp[4],temp[5],temp[6]));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        currentListOfOrders.clear();
        currentListOfOrders = orderArrayList;
        return orderArrayList;
    }


}
