package by.fpmibsu.ozi.dao;

import by.fpmibsu.ozi.db.ConnectionCreator;
import by.fpmibsu.ozi.entity.User;

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
    public static final String SQL_DELETE_BY_USER = "DELETE FROM user where id = ?";
    public static final String SQL_CREATE_USER = "INSERT INTO user(phone, email, password, name, surname, birthday, sex) " +
            "values(?, ?, ?, ? ,?, ?, ?);";
    public static final String SQL_UPDATE_USER = "UPDATE user SET password = ?, name = ?, surname = ?, birthday = ?, sex = ?, " +
            "country = ?, city = ?, about = ?, photo = ?";
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

    @Override
    public boolean delete(User user) throws DaoException {
        return false;
    }

    @Override
    public boolean create(User user) throws DaoException {
        return false;
    }

    @Override
    public User update(User user) throws DaoException {
        return null;
    }
}
