package com.kir138.lesson3StreamAPI.trainingSkills.taskHard1;

public class Employee {
    String name;
    String department;

    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String toString() {
        return name + " (" + department + ")";
    }
}
