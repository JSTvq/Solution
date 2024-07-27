package com.kir138.lesson4.task1.repository;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<T, K> {

    List<T> findAll();

    Optional<T> findById(K id);

    List<T> save(T t);

    List<T> deleteById(K id);
}
