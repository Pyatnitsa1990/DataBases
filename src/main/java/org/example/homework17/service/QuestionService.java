package org.example.homework17.service;

import org.example.homework17.model.Question;
import org.example.homework17.repository.dao.QuestionRepository;

import java.util.List;
import java.util.Random;


public class QuestionService {
    private static final Random random = new Random();

    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }


    public Question getRandom() {
        List<Question> questions = questionRepository.findAll();
        int randomValue = random.nextInt(0, questions.size());
        return questions.get(randomValue);
    }


}