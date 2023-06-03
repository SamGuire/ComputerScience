package controller;

import interactor.FinancialDataGenerator;
import interactor.FinancialReportRequest;
import interactor.FinancialReportRequester;
import interactor.FinancialReportResponse;

public class FinancialReportController {

    public void generateView() {
        FinancialReportRequest request = new FinancialReportRequest();
        FinancialReportRequester requester = new FinancialDataGenerator();
        FinancialReportResponse reportResponse = requester.getFinancialReport(request);

    }
}
