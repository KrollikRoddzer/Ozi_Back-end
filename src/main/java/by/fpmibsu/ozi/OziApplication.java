package by.fpmibsu.ozi;

import by.fpmibsu.ozi.dao.*;
import by.fpmibsu.ozi.db.ConnectionCreator;
import by.fpmibsu.ozi.entity.User;
import by.fpmibsu.ozi.services.RegistrationService;

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
		RegistrationService service = new RegistrationService(new UserDao());
		User user = new User(0, "+375445918769", "stas315172004@mail.ru", "Stasyan04", "Stas", "Zaycev", new Date(2004, 02, 05), "m");
		System.out.println(service.register(user));
	}
}
