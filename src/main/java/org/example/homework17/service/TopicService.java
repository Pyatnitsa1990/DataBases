package org.example.homework17.service;


import org.example.homework17.model.Topic;
import org.example.homework17.repository.dao.TopicRepository;

import java.util.List;


public class TopicService {

    private final TopicRepository topicRepository;


    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }


    public Topic findById(int topicId) {
        return topicRepository.findById(topicId);
    }

    public List<Topic> findAll() {
        return topicRepository.findAll();
    }

    public void addTopic(Topic topic) {
        topicRepository.create(topic);
    }

}


