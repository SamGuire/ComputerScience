package database;

import interactor.FinancialDataGateway;
import interactor.FinancialEntity;

import java.util.List;

public class FinancialDataMapper implements FinancialDataGateway {


    @Override
    public List<FinancialEntity> getFinancialReport() {
        FinancialDatabase financialDatabase = new FinancialDatabase();
        System.out.println("Got data from DB !");
        return null;
    }
}
