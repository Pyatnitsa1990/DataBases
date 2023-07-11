package org.example.homework17.repository.dao;

import org.example.homework17.model.Topic;

import java.util.List;

public interface TopicRepository {

    boolean create(Topic topic);

    Topic findById(int id);

    boolean remove(int id);

    int update(Topic topic);
    List<Topic> findAll();
}
