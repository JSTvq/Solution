package com.kir138.lesson3StreamAPI.task1;

import com.kir138.lesson3StreamAPI.task1.Course;
import com.kir138.lesson3StreamAPI.task1.Student;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class UniversityStudent implements Student {
    private final String name;
    private final List<Course> allCourses;

}
