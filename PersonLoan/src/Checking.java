import java.io.*;

public class Checking extends Account
{
	double annualInterestRate;
	String name;
	
	public Checking(double annualInterestRate, String name)
	{
		super();
		this.annualInterestRate = annualInterestRate;
		this.name = name;
	}
	
	public Checking(long accountNumber, double accountBalance, 
					double annualInterestRate, String name) throws IOException
	{
		super(accountNumber, accountBalance);
		this.annualInterestRate = annualInterestRate;
		this.name = name;
	}
	
	public double getAnnualInterestRate()
	{
		return annualInterestRate;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setAnnualInterestRate(double annualInterestRate)
	{
		this.annualInterestRate = annualInterestRate;
	}
	
	
	public void setAccountBalance(double accountBalance)
	{
		this.accountBalance = accountBalance;
	}
	
	public void makeDeposit(double depositAmount)
	{
		accountBalance += depositAmount;
	}
	
	public void makeWithdrawal(double withdrawalAmount)
	{
		// A fee of $1 is applied for every withdraw.
		
		accountBalance -= (withdrawalAmount + 1);
	}
}
