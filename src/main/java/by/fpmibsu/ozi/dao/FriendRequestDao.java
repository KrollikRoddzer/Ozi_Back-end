package by.fpmibsu.ozi.dao;

import by.fpmibsu.ozi.db.ConnectionCreator;
import by.fpmibsu.ozi.entity.Friend;
import by.fpmibsu.ozi.entity.FriendRequest;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FriendRequestDao implements Dao<FriendRequest>
{

    public static final String SQL_SELECT_ALL = "SELECT * FROM friend_requests;";
    public static final String SQL_DELETE_FRIEND_REQUEST = "DELETE FROM friend_requests WHERE (receiver_id = ? AND sender_id = ?) OR (sender_id = ? AND receiver_id = ?);";
    public static final String SQL_CREATE_FRIEND_REQUEST = "INSERT INTO friend_requests(receiver_id, sender_id, date) VALUES(?, ?, ?),(?, ?, ?);";

    @Override
    public List<FriendRequest> findAll() throws DaoException {
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
    public boolean delete(FriendRequest friend) throws DaoException {
        try (PreparedStatement statement = ConnectionCreator.createConnection().prepareStatement(SQL_DELETE_FRIEND_REQUEST))
        {
            int receiver_id = friend.getReceiver().getId();
            int sender_id = friend.getSender().getId();
            statement.setInt(1, receiver_id);
            statement.setInt(2, sender_id);
            statement.setInt(3, sender_id);
            statement.setInt(4,receiver_id);

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e.getCause());
        }

    }

    @Override
    public boolean create(FriendRequest friend) throws DaoException {
        try(PreparedStatement statement = ConnectionCreator.createConnection().prepareStatement(SQL_CREATE_FRIEND_REQUEST))
        {
            int receiver_id = friend.getReceiver().getId();
            int sender_id = friend.getSender().getId();
            Date date = friend.getDate();
            statement.setInt(1, receiver_id);
            statement.setInt(2, sender_id);
            statement.setDate(3, date);
            statement.setInt(5, receiver_id);
            statement.setInt(4, sender_id);
            statement.setDate(6, date);

            return statement.executeUpdate() > 0;
        }
        catch (SQLException e)
        {
            throw new DaoException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public FriendRequest update(FriendRequest friend) throws DaoException {
        return null;
    }

    private List<FriendRequest> createFromResultSet(ResultSet set) throws SQLException, DaoException
    {
        try {
            UserDao userDao = new UserDao();
            ArrayList<FriendRequest> list = new ArrayList<>();
            while (set.next()) {
                list.add(new FriendRequest(
                        userDao.findById(set.getInt("receiver_id")),
                        userDao.findById(set.getInt("sender_id")),
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
