package com.cm.alice.financial.repository.product;

import com.cm.alice.financial.domain.product.ProductOperation;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductOperationRepositoryTestImpl implements ProductOperationRepository {
    private List<ProductOperation> productOperations = new ArrayList<>();

    @Override
    public List<ProductOperation> findAll() {
        return null;
    }

    @Override
    public List<ProductOperation> findAll(Sort sort) {
        return null;
    }

    @Override
    public List<ProductOperation> findAllById(Iterable<String> iterable) {
        return null;
    }

    @Override
    public <S extends ProductOperation> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends ProductOperation> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<ProductOperation> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public ProductOperation getOne(String s) {
        return null;
    }

    @Override
    public <S extends ProductOperation> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends ProductOperation> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public Page<ProductOperation> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public <S extends ProductOperation> S save(S s) {
        boolean found = false;
        for (ProductOperation productOperation : productOperations) {
            if (productOperation.getId().equals(s.getId())) {
                found = true;
                productOperation = s;
                break;
            }
        }
        if (!found) {
            productOperations.add(s);
        }
        return s;
    }

    @Override
    public Optional<ProductOperation> findById(String s) {
        return productOperations.stream().filter(productOperation -> productOperation.getId().equals(s)).findFirst();
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public void delete(ProductOperation productOperation) {

    }

    @Override
    public void deleteAll(Iterable<? extends ProductOperation> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends ProductOperation> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends ProductOperation> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends ProductOperation> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends ProductOperation> boolean exists(Example<S> example) {
        return false;
    }
}
