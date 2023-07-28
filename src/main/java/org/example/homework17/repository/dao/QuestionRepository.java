package org.example.homework17.repository.dao;


import org.example.homework17.exception.QuestionException;
import org.example.homework17.model.Question;
import java.util.List;

public interface QuestionRepository {

        int create(Question question);

        Question findById(int id);

       List<Question> findByTopicId(int topicId);

        int remove(int id);

        int update(Question question);

        List<Question> findAll();
}


