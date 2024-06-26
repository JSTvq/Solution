package com.kir138.lesson2Collection.trainingSkills.builderTask;

public class Main {
    public static void main(String[] args) {

        User u1 = Main.user();
        System.out.println(u1);
        u1.setName("Villi");
        System.out.println(u1);
    }

    public static User user() {
        return User.builder()
            .id(3)
            .name("Vasya")
            .build();
    }


}
