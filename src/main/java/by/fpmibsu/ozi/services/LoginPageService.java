package by.fpmibsu.ozi.services;

import by.fpmibsu.ozi.dao.DaoException;
import by.fpmibsu.ozi.dao.UserDao;
import by.fpmibsu.ozi.entity.User;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.security.NoSuchAlgorithmException;

public class LoginPageService
{
    static Logger logger = LogManager.getLogger(LoginPageService.class.getName());
    UserDao userDao;
    public LoginPageService(UserDao userDao)
    {
        logger.log(Level.INFO, "Created LoginPageService.");
        this.userDao = userDao;
    }

    public Boolean login(String phoneOrEmail , String password)
    {
        logger.log(Level.INFO, "User is trying to log in.");
        try {
            User user = userDao.findByPhone(phoneOrEmail);
            if (user == null)
            {
                user = userDao.findByEmail(phoneOrEmail);
            }
            if (user == null) {
                logger.log(Level.INFO, "No user with following phone or email: " + phoneOrEmail + '.');
                return false;
            }

            boolean res = comparePassword(password, user.getPassword());
            if (!res)
            {
                logger.log(Level.INFO, "Unable to log in, wrong password.");
                return false;
            }
            logger.log(Level.INFO, "Successfully logged in.");
            return true;

        } catch (DaoException e) {
            logger.log(Level.ERROR, "Error occurred: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    private Boolean comparePassword(String password, String toCompare)
    {
        try {
            logger.log(Level.INFO, "Comparing passwords in method comparePassword.");
            String hashPassword = User.makeHash(password);
//            System.out.println(hashPassword);
//            System.out.println(toCompare);
            return hashPassword.equals(toCompare);
        } catch (NoSuchAlgorithmException e) {
            logger.log(Level.ERROR, "No hash algorithm: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }
}
