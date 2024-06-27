package com.kir138.lesson2Collection.task2;

import java.util.ArrayList;
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
    private final Map<String, List<String>> map;

    public PhoneDirectory(final Map<String, List<String>> map) {
        this.map = map;
    }

    public void add(final String surname, final String numberPhone) {
        map.computeIfAbsent(surname, r -> new ArrayList<>()).add(numberPhone);
    }

    public List<String> get(final String name) {
        return map.getOrDefault(name, new ArrayList<>());
    }
}
