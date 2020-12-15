package com.example.authweb.core.service;

import com.example.authweb.core.entity.BaseEntity;

import java.io.Serializable;
import java.util.List;

public interface BaseService<T extends BaseEntity, PK extends Serializable> {

    T save(T entity);

    void delete(PK id);

    T findById(PK id);

    List<T> findAll();

}
