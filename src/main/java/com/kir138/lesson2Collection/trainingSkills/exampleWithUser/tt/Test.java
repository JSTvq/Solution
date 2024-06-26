package com.kir138.lesson2Collection.trainingSkills.exampleWithUser.tt;

import java.util.HashSet;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        User user1 = new User("чел1");
        User user2 = new User("чел2");
        User user3 = new User("чел3");
        User user4 = new User("чел4");
        User user5 = new User("чел5");
        Set<User> list = new HashSet<>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);
        list.add(user5);
        System.out.println();

        user1.setName("chel800");

    }
}
