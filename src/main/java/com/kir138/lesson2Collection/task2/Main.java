package com.kir138.lesson2Collection.task2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        PhoneDirectory phoneDirectory = new PhoneDirectory(new HashMap<>());
        phoneDirectory.add("чел1", "1234");
        phoneDirectory.add("чел2", "123");
        phoneDirectory.add("чел3", "12");
        phoneDirectory.add("чел4", "12347");
        phoneDirectory.add("чел1", "12345");
        System.out.println(phoneDirectory.get("чел1"));

    }
}
