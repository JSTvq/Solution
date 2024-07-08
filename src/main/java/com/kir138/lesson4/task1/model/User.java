package com.kir138.lesson4.task1.model;

//Entity
public class User {
    private Long id;
    private String name;
    private int age;
    private int salary;
    private String role; //мб енам?

    public User(Long id, String name, int age, int salary, String role) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", age=" + age +
            ", salary=" + salary +
            ", role='" + role + '\'' +
            '}';
    }
}
