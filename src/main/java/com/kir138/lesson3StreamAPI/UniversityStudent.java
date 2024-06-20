package com.kir138.lesson3StreamAPI;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class UniversityStudent implements Student {
    private final String name;
    private final List<Course> allCourses;

}
