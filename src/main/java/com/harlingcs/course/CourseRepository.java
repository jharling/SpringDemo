package com.harlingcs.course;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, String> {

    public List<Course> findAllByName(String name);

    public List<Course> findAllByTopicId(Long topicId);

}
