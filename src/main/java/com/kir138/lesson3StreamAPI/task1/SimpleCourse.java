package com.kir138.lesson3StreamAPI.task1;

import com.kir138.lesson3StreamAPI.task1.Course;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SimpleCourse implements Course {
    private final String courseName;

}
