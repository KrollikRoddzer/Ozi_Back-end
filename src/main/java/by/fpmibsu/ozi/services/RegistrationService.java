package by.fpmibsu.ozi.services;

import by.fpmibsu.ozi.dao.DaoException;
import by.fpmibsu.ozi.dao.UserDao;
import by.fpmibsu.ozi.entity.User;

import java.sql.SQLException;

public class RegistrationService
{
    UserDao userDao;

    public RegistrationService(UserDao userDao)
    {
        this.userDao = userDao;

    }

    public User register(User user)
    {
        try
        {
            userDao.create(user);
            return userDao.findByPhone(user.getPhone());
        }
        catch (DaoException e)
        {
            e.printStackTrace();
        }
        finally {
            return null;
        }
    }
}
