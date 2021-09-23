package com.cm.alice.financial.service;

import com.cm.alice.financial.FinancialException;
import com.cm.alice.financial.domain.Amount;
import com.cm.alice.financial.domain.balance.BalanceEntity;
import com.cm.alice.financial.domain.balance.FinancialItem;
import com.cm.alice.financial.domain.product.ProductOperation;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BalanceServiceTest {

    @Test
    void addItemToBalanceTest() {
        BalanceService balanceService = BalanceServiceTestHelper.buildBalanceService();
        balanceService.addItemToBalance(1L, "loan.debt", Amount.of(100, "RON"));
        List<FinancialItem> items = balanceService.getFinancialItemsForBalanceId(1L);
        assertEquals(1, items.size());
        assertEquals("loan.debt", items.get(0).getFinProductOperationId());
    }

    @Test
    void getBalanceEntityWithValidIdTest() {
        BalanceService balanceService = BalanceServiceTestHelper.buildBalanceService();
        BalanceEntity balanceEntity = balanceService.getBalanceEntity(1L);
        assertEquals(1L, balanceEntity.getId());
    }

    @Test
    void getBalanceEntityWithInvalidIdTest() {
        BalanceService balanceService = BalanceServiceTestHelper.buildEmptyBalanceService();
        FinancialException thrown = assertThrows(
                FinancialException.class,
                () -> balanceService.getBalanceEntity(1L));
        assertEquals("Invalid balanceId: 1", thrown.getMessage());
    }

    @Test
    void getProductOperationWithValidIdTest() {
        BalanceService balanceService = BalanceServiceTestHelper.buildBalanceService();
        ProductOperation productOperation = balanceService.getProductOperation("loan.debt");
        assertEquals("loan.debt", productOperation.getId());
    }

    @Test
    void getProductOperationWithInvalidIdTest() {
        BalanceService balanceService = BalanceServiceTestHelper.buildEmptyBalanceService();
        FinancialException thrown = assertThrows(
                FinancialException.class,
                () -> balanceService.getProductOperation("load.debt"));
        assertEquals("Invalid productOperationId: load.debt", thrown.getMessage());
    }
}