package com.kir138.lesson3StreamAPI.trainingSkills.taskMedium1;

public class Student {
    private final String name;
    private final double grade;

    Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public double getGrade() {
        return grade;
    }

    public String toString() {
        return name + ": " + grade;
    }
}
