package by.fpmibsu.ozi.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public interface Dao<T>
{
    List<T> findAll() throws DaoException;

    boolean delete(T t) throws DaoException;

    boolean create(T t) throws DaoException;

    T update(T t) throws DaoException;

    default void close(Statement statement) throws DaoException
    {
        try
        {
            if (statement != null)
            {
                statement.close();
            }
        }
        catch (SQLException e)
        {
            throw new DaoException(e.getMessage(), e.getCause());
        }
    }

    default void close(Connection connection) throws DaoException
    {
        try
        {
            if (connection != null)
            {
                connection.close();
            }
        }
        catch (SQLException e)
        {
            throw new DaoException(e.getMessage(), e.getCause());
        }
    }
}
