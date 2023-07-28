package org.example.homework17.service;

import org.example.homework17.model.Question;
import org.example.homework17.repository.dao.QuestionRepository;

import java.util.ArrayList;
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
        return getQuestion(questions);
    }

    public Question getRandomByTopicId(int topicId) {
        List<Question> questions = questionRepository.findAll();

        List<Question> filteredByTopicId = new ArrayList<>();
        for (Question qs : questions) {
            if (qs.getTopic_id() == topicId) {
                filteredByTopicId.add(qs);
            }
        }
        return getQuestion(filteredByTopicId);
    }

    public void createQuestion(Question question) {
         this.questionRepository.create(question);
    }

    public void removeById(int questionId) {
        this.questionRepository.remove(questionId);
    }

    private static Question getQuestion(List<Question> questions) {
        int randomValue = random.nextInt(0, questions.size());
        return questions.get(randomValue);
    }

    public List<Question> findAll() {
        return questionRepository.findAll();
    }

}