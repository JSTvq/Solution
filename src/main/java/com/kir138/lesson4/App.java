package com.kir138.lesson4;

import com.kir138.lesson4.model.User;
import com.kir138.lesson4.repository.UserRepository;
import com.kir138.lesson4.service.UserService;

import java.io.File;

public class App {
    public static void main(String[] args) {
        File file = new File("path-name.txt");
        UserRepository userRepository = new UserRepository(file);
        UserService userService = new UserService(userRepository);

        User byId = userService.findById(123L);
    }
}
