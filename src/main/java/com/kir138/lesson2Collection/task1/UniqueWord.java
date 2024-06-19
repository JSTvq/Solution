package com.kir138.lesson2Collection.task1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UniqueWord {
    public static void main(String[] args) {
        /**
         * Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
         * Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
         * Посчитать, сколько раз встречается каждое слово.
         */
        String[] massWords = {"слово1", "слово2", "слово3", "слово1", "слово2",
                "слово4", "слово5", "слово6", "слово7", "слово6", "слово8", "слово9"};

        Set<String> words = new HashSet<>(Arrays.asList(massWords));
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (String a : words) {
            sb.append(a).append(", ");
            count++;
        }
        System.out.println("уникальные слова в массиве massWords: " + sb + "\nв массиве встречается " + count + " уникальных слов");
    }
}
