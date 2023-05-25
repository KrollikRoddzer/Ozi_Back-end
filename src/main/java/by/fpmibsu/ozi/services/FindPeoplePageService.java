package by.fpmibsu.ozi.services;

import by.fpmibsu.ozi.dao.DaoException;
import by.fpmibsu.ozi.dao.UserDao;
import by.fpmibsu.ozi.entity.User;

import java.util.List;

public class FindPeoplePageService
{
    private final UserDao userDao;

    FindPeoplePageService(UserDao userDao)
    {
        this.userDao = userDao;
    }

    public List<User> findByName(String name) throws DaoException
    {
        return userDao.findByName(name);
    }
}
