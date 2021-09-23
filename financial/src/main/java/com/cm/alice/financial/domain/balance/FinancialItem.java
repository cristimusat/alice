package com.cm.alice.financial.domain.balance;

import com.cm.alice.financial.domain.Amount;
import com.cm.alice.financial.domain.Loggable;
import com.cm.alice.financial.domain.product.OperationSign;
import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
@Entity(name = "FIN_FINANCIAL_ITEMS")
public class FinancialItem extends Loggable {

    @Id
    @Column(name = "fin_financial_item_id")
    private Long id;

    @Column(name = "operationSign")
    private OperationSign operationSign;

    @Column(name = "fin_product_operation_id")
    private String finProductOperationId;

    @Column(name = "fin_balance_id")
    private Long finBalanceId;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "AMOUNT", nullable = false))
    @AttributeOverride(name = "currency", column = @Column(name = "AMOUNT_CURRENCY", nullable = false))
    private Amount amount;
}
