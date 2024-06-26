package com.kir138.lesson2Collection.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Main {
    public static void main(String[] args) {
        String[] wordsArray = {"слово1", "слово2", "слово3",
            "слово1", "слово4", "слово5", "слово6", "слово7", "слово8", "слово2", "слово3", "слово9"};

        Map<String, Integer> map = UniqueWord.calcUniqueWord(wordsArray);
        System.out.println(map);

        List<String> list = new ArrayList<>(map.keySet());
        System.out.println("уникальный список ключей: " + list);
    }
}
