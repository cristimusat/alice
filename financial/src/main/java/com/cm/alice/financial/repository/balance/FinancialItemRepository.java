package com.cm.alice.financial.repository.balance;

import com.cm.alice.financial.domain.balance.FinancialItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FinancialItemRepository extends JpaRepository<FinancialItem, String> {
    List<FinancialItem> findAllByFinBalanceId(Long finBalanceId);
}
