package interactor;

import database.FinancialDataMapper;

import java.util.List;

public class FinancialDataGenerator implements FinancialReportRequester {

    @Override
    public FinancialReportResponse getFinancialReport(FinancialReportRequest reportRequest) {
        FinancialDataGateway dataGateway = new FinancialDataMapper();
        List<FinancialEntity> entities = dataGateway.getFinancialReport();
        return new FinancialReportResponse();
    }
}
