package uebung04_130618;

import java.util.ArrayList;

public class User {

	private String name;
	private static ArrayList<User> userDB = new ArrayList<>();

	public User(String _name) {
		this.name = _name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof User) {
			User user = (User) obj;
			System.out.println("EQUALS: Object is class User");
			System.out.println("EQUALS: User name: " + user.name);
			System.out.println("EQUALS: this.name: " + name);
			if (user != null && name.equals(user.name) ) {
				System.out.println("EQUALS: Same name. Return true!");
				return true;
			}
		}
		return false;
	}

	public static void addUserToDb(User user) {
		if (userDB.contains(user)) {
			System.out.println("User " + user.getName() + " already in DB!");
		} else {
			userDB.add(user);
			System.out.println("Added User " + user.getName() + " to DB");

		}
	}
	
	public static User getUserWithName(String username) {
		int index = userDB.indexOf(new User(username));
		if(index == -1) {
			System.out.println("Error: User not available");
			return null;
		} else {
			return userDB.get(index);
		}
	}

}
