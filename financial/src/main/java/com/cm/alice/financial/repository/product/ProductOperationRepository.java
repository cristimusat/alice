package com.cm.alice.financial.repository.product;

import com.cm.alice.financial.domain.product.ProductOperation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductOperationRepository extends JpaRepository<ProductOperation, String> {
}
