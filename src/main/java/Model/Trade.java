package Model;

public class Trade {
    private int trade_id;
    private String user_name_buyer;
    private int vacation_id_buyer;
    private String user_name_seller;
    private int vacation_id_seller;
    private String trade_status;
    private String last_update;

    public Trade(int trade_id, String user_name_buyer, int vacation_id_buyer, String user_name_seller, int vacation_id_seller, String trade_status, String last_update){
        this.trade_id = trade_id;
        this.user_name_buyer = user_name_buyer;
        this.vacation_id_buyer = vacation_id_buyer;
        this.user_name_seller=user_name_seller;
        this.vacation_id_seller = vacation_id_seller;
        this.trade_status = trade_status;
        this.last_update = last_update;
    }

    public int getTrade_id() {
        return trade_id;
    }

    public void setTrade_id(int trade_id) {
        this.trade_id = trade_id;
    }

    public String getUser_name_buyer() {
        return user_name_buyer;
    }

    public void setUser_name_buyer(String user_name_buyer) {
        this.user_name_buyer = user_name_buyer;
    }

    public int getVacation_id_buyer() {
        return vacation_id_buyer;
    }

    public void setVacation_id_buyer(int vacation_id_buyer) {
        this.vacation_id_buyer = vacation_id_buyer;
    }

    public String getUser_name_seller() {
        return user_name_seller;
    }

    public void setUser_name_seller(String user_name_seller) {
        this.user_name_seller = user_name_seller;
    }

    public int getVacation_id_seller() {
        return vacation_id_seller;
    }

    public void setVacation_id_seller(int vacation_id_seller) {
        this.vacation_id_seller = vacation_id_seller;
    }

    public String getTrade_status() {
        return trade_status;
    }

    public void setTrade_status(String trade_status) {
        this.trade_status = trade_status;
    }

    public String getLast_update() {
        return last_update;
    }

    public void setLast_update(String last_update) {
        this.last_update = last_update;
    }
}