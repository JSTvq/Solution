package com.kir138.lesson4.task1.service;

import java.util.List;
import java.util.Optional;

public interface CrudService<T, K> {
    List<T> findAll();

    Optional<T> findById(K id);

    void save(T t);

    void deleteById(K id);
}
