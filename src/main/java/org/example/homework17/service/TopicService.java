package org.example.homework17.service;


import org.example.homework17.model.Topic;
import org.example.homework17.repository.dao.TopicRepository;


public class TopicService {

    private final TopicRepository topicRepository;


    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }


    public Topic findById(int topicId) {
        return topicRepository.findById(topicId);
    }


    public int addTopic(Topic topic) {
        return topicRepository.create(topic);
    }

}


