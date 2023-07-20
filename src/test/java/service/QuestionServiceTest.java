package service;

import org.example.homework17.model.Question;
import org.example.homework17.repository.dao.QuestionRepository;
import org.example.homework17.service.QuestionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.List;

import static org.mockito.Mockito.*;


public class QuestionServiceTest extends BaseTest {

    @Mock
    private QuestionRepository repository;

    @InjectMocks
    private QuestionService service;


    @Test
    public void getRandom() {
        //when
        when(repository.findAll())
                .thenReturn(getLists());

        //then
        Question random = service.getRandom();
        Assertions.assertNotNull(random);
    }

    @Test
    public void getRandomByTopicId() {
        int topicId = 2;
        when(repository.findAll())
                .thenReturn(getLists());

        Question random = service.getRandomByTopicId(topicId);
        Assertions.assertNotNull(random);
    }
    @Test
    public void checkAdd() {
        Question question = Question.builder().id(4).text("What is Mocking in the context of software testing, and how does it help in writing unit tests?").topicId(13).build();

        service.addQuestion(question);

        verify(repository, only()).create(question);

    }
    @Test
    public void checkRemove() {
        int id = 4;
        service.removeById(id);

        verify(repository, only()).remove(id);

    }
    public List<Question> getLists() {
        return List.of(
                Question.builder().id(0).text("What is the difference between JDK and JRE?").topicId(2).build(),
                Question.builder().id(1).text("Explain the differences between ArrayList and LinkedList in Java?").topicId(4).build(),
                Question.builder().id(2).text("What is the difference between the equals() and == operators in Java?").topicId(4).build(),
                Question.builder().id(3).text("What is the purpose of the final keyword in Java?").topicId(4).build()

        );
    }


}