package com.kir138.lesson4.task1.service;

import com.kir138.lesson4.task1.model.User;
import com.kir138.lesson4.task1.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

//Метод который высчитывает среднюю зп, метод кот высчитывает макс возраст
//Метод который высчитывает мин возраст
@RequiredArgsConstructor
public class UserService implements CrudService<User, Long> {
    private final UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User with id %s not found".formatted(id))));
    }

    public User findByName(String name) {
        return userRepository.findByName(name)
            .orElseThrow(() -> new RuntimeException("User with name %s not found".formatted(name)));
    }

    @Override
    public List<User> save(User user) {
        userRepository.save(user);
        return findAll();
    }

    @Override
    public List<User> deleteById(Long id) {
        userRepository.deleteById(id);
        return findAll();
    }

    /*public double calculateAverageSalary() {
        return userRepository.findAll().stream()
            .mapToInt(User::getSalary).average()
            .orElse(0);
    }*/

    public int findMaxAge() {
        return userRepository.findAll().stream()
            .mapToInt(user -> ((User) user).getAge()).max()
            .orElse(0);
    }

    public int findMinAge() {
        return userRepository.findAll().stream()
            .mapToInt(User::getAge).min()
            .orElse(0);
    }
}
