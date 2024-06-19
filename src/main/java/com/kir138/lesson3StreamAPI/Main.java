package com.kir138.lesson3StreamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new UniversityStudent("чел1", Arrays.asList(new SimpleCourse("математика"),
                        new SimpleCourse("физика"), new SimpleCourse("геометрия"))),
                new UniversityStudent("чел2", Arrays.asList(new SimpleCourse("геометрия"),
                        new SimpleCourse("физкультура"))),
                new UniversityStudent("чел3", Arrays.asList(new SimpleCourse("математика"),
                        new SimpleCourse("физика"), new SimpleCourse("физкультура"),
                        new SimpleCourse("химия"))),
                new UniversityStudent("чел4", Arrays.asList(new SimpleCourse("математика"),
                        new SimpleCourse("физика")))
        );

        List<Course> uniqueCourses = getUniqueCourses(students);
        uniqueCourses.forEach(course -> System.out.println("уникальные курсы: " + course.getCourseName()));

        List<Student> mostInquisitive = getMostInquisitive(students);
        mostInquisitive.forEach(student -> System.out.println("самые любознательные: " + student.getName()));

        List<Student> StudentsAttendingTheCourse = getStudentsAttendingTheCourse(students, new SimpleCourse("геометрия"));
        StudentsAttendingTheCourse.forEach(student -> System.out.println("студенты посещающие уроки " +
                new SimpleCourse("геометрии ") + student.getName()));
    }

    /**
     * Написать функцию, принимающую список Student и возвращающую список
     * уникальных курсов, на которые подписаны студенты.
     */
    public static List<Course> getUniqueCourses(List<Student> students) {
        return students.stream()
                .flatMap(student -> student.getAllCourses().stream())
                .distinct()
                .collect(Collectors.toList());
    }

    /**
     * Написать функцию, принимающую на вход список Student и возвращающую
     * список из трех самых любознательных (любознательность определяется количеством курсов).
     */
    public static List<Student> getMostInquisitive(List<Student> students) {
        return students.stream()
                .sorted(Comparator.comparingInt(student -> -student.getAllCourses().size()))
                .limit(3)
                .collect(Collectors.toList());
    }

    /**
     * Написать функцию, принимающую на вход список Student и экземпляр Course, возвращающую
     * список студентов, которые посещают этот курс.
     */
    public static List<Student> getStudentsAttendingTheCourse(List<Student> students, Course course) {
        return students.stream()
                .filter(student -> student.getAllCourses().contains(course))
                .collect(Collectors.toList());
    }
}
