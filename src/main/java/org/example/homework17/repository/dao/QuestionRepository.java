package org.example.homework17.repository.dao;

import org.example.homework17.model.Question;

import java.sql.ResultSet;
import java.util.List;

public interface QuestionRepository {

        boolean create(Question question);

        Question findById(int id);

        boolean remove(int id);

        int update(Question question);

        List<Question> findAll();
}


