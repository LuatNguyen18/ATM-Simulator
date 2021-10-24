import java.io.Serializable;
import java.util.ArrayList;

public class SavingsAccount extends Account{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double interest;
	
	
	public SavingsAccount()
	{
		interest = 0.05;
	}


	public double getInterest() {
		return interest;
	}


	@Override
	void print() {
		System.out.println("Savings Account" + "\t" + this.getAccNum() + "\t" + this.getInterest() + "\t" + this.getBalance() + "$");
		
	}
}
