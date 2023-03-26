package by.fpmibsu.ozi;

import by.fpmibsu.ozi.dao.DaoException;
import by.fpmibsu.ozi.dao.UserDao;
import by.fpmibsu.ozi.db.ConnectionCreator;
import by.fpmibsu.ozi.entity.User;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;


public class OziApplication {

	public static void main(String[] args) {
		UserDao userDao = new UserDao();
		try {
//			String phone, email, password, name, surname, sex, birthday;
//			Scanner scanner = new Scanner(System.in);
//			phone = scanner.nextLine();
//			email = scanner.nextLine();
//			password = scanner.nextLine();
//			name = scanner.nextLine();
//			surname = scanner.nextLine();
//			birthday = scanner.nextLine();
//			sex = scanner.nextLine();
//
//			User user = new User(-1, phone, email, password, name, surname, birthday, sex);
//			System.out.println(userDao.create(user));

			for (var item : userDao.findAll()) {
				System.out.println(item);
			}
		}
		catch (DaoException e)
		{
			e.printStackTrace();
		}
	}
}
