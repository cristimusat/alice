package com.cm.alice.financial.domain.balance;

import com.cm.alice.financial.domain.Loggable;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
@Entity(name = "FIN_BALANCES")
public class BalanceEntity extends Loggable {

    @Id
    @Column(name = "fin_balance_id")
    private Long id;

    @Column(name = "fin_product_id")
    private String finProductId;
}
