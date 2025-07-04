package br.com.ifba.infrastructure.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericIDao<T, ID extends Serializable> {

    T save(T entity);

    void delete(T entity);

    T findById(ID id);

    List<T> findAll();
}