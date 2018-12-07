package Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VacationModel extends MainModel {


    /*

    בעת הוספת חופשה על המוכר להזין את הקריטריונים הבאים:
     חברות התעופה, שעות המראה ונחיתה, מספרי טיסות, תאריכים לחופשה,
     איזו כבודה כלולה בחופשה, מספר כרטיסים, מדינת היעד, האם כלולה טיסה חזור, סוג כרטיס הטיסה (מבוגר/ילד/תינוק), סוג החופשה (אורבנית/אקזוטית)
     , האם המלון/צימר/חדר שכור כלול במחיר, דירוג מקום הלינה, מחיר, האם מדובר בטיסת המשך או טיסה ישירה, האם ניתן לרכוש חלק מכרטיסי הטיסה.
     */

    public void insertVacationToDB( String airline_name1,String airline_name2, String departure_time_1 , String destination_time_1, String departure_time_2, String destination_time_2,
                                    String flight_number_1,String flight_number_2,String flight_date_1,String filght_date_2,String flight_baggage_1,String flight_baggage_2,
                                    int number_of_tickets, String departure_city,String destination_city, String tickets_type, String vacation_type, String stying_place_name, String stying_place_rank,
                                    String price , String connection1  ,String connection2, String sell_all_tickets , String bank_acount_number, String number_snif, String bank_number, String paypal,String post_type) {
        String sql_vacation_id = "SELECT max(vacation_id) FROM Vacation";
        int vacation_id =0;
        try (Connection conn1 = connect();
             Statement stmt = conn1.createStatement();
             ResultSet rs = stmt.executeQuery(sql_vacation_id))
        {
            if(rs.getObject(1) != null)
                vacation_id = Integer.parseInt(rs.getObject(1).toString()) + 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("gal");

        String sql = "INSERT INTO Vacation(vacation_id," +
                "user_name," +
                "airline_name1," +
                "airline_name2," +
                "departure_time_1," +
                "destination_time_1," +
                "departure_time_2," +
                "destination_time_2," +
                "flight_number_1," +
                "flight_number_2 ," +
                "flight_date_1," +
                "filght_date_2," +
                "flight_baggage_1," +
                "flight_baggage_2," +
                "number_of_tickets," +
                "departure_city," +
                "destination_city," +
                "tickets_type," +
                "vacation_type," +
                "stying_place_name," +
                "stying_place_rank," +
                "price," +
                "connection1," +
                "connection2," +
                "sell_all_tickets, " +
                "bank_acount_number," +
                "number_snif," +
                "bank_number, " +
                "paypal," +
                "status," +
                "post_type) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1 ,vacation_id);
            pstmt.setString(2 ,current_user);
            pstmt.setString(3 ,airline_name1);
            pstmt.setString(4 ,airline_name2);
            pstmt.setString(5 ,departure_time_1);
            pstmt.setString(6 ,destination_time_1);
            pstmt.setString(7 ,departure_time_2);
            pstmt.setString(8 ,destination_time_2);
            pstmt.setString(9 ,flight_number_1);
            pstmt.setString(10 ,flight_number_2);
            pstmt.setString(11 ,flight_date_1);
            pstmt.setString(12 ,filght_date_2);
            pstmt.setString(13,flight_baggage_1);
            pstmt.setString(14 ,flight_baggage_2);
            pstmt.setInt(15,number_of_tickets);
            pstmt.setString(16 ,departure_city);
            pstmt.setString(17 ,destination_city);
            pstmt.setString(18 ,tickets_type);
            pstmt.setString(19 ,vacation_type);
            pstmt.setString(20 ,stying_place_name);
            pstmt.setString(21 ,stying_place_rank);
            pstmt.setString(22 ,price);
            pstmt.setString(23 ,connection1);
            pstmt.setString(24 ,connection2);
            pstmt.setString(25 ,sell_all_tickets);
            pstmt.setString(26 ,bank_acount_number);
            pstmt.setString(27 ,number_snif);
            pstmt.setString(28 ,bank_number);
            pstmt.setString(29 ,paypal);
            pstmt.setString(30 ,"זמינה");
            pstmt.setString(31 ,post_type);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    /**
     * could not update user name, vacation id , and post type
     */

    public boolean updateVacation(int vacation_ID,String airline_name1,String airline_name2, String departure_time_1 , String destination_time_1, String departure_time_2, String destination_time_2,
                                  String flight_number_1,String flight_number_2,String flight_date_1,String filght_date_2,String flight_baggage_1,String flight_baggage_2,
                                  int number_of_tickets, String departure_city,String destination_city, String tickets_type, String vacation_type, String stying_place_name, String stying_place_rank,
                                  String price , String connection1  ,String connection2, String sell_all_tickets , String bank_acount_number, String number_snif, String bank_number, String paypal) {
     //   if (!searchVacationByVacationID(vacation_ID).isEmpty()){
            String sql = "UPDATE Vacation SET airline_name1=?," +
                    "airline_name2=?," +
                    "departure_time_1=?," +
                    "destination_time_1=?," +
                    "departure_time_2=?," +
                    "destination_time_2=?," +
                    "flight_number_1=?," +
                    "flight_number_2 =?," +
                    "flight_date_1=?," +
                    "filght_date_2=?," +
                    "flight_baggage_1=?," +
                    "flight_baggage_2=?," +
                    "number_of_tickets=?," +
                    "departure_city=?," +
                    "destination_city=?," +
                    "tickets_type=?," +
                    "vacation_type=?," +
                    "stying_place_name=?," +
                    "stying_place_rank=?," +
                    "price=?," +
                    "connection1=?," +
                    "connection2=?," +
                    "sell_all_tickets=?, " +
                    "bank_acount_number=?," +
                    "number_snif=?," +
                    "bank_number=?, " +
                    "paypal=?"
                    + "WHERE vacation_id  = ?";


            try (Connection conn = this.connect();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

                // set the corresponding param
                pstmt.setString(1 ,airline_name1);
                pstmt.setString(2 ,airline_name2);
                pstmt.setString(3 ,departure_time_1);
                pstmt.setString(4 ,destination_time_1);
                pstmt.setString(5 ,departure_time_2);
                pstmt.setString(6 ,destination_time_2);
                pstmt.setString(7 ,flight_number_1);
                pstmt.setString(8 ,flight_number_2);
                pstmt.setString(9 ,flight_date_1);
                pstmt.setString(10 ,filght_date_2);
                pstmt.setString(11,flight_baggage_1);
                pstmt.setString(12 ,flight_baggage_2);
                pstmt.setInt(13,number_of_tickets);
                pstmt.setString(14 ,departure_city);
                pstmt.setString(15 ,destination_city);
                pstmt.setString(16 ,tickets_type);
                pstmt.setString(17 ,vacation_type);
                pstmt.setString(18 ,stying_place_name);
                pstmt.setString(19 ,stying_place_rank);
                pstmt.setString(20 ,price);
                pstmt.setString(21 ,connection1);
                pstmt.setString(22 ,connection2);
                pstmt.setString(23 ,sell_all_tickets);
                pstmt.setString(24 ,bank_acount_number);
                pstmt.setString(25 ,number_snif);
                pstmt.setString(26 ,bank_number);
                pstmt.setString(27 ,paypal);
                pstmt.setInt(28 ,vacation_ID);

                // update
                pstmt.executeUpdate();
                return true;
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
      //  }
        return false;
    }




    public List<String> searchVacationByVacationID(int vacation_id){
        String sql = "SELECT * from Vacation where vacation_id = ?";
        List<String> VacationDetails = new ArrayList<String>();
        try (Connection conn = this.connect();
             PreparedStatement statement = conn.prepareStatement(sql)){
            statement.setInt(1, vacation_id);
            ResultSet rs = statement.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int colCount = rsmd.getColumnCount();
            while (rs.next())
            {
                for (int col=1; col <= colCount; col++)
                {
                    Object value = rs.getObject(col);
                    if (value != null)
                    {
                        VacationDetails.add(value.toString());
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return VacationDetails;
    }



    public boolean updateVacationStatus(int vacation_ID,String status){
        if (!searchVacationByVacationID(vacation_ID).isEmpty()) {
            String sql = "UPDATE Vacation SET status=?"
                    + "WHERE vacation_id  = ?";

            try (Connection conn = this.connect();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
                // set the corresponding param
                pstmt.setString(1, status);
                pstmt.setInt(2, vacation_ID);
                // update
                pstmt.executeUpdate();
                return true;
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return false;
    }

    public void deleteVacation(int vacation_id) {
        String sql = "DELETE FROM Vacation WHERE vacation_id = ?";
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            // set the corresponding param
            pstmt.setInt(1, vacation_id);
            // execute the delete statement
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }



        public List<String> searchVacationsByUser_Id(){
            String sql = "SELECT * from Vacation where user_name = ?";
            List<String> VacationDetails = new ArrayList<String>();
            try (Connection conn = this.connect();
                 PreparedStatement statement = conn.prepareStatement(sql)){
                statement.setString(1, current_user);
                ResultSet rs = statement.executeQuery();
                ResultSetMetaData rsmd = rs.getMetaData();
                int colCount = rsmd.getColumnCount();
                while (rs.next())
                {
                    for (int col=1; col <= colCount; col++)
                    {
                        Object value = rs.getObject(col);
                        if (value != null)
                        {
                            VacationDetails.add(value.toString());
                        }
                    }
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            return VacationDetails;
        }
}
