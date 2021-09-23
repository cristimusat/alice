package com.cm.alice.financial.domain.product;

import com.cm.alice.financial.domain.Loggable;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "FIN_PRODUCTS")
public class Product extends Loggable {

    @Id
    @Column(name = "fin_product_id")
    private String id;

    @Column(name = "name")
    private String name;
}
