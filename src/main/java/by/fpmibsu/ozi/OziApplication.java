package by.fpmibsu.ozi;

import by.fpmibsu.ozi.dao.*;
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
			DialogDao dialogDao = new DialogDao();
			var tmp = dialogDao.getUserDialogs(user1);
			System.out.println(tmp);
		}
		catch (DaoException e)
		{
			e.printStackTrace();
		}
	}
}
