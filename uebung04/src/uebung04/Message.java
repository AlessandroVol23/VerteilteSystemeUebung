package uebung04;

public class Message {

	private User fromUser;
	private User toUser;
	private String message;

	public Message(User _fromUser, User _toUser, String _message) {
		this.fromUser = _fromUser;
		this.toUser = _toUser;
		this.message = _message;
	}

	public User getFromUser() {
		return fromUser;
	}

	public void setFromUser(User fromUser) {
		this.fromUser = fromUser;
	}

	public User getToUser() {
		return toUser;
	}

	public void setToUser(User toUser) {
		this.toUser = toUser;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
