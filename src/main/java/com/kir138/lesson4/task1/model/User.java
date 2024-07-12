package com.kir138.lesson4.task1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;

//Entity
@Data
@Builder
@AllArgsConstructor
public class User {
    private Long id;
    private String name;
    private int age;
    private int salary;
    private Role role;
}
