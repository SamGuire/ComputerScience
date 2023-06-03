package interactor;

import java.util.List;

public interface FinancialDataGateway {
    List<FinancialEntity> getFinancialReport();
}
