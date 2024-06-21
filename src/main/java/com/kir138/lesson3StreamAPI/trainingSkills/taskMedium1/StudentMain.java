package com.kir138.lesson3StreamAPI.trainingSkills.taskMedium1;

import com.kir138.lesson3StreamAPI.trainingSkills.taskMedium1.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentMain {
    public static void main(String[] args) {
    /**
     * Задача 3.
     *      Фильтрация списка объектов класса `Student`,
     *      оставляя только тех студентов, чей средний балл выше 8.0.
     */
    Student st1 = new Student("чел1", 5.0);
    Student st2 = new Student("чел2", 6.0);
    Student st3 = new Student("чел3", 7.0);
    Student st4 = new Student("чел4", 8.2);
    Student st5 = new Student("чел5", 9.0);

    List<Student> res = new ArrayList<>();
    res.add(st1);
    res.add(st2);
    res.add(st3);
    res.add(st4);
    res.add(st5);

    List<Student> res2 = res.stream()
        .filter(s -> s.getGrade() > 8.0)
        .toList();

        System.out.println(res2);
    }
}
