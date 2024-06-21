package com.kir138.lesson3StreamAPI.task1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        UniversityStudent universityStudent1 = getUniversityStudent();

        UniversityStudent universityStudent2 = new UniversityStudent("чел2", Arrays.asList(new SimpleCourse("геометрия"),
            new SimpleCourse("физкультура")));

        UniversityStudent universityStudent3 = new UniversityStudent("чел3", Arrays.asList(new SimpleCourse("математика"),
            new SimpleCourse("физика"), new SimpleCourse("физкультура"),
            new SimpleCourse("химия")));
        UniversityStudent universityStudent4 = new UniversityStudent("чел4", Arrays.asList(new SimpleCourse("математика"),
            new SimpleCourse("физика")));

        List<Student> students = Arrays.asList(
            universityStudent1,
            universityStudent2,
            universityStudent3,
            universityStudent4
        );

        List<Course> uniqueCourses = getUniqueCourses(students);
        uniqueCourses.forEach(course -> System.out.println("уникальные курсы: " + course.getCourseName()));

        List<Student> mostInquisitive = getMostInquisitive(students);
        mostInquisitive.forEach(student -> System.out.println("самые любознательные: " + student.getName()));

        List<Student> StudentsAttendingTheCourse = getStudentsAttendingTheCourse(students, new SimpleCourse("геометрия"));
        StudentsAttendingTheCourse.forEach(student -> System.out.println("студенты посещающие уроки " +
            new SimpleCourse("геометрии ") + student.getName()));
    }

    private static UniversityStudent getUniversityStudent() {
        return UniversityStudent.builder()
            .name("чел1")
            .allCourses(List.of(
                SimpleCourse.builder()
                    .courseName("математика")
                    .build(),
                SimpleCourse.builder()
                    .courseName("физика")
                    .build(),
                SimpleCourse.builder()
                    .courseName("геометрия")
                    .build()))
            .build();
    }

    /**
     * Написать функцию, принимающую список Student и возвращающую список
     * уникальных курсов, на которые подписаны студенты.
     */
    public static List<Course> getUniqueCourses(List<Student> students) {
        System.out.println();
        return students.stream()
            .flatMap(student -> student.getAllCourses().stream())
            .distinct()
            .toList();
//            .collect(Collectors.toList());
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
