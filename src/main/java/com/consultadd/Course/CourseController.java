package com.consultadd.Course;

import com.consultadd.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/topics/{id}/Courses")
    public List<Course> getAllCourses(@PathVariable String id) {
        return courseService.getAllCourses(id);
    }

    @GetMapping("/topics/{topicId}/Courses/{Id}")
    public Optional<Course> getCourse(@PathVariable String id) {
        return courseService.getCourse(id);
    }

    @PostMapping("/topics/{topicId}/Courses")
    public void addCourse(@RequestBody Course course, @PathVariable String topicId) {
        course.setTopic((new Topic(topicId, "", "")));
        courseService.addCourse(course);
    }

    @PutMapping("/topics/{topicId}/Courses/{id}")
    public void updateCourse(@RequestBody Course course, @PathVariable String id, @PathVariable String topicId) {
        course.setTopic((new Topic(topicId, "", "")));
        courseService.updateCourse(course);
    }

    @DeleteMapping("/topics/{topicId}/Courses/{id}")
    public void deleteTopic(@PathVariable String id) {
        courseService.deleteCourse(id);
    }
}
