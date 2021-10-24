import java.io.Serializable;
import java.util.ArrayList;

public class CheckingAccount extends Account{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int nboftransactions;
	private double transactionfee;
	
	
	public double getBalanced()
	{
		return this.balance;
		
	}
	
	public CheckingAccount()
	{
		nboftransactions = 25;
		transactionfee = 1.00;
	}


	public int getNboftransactions() {
		return nboftransactions;
	}

	public double getTransactionfee() {
		return transactionfee;
	}

	@Override
	void print() {
		System.out.println("Checking Account" + "\t" + this.getAccNum() + "\t" + this.getBalance() + "$");
		
	}
	
}
