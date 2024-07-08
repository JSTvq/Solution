package com.kir138.lesson4.test1;

import com.kir138.lesson3StreamAPI.optional.OptionalExample;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Test {
    private final List<User> list = new ArrayList<>();

    /*public User getById(Integer id) {
        for (User user : list) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }*/

    public Optional<User> getById(Integer id) {
        return list.stream()
            .filter(user -> user.getId().equals(id))
            .findFirst();
    }

    public void go() {
        getById(123);
    }
    public static void main(String[] args) {
        OptionalExample optionalExample = new OptionalExample();
        //Optional<User> gg = optionalExample.
    }
}
