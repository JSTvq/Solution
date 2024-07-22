package com.kir138.lesson4.task1.service;

import com.kir138.lesson4.task1.model.User;
import com.kir138.lesson4.task1.repository.PgUserRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class PgUserService implements CrudService<User, Long>{
    private final PgUserRepository pgUserRepository;

    @Override
    public List<User> findAll() {
        return pgUserRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(pgUserRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User with id %s not found".formatted(id))));
    }

    @Override
    public void save(User user) {
        pgUserRepository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        pgUserRepository.deleteById(id);
    }
}
