package service;

import org.example.homework17.model.Topic;
import org.example.homework17.repository.dao.TopicRepository;
import org.example.homework17.service.TopicService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.List;


import static org.mockito.Mockito.*;


public class TopicServiceTest extends BaseTest {

    @Mock
    private TopicRepository repository;

    @InjectMocks
    private TopicService service;


    @Test
    public void checkAdd() {
        Topic topic = Topic.builder().id(4).name("Mock").rating(13).build();

        service.addTopic(topic);

        verify(repository, only()).create(topic);

    }

    @Test
    public void getTopic() {
        int id = 3;

        service.findById(id);

        verify(repository, only()).findById(id);
    }

    public List<Topic> getLists() {
        return List.of(
                Topic.builder().id(0).name("Basic Java").rating(14).build(),
                Topic.builder().id(1).name("List").rating(11).build(),
                Topic.builder().id(2).name("OOP").rating(4).build(),
                Topic.builder().id(3).name("Exception").rating(1).build(),
                Topic.builder().id(4).name("Pattern").rating(13).build()
        );
    }
}
