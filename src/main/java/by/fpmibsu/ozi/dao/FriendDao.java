package by.fpmibsu.ozi.dao;

import by.fpmibsu.ozi.db.ConnectionCreator;
import by.fpmibsu.ozi.entity.Friend;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FriendDao implements Dao<Friend>
{
    public static final String SQL_SELECT_ALL = "SELECT * FROM friends;";
    public static final String SQL_DELETE_FRIEND = "DELETE FROM friends WHERE (user_id = ? AND friend_id = ?) OR (user_id = ? AND friend_id = ?);";
    public static final String SQL_CREATE_FRIEND = "INSERT INTO friends(user_id, friend_id, date) VALUES(?, ?, ?),(?, ?, ?);";
    public static final String SQL_SELECT_ALL_BY_USER_ID = "SELECT * FROM friends WHERE user_id = ?;";
    @Override
    public List<Friend> findAll() throws DaoException {
        try (PreparedStatement statement = ConnectionCreator.createConnection().prepareStatement(SQL_SELECT_ALL))
        {
            ResultSet set = statement.executeQuery();
            return createFromResultSet(set);
        }
        catch (SQLException e)
        {
            throw new DaoException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public boolean delete(Friend friend) throws DaoException {
        try (PreparedStatement statement = ConnectionCreator.createConnection().prepareStatement(SQL_DELETE_FRIEND))
        {
            int user_id = friend.getPerson().getId();
            int friend_id = friend.getFriend().getId();
            statement.setInt(1, user_id);
            statement.setInt(2, friend_id);
            statement.setInt(3, friend_id);
            statement.setInt(4,user_id);

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e.getCause());
        }

    }

    @Override
    public boolean create(Friend friend) throws DaoException {
        try(PreparedStatement statement = ConnectionCreator.createConnection().prepareStatement(SQL_CREATE_FRIEND))
        {
            int user_id = friend.getPerson().getId();
            int frined_id = friend.getFriend().getId();
            Date date = friend.getDate();
            statement.setInt(1, user_id);
            statement.setInt(2, frined_id);
            statement.setDate(3, date);
            statement.setInt(5, user_id);
            statement.setInt(4, frined_id);
            statement.setDate(6, date);

            return statement.executeUpdate() > 0;
        }
        catch (SQLException e)
        {
            throw new DaoException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public Friend update(Friend friend) throws DaoException {
        return null;
    }

    public List<Friend> findFriendsByUserId(int id) throws DaoException
    {
        try (PreparedStatement statement = ConnectionCreator.createConnection().prepareStatement(SQL_SELECT_ALL_BY_USER_ID))
        {
            statement.setInt(1, id);
            ResultSet set = statement.executeQuery();
            return createFromResultSet(set);
        }
        catch (SQLException e)
        {
            throw new DaoException(e.getMessage(), e.getCause());
        }
    }

    private List<Friend> createFromResultSet(ResultSet set) throws SQLException, DaoException
    {
        try {
            UserDao userDao = new UserDao();
            ArrayList<Friend> list = new ArrayList<>();
            while (set.next()) {
                list.add(new Friend(
                        userDao.findById(set.getInt("user_id")),
                        userDao.findById(set.getInt("friend_id")),
                        set.getDate("date")
                ));
            }

            return list;
        }
        catch (SQLException | DaoException e)
        {
            throw new DaoException(e.getMessage(), e.getCause());
        }
    }
}
