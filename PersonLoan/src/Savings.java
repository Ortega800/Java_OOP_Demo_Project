import java.io.IOException;

public class Savings extends Account
{
	double annualInterestRate;
	String name;
	
	public Savings(double annualInterestRate, String name)
	{
		super();
		this.annualInterestRate = annualInterestRate;
		this.name = name;
	}
	
	public Savings(long accountNumber, double accountBalance, 
				   double annualInterestRate, String name)  throws IOException
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
		// Adds $5 if deposit amount is over $10000.00
		
		if (depositAmount >= 10000)
			{
				accountBalance += depositAmount + 5;
			}
		else
			{
				accountBalance += depositAmount;
			}
	}
	
	public void makeWithdrawal(double withdrawalAmount)
	{	
		accountBalance -= withdrawalAmount;
	}
}
