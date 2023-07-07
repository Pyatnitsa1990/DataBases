package service;

import org.example.homework17.model.Question;
import org.example.homework17.repository.dao.QuestionRepository;
import org.example.homework17.service.QuestionService;
import org.junit.jupiter.api.Test;

import java.util.List;

public class QuestionServiceTest {
    @Test
    public void getRandomTest() {
        QuestionRepository repository = new QuestionRepository() {

            @Override
            public boolean create(Question question) {
                return false;
            }

            @Override
            public Question findById(int id) {
                return null;
            }

            @Override
            public boolean remove(int id) {
                return false;
            }

            @Override
            public int update(Question question) {
                return 0;
            }

            @Override
            public List<Question> findAll() {
                return List.of(
                        Question.builder().id(0).text("What is the difference between JDK and JRE?").build(),
                        Question.builder().id(1).text("Explain the differences between ArrayList and LinkedList in Java?").build(),
                        Question.builder().id(2).text("What is the difference between the equals() and == operators in Java?").build(),
                        Question.builder().id(3).text("What is the purpose of the final keyword in Java?").build()
                );
            }
        };

        QuestionService questionService = new QuestionService(repository);
        System.out.println(questionService.getRandom());
    }
}


