package io.shivam.springbootstart.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

/**
 * Spring creates only a single instance of this service class and registers it. '@service' is used to do that.
 * 
 * @author shivam
 *
 */
@Service
public class TopicService {
	
	private List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("spring", "spring framework", "spring framework course"),
			new Topic("java", "java framework", "java framework course"),
			new Topic("springboot", "spring boot framework", "spring framework bootstraps")
		));
	
	public List<Topic> getAllTopics() {
		return topics;
	}
			
	public Topic getTopic(String id) {
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}
	
	public void addTopic(Topic topic) {
		topics.add(topic);
	}
	
	public void updateTopic(String id, Topic topic) {
		for (int i = 0; i < topics.size(); i++) {
			Topic t = topics.get(i);
			if (t.getId().equals(id)) {
				topics.set(i, topic);
				return;
			}
		}
	}

	public void deleteTopic(String id) {
		topics.removeIf(t -> t.getId().equals(id));		
	}
}

