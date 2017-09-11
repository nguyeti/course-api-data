package io.javabrains.springbootstarter.lesson;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
// Spring Business Service

@Service
public class LessonService {

	@Autowired
	private LessonRepository lessonRepository;

	public List<Lesson> getAllLessons(String courseId) {
		List<Lesson> courses = new ArrayList<>();
		lessonRepository.findByCourseId(courseId).forEach(courses::add); // Java 8 lambda expression
		return courses;
	}

	public Lesson getLesson(String id) {
		return lessonRepository.findOne(id);
	}

	public void addLesson(Lesson lesson) {
		lessonRepository.save(lesson);
	}

	public void updateLesson(Lesson lesson) {
		lessonRepository.save(lesson);
	}

	public void deleteLesson(String id) {
		lessonRepository.delete(id);
	}
}
