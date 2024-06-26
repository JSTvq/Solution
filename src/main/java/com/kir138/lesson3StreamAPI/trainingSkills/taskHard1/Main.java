package com.kir138.lesson3StreamAPI.trainingSkills.taskHard1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

    /**
     * Используйте лямбда-выражения и классы из java.util.stream
     * для группировки списка сотрудников по их отделам.
     */
    Employee employee1 = new Employee("чел1", "департамент1");
    Employee employee2 = new Employee("чел2", "департамент2");
    Employee employee3 = new Employee("чел3", "департамент3");
    Employee employee4 = new Employee("чел4", "департамент1");
    Employee employee5 = new Employee("чел5", "департамент2");
    Employee employee6 = new Employee("чел6", "департамент3");
    Employee employee7 = new Employee("чел7", "департамент1");
    Employee employee8 = new Employee("чел8", "департамент1");
    Employee employee9 = new Employee("чел9", "департамент3");

        List<Employee> list = new ArrayList<>(Arrays.asList(employee1, employee2, employee3, employee4,
            employee5, employee6, employee7, employee8, employee9));

        Map<String, List<Employee>> list2 = list.stream()
            .collect(Collectors.groupingBy(s -> s.getDepartment()));

        System.out.println(list2);
    }
}
