package com.sparta.week01.controller;

import com.sparta.week01.domain.CourseRepository;
import com.sparta.week01.domain.Course;
import com.sparta.week01.domain.CourseRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CourseController {

    private final CourseRepository courseRepository;

    @GetMapping("/api/courses")
    public List<Course> getCourses() {
        return courseRepository.findAll();
    }

    // @RequestBody 어노테이션으로 넘어오는 데이터를 변환
    @PostMapping("/api/courses")
    public Course createCourses(@RequestBody CourseRequestDto requestDto) {
        Course course = new Course(requestDto);

        return courseRepository.save(course);
    }
}
