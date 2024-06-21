package com.kir138.lesson2Collection.task1;

import java.util.HashMap;
import java.util.Map;

public class UniqueWord {
        /**
         * Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
         * Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
         * Посчитать, сколько раз встречается каждое слово.
         */

    public static Map<String, Integer> calcUniqueWord(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word,0) + 1);
        }
        return map;
    }
}
