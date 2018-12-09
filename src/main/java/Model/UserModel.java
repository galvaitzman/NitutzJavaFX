package Model;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserModel extends AModel {

    public UserModel(){
        current_user = new User();
    }
    
    
    public boolean createUser(String user_name, String password, String birth_day, String first_name, String last_name, String city, String email)
    {
        if(searchUserByUserName(user_name).isEmpty())
        {
            current_user = new User( user_name, password, birth_day, first_name, last_name,  city,  email,"standard" );
            insertUserToDB(user_name,password,birth_day,first_name,last_name,city,email,"standard");
            return true;
        }

        else
        {
            //telling the controller that the user is already exist
            return false;
            //users_passwords_Dic.put(user_name,password);
            //users_Dic.put(user_name,new User(user_name,password,birth_day,first_name,last_name,city,email));
        }
    }

    /**
     * Insert a new row into the warehouses table
     * @param User_name
     * @param Password
     * @param Birth_day
     * @param First_name
     * @param Last_name
     * @param City
     */

    private void insertUserToDB(String User_name, String Password, String Birth_day, String First_name, String Last_name, String City,String Email,String User_type) {
        // insert new User
        String sql = "INSERT INTO Users(User_name,Password,Birth_day,First_name,Last_name,City,Email,User_type)" +
                " VALUES(?,?,?,?,?,?,?,?)";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, User_name);
            pstmt.setString(2, Password);
            pstmt.setString(3, Birth_day);
            pstmt.setString(4, First_name);
            pstmt.setString(5, Last_name);
            pstmt.setString(6, City);
            pstmt.setString(7, Email);
            pstmt.setString(8, User_type);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /*
    public List<String> searchUser (String user_name){
        if (!users_passwords_Dic.containsKey(user_name)){
            return new ArrayList<String>() {
            };
        }
        System.out.println("yes");
        return users_Dic.get(user_name).listOfUserDetails();
    }
    */


    public boolean updateUser(String user_name_after,String user_name,String password, String birth_day, String first_name, String last_name, String city, String email) {
        if (user_name.equals(user_name_after) || searchUserByUserName(user_name_after).isEmpty()){
            current_user.setPassword(password);
            current_user.setBirth_day(birth_day);
            current_user.setUser_name(user_name);
            current_user.setFirst_name(first_name);
            current_user.setLast_name(last_name);
            current_user.setCity(city);
            current_user.setEmail(email);
            String sql = "UPDATE Users SET Password = ? , "
                    + "Birth_day = ? ,"
                    + "User_name = ? ,"
                    + "First_name = ? ,"
                    + "Last_name = ? ,"
                    + "City = ? ,"
                    + "Email = ? "
                    + "WHERE User_name  = ?";

            try (Connection conn = this.connect();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

                // set the corresponding param
                pstmt.setString(1, password);
                pstmt.setString(2, birth_day);
                pstmt.setString(3, user_name_after);
                pstmt.setString(4, first_name);
                pstmt.setString(5, last_name);
                pstmt.setString(6, city);
                pstmt.setString(7, email);
                pstmt.setString(8, user_name);
                // update
                pstmt.executeUpdate();
                return true;
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return false;
    }

    public void delete(String user_name) {
        String sql = "DELETE FROM Users WHERE User_name = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setString(1, user_name);
            // execute the delete statement
            pstmt.executeUpdate();


            // maybe to remove all the details in other tables like flights , vacations and stying_places


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<String> searchUserByUserName(String user_name){
        String sql = "SELECT * from Users where User_name = ?";
        List<String> userDetails = new ArrayList<String>();
        try (Connection conn = this.connect();
             PreparedStatement statement = conn.prepareStatement(sql)){
             statement.setString(1, user_name);
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
                        userDetails.add(value.toString());
                    }
                }
             }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return userDetails;
    }

    public boolean validateUserNameAndPassword(String userName, String password){
        List<String> searchResult = searchUserByUserName(userName);
        
        if (searchResult.isEmpty() || !password.equals(searchResult.get(1)))
            return false;
        current_user = new User(searchResult);
        return true;
    }

}
