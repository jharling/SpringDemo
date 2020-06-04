package com.harlingcs.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses(Long topicId) {
        return courseRepository.findAllByTopicId(topicId);
    }

    public Course getCourseById(String id) {
        return courseRepository.findById(id).orElse(null);
    }

    public void addOrUpdateCourse(Course course) {
        courseRepository.save(course);
    }

    public void deleteCourseById(String id) {
        courseRepository.deleteById(id);
    }

}
