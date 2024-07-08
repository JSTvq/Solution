package com.kir138.lesson4.task1;

import com.kir138.lesson4.task1.model.User;
import com.kir138.lesson4.task1.repository.UserRepository;
import com.kir138.lesson4.task1.service.UserService;

import java.io.File;

public class App {
    public static void main(String[] args) {
        String filePath = "C:\\Games\\Книга2.csv";
        File file = new File(filePath);
        UserRepository userRepository = new UserRepository(file);
        UserService userService = new UserService(userRepository);

        User byId = userService.findById(3L);
        System.out.println(byId);

        User byName = userService.findByName("Николай");
        System.out.println(byName);
    }
}
