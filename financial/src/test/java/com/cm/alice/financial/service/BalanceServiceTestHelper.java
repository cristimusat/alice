package com.cm.alice.financial.service;

import com.cm.alice.financial.domain.balance.BalanceEntity;
import com.cm.alice.financial.domain.product.ProductOperation;
import com.cm.alice.financial.repository.balance.BalanceEntityRepositoryTestImpl;
import com.cm.alice.financial.repository.balance.FinancialItemRepositoryTestImpl;
import com.cm.alice.financial.repository.product.ProductOperationRepositoryTestImpl;

public class BalanceServiceTestHelper {
    private BalanceEntityRepositoryTestImpl balanceEntityRepositoryTest;
    private ProductOperationRepositoryTestImpl productOperationRepositoryTest;
    private FinancialItemRepositoryTestImpl financialItemRepositoryTest;
    private BalanceService balanceService;

    public static BalanceService buildBalanceService() {
        BalanceServiceTestHelper balanceServiceTestHelper = new BalanceServiceTestHelper();
        balanceServiceTestHelper.buildRepositoriesAndService();
        balanceServiceTestHelper.addCatalogs();
        return balanceServiceTestHelper.getBalanceService();
    }

    public static BalanceService buildEmptyBalanceService() {
        BalanceServiceTestHelper balanceServiceTestHelper = new BalanceServiceTestHelper();
        balanceServiceTestHelper.buildRepositoriesAndService();
        return balanceServiceTestHelper.getBalanceService();
    }

    public BalanceService getBalanceService() {
        return balanceService;
    }

    public void buildRepositoriesAndService() {
        balanceEntityRepositoryTest = new BalanceEntityRepositoryTestImpl();
        productOperationRepositoryTest = new ProductOperationRepositoryTestImpl();
        financialItemRepositoryTest = new FinancialItemRepositoryTestImpl();
        balanceService = new BalanceService(balanceEntityRepositoryTest, productOperationRepositoryTest, financialItemRepositoryTest);
    }

    public void addCatalogs() {
        balanceEntityRepositoryTest.save(BalanceEntity.builder()
                .id(1L)
                .finProductId("loan")
                .build());
        productOperationRepositoryTest.save(ProductOperation.builder()
                .id("loan.debt")
                .finProductId("loan")
                .name("Loan")
                .build());
    }
}
