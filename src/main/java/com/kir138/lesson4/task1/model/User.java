package com.kir138.lesson4.task1.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

//Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;
    private String name;
    private Integer age;
    private BigDecimal salary;
    private Role role;
    private Long team_id;

    @Override
    public String toString() {
        return "User{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", age=" + age +
            ", salary=" + salary +
            ", role=" + role +
            ", team_id=" + team_id +
            '}';
    }
}
