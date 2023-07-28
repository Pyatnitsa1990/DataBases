package org.example;

import org.example.homework17.command.Command;
import org.example.homework17.command.Shell;
import org.example.homework17.repository.QuestionRepositoryImpl;
import org.example.homework17.repository.TopicRepositoryImpl;
import org.example.homework17.service.QuestionService;
import org.example.homework17.service.TopicService;

import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class Main {

    private static final Map<Integer, Runnable> COMMANDS;

    static {
        Shell shell = new Shell(new QuestionService(new QuestionRepositoryImpl()), new TopicService(new TopicRepositoryImpl()));
        COMMANDS = Map.of(
                1, shell.getRandom(),
                2, shell.getRandomByTopicId(),
                3, shell.createQuestion(),
                4, shell.removeById(),
                5, shell.findById(),
                6, shell.addTopic()
        );
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Hello! Do you want use some command y/n?");
        while (sc.hasNext()) {
            String answer = sc.nextLine();
            if (answer.equalsIgnoreCase("y")) {
                for (String command : Command.showForUser) {
                    System.out.println(command);

                }
                System.out.println("\nPlease choice and enter number command");
                while (sc.hasNext()) {
                    int number = sc.nextInt();
                    Optional.ofNullable(COMMANDS.get(number))
                            .ifPresent(Runnable::run);
                    break;
                }
            }
            if (answer.equalsIgnoreCase("n")) {
                System.out.println("Good bye)");
                break;
            }
            sc.nextLine();
            System.out.println("\nYou want to use some other command y/n?");
        }
    }

}