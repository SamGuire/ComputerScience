package presenters.screenpresenter;

import controller.FinancialReportPresenter;
import interactor.FinancialReportRequester;
import interactor.FinancialReportResponse;
import views.webview.WebView;

public class ScreenPresenter implements FinancialReportPresenter {
    @Override
    public void present(FinancialReportResponse financialReportResponse) {
        ScreenViewModel model = new ScreenViewModel();
        ScreenView view = new WebView();
        view.showView(model);
    }
}
