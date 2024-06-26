package com.kir138.lesson3StreamAPI.task2UniqueWord;

import java.util.List;
import java.util.Map;


public class Main {
    public static void main(String[] args) {
        /**
         * Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
         * Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
         * Посчитать, сколько раз встречается каждое слово.
         */

    String[] wordsArray = {"слово1", "слово2", "слово3",
        "слово1", "слово4", "слово5", "слово6", "слово7", "слово8", "слово2", "слово3", "слово9"};

        System.out.println("уникальные слова:");
        List<String> list = UniqueWord.calcUniqueWord(wordsArray);
        System.out.println(list);

        System.out.println("сколько раз встречаются слова");
        Map<String, Long> countWords = UniqueWord.calcNumbWord(wordsArray);
        System.out.println(countWords);

    }
}
