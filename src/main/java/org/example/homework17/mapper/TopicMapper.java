package org.example.homework17.mapper;

import lombok.experimental.UtilityClass;
import org.example.homework17.model.Topic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@UtilityClass
public class TopicMapper {
    private static String NAME = "name";
    private static String RATING = "rating";
    private static String ID = "id";

    public static Topic topicMapper(ResultSet resultSet) throws SQLException {

        return Topic.builder().
                name(resultSet.getString(NAME)).
                rating(resultSet.getInt(RATING)).
                id(resultSet.getInt(ID)).
                build();

    }

    public static List<Topic> mapToListTopic(ResultSet resultSet) throws SQLException {
        List<Topic> topics = new ArrayList<>();
        while (resultSet.next()) {
            topics.add(Topic.builder().
                    name(resultSet.getString(NAME)).
                    rating(resultSet.getInt(RATING)).
                    id(resultSet.getInt(ID)).
                    build());
        }
        return topics;
    }
}
