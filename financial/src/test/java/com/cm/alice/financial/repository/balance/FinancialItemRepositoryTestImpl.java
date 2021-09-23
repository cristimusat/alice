package com.cm.alice.financial.repository.balance;

import com.cm.alice.financial.domain.balance.FinancialItem;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalLong;
import java.util.stream.Collectors;

public class FinancialItemRepositoryTestImpl implements FinancialItemRepository {
    private List<FinancialItem> financialItems = new ArrayList<>();

    @Override
    public List<FinancialItem> findAllByFinBalanceId(Long finBalanceId) {
        return financialItems.stream()
                .filter(financialItem -> financialItem.getId().equals(finBalanceId)).collect(Collectors.toList());
    }

    @Override
    public List<FinancialItem> findAll() {
        return null;
    }

    @Override
    public List<FinancialItem> findAll(Sort sort) {
        return null;
    }

    @Override
    public List<FinancialItem> findAllById(Iterable<String> iterable) {
        return null;
    }

    @Override
    public <S extends FinancialItem> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends FinancialItem> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<FinancialItem> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public FinancialItem getOne(String s) {
        return null;
    }

    @Override
    public <S extends FinancialItem> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends FinancialItem> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public Page<FinancialItem> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public <S extends FinancialItem> S save(S s) {
        OptionalLong maxIdOptional = financialItems.stream().mapToLong(FinancialItem::getId).max();
        Long maxId = maxIdOptional.orElse(0L);
        Optional<FinancialItem> optionalFinancialItem = financialItems.stream()
                .filter(financialItem -> financialItem.getId().equals(s.getId())).findFirst();
        if (financialItems.isEmpty()) {
            s.setId(maxId + 1);
            financialItems.add(s);
        } else {
            FinancialItem financialItem = optionalFinancialItem.get();
            financialItem = s;
        }
        return s;
    }

    @Override
    public Optional<FinancialItem> findById(String s) {
        return Optional.empty();
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
    public void delete(FinancialItem financialItem) {

    }

    @Override
    public void deleteAll(Iterable<? extends FinancialItem> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends FinancialItem> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends FinancialItem> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends FinancialItem> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends FinancialItem> boolean exists(Example<S> example) {
        return false;
    }
}
