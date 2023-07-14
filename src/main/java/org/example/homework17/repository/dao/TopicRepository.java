package org.example.homework17.repository.dao;

import org.example.homework17.model.Topic;

import java.util.List;

public interface TopicRepository {

    int create(Topic topic);

    Topic findById(int id);

    int remove(int id);

    int update(Topic topic);
    List<Topic> findAll();
}
