package com.harlingcs.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    public List<Topic> getAllTopics() {
        return (List<Topic>) topicRepository.findAll();
    }

    public Topic getTopic(Long id) {
        return topicRepository.findById(id).orElse(null);
    }

    public void addOrUpdateTopic(Topic topic) {
        topicRepository.save(topic);
    }

    public void deleteTopicById(Long id) {
        topicRepository.deleteById(id);
    }


}
