import java.io.Serializable;

public class Transaction implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private double amount;
	private String date;
	private String event;
	
	public Transaction(double Amount, String Date, String Event)
	{
		amount = Amount;
		date = Date;
		event = Event;
	}
	

	public double getAmount() {
		return amount;
	}

	public String getDate() {
		return date;
	}

	public String getEvent() {
		return event;
	}
}
