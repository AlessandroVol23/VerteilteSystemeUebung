package uebung04;

import java.util.ArrayList;

public class UserDB {

	private ArrayList<User> userZuordnung = new ArrayList<User>();

	public void addUser(User newUser) {
		this.userZuordnung.add(newUser);
	}

	public User searchuser(String userName) {

		for (User u : this.userZuordnung) {
			if (u.getUsername() == userName) {
				return u;
			}
		}
		return null;

	}

}
