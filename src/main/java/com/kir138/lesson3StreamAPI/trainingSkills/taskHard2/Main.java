package com.kir138.lesson3StreamAPI.trainingSkills.taskHard2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        /**
         * Используйте лямбда-выражения для создания таблицы, показывающей
         * список сотрудников в каждой возрастной группе (например, до 30, от 30 до 40, старше 40).
         */
        Employee employee1 = new Employee("чел1", 26);
        Employee employee2 = new Employee("чел2", 27);
        Employee employee3 = new Employee("чел3", 35);
        Employee employee4 = new Employee("чел4", 36);
        Employee employee5 = new Employee("чел5", 41);
        Employee employee6 = new Employee("чел6", 55);

        List<Employee> list = new ArrayList<>(Arrays.asList(employee1, employee2, employee3, employee4, employee5, employee6));

        Map<String, List<Employee>> list2 = list.stream()
            .collect(Collectors.groupingBy(s -> {
                    if (s.getAge() < 30) {
                        return "до 30";
                    } else if (s.getAge() >= 30 && s.getAge() < 40) {
                        return "от 30 до 40";
                    } else {
                        return "старше 40";
                    }
                }
            ));

        System.out.println(list2);
    }
}
