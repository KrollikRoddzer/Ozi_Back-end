package by.fpmibsu.ozi.dbtest;

import by.fpmibsu.ozi.db.ConnectionCreator;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DataDestructor
{
    private static final String SQL_DELETE_USER = "DELETE FROM user;";
    private static final String SQL_DELETE_MESSAGES = "DELETE FROM messages;";
    private static final String SQL_DELETE_FRIENDS = "DELETE FROM friends;";
    private static final String SQL_DELETE_FRIEND_REQUESTS = "DELETE FROM friend_requests;";
    private static final String SQL_DELETE_POSTS = "DELETE FROM posts;";
    public DataDestructor()
    {
        if (!ConnectionCreator.PROPERTIES.getProperty("db.url").equals("jdbc:mysql://127.0.0.1:3306/ozitest")) throw new RuntimeException();
        try (Statement statement = ConnectionCreator.createConnection().createStatement())
        {
            statement.execute(SQL_DELETE_USER);
            statement.execute(SQL_DELETE_MESSAGES);
            statement.execute(SQL_DELETE_FRIENDS);
            statement.execute(SQL_DELETE_FRIEND_REQUESTS);
            statement.execute(SQL_DELETE_POSTS);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
