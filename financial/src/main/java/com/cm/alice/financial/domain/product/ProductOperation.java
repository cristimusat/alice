package com.cm.alice.financial.domain.product;

import com.cm.alice.financial.domain.Loggable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "FIN_PRODUCT_OPERATIONS")
public class ProductOperation extends Loggable {

    @Id
    @Column(name = "fin_product_operation_id")
    private String id;

    @Column(name = "fin_product_id")
    private String finProductId;

    @Column(name = "name")
    private String name;

    @Column(name = "operation_sign")
    private OperationSign operationSign;
}
