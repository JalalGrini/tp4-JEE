package DAO;

import java.util.ArrayList;
import java.util.List;
import model.User;

public class UserDAO {
	private static List<User> users = new ArrayList<>();
	
	static {
		users.add(new User("jalal", "1234", "admin"));
		users.add(new User("test", "1234", "user"));
	}
	
	public User findByLoginAndPassword(String login, String password) {
		for (User u : users) {
			if (u.getLogin().equals(login) && u.getPassword().equals(password)) {
				return u;
			}
		}
		return null;
	}
}
