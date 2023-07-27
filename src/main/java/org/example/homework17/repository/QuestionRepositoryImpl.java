package org.example.homework17.repository;

import org.example.homework17.config.db.DBConnection;
;
import org.example.homework17.exception.QuestionException;
import org.example.homework17.mapper.QuestionMapper;
import org.example.homework17.model.Question;
import org.example.homework17.repository.dao.QuestionRepository;


import java.sql.*;
import java.util.List;

public class QuestionRepositoryImpl implements QuestionRepository {

    private static final String NOT_FOUND_BY_ID = "Question not found by id";
    private static final String NOT_FOUND_BY_TOPIC_ID = "Question not found by id";
    private static final String NOT_FOUND_BY_FIND_ALL = "Question not found ";
    private static final String NOT_BEEN_CREATED = "Question not been created ";

    private static final String CREATE = """
                    INSERT INTO question(text, topic_id)
                    VALUES (?, ?)
            """;

    private static final String REMOVE = """
                    DELETE FROM question
                    WHERE id = ?
                                
            """;

    private static final String UPDATE = """
                    UPDATE question
                    SET text=?
                    WHERE  id = ?;
                                        
            """;

    private static final String FIND_BY_ID = """
                    SELECT * from question
                    WHERE  id = ?;
            """;

    private static final String FIND_ALL = """
                    SELECT * from question;
            """;
    private static final String FIND_BY_TOPIC_ID = """
            SELECT id, text, topic_id FROM question
            WHERE topic_id = ?;
            """;

    @Override
    public int create(Question question) {

        try (PreparedStatement preparedStatement = DBConnection.getInstance().prepareStatement(CREATE)) {
            preparedStatement.setString(1, question.getText());
            preparedStatement.setInt(2, question.getTopic_id());

            return preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            throw new QuestionException(NOT_BEEN_CREATED, ex);
        }
    }

    @Override
    public Question findById(int questionId) {

        try (PreparedStatement statement = DBConnection.getInstance().prepareStatement(FIND_BY_ID)) {
            statement.setInt(1, questionId);
            ResultSet resultSet = statement.executeQuery();

            return QuestionMapper.mapToQuestion(resultSet);

        } catch (SQLException ex) {
            throw new QuestionException(NOT_FOUND_BY_ID, ex);
        }
    }

    @Override
    public List<Question> findByTopicId(int topicId) {

        try (PreparedStatement statement = DBConnection.getInstance().prepareStatement(FIND_BY_TOPIC_ID)) {
            statement.setInt(1, topicId);
            ResultSet resultSet = statement.executeQuery();

            return QuestionMapper.mapToListQuestion(resultSet);
        } catch (SQLException ex) {
            throw new QuestionException(NOT_FOUND_BY_TOPIC_ID + topicId, ex);
        }
    }

    public List<Question> findAll() {

        try (PreparedStatement statement = DBConnection.getInstance().prepareStatement(FIND_ALL)) {
            ResultSet resultSet = statement.executeQuery();

            return QuestionMapper.mapToListQuestion(resultSet);
        } catch (SQLException ex) {
            throw new QuestionException(NOT_FOUND_BY_FIND_ALL, ex);
        }
    }

    @Override
    public int remove(int id) {
        try (PreparedStatement preparedStatement = DBConnection.getInstance().prepareStatement(REMOVE)) {
            preparedStatement.setInt(1, id);

            return preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            throw new QuestionException(NOT_FOUND_BY_ID, ex);
        }
    }

    @Override
    public int update(Question question) {
        try (PreparedStatement preparedStatement = DBConnection.getInstance().prepareStatement(UPDATE)) {
            preparedStatement.setString(1, question.getText());
            preparedStatement.setInt(2, question.getId());

            return preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

}

