package com.kir138.lesson3StreamAPI;

import java.util.Objects;

public class SimpleCourse implements Course {
    private final String courseName;

    public SimpleCourse(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String getCourseName() {
        return courseName;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        SimpleCourse that = (SimpleCourse) obj;
        return Objects.equals(courseName, that.courseName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseName);
    }

    @Override
    public String toString() {
        return "SimpleCourse{" +
                "courseName='" + courseName + '\'' +
                '}';
    }
}
