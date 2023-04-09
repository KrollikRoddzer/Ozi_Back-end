package by.fpmibsu.ozi;

import by.fpmibsu.ozi.dao.DaoException;
import by.fpmibsu.ozi.dao.MessageDao;
import by.fpmibsu.ozi.dao.PostDao;
import by.fpmibsu.ozi.dao.UserDao;
import by.fpmibsu.ozi.db.ConnectionCreator;
import by.fpmibsu.ozi.entity.User;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;


public class OziApplication {

	public static void main(String[] args) {
		ShowMessages();
	}

	public static void ShowMessages()
	{
		try {
			UserDao userDao = new UserDao();
			User user1 = userDao.findById(1);
			User user2 = userDao.findById(2);
			MessageDao messageDao = new MessageDao();
			var list = messageDao.findBySenderAndReceiverId(user1, user2);
			//list = messageDao.findAll();
			for (var item : list)
			{
				System.out.println(item);
			}
		}
		catch (DaoException e)
		{
			e.printStackTrace();
		}
	}
}
