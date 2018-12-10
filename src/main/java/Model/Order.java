package Model;

public class Order {

    private String order_id;
    private String user_name_buyer;
    private String user_name_seller;
    private String vacation_id,String;
    private String number_of_tickets;
    private String order_status;
    private String last_update;

    public Order(String order_id1,String user_name_buyer1,String user_name_seller1,String vacation_id1,String number_of_tickets1,String order_status1,String last_update1){
        order_id = order_id1;
        user_name_buyer=user_name_buyer1;
        user_name_seller=user_name_seller1;
        vacation_id=vacation_id1;
        number_of_tickets=number_of_tickets1;
        order_status=order_status1;
        last_update=last_update1;
    }


    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public java.lang.String getUser_name_buyer() {
        return user_name_buyer;
    }

    public void setUser_name_buyer(java.lang.String user_name_buyer) {
        this.user_name_buyer = user_name_buyer;
    }

    public java.lang.String getUser_name_seller() {
        return user_name_seller;
    }

    public void setUser_name_seller(java.lang.String user_name_seller) {
        this.user_name_seller = user_name_seller;
    }

    public java.lang.String getVacation_id() {
        return vacation_id;
    }

    public void setVacation_id(java.lang.String vacation_id) {
        this.vacation_id = vacation_id;
    }

    public java.lang.String getString() {
        return String;
    }

    public void setString(java.lang.String string) {
        String = string;
    }

    public java.lang.String getNumber_of_tickets() {
        return number_of_tickets;
    }

    public void setNumber_of_tickets(java.lang.String number_of_tickets) {
        this.number_of_tickets = number_of_tickets;
    }

    public java.lang.String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(java.lang.String order_status) {
        this.order_status = order_status;
    }

    public java.lang.String getLast_update() {
        return last_update;
    }

    public void setLast_update(java.lang.String last_update) {
        this.last_update = last_update;
    }
}
