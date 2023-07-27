package org.example.homework17.command;

import org.example.homework17.model.Question;
import org.example.homework17.model.Topic;
import org.example.homework17.service.QuestionService;
import org.example.homework17.service.TopicService;

import java.util.List;
import java.util.Scanner;


public class Shell {
    private final QuestionService questionService;
    private final TopicService topicService;
    private Scanner scanner = new Scanner(System.in);


    public Shell(QuestionService questionService, TopicService topicService) {
        this.questionService = questionService;
        this.topicService = topicService;
    }

    public Runnable getRandom() {
        return () -> {
            System.out.println("Random question");
            Question question = questionService.getRandom();
            System.out.println(question.getText());
        };
    }

    public Runnable getRandomByTopicId() {
        return () -> {
            System.out.println("Enter topic id:");
            int topicId = this.scanner.nextInt();
            Question question = questionService.getRandomByTopicId(topicId);
            System.out.printf("The question is: %s", question.getText());
        };
    }

    public Runnable createQuestion() {
        return () -> {
            System.out.println("Please enter the question for add:");
            String questionText = scanner.nextLine();
            System.out.println("And pick a topic id");
            List<Topic> topics = topicService.findAll();
            topics.forEach(topic -> System.out.println(topic.getName()));
            System.out.println("Please enter number topic id");
            int topicId = scanner.nextInt();
            Question question = Question.builder().text(questionText).topic_id(topicId).build();
            questionService.createQuestion(question);


        };
    }

    public Runnable removeById() {
        return () -> {

            List<Question> questions = questionService.findAll();
            questions.forEach(topic -> System.out.println(topic.getId() + " " + topic.getText()));
            System.out.println("Please enter the number of the question you want to delete:");
            int questionId = scanner.nextInt();
            questionService.removeById(questionId);
        };
    }

    public Runnable findById() {
        return () -> {
            System.out.println("Get topic by id");
            int topicId = scanner.nextInt();
            Topic topic = topicService.findById(topicId);
            System.out.printf("The topic is: %s", topic.getName());
        };
    }

    public Runnable addTopic() {
        return () -> {
            System.out.println("Please enter the topic for add:");
            String topicText = scanner.nextLine();
            System.out.println("Please enter rating topic");
            int rating = scanner.nextInt();
            Topic topic = Topic.builder()
                    .name(topicText)
                    .rating(rating)
                    .build();
            topicService.addTopic(topic);
        };
    }
}
