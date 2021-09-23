package com.cm.alice.financial.repository.balance;

import com.cm.alice.financial.domain.balance.BalanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BalanceEntityRepository extends JpaRepository<BalanceEntity, Long> {
}
