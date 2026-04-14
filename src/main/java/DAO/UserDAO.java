package DAO;

import java.util.*;
import model.User;
public class UserDAO {
	private static ArrayList<User> Users = new ArrayList<>();
	static {
		User a = new User("jalal","1234","admin");
		Users.add(a);
		User b = new User("test","1234","user");
		Users.add(b);
	}
	public User UserValid(String username,String password) {
		for(User a : Users) {
			if(a.getLogin().equals(username)&&a.getPassword().equals(password)) {
				return a;
			}
		}
		return null;
	}
	public void registerUser(User u) {
	    Users.add(u);
	}
	
}
