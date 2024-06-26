package com.kir138.lesson3StreamAPI.task2UniqueWord;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UniqueWord {
    /**
     * Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
     * Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
     * Посчитать, сколько раз встречается каждое слово.
     */
    public static List<String> calcUniqueWord(String[] wordsArray) {
        return Arrays.stream(wordsArray)
            .distinct()
            .toList();
    }

    public static Map<String, Long> calcNumbWord(String[] wordsArray) {
        return Arrays.stream(wordsArray)
            .collect(Collectors.groupingBy(word -> word, Collectors.counting()));
    }
}
