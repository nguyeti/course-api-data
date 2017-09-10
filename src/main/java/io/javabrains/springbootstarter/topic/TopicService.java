package io.javabrains.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
// Spring Business Service

@Service
public class TopicService {

	@Autowired
	private TopicRepository topicRepository;
	
	// hard coded
	// List<Topic> topics = new ArrayList<>(Arrays.asList(
	// new Topic("spring", "Spring boot name", "Spring boot description"),
	// new Topic("java", "java name", "java description"), new Topic("SQL", "SQL
	// name", "SQL description")));

	public List<Topic> getAllTopics() {
		// return topics; -- with CrudRepository
		List<Topic> topics = new ArrayList<>();
		// topicRepository.findAll().forEach(topics::add); -- Java 8 lambda expression
		for (Topic t : topicRepository.findAll()) {
			topics.add(t);
		}
		return topics;
	}

	public Topic getTopic(String id) {
		// return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return topicRepository.findOne(id);
	}

	public void addTopic(Topic topic) {
		// topics.add(topic);
		topicRepository.save(topic);
	}

	public void updateTopic(String id, Topic topic) {
		// for (int i = 0; i < topics.size(); i++) {
		// Topic t = topics.get(i);
		// if (t.getId().equals(id)) {
		// topics.set(i, topic);
		// return;
		// }
		// }
		// smart enough to figure out if a topic is already there thanks to the pk and add the topic or update
		topicRepository.save(topic);
	}

	public void deleteTopic(String id) {
		/*
		 * for (int i = 0; i < topics.size(); i++) { Topic t = topics.get(i); if
		 * (t.getId().equals(id)) { topics.remove(i); return; } }
		 */
//		topics.removeIf(t -> t.getId().equals(id));
		topicRepository.delete(id);
	}
}
