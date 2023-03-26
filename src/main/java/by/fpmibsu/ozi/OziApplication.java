package by.fpmibsu.ozi;

import by.fpmibsu.ozi.dao.DaoException;
import by.fpmibsu.ozi.dao.UserDao;
import by.fpmibsu.ozi.db.ConnectionCreator;
import by.fpmibsu.ozi.entity.User;

import java.sql.SQLException;
import java.util.List;

public class OziApplication {

	public static void main(String[] args) {
		UserDao userDao = new UserDao();
		try {
			List<User> list = userDao.findAll();
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
