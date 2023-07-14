package org.example.homework17.repository;

import org.example.homework17.config.db.DBConnection;
import org.example.homework17.model.Topic;
import org.example.homework17.repository.dao.TopicRepository;
import org.example.homework17.mapper.TopicMapper;

import java.sql.*;
import java.util.List;


public class TopicRepositoryImpl implements TopicRepository {

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
    public int create(Topic topic) {
        try (PreparedStatement preparedStatement = DBConnection.getInstance().prepareStatement(CREATE)) {

            preparedStatement.setString(1, topic.getName());
            preparedStatement.setInt(2, topic.getRating());
            return preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Topic findById(int topicId) {

        try (PreparedStatement statement = DBConnection.getInstance().prepareStatement(FIND_BY_ID)) {
            statement.setInt(1, topicId);
            ResultSet resultSet = statement.executeQuery();

            return TopicMapper.mapToTopic(resultSet);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int remove(int id) {
        try (PreparedStatement preparedStatement = DBConnection.getInstance().prepareStatement(REMOVE)) {
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int update(Topic topic) {
        try (PreparedStatement preparedStatement = DBConnection.getInstance().prepareStatement(UPDATE);) {

            preparedStatement.setString(1, topic.getName());
            preparedStatement.setInt(2, topic.getRating());
            preparedStatement.setInt(3, topic.getId());

            return preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Topic> findAll() {
        try (PreparedStatement preparedStatement = DBConnection.getInstance().prepareStatement(FIND_ALL)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            return TopicMapper.mapToListTopic(resultSet);

        } catch (SQLException ex) {
            throw new RuntimeException(ex);

        }

    }

}





