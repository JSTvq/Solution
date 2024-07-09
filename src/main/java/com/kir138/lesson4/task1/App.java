package com.kir138.lesson4.task1;

import com.kir138.lesson4.task1.model.User;
import com.kir138.lesson4.task1.repository.UserRepository;
import com.kir138.lesson4.task1.service.UserService;

import java.io.File;
import java.util.List;

public class App {
    public static void main(String[] args) {
        String filePath = "C:\\Games\\Книга2.csv";
        File file = new File(filePath);
        UserRepository userRepository = new UserRepository(file);
        UserService userService = new UserService(userRepository);

        User byId = userService.findById(3L);
        System.out.println(byId);

        User byName = userService.findByName("Nikolai");
        System.out.println(byName);

        User user6 = User.builder()
            .id(2L)
            .name("Olga")
            .age(24)
            .salary(96000)
            .role("BACKEND_DEV")
            .build();

        userService.save(user6);

        //userService.deleteById(2L);

        List<User> findAll = userService.findAll();
        System.out.println(findAll);

        double averageSalary = userService.calculateAverageSalary();
        System.out.println(averageSalary);

        int maxAge = userService.findMaxAge();
        int minAge = userService.findMinAge();

        System.out.println(maxAge);
        System.out.println(minAge);
    }
}
