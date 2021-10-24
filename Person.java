import java.io.Serializable;

public class Person implements Serializable{

	private static final long serialVersionUID = 1;
	private Account [] account;
	
	public Person()
	{
		account = new Account [2];
	}

	public Account [] getAccount() {
		return account;
	}
}
