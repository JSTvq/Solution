package com.kir138.lesson4.task1.service;

import com.kir138.lesson4.task1.model.User;
import com.kir138.lesson4.task1.repository.UserRepository;

import java.util.List;

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

    public User findByName(String name) {
        return userRepository.findByName(name)
            .orElseThrow(() -> new RuntimeException("User with name %s not found".formatted(name)));
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public double calculateAverageSalary() {
        return userRepository.readUsersFromFile().stream()
            .mapToInt(User::getSalary).average()
            .orElse(0);
    }

    public int findMaxAge() {
        return userRepository.readUsersFromFile().stream()
            .mapToInt(User::getAge).max()
            .orElse(0);
    }

    public int findMinAge() {
        return userRepository.readUsersFromFile().stream()
            .mapToInt(User::getAge).min()
            .orElse(0);
    }
}
