package org.example.homework17.repository;

import org.example.homework17.mapper.QuestionMapper;
import org.example.homework17.model.Question;
import org.example.homework17.repository.dao.QuestionRepository;


import java.sql.*;
import java.util.List;

public class QuestionRepositoryImpl implements QuestionRepository {
    private final Connection connection;

    public QuestionRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    private static final String CREATE = """
                    INSERT INTO question(name, rating)
                    VALUES (?, ?)
            """;

    private static final String REMOVE = """
                    DELETE FROM question
                    WHERE id = ?
                                
            """;

    private static final String UPDATE = """
                    UPDATE question
                    SET name=?, rating=?
                    WHERE  id = ?;
                                        
            """;

    private static final String FIND_BY_ID = """
                    SELECT * from question
                    WHERE  id = ?;
            """;

    private static final String FIND_ALL = """
                    SELECT * from question;
            """;


    @Override
    public boolean create(Question question) {

        try (connection) {
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE);

            preparedStatement.setString(1, question.getText());

            return preparedStatement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Question findById(int questionId) {

        try (connection;
             PreparedStatement statement = connection.prepareStatement(FIND_BY_ID)) {
            statement.setInt(1, questionId);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return QuestionMapper.mapToQuestion(resultSet);
            }
            return null;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Question> findAll() {

        try (connection;
             PreparedStatement statement = connection.prepareStatement(FIND_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return QuestionMapper.mapToListQuestion(resultSet);
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
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
    public int update(Question question) {
        try {

            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1, question.getText());
            preparedStatement.setInt(3, question.getId());

            return preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

