package com.kir138.lesson3StreamAPI.trainingSkills.taskMedium2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
    /**
     * Используйте лямбда-выражения для сортировки списка строк по возрастанию их длины.
     */
    List<String> strings = Arrays.asList("elephant", "cat", "hippopotamus", "dog");
    List<String> res = strings.stream()
        .sorted(Comparator.comparing(String::length))
        .collect(Collectors.toList());
        System.out.println(res);
    }
}
