package Controller;

public class BuyingVacationPaypalOrVisaPaymentController extends Controller {

    private BuyingVacationPaypalOrVisaPaymentController buyingVacationPaypalOrVisaPaymentController;
    public BuyingVacationPaypalOrVisaPaymentController(){
        super("BuyingVacationPaypalOrVisaPayment.fxml");
        buyingVacationPaypalOrVisaPaymentController = fxmlLoader.getController();
        buyingVacationPaypalOrVisaPaymentController.start();

    }
    @Override
    public void start() {
        buyingVacationPaypalOrVisaPaymentController.start();
    }
}
