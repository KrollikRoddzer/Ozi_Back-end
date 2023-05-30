package by.fpmibsu.ozi;

import by.fpmibsu.ozi.dao.*;
import by.fpmibsu.ozi.entity.User;
import by.fpmibsu.ozi.services.ProfilePageService;
import by.fpmibsu.ozi.services.RegistrationPageService;
import by.fpmibsu.ozi.services.Status;

import java.sql.Date;
import java.util.Scanner;


public class OziApplication {

	public static void main(String[] args) throws DaoException, InterruptedException {
		String str;
		Scanner scanner = new Scanner(System.in);
		str = scanner.nextLine();
		ProfilePageService service = new ProfilePageService(new UserDao(), new FriendDao(), new PostDao(), new FriendRequestDao());
		service.createPost(20, str, new Date(new java.util.Date().getTime()));
		//ShowMessages();
	}

	public static void ShowMessages()
	{
		UserDao userDao = new UserDao();
		try {
			System.out.println(userDao.findById(19));
		} catch (DaoException e) {
			throw new RuntimeException(e);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
}
