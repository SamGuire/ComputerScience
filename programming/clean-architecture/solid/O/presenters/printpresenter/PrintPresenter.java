package presenters.printpresenter;

import controller.FinancialReportPresenter;
import interactor.FinancialReportResponse;
import views.pdfview.PdfView;
import views.webview.WebView;

public class PrintPresenter implements FinancialReportPresenter {
    @Override
    public void present(FinancialReportResponse financialReportResponse) {
        PrintViewModel model = new PrintViewModel();
        PrintView view = new PdfView();
        view.showPrintView(model);
    }
}
