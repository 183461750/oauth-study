package com.example.authweb.core.mapper;

import com.example.authweb.core.entity.BaseEntity;

import java.io.Serializable;
import java.util.List;

public interface BaseMapper<T extends BaseEntity, PK extends Serializable> {

    void insert(T entity);

    void delete(PK id);

    void update(T entity);

    T findById(PK id);

    List<T> findAll();

}
