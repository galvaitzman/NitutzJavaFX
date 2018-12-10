package Model;

public class Vacation {
    private String[] vacation_details;

    public Vacation()
    {
        vacation_details=new String[31];
    }

    public String getFlight_date_1(){
        return vacation_details[10];
    }
    public String getFlight_date_2(){
        return vacation_details[11];
    }

    public String getDeparture_city(){
        return vacation_details[15];
    }
    public String getDestination_city(){
        return vacation_details[16];
    }
    public String getPrice(){
        return vacation_details[21];
    }
    public String[] getVacation_details(){return vacation_details;}
    /*
    String vacation_ID,
    String user_name,
    String airline_name1,
    String airline_name2,
    String departure_time_1,
    String destination_time_1,
    String departure_time_2,
    String destination_time_2,
    String flight_number_1,
    String flight_number_2,
    String flight_date_1,
    String filght_date_2,
    String flight_baggage_1,
    String flight_baggage_2,
    String number_of_tickets,
    String departure_city,
    String destination_city,
    String tickets_type,
    String vacation_type,
    String stying_place_name,
    String stying_place_rank,
    String price ,
    String connection1,
    String connection2,
    String sell_all_tickets,
    String bank_acount_number,
    String number_snif,
    String bank_number,
    String paypal,
    String status,
    String post_type
     */

}
