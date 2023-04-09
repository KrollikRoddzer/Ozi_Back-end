package by.fpmibsu.ozi.dao;

import by.fpmibsu.ozi.db.ConnectionCreator;
import by.fpmibsu.ozi.entity.User;

import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements Dao<User>
{
    public static final String SQL_SELECT_ALL_USERS = "SELECT * FROM user;";
    public static final String SQL_SELECT_BY_PHONE = "SELECT * FROM user WHERE phone = ?;";
    public static final String SQL_SELECT_BY_EMAIL = "SELECT * FROM user WHERE email = ?;";
    public static final String SQL_SELECT_BY_ID = "SELECT * FROM user WHERE id = ?";
    public static final String SQL_DELETE_BY_USER = "DELETE FROM user WHERE id = ?";
    public static final String SQL_CREATE_USER = "INSERT INTO user(phone, email, password, name, surname, birthday, sex, country, city, about, photo) " +
            "values(?, ?, ?, ? ,?, ?, ?, ?, ?, ?, ?);";
    public static final String SQL_UPDATE_USER = "UPDATE user SET phone = ?, email = ?, password = ?, name = ?, surname = ?, birthday = ?, sex = ?, " +
            "country = ?, city = ?, about = ?, photo = ? WHERE id = ?";
    @Override
    public List<User> findAll() throws DaoException {
        try(PreparedStatement statement = ConnectionCreator.createConnection().prepareStatement(SQL_SELECT_ALL_USERS))
        {
            List<User> result = new ArrayList<>();
            ResultSet set = statement.executeQuery();
            while(set.next())
            {
                Integer id = set.getInt("id");
                String phone = set.getString("phone");
                String email = set.getString("email");
                String password = set.getString("password");
                String name = set.getString("name");
                String surname = set.getString("surname");
                Date birthday = set.getDate("birthday");
                String sex = set.getString("sex");
                String country = set.getString("country");
                String city = set.getString("city");
                String about = set.getString("about");
                Blob image = set.getBlob("photo");

                result.add(new User(id, phone, email, password, name, surname, birthday, sex, country, city, about, image));
            }

            return result;
        }
        catch (SQLException e)
        {
            throw new DaoException(e.getMessage(), e.getCause());
        }
    }

    public User findByPhone(String phone) throws DaoException
    {
        try (PreparedStatement statement = ConnectionCreator.createConnection().prepareStatement(SQL_SELECT_BY_PHONE))
        {
            statement.setString(1, phone);
            ResultSet set = statement.executeQuery();
            if (set.next())
            {
                return new User(
                        set.getInt("id"),
                        set.getString("phone"),
                        set.getString("email"),
                        set.getString("password"),
                        set.getString("name"),
                        set.getString("surname"),
                        set.getDate("birthday"),
                        set.getString("sex"),
                        set.getString("country"),
                        set.getString("city"),
                        set.getString("about"),
                        set.getBlob("photo")
                );
            }
            else
            {
                return null;
            }
        }
        catch (SQLException e)
        {
            throw new DaoException(e.getMessage(), e.getCause());
        }
    }

    public User findById(Integer id) throws DaoException
    {
        try (PreparedStatement statement = ConnectionCreator.createConnection().prepareStatement(SQL_SELECT_BY_ID))
        {
            statement.setInt(1, id);
            ResultSet set = statement.executeQuery();
            if (set.next())
            {
                return new User(
                        set.getInt("id"),
                        set.getString("phone"),
                        set.getString("email"),
                        set.getString("password"),
                        set.getString("name"),
                        set.getString("surname"),
                        set.getDate("birthday"),
                        set.getString("sex"),
                        set.getString("country"),
                        set.getString("city"),
                        set.getString("about"),
                        set.getBlob("photo")
                );
            }
            else
            {
                return null;
            }
        }
        catch (SQLException e)
        {
            throw new DaoException(e.getMessage(), e.getCause());
        }
    }

    public User findByEmail(String email) throws DaoException
    {
        try (PreparedStatement statement = ConnectionCreator.createConnection().prepareStatement(SQL_SELECT_BY_EMAIL))
        {
            statement.setString(1, email);
            ResultSet set = statement.executeQuery();
            if (set.next())
            {
                return new User(
                        set.getInt("id"),
                        set.getString("phone"),
                        set.getString("email"),
                        set.getString("password"),
                        set.getString("name"),
                        set.getString("surname"),
                        set.getDate("birthday"),
                        set.getString("sex"),
                        set.getString("country"),
                        set.getString("city"),
                        set.getString("about"),
                        set.getBlob("photo")
                );
            }
            else
            {
                return null;
            }
        }
        catch (SQLException e)
        {
            throw new DaoException(e.getMessage(), e.getCause());
        }
    }
    @Override
    public boolean delete(User user) throws DaoException {
        try (PreparedStatement statement = ConnectionCreator.createConnection().prepareStatement(SQL_DELETE_BY_USER))
        {
            statement.setInt(1, user.getId());
            int count = statement.executeUpdate();
            return count > 0;
        }
        catch (SQLException e)
        {
            throw new DaoException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public boolean create(User user) throws DaoException {
        try (PreparedStatement statement = ConnectionCreator.createConnection().prepareStatement(SQL_CREATE_USER))
        {
            statement.setString(1, user.getPhone());
            statement.setString(2, user.getEmail());
            statement.setString(3, User.makeHash(user.getPassword()));
            statement.setString(4, user.getName());
            statement.setString(5, user.getSurname());
            statement.setDate(6, user.getBirthday());
            statement.setString(7, user.getSex());
            statement.setString(8, user.getCountry());
            statement.setString(9, user.getCity());
            statement.setString(10, user.getAbout());
            statement.setBlob(11, user.getImage());

            return statement.executeUpdate() > 0;
        }
        catch (SQLException | NoSuchAlgorithmException e)
        {
            throw new DaoException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public User update(User user) throws DaoException {
        try (PreparedStatement statement = ConnectionCreator.createConnection().prepareStatement(SQL_UPDATE_USER))
        {
            statement.setInt(12, user.getId());
            statement.setString(1, user.getPhone());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getName());
            statement.setString(5, user.getSurname());
            statement.setDate(6, user.getBirthday());
            statement.setString(7, user.getSex());
            statement.setString(8, user.getCountry());
            statement.setString(9, user.getCity());
            statement.setString(10, user.getAbout());
            statement.setBlob(11, user.getImage());

            if (statement.executeUpdate() > 0)
                return user;
            else
                return null;
        }
        catch (SQLException e)
        {
            throw new DaoException(e.getMessage(), e.getCause());
        }
    }
}
