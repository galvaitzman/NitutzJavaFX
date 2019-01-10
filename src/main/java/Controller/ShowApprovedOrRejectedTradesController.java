package Controller;

import View.ShowApprovedOrRejectedTradesView;

public class ShowApprovedOrRejectedTradesController extends Controller {
    private ShowApprovedOrRejectedTradesView showApprovedOrRejectedTradesView;

    public ShowApprovedOrRejectedTradesController() {
        super("ShowApprovedOrRejectedTrades.fxml");
        showApprovedOrRejectedTradesView = fxmlLoader.getController();
        showApprovedOrRejectedTradesView.start();
    }

    @Override
    public void start() {
        showApprovedOrRejectedTradesView.ShowApprovedOrRejectedTradesFunction(tradeModel.getTradesInCaseBuyer());
        tradeModel.changeStatusForAllTradesAfterShowedToTheBuyer();
        window.setTitle("Vacation Trades");
        window.show();//
    }

}
