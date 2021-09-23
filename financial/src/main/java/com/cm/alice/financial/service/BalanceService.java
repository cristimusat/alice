package com.cm.alice.financial.service;

import com.cm.alice.financial.FinancialException;
import com.cm.alice.financial.domain.Amount;
import com.cm.alice.financial.domain.balance.BalanceEntity;
import com.cm.alice.financial.domain.balance.FinancialItem;
import com.cm.alice.financial.domain.product.ProductOperation;
import com.cm.alice.financial.repository.balance.BalanceEntityRepository;
import com.cm.alice.financial.repository.balance.FinancialItemRepository;
import com.cm.alice.financial.repository.product.ProductOperationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BalanceService {

    private final BalanceEntityRepository balanceEntityRepository;
    private final ProductOperationRepository productOperationRepository;
    private final FinancialItemRepository financialItemRepository;

    public BalanceService(BalanceEntityRepository balanceEntityRepository,
                          ProductOperationRepository productOperationRepository,
                          FinancialItemRepository financialItemRepository) {
        this.balanceEntityRepository = balanceEntityRepository;
        this.productOperationRepository = productOperationRepository;
        this.financialItemRepository = financialItemRepository;
    }

    public void addItemToBalance(Long balanceId, String productOperationId, Amount amount) {
        BalanceEntity balanceEntity = getBalanceEntity(balanceId);
        ProductOperation productOperation = getProductOperation(productOperationId);
        if (!balanceEntity.getFinProductId().equals(productOperation.getFinProductId())) {
            throw new FinancialException("Product for this balance(" + balanceId.toString() + ") does not contain " + productOperationId);
        }
        FinancialItem financialItem = FinancialItem.builder()
                .operationSign(productOperation.getOperationSign())
                .amount(amount)
                .finProductOperationId(productOperation.getId())
                .finBalanceId(balanceEntity.getId())
                .build();
        financialItemRepository.save(financialItem);
    }

    public List<FinancialItem> getFinancialItemsForBalanceId(Long balanceId) {
        return financialItemRepository.findAllByFinBalanceId(balanceId);
    }

    public ProductOperation getProductOperation(String productOperationId) {
        Optional<ProductOperation> productOperationOptional = productOperationRepository.findById(productOperationId);
        if (productOperationOptional.isEmpty()) {
            throw new FinancialException("Invalid productOperationId: " + productOperationId);
        }
        return productOperationOptional.get();
    }

    public BalanceEntity getBalanceEntity(Long balanceId) {
        Optional<BalanceEntity> balanceEntityOptional = balanceEntityRepository.findById(balanceId);
        if (balanceEntityOptional.isEmpty()) {
            throw new FinancialException("Invalid balanceId: " + balanceId.toString());
        }
        return balanceEntityOptional.get();
    }
}
