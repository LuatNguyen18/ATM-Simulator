import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public abstract class Account implements Serializable{


	private static final long serialVersionUID = 1L;
	protected double balance;
	protected String accNum;
	protected ArrayList<Transaction> history;
	
	//Constructor
	public Account()
	{
		balance = 0.00;
		accNum = getSaltString();
		history = new ArrayList<Transaction>();
	}
	
	
	//Getters and Setters
	double getBalance() {
		return balance;
	}

	void setBalance(double balance) {
		this.balance = balance;
	}

	String getAccNum() {
		return accNum;
	}
	
	//abstract method
	abstract void print();
	
	//Functions for a Deposit
	void Deposit(double deposit)
	{
		Transaction trans = new Transaction(deposit, getDate(), "Deposit");
		history.add(trans);
		balance += deposit;
	}
	
	//Function for a WithDrawal
	void Withdraw(double amount)
	{
		if(balance > amount)
		{
			Transaction trans = new Transaction(amount, getDate(), "Withdraw");
			history.add(trans);
			balance -= amount;
		}
		
		else
			System.out.println("Insufficient funds.");
	}
	
	//Function to print the transaction history
	void getHistory()
	{
		for(Transaction transaction : history)
			System.out.println(transaction.getDate() + " " + transaction.getEvent() + " " + transaction.getAmount() + "$");
	}
	
	//Function to make a payment
	void pay(int amount, String event)
	{
		String date = getDate();

		Transaction trans = new Transaction(amount, date, event);
		history.add(trans);
		
		balance -= amount;
	}
	
	//Returns the current date
	String getDate()
	{
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		return (dtf.format(now)); 
	}



	//Generates a random 5-digit account number
	String getSaltString()
	{
        String SALTCHARS = "1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        
        while (salt.length() < 6) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }
}
