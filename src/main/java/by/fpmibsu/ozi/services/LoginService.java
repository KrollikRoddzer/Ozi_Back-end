package by.fpmibsu.ozi.services;

import by.fpmibsu.ozi.dao.DaoException;
import by.fpmibsu.ozi.dao.UserDao;
import by.fpmibsu.ozi.entity.User;

import java.security.NoSuchAlgorithmException;

public class LoginService
{
    UserDao userDao;
    public LoginService(UserDao userDao)
    {
        this.userDao = userDao;
    }

    public Boolean login(String phoneOrEmail , String password)
    {
        try {
            User user = userDao.findByPhone(phoneOrEmail);
            if (user == null)
            {
                user = userDao.findByEmail(phoneOrEmail);
            }
            if (user == null) return false;
            return comparePassword(password, user.getPassword());
        } catch (DaoException e) {
            e.printStackTrace();
        }
        finally {
            return false;
        }
    }

    private Boolean comparePassword(String password, String toCompare)
    {
        try {
            String hashPassword = User.makeHash(password);
            return hashPassword.equals(toCompare);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        finally {
            return false;
        }
    }
}
