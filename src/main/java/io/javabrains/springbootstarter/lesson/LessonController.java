package io.javabrains.springbootstarter.lesson;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.springbootstarter.course.Course;
import io.javabrains.springbootstarter.topic.Topic;

@RestController
public class LessonController {

	@Autowired
	private LessonService lessonService;

	// GET
	@RequestMapping("/topics/{topicId}/courses/{courseId}/lessons")
	public List<Lesson> getAllCourses(@PathVariable String courseId) {
		return lessonService.getAllLessons(courseId);
	}

	@RequestMapping("/topics/{topicId}/courses/{courseId}/lessons/{id}")
	public Lesson getCourse(@PathVariable String id) {
		return lessonService.getLesson(id);
	}

	// POST request, create a course
	@RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/courses/{courseId}/lessons")
	public void addCourse(@RequestBody Lesson lesson, @PathVariable String courseId) {
		lesson.setCourse(new Course(courseId, "", ""));
		lessonService.addLesson(lesson);
	}

	// PUT request, update a course
	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/courses/{courseId}/lessons/{id}")
	public void updateCourse(@RequestBody Lesson lesson, @PathVariable String id, @PathVariable String courseId) {
		lesson.setCourse(new Course(courseId, "", ""));
		lessonService.updateLesson(lesson);
	}

	// DELETE request, delete a course
	@DeleteMapping("/topics/{topicId}/courses/{courseId}/lessons/{id}")
	public void deleteCourse(@PathVariable String id) {
		lessonService.deleteLesson(id);
	}
}
