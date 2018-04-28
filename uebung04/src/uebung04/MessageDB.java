package uebung04;

import java.util.ArrayList;

public class MessageDB {

	private ArrayList<Message> allMessages = new ArrayList<Message>();

	public void addNewMessage(Message newMessage) {
		this.allMessages.add(newMessage);
	}

	public ArrayList<Message> getAllMessagesForUser(User user) {
		ArrayList<Message> messagesForUser = new ArrayList<>();

		for (Message m : allMessages) {
			if (m.getToUser() == user) {
				messagesForUser.add(m);
			}
		}

		return messagesForUser;
	}

}
