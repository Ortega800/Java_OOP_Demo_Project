import java.io.FileNotFoundException;

public abstract class Account
{
	long accountNumber;
	double accountBalance;
	
	public Account()
	{
		// Creates a random 10 digit number between 0 and 9999999999 for account number.
		
		accountNumber = (long) (9999999999.0 * Math.random());
		accountBalance = 0;
	}
	
	public Account(long accountNumber, double accountBalance) throws FileNotFoundException
	{
		this.accountNumber = accountNumber;
		this.accountBalance = accountBalance;
	}
	
	public double getAccountBalance()
	{
		return accountBalance;
	}
	
	public long getAccountNumber()
	{
		return accountNumber;
	}
	
	abstract public void setAccountBalance(double accountBalance);
	
}
