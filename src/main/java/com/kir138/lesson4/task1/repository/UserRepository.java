package com.kir138.lesson4.task1.repository;

import com.kir138.lesson4.task1.model.Role;
import com.kir138.lesson4.task1.model.User;
import lombok.RequiredArgsConstructor;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import java.io.*;
import java.util.stream.Stream;

//findById, findByName, save(User user), deleteById(Long id),
// update (Логика апдейта должны быть в методе save)
// List<User> findAll()
@RequiredArgsConstructor
public class UserRepository implements CrudRepository<User, Long> {

    public Path getFilePath() {
        return Paths.get("C:\\Games\\Книга2.csv");
    }

    @Override
    public List<User> findAll() {
        List<User> listUser = new ArrayList<>();
        try (Stream<String> lines = Files.lines(getFilePath())) {
            List<String> line = lines.skip(1).toList();

            for (String s : line) {
                String[] values = s.split(";");
                Long id = Long.parseLong(values[0]);
                String name = values[1];
                int age = Integer.parseInt(values[2]);
                int salary = Integer.parseInt(values[3]);
                Role role = Role.valueOf(values[4]);
                int team_id = Integer.parseInt(values[5]);
                listUser.add(new User(id, name, age, salary, role, team_id));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return listUser;
    }

    @Override
    public Optional<User> findById(Long id) {
        return findAll().stream()
            .filter(user -> user.getId().equals(id))
            .findFirst();
    }

    public Optional<User> findByName(String name) {
        return findAll().stream()
            .filter(user -> user.getName().equals(name))
            .findFirst();
    }

    @Override
    public void save(User user) {
        List<User> users = findAll();
        users.removeIf(u1 -> u1.getId().equals(user.getId()));
        users.add(user);
        saveAllUsers(users);
    }

    private void saveAllUsers(List<User> users) {
        List<String> list = new ArrayList<>();
        list.add("id;name;age;salary;role");

        for (User user : users) {
            list.add(user.getId() + ";" + user.getName() + ";" +
                user.getAge() + ";" + user.getSalary() + ";" + user.getRole());
        }
        try {
            Files.write(getFilePath(), list, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(Long id) {
        List<User> users = findAll();
        users.removeIf(user -> user.getId().equals(id));
        saveAllUsers(users);
    }
}
