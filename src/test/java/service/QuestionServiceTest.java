package service;

import org.example.homework17.model.Question;
import org.example.homework17.repository.dao.QuestionRepository;
import org.example.homework17.service.QuestionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.when;


public class QuestionServiceTest {

    @Mock
    private QuestionRepository repository;

    @InjectMocks
    private QuestionService service;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getRandomTest() {
        //when
        when(repository.findAll())
                .thenReturn(getLists());

        //then
        Question random = service.getRandom();
        Assertions.assertNotNull(random);
    }

    private List<Question> getLists() {
        return List.of(
                Question.builder().id(0).text("What is the difference between JDK and JRE?").build(),
                Question.builder().id(1).text("Explain the differences between ArrayList and LinkedList in Java?").build(),
                Question.builder().id(2).text("What is the difference between the equals() and == operators in Java?").build(),
                Question.builder().id(3).text("What is the purpose of the final keyword in Java?").build()
        );
    }

}


