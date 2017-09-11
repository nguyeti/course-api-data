package io.javabrains.springbootstarter.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
// Spring Business Service

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;

	public List<Course> getAllCourses(String topicId) {
		List<Course> courses = new ArrayList<>();
		courseRepository.findByTopicId(topicId).forEach(courses::add); // Java 8 lambda expression
		return courses;
	}

	public Course getCourse(String id) {
		return courseRepository.findOne(id);
	}

	public void addCourse(Course topic) {
		courseRepository.save(topic);
	}

	public void updateCourse(Course topic) {
		courseRepository.save(topic);
	}

	public void deleteCourse(String id) {
		courseRepository.delete(id);
	}
}
