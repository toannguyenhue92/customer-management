package com.example.customermanagement.services;

import java.util.List;

public interface Service<T> {
    List<T> findAll();

    T findById(Long id);

    void save(T t);
}
