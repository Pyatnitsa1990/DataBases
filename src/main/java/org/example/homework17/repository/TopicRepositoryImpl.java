package org.example.homework17.repository;

import org.example.homework17.model.Topic;
import org.example.homework17.repository.dao.TopicRepository;
import org.example.homework17.mapper.TopicMapper;

import java.sql.*;
import java.util.List;


public class TopicRepositoryImpl implements TopicRepository {

    private final Connection connection;

    public TopicRepositoryImpl(Connection connection) {
        this.connection = connection;
    }


    private static final String CREATE =
            """
                            INSERT INTO public.question(
                            name, rating)
                            VALUES (?, ?, ?)
                    """;

    private static final String REMOVE =
            """
                            DELETE FROM public.question
                            WHERE id = ?
                                        
                    """;

    private static final String UPDATE =
            """
                            UPDATE public.question
                            SET name=?, rating=?
                            WHERE  id = ?;
                                                
                    """;

    private static final String FIND_BY_ID =
            """
                            SELECT * from topic
                            WHERE id = ?;
                                
                    """;

    private static final String FIND_ALL = """
            SELECT * from topic;
               
            """;

    @Override
    public boolean create(Topic topic) {
        try (connection;
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE)) {

            preparedStatement.setString(1, topic.getName());
            preparedStatement.setInt(2, topic.getRating());
            return preparedStatement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Topic findById(int topicId) {

        try (connection;
             PreparedStatement statement = this.connection.prepareStatement(FIND_BY_ID)) {
            ResultSet resultSet = statement.executeQuery();
            statement.setInt(1, topicId);

            return Topic.builder()
                    .name(resultSet.getString("name"))
                    .rating(resultSet.getInt("rating"))
                    .id(resultSet.getInt("id"))
                    .build();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }

    @Override
    public boolean remove(int id) {
        try (connection;
             PreparedStatement preparedStatement = connection.prepareStatement(REMOVE)) {
            preparedStatement.setInt(1, id);
            return preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int update(Topic topic) {
        try (connection;
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);) {

            preparedStatement.setString(1, topic.getName());
            preparedStatement.setInt(2, topic.getRating());
            preparedStatement.setInt(3, topic.getId());

            return preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Topic> findAll() {
        try (connection;
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return TopicMapper.mapToListTopic(resultSet);
            }
            return null;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);

        }

    }

}





