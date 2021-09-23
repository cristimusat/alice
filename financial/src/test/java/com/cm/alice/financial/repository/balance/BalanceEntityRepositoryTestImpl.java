package com.cm.alice.financial.repository.balance;

import com.cm.alice.financial.domain.balance.BalanceEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BalanceEntityRepositoryTestImpl implements BalanceEntityRepository {
    private List<BalanceEntity> balanceEntities = new ArrayList<>();

    @Override
    public List<BalanceEntity> findAll() {
        return null;
    }

    @Override
    public List<BalanceEntity> findAll(Sort sort) {
        return null;
    }

    @Override
    public List<BalanceEntity> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public <S extends BalanceEntity> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends BalanceEntity> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<BalanceEntity> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public BalanceEntity getOne(Long aLong) {
        return null;
    }

    @Override
    public <S extends BalanceEntity> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends BalanceEntity> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public Page<BalanceEntity> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public <S extends BalanceEntity> S save(S s) {
        boolean found = false;
        for (BalanceEntity balanceEntity:balanceEntities){
            if (balanceEntity.getId().equals(s.getId())) {
                balanceEntity = s;
                found = true;
                break;
            }
        }
        if (!found) {
            balanceEntities.add(s);
        }
        return s;
    }

    @Override
    public Optional<BalanceEntity> findById(Long aLong) {
        return balanceEntities.stream().filter(balanceEntity -> balanceEntity.getId().equals(aLong)).findFirst();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(BalanceEntity balanceEntity) {

    }

    @Override
    public void deleteAll(Iterable<? extends BalanceEntity> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends BalanceEntity> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends BalanceEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends BalanceEntity> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends BalanceEntity> boolean exists(Example<S> example) {
        return false;
    }
}
