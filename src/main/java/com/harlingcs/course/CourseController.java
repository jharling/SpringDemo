package com.harlingcs.course;

import com.harlingcs.topic.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;
    @Autowired
    private TopicService topicService;

    @RequestMapping("/topics/{topicId}/courses")
    public List<Course> getAllCourses(@PathVariable Long topicId) {
        return courseService.getAllCourses(topicId);
    }

    @RequestMapping("/topics/{topicId}/courses/{courseId}")
    public Course getCourse(@PathVariable Long topicId, @PathVariable String courseId) {
        return courseService.getCourseById(courseId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/courses/")
    public void addCourse(@RequestBody Course course, @PathVariable Long topicId) {
        if (course.getTopic() == null) {
            course.setTopic(topicService.getTopic(topicId));
        }
        courseService.addOrUpdateCourse(course);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/courses/{courseId}")
    public void updateCourse(@RequestBody Course course, @PathVariable Long topicId, @PathVariable String courseId) {
        if (course.getTopic() == null) {
            course.setTopic(topicService.getTopic(topicId));
        }
        courseService.addOrUpdateCourse(course);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}/courses/{courseId}")
    public void deleteCourse(@PathVariable Long topicId, @PathVariable String courseId) {
        courseService.deleteCourseById(courseId);
    }
}

