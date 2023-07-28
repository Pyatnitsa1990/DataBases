package org.example.homework17.mapper;

import lombok.experimental.UtilityClass;
import org.example.homework17.model.Question;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


@UtilityClass
public class QuestionMapper {
    private static final String TEXT = "text";
    private static final String ID = "id";
    private static final String TOPIC_ID = "topic_id";


    public static Question mapToQuestion(ResultSet resultSet) throws SQLException {

        return Question.builder()
                .text(resultSet.getString(TEXT))
                .id(resultSet.getInt(ID))
                .topic_id(resultSet.getInt(TOPIC_ID))
                .build();
    }

    public static List<Question> mapToListQuestion(ResultSet resultSet) throws SQLException {
        List<Question> questions = new LinkedList<>();

        while (resultSet.next()) {
            questions.add(Question.builder()
                    .text(resultSet.getString(TEXT))
                    .id(resultSet.getInt(ID))
                    .topic_id(resultSet.getInt(TOPIC_ID))
                    .build());
        }
        return questions;
    }

}
