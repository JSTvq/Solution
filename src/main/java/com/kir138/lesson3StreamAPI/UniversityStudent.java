package com.kir138.lesson3StreamAPI;

import java.util.List;

public class UniversityStudent implements Student, Comparable<UniversityStudent>{
    private final String nameStudent;
    private final List<Course> courses;

    public UniversityStudent(String nameStudent, List<Course> courses) {
        this.nameStudent = nameStudent;
        this.courses = courses;
    }

    @Override
    public List<Course> getAllCourses() {
        return courses;
    }

    @Override
    public String getName() {
        return nameStudent;
    }

    @Override
    public String toString() {
        return "UniversityStudent{" +
                "nameStudent='" + nameStudent + '\'' +
                ", courses=" + courses +
                '}';
    }

    @Override
    public int compareTo(UniversityStudent o) {
        return Integer.compare(o.getAllCourses().size(), this.getAllCourses().size());
    }
}
