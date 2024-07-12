package com.kir138.lesson4.task1.repository;

import com.kir138.lesson4.task1.model.Role;
import com.kir138.lesson4.task1.model.User;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

//findById, findByName, save(User user), deleteById(Long id),
// update (Логика апдейта должны быть в методе save)
// List<User> findAll()
public class UserRepository {

    private final Path file;

    /*public UserRepository(File file) {
        this.file = file;
    }*/

    public UserRepository(Path file) {
        this.file = file;
    }

    /**
     * Считывание данных с файла
     * @return
     */
    /*public List<User> readUsersFromFile() {
        List<User> listUser = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            boolean firstLine = true;
            while ((line = bufferedReader.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                String[] values = line.split(";");
                Long id = Long.parseLong(values[0]);
                String name = values[1];
                int age = Integer.parseInt(values[2]);
                int salary = Integer.parseInt(values[3]);
                Role role = Role.valueOf(values[4]);
                listUser.add(new User(id, name, age, salary, role));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return listUser;
    }*/

    public List<User> readUsersFromFile() {
        List<User> listUser = new ArrayList<>();
        try(Stream<String> lines = Files.lines(file)) {
            List<String> line = lines.skip(1).toList();

            for (String s : line) {
                String[] values = s.split(";");
                Long id = Long.parseLong(values[0]);
                String name = values[1];
                int age = Integer.parseInt(values[2]);
                int salary = Integer.parseInt(values[3]);
                Role role = Role.valueOf(values[4]);
                listUser.add(new User(id, name, age, salary, role));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return listUser;
    }

    /**
     * Поиск по id
     * @param id
     * @return
     */
    public Optional<User> findById(Long id) {
        return readUsersFromFile().stream()
            .filter(user -> user.getId().equals(id))
            .findFirst();
    }

    /**
     * Поиск по имени
     * @param name
     * @return
     */
    public Optional<User> findByName(String name) {
        return readUsersFromFile().stream()
            .filter(user -> user.getName().equals(name))
            .findFirst();
    }

    /**
     * Сохранение юзера
     * @param user
     */
    public void save(User user) {
        List<User> users = readUsersFromFile();
        users.removeIf(u1 -> u1.getId().equals(user.getId()));
        users.add(user);
        saveAllUsers(users);
    }

    /**
     * Сохранение всех юзеров
     * @param users
     */
    /*private void saveAllUsers(List<User> users) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            bufferedWriter.write("id;name;age;salary;role");
            bufferedWriter.newLine();

            for (User user : users) {
                bufferedWriter.write(user.getId() + ";" + user.getName() + ";" +
                    user.getAge() + ";" + user.getSalary() + ";" + user.getRole());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }*/

    private void saveAllUsers(List<User> users) {
        List<String> list = new ArrayList<>();
        list.add("id;name;age;salary;role");

        for (User user : users) {
            list.add(user.getId() + ";" + user.getName() + ";" +
                user.getAge() + ";" + user.getSalary() + ";" + user.getRole());
        }

        try {
            Files.write(file, list, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Удаление юзера по id
     * @param id
     */
    public void deleteById(Long id) {
        List<User> users = readUsersFromFile();
        users.removeIf(user -> user.getId().equals(id));
        saveAllUsers(users);
    }

    /**
     * Все юзеры
     * @return
     */
    public List<User> findAll() {
        return readUsersFromFile();
    }
}
