package com.kir138.lesson4.task1.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Team {
    private Long id;
    private String name;
    private String department;
}
