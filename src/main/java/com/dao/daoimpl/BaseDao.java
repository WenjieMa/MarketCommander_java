package com.dao.daoimpl;

import com.pojo.DistrictCity;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Created by xiaoma on 2018/5/15.
 */
public class BaseDao implements JpaRepository<Object, Long>{
    @Override
    public Object save(Object entity) {
        return null;
    }
    @Override
    public Optional<Object> findById(Long aLong) {
        return null;
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List findAll() {
        return null;
    }

    @Override
    public List findAll(Sort sort) {
        return null;
    }

    @Override
    public Page findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List findAllById(Iterable iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Object entity) {

    }

    @Override
    public void deleteAll(Iterable entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void flush() {

    }

    @Override
    public void deleteInBatch(Iterable entities) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Object getOne(Long aLong) {
        return null;
    }

    @Override
    public List findAll(Example example, Sort sort) {
        return null;
    }

    @Override
    public List findAll(Example example) {
        return null;
    }

    @Override
    public Object saveAndFlush(Object entity) {
        return null;
    }

    @Override
    public List saveAll(Iterable entities) {
        return null;
    }

    @Override
    public Optional findOne(Example example) {
        return null;
    }

    @Override
    public Page findAll(Example example, Pageable pageable) {
        return null;
    }

    @Override
    public long count(Example example) {
        return 0;
    }

    @Override
    public boolean exists(Example example) {
        return false;
    }
}
