package com.kir138.lesson4.task1.repository;

import com.kir138.lesson4.task1.model.User;

import java.util.List;
import java.util.Optional;

public class PgUserRepository implements CrudRepository<User, Long> {
    @Override
    public List<User> findAll() {
        return List.of();
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(User user) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
