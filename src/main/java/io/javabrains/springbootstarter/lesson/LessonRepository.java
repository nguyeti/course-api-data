package io.javabrains.springbootstarter.lesson;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LessonRepository extends CrudRepository<Lesson, String>{
	// getAllCourses()
	// getCourse(String id)
	// updateCourse(Course t)
	// deleteCourse(String id)
	
	public List<Lesson> findByCourseId(String courseId);
}
