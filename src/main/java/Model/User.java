package Model;

import java.util.Arrays;
import java.util.List;

public class User {

    private String User_name;
    private String Password;
    private String Birth_day;
    private String First_name;
    private String Last_name;
    private String City;
    private String Email;
    private String User_type;


    // relevant for debug
    public User(){
        User_name= "";
        Password ="";
        Birth_day="";
        First_name="";
        Last_name="";
        City="";
        Email="";
        User_type="";

    }

    public User( List<String> searchResult)
    {
    User_name= searchResult.get(0);
    Password = searchResult.get(1);
    Birth_day=searchResult.get(2);
    First_name=searchResult.get(3);
    Last_name=searchResult.get(4);
    City=searchResult.get(5);
    Email=searchResult.get(6);
    User_type=searchResult.get(7);
    }




    public User(String user_name, String password, String birth_day, String first_name, String last_name, String city, String email,String user_type) {
        User_name = user_name;
        Password = password;
        Birth_day = birth_day;
        First_name = first_name;
        Last_name = last_name;
        City = city;
        Email = email;
        User_type = user_type;
    }

    public String getUser_name() {
        return User_name;
    }

    public void setUser_name(String user_name) {
        User_name = user_name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getBirth_day() {
        return Birth_day;
    }

    public void setBirth_day(String birth_day) {
        Birth_day = birth_day;
    }

    public String getFirst_name() {
        return First_name;
    }

    public void setFirst_name(String first_name) {
        First_name = first_name;
    }

    public String getLast_name() {
        return Last_name;
    }

    public void setLast_name(String last_name) {
        Last_name = last_name;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String get_User_type() {
        return User_type;
    }

    public void set_User_type(String user_type) {
        User_type = user_type;
    }

    public List<String> listOfUserDetails() {
        List <String> list = Arrays.asList(User_name,Password,Birth_day,First_name,Last_name,City,Email,User_type);
        return list;
    }
}
