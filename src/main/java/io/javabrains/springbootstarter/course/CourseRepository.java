package io.javabrains.springbootstarter.course;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, String>{
	// getAllCourses()
	// getCourse(String id)
	// updateCourse(Course t)
	// deleteCourse(String id)
	
	public List<Course> findByTopicId(String topicId);
}
