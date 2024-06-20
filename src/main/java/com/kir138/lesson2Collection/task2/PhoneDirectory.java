package com.kir138.lesson2Collection.task2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Написать простой класс Телефонный Справочник, который хранит в себе список фамилий
 * и телефонных номеров.
 * В этот телефонный справочник с помощью метода add() можно
 * добавлять записи, а с помощью метода get() искать номер телефона по фамилии.
 * Следует учесть, что под одной фамилией может быть несколько телефонов
 * (в случае однофамильцев), тогда при запросе такой фамилии должны выводиться
 * все телефоны. Желательно не добавлять лишний функционал(дополнительные поля
 * (имя, отчество, адрес), взаимодействие с пользователем через консоль и т.д).
 * Консоль использовать только для вывода результатов проверки телефонного справочника.
 */

public class PhoneDirectory {
    public static void main(String[] args) {

        Map<String, List<String>> phoneDirectory = new HashMap<>();
        addValue(phoneDirectory, "фамилия1", "88005553535");
        addValue(phoneDirectory, "фамилия2", "8800");
        addValue(phoneDirectory, "фамилия3", "8801");
        addValue(phoneDirectory, "фамилия4", "8802");
        addValue(phoneDirectory, "фамилия1", "880055535356");
        addValue(phoneDirectory, "фамилия2", "880055535357");
        System.out.println(phoneDirectory);
    }

    public static void addValue(Map<String, List<String>> map, String key, String value) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(value);
    }
}
