package uebung04_130618;

import java.util.ArrayList;
import java.util.Date;

public class Message {
	
	private String reciepient;
	private String sender;
	private String text;
	private Date date;
	public static ArrayList<Message> messageDB = new ArrayList<>();
	
	public Message(String reciepient, String sender, String text, Date date) {
		super();
		this.reciepient = reciepient;
		this.sender = sender;
		this.text = text;
		this.date = date;
		this.messageDB.add(this);
	}

	@Override
	public String toString() {
		return "Message [reciepient=" + reciepient + ", sender=" + sender + ", text=" + text + ", date=" + date + "]";
	}
	
	
	
	
	
	
	

}
