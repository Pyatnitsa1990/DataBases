package org.example.homework17.command;

import java.util.List;

public class Command {

    public static String GET_RANDOM = "Get a random question -> 1";
    public static String GET_RANDOM_QUESTION_BY_TOPIC_ID = "Get a random question by topic -> 2";
    public static String CREATE = "Create question -> 3";
    public static String REMOVE_BY_ID = "Remove question by id - > 4";
    public static String GET_TOPIC_BY_ID = "Get a topic by id -> 5 ";
    public static String ADD_TOPIC = "Create topic -> 6";

    public static List<String> showForUser = List.of(
            GET_RANDOM,
            GET_RANDOM_QUESTION_BY_TOPIC_ID,
            CREATE,
            REMOVE_BY_ID,
            GET_TOPIC_BY_ID,
            ADD_TOPIC
    );
}
