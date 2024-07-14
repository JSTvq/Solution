package com.kir138.lesson4.task1;

import com.kir138.lesson4.task1.model.Role;
import com.kir138.lesson4.task1.model.User;
import com.kir138.lesson4.task1.repository.CrudRepository;
import com.kir138.lesson4.task1.repository.PgUserRepository;
import com.kir138.lesson4.task1.repository.UserRepository;
import com.kir138.lesson4.task1.service.UserService;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class App {
    public static void main(String[] args) {
        String filePath = "C:\\Games\\Книга2.csv";
        Path path = Paths.get(filePath);

        CrudRepository userRepository;
        if (args[0].equals("db")) {
            userRepository = new PgUserRepository();
        } else {
            userRepository = new UserRepository(path);
        }
//        CrudRepository userRepository = new UserRepository(path);
//        CrudRepository userRepository = new PgUserRepository();

        UserService userService = new UserService(userRepository);

        User byId = userService.findById(3L);
        System.out.println(byId);

        User byName = userService.findByName("Nikolai");
        System.out.println(byName);

        User user6 = User.builder()
            .id(2L)
            .name("Olga1")
            .age(24)
            .salary(96000)
            .role(Role.BACKEND_DEV)
            .build();

        userService.save(user6);

        userService.deleteById(20L);

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
