package org.example.homework17.repository.dao;

import org.example.homework17.model.Topic;

public interface TopicRepository {

    boolean create(Topic topic);

    Topic findById(int id);

    boolean remove(int id);

    int update(Topic topic);

}
