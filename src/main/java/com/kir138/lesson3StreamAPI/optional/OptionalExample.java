package com.kir138.lesson3StreamAPI.optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalExample {
    private final List<User> userList = new ArrayList<>();
    private final List<User> userListAnotherOne = new ArrayList<>();

    public static void main(String[] args) {
        Optional<User> optionalUser = Optional.of(new User("Vanya", 3321L));
        Optional<Long> optionalLong = Optional.of(123L);
        Optional<Long> empty = Optional.empty();

        OptionalExample optionalExample = new OptionalExample();

        optionalExample.userListAnotherOne.add(new User("Igor", 123L));

        String userName = optionalExample.getByIdFirstList(123L)
            .or(() -> optionalExample.getByIdSecondList(123L))
            .map(User::getName)
            .orElseThrow(() -> new RuntimeException("User with id %s not found".formatted(123L)));

        System.out.println(userName);
    }

    public Optional<User> getByIdFirstList(Long id) {
        return userList.stream()
            .filter(user -> user.getId().equals(id))
            .findFirst();
    }

    public Optional<User> getByIdSecondList(Long id) {
        return userListAnotherOne.stream()
            .filter(user -> user.getId().equals(id))
            .findFirst();
    }
}

class User {
    private String name;
    private Long id;

    public User(String name, Long id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
