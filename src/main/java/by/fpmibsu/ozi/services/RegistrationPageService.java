package by.fpmibsu.ozi.services;

import by.fpmibsu.ozi.dao.DaoException;
import by.fpmibsu.ozi.dao.UserDao;
import by.fpmibsu.ozi.entity.User;

public class RegistrationPageService
{
    UserDao userDao;

    public RegistrationPageService(UserDao userDao)
    {
        this.userDao = userDao;

    }

    public User register(User user)
    {
        try
        {
            Boolean res = userDao.create(user);
            if (!res) return null;
            return userDao.findByPhone(user.getPhone());
        }
        catch (DaoException e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
