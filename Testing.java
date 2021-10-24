import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Testing {

	static Person person = new Person();
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String args[]) throws ClassNotFoundException, IOException
	{	
		System.out.print("Would you like to create a checking and saving account? \n1: Yes \t 2: No");
		int answer = scan.nextInt();
		
		if(answer == 1)
		{
			CheckingAccount checkA = new CheckingAccount();
			SavingsAccount saveA = new SavingsAccount();
			
			person.getAccount()[0] = checkA;
			person.getAccount()[1] = saveA;
			
			while(true)
			{	
				
				System.out.println("Please choose and action: -1: Exit\t1: Deposit\t2: Withdraw\t3: Transfer\t4: Pay\t5: Get Transaction History");
				int choice = scan.nextInt();
				scan.nextLine();
				 
				switch(choice)
				{
					case -1:
						System.out.println("Program exit.");
						System.exit(0);
						
						
					case 1:
						System.out.println("In which account would you like to make the deposit: \n1: Checking \t 2:Saving");
						int depositAccount = scan.nextInt();
						
						if(depositAccount == 1)
						{
							System.out.println("Enter an amount: ");
							double amount = scan.nextDouble();
							person.getAccount()[0].Deposit(amount);	
						}
						
						else
						{
							System.out.println("Enter an amount: ");
							double amount = scan.nextDouble();
							person.getAccount()[1].Deposit(amount);	
						}
						
						break;
					
					case 2:
						System.out.println("In which account would you like to withdraw from: \n1: Checking \t 2:Saving");
						int WithdrawAccount = scan.nextInt();
						
						
						if(WithdrawAccount == 1)
						{
							System.out.println("Enter an amount: ");
							double amount = scan.nextDouble();
							person.getAccount()[0].Withdraw(amount);
						}
						
						else
						{
							System.out.println("Enter an amount: ");
							double amount = scan.nextDouble();
							person.getAccount()[1].Withdraw(amount);	
						}
						
						break;
					
					case 3:
						System.out.println("Choose an option: \n1: Checking to Saving\t2:Saving to Checking");
						int transfer = scan.nextInt();
						scan.nextLine();
						
						if(transfer == 1)
						{
							System.out.println("Enter an amount: ");
							double transferAmount = scan.nextDouble();
							
							person.getAccount()[0].Withdraw(transferAmount);
							person.getAccount()[1].Deposit(transferAmount);
							
							System.out.println(person.getAccount()[0].getBalance());
							System.out.println(person.getAccount()[1].getBalance());
						}
						
						else
						{
							System.out.println("Enter an amount: ");
							double transferAmount = scan.nextDouble();
							
							person.getAccount()[1].Withdraw(transferAmount);
							person.getAccount()[0].Deposit(transferAmount);
						}
						
						break;
					
					case 4:
						System.out.println("Choose an account: \n1: Checking \t 2: Saving");
						int accountPay = scan.nextInt();
						
						
						if(accountPay == 1)
						{
							System.out.println("Enter the amount: ");
							int amountPay = scan.nextInt();
							scan.nextLine();
							
							System.out.println("Enter the event: ");
							String event = scan.nextLine();
							
							person.getAccount()[0].pay(amountPay, event);
							
							System.out.println(person.getAccount()[0].getBalance());
						}
						
						else
						{
							System.out.println("Enter the amount: ");
							int amountPay = scan.nextInt();
							scan.nextLine();
							
							System.out.println("Enter the event: ");
							String event = scan.nextLine();
							
							person.getAccount()[1].pay(amountPay, event);
						}
						
						break;
						
					case 5:
						System.out.println("Transaction history of which account: \n1: Checking \t 2: Saving");
						int TransAcc = scan.nextInt();
						
						if(TransAcc == 1)
							person.getAccount()[0].getHistory();
						
						else
							person.getAccount()[1].getHistory();
						
						break;
						
				}
				
				saveData();
				
				
				
			}
		
		}
	}
	
	public static void saveData()
	{
		ArrayList<Object> data = new ArrayList<Object>();
		data.add(person);
		
		
		try 
		{
			FileOutputStream fileOut = new FileOutputStream("data.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			
			out.writeObject(data);
		
			out.close();
			fileOut.close();
		} 
		
		catch(IOException i)
		{
			i.printStackTrace();
		}
		
	}
	
	public static void readFile() throws IOException, ClassNotFoundException
	{
		ArrayList<Object> deserialized = new ArrayList<Object>();
		
		try 
		{
			FileInputStream fileIn = new FileInputStream("data.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			
			deserialized = (ArrayList<Object>)in.readObject();
		
			in.close();
			fileIn.close();
		}
		
		catch(IOException i)
		{
			i.printStackTrace();
			return;
		}
		
		catch(ClassNotFoundException c)
		{
			c.printStackTrace();
			return;
		}
		
		Person retrievedAccounts = (Person)deserialized.get(0);
		System.out.println(retrievedAccounts.getAccount()[0].getBalance() + " " + retrievedAccounts.getAccount()[1].getBalance());
	}
}
