package org.example.homework17.config.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static Connection connection;
    private static final String name = "postgres";
    private static final String password = "maestri";

    private DBConnection() {
    }

    public static Connection getInstance() throws SQLException {
        if (connection == null || connection.isClosed()) {
            synchronized (DBConnection.class) {
                if (connection == null || connection.isClosed()) {
                    connection = DriverManager
                            .getConnection("jdbc:postgresql://localhost:5432/questionarium", name, password);
                }
            }
        }
        return connection;
    }

}

