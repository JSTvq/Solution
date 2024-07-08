package com.kir138.lesson4.task1.service;

import com.kir138.lesson4.task1.model.User;
import com.kir138.lesson4.task1.repository.UserRepository;

//Метод который высчитывает среднюю зп, метод кот высчитывает макс возраст
//Метод который высчитывает мин возраст
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findById(Long id) {
        return userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User with id %s not found".formatted(id)));
    }
}
