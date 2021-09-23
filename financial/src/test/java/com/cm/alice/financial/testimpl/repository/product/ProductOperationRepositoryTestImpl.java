package com.cm.alice.financial.testimpl.repository.product;

import com.cm.alice.financial.domain.product.ProductOperation;
import com.cm.alice.financial.repository.product.ProductOperationRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.*;
import java.util.stream.Collectors;

public class ProductOperationRepositoryTestImpl implements ProductOperationRepository {
    private final List<ProductOperation> productOperations = new ArrayList<>();

    @Override
    public List<ProductOperation> findAll() {
        return productOperations;
    }

    @Override
    public List<ProductOperation> findAll(Sort sort) {
        return productOperations;
    }

    @Override
    public List<ProductOperation> findAllById(Iterable<String> iterable) {
        Set<String> ids = new HashSet<>();
        iterable.forEach(ids::add);
        return productOperations.stream()
                .filter(p -> ids.contains(p.getFinProductId()))
                .collect(Collectors.toList());
    }

    @Override
    public <S extends ProductOperation> List<S> saveAll(Iterable<S> iterable) {
        List<S> ops = new ArrayList<>();
        iterable.forEach(this::save);
        iterable.forEach(ops::add);
        return ops;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends ProductOperation> S saveAndFlush(S s) {
        return save(s);
    }

    @Override
    public <S extends ProductOperation> List<S> saveAllAndFlush(Iterable<S> entities) {
        return saveAll(entities);
    }

    @Override
    public void deleteAllInBatch(Iterable<ProductOperation> entities) {

    }

    @SuppressWarnings("SpringDataMethodInconsistencyInspection")
    @Override
    public void deleteAllByIdInBatch(Iterable<String> strings) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public ProductOperation getOne(String s) {
        return findById(s).orElseThrow();
    }

    @Override
    public ProductOperation getById(String id) {
        return findById(id).orElseThrow();
    }

    @Override
    @SuppressWarnings("unchecked")
    public <S extends ProductOperation> List<S> findAll(Example<S> example) {
        return (List<S>) productOperations;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <S extends ProductOperation> List<S> findAll(Example<S> example, Sort sort) {
        return (List<S>) productOperations;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Page<ProductOperation> findAll(Pageable pageable) {
        return (Page<ProductOperation>) productOperations;
    }

    @Override
    public <S extends ProductOperation> S save(S s) {
        boolean found = false;
        for (int i = 0; i < productOperations.size(); i++) {
            if (productOperations.get(i).getId().equals(s.getId())) {
                found = true;
                productOperations.set(i, s);
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
    public void deleteAllById(Iterable<? extends String> strings) {

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
    @SuppressWarnings("unchecked")
    public <S extends ProductOperation> Page<S> findAll(Example<S> example, Pageable pageable) {
        return (Page<S>) productOperations;
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
