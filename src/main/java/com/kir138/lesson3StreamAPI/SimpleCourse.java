package com.kir138.lesson3StreamAPI;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SimpleCourse implements Course {
    private final String courseName;

}
