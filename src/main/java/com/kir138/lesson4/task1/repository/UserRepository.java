package com.kir138.lesson4.task1.repository;

import com.kir138.lesson4.task1.model.User;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//findById, findByName, save(User user), deleteById(Long id),
// update (Логика апдейта должны быть в методе save)
// List<User> findAll()
public class UserRepository {

    private final File file;
    private final List<User> listUser = new ArrayList<>();

    public UserRepository(File file) {
        this.file = file;
    }

    public Optional<User> findById(Long id) {
        return
    }
}
