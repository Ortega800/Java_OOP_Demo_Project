import java.io.FileNotFoundException;
import java.util.Date;

public class Loan extends Account
{
	double annualInterestRate;
	int numberOfYears;
	java.util.Date loanDate;
	String name;
	
	public Loan(String name)
	{
		super();
		this.name = name;
		loanDate = new Date();
	}
	
	public Loan(long accountNumber, double accountBalance, 
				double annualInterestRate, int numberOfYears, String name) throws FileNotFoundException
	{
		super(accountNumber, accountBalance);
		this.annualInterestRate = annualInterestRate;
		this.numberOfYears = numberOfYears;
		this.name = name;
		loanDate = new Date();
	}
	
	public double getAnnualInterestRate()
	{
		return annualInterestRate;
	}
	
	public int getNumberOfYears()
	{
		return numberOfYears;
	}
	
	public Date getLoanDate()
	{
		 return loanDate;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setAnnualInterestRate(double annualInterestRate)
	{
		this.annualInterestRate = annualInterestRate;
	}
	
	public void setNumberOfYears(int numberOfYears)
	{
		this.numberOfYears = numberOfYears;
	}
	
	public void setAccountBalance(double accountBalance)
	{
		this.accountBalance = accountBalance;
	}
	
	public double getMonthlyPayment()
	{
		double monthlyInterestRate = annualInterestRate / 1200;
		
		// Calculates monthly payment.
		
		double monthlyPayment = (accountBalance * monthlyInterestRate)
				/ (1 - (1 / (Math.pow(1 + monthlyInterestRate, 
				numberOfYears * 12))));;
		
		return monthlyPayment;
	}
	
	public double getTotalPayment()
	{
		return getMonthlyPayment() * numberOfYears * 12;
	}
}
