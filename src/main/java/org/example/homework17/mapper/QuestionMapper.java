package org.example.homework17.mapper;

import lombok.experimental.UtilityClass;
import org.example.homework17.model.Question;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


@UtilityClass
public class QuestionMapper {
    private static final String NAME = "name";
    private static final String ID = "id";


    public static Question mapToQuestion(ResultSet resultSet) throws SQLException {

        return Question.builder()
                .text(resultSet.getString(NAME))
                .id(resultSet.getInt(ID))
                .build();
    }

    public static List<Question> mapToListQuestion(ResultSet resultSet) throws SQLException {
        List<Question> questions = new LinkedList<>();
        while (resultSet.next()) {
            questions.add(Question.builder()
                    .text(resultSet.getString(NAME))
                    .id(resultSet.getInt(ID))
                    .build());
        }
        return questions;
    }

}
