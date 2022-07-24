/* 
 * EECS 1510
 * Project2
 * Instructor: Dr.Hobbs
 * Written by: Estevan Ortega
 * Date: 04-02-22
 * Description: This program allows the user to choose what object to create,
 * what constructor will be used to create that object, and the methods to be executed.
 * The program takes input from a file named input.txt and outputs to both
 * the console and a file named output.txt
 */

import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Project2
{
	public static void main(String[] args) throws IOException
	{
		// Variables and objects set up for use in main loop.
		// Scanner object named inputScanner is used to read input file.
		
		File input = new File("input.txt");
		Scanner inputScanner = new Scanner(input);
		
		// Stores the name of the user requested object.
		
		String objectName;
		
		// Stores user inputed constructor number.
		
		String constructorNumber;
		
		// PrintWriter used to write output to output.txt
		
		PrintWriter output = new PrintWriter("output.txt");
		
		// Stores user inputed method number
		
		String methodNumber;
		
		// Used for breaking method loops
		
		Boolean notZero;
		
		/*
		 * Main loop will continue until an error has occurred or 
		 * if a zero was entered when prompted for a name of an object to create,
		 * both of which will halt the program.
		 */
		
		while(true) 
		{
			objectName = inputScanner.nextLine();
			
			// The first series of if statements decide the name (type) of the object to create.
			
			if (objectName.equals("Customer"))
			{
				constructorNumber = inputScanner.nextLine();
				
				// Within each 'if' statement for deciding object type, there is another
				// series of nested if statements that decide which constructor to use to build the object.
				
				if (constructorNumber.equals("1"))
				{
					try
					{
						// Within each 'if' statement for constructor number, 
						// the object will be created using the specified constructor
						// and arguments will be given from input.txt
						
						String name = inputScanner.nextLine();
						String address = inputScanner.nextLine();
						String licenseNumber = inputScanner.nextLine();
						
						// Check if license number contains two upper-case letters followed by six digits.
						// If not, throw an error and halt program.
						
						if (licenseNumber.length() == 8 && Character.isUpperCase(licenseNumber.charAt(0)) 
								&& Character.isUpperCase(licenseNumber.charAt(1)) && Character.isDigit(licenseNumber.charAt(2)) 
								&& Character.isDigit(licenseNumber.charAt(3)) && Character.isDigit(licenseNumber.charAt(4)) 
								&& Character.isDigit(licenseNumber.charAt(5)) && Character.isDigit(licenseNumber.charAt(6)) 
								&& Character.isDigit(licenseNumber.charAt(7)))
						{
							
						}
						else
						{
							System.out.println("error");
							output.println("error");
							inputScanner.close();
							output.close();
							System.exit(0);
						}
						
						Customer customerObject = new Customer (name, address, licenseNumber);
						
						notZero = true;
						
						// Finally, after an object is created, a while loop is entered and is
						// only broken when a zero is entered when a method number in inputed.
						
						while(notZero)
						{
							// Stores next string as a method number.
							
							methodNumber = inputScanner.next();
							
							// Switch statements decide which method to use or whether to break out
							// of the loop.
							
							switch(methodNumber)
							{
								case "0":
									notZero = false;
									inputScanner.nextLine();
									break;
								case "1":
									
									// Outputs result of method to console.
									
									System.out.println(customerObject.getName());
									
									// Outputs result of method to output.txt
									
									output.println(customerObject.getName());
									break;
								case "2":
									System.out.println(customerObject.getAddress());
									output.println(customerObject.getAddress());
									break;
								case "3":
									System.out.println(customerObject.getLicenseNumber());
									output.println(customerObject.getLicenseNumber());
									break;
								case "4":
									inputScanner.nextLine();
									
									// Uses input from input.txt as arguments for selected method. 
									
									customerObject.setName(inputScanner.nextLine());
									break;
								case "5":
									inputScanner.nextLine();
									customerObject.setAddress(inputScanner.nextLine());
									break;
								case "6":
									// Check if license number contains two upper-case letters followed by six digits.
									// If not, throw an error and halt program.
									
									String LocalLicenseNumb = inputScanner.nextLine();
									
									if (LocalLicenseNumb.length() == 8 && Character.isUpperCase(LocalLicenseNumb.charAt(0)) 
											&& Character.isUpperCase(LocalLicenseNumb.charAt(1)) && Character.isDigit(LocalLicenseNumb.charAt(2)) 
											&& Character.isDigit(LocalLicenseNumb.charAt(3)) && Character.isDigit(LocalLicenseNumb.charAt(4)) 
											&& Character.isDigit(LocalLicenseNumb.charAt(5)) && Character.isDigit(LocalLicenseNumb.charAt(6)) 
											&& Character.isDigit(LocalLicenseNumb.charAt(7)))
										{
											customerObject.setLicenseNumber(LocalLicenseNumb);
										}
										else
										{
											System.out.println("error");
											output.println("error");
											inputScanner.close();
											output.close();
											System.exit(0);
										}
									break;
								default:
									
									// Unknown method number was inputed.
									
									System.out.println("error");
									output.println("error");
									inputScanner.close();
									output.close();
									System.exit(0);
							}
						}
					}
					catch(NoSuchElementException exception)
					{
						// No element was inputed when one was expected.
						
						System.out.println("error");
						output.println("error");
						inputScanner.close();
						output.close();
						System.exit(0);
					}
				}
				
				else
				{
					// Does not match any known constructor numbers
					
					System.out.println("error");
					output.println("error");
					inputScanner.close();
					output.close();
					System.exit(0);	
				}
			}
			
			// Each Object will have it's own set of nested 'if' and switch statements,
			// with the same structure as the one above.
			
			else if (objectName.equals("Employee"))
			{
				constructorNumber = inputScanner.nextLine();
				
				if (constructorNumber.equals("1"))
				{
					try
					{
						String name = inputScanner.nextLine();
						String address = inputScanner.nextLine();
						String licenseNumber = inputScanner.nextLine();
						int employeeID = inputScanner.nextInt();
						
						// Check if employeeID is an 8 digit number 
						// and that license number contains two upper-case letters followed by six digits.
						// If not, throw an error and halt program.
						
						if (99999999 >= employeeID && employeeID >= 0 && licenseNumber.length() == 8 && Character.isUpperCase(licenseNumber.charAt(0)) 
								&& Character.isUpperCase(licenseNumber.charAt(1)) && Character.isDigit(licenseNumber.charAt(2)) 
								&& Character.isDigit(licenseNumber.charAt(3)) && Character.isDigit(licenseNumber.charAt(4)) 
								&& Character.isDigit(licenseNumber.charAt(5)) && Character.isDigit(licenseNumber.charAt(6)) 
								&& Character.isDigit(licenseNumber.charAt(7)))
						{
							
						}
						else
						{
							System.out.println("error");
							output.println("error");
							inputScanner.close();
							output.close();
							System.exit(0);
						}
						
						Employee employeeObject = new Employee (name, address, licenseNumber, employeeID);
						
						inputScanner.nextLine();
						
						notZero = true;
						
						while(notZero)
						{
							methodNumber = inputScanner.next();
							
							switch(methodNumber)
							{
								case "0":
									notZero = false;
									inputScanner.nextLine();
									break;
								case "1":
									System.out.println(employeeObject.getName());
									output.println(employeeObject.getName());
									break;
								case "2":
									System.out.println(employeeObject.getAddress());
									output.println(employeeObject.getAddress());
									break;
								case "3":
									System.out.println(employeeObject.getLicenseNumber());
									output.println(employeeObject.getLicenseNumber());
									break;
								case "4":
									
									// Outputs employeeID as eight digits with leading zeros.
									
									System.out.printf("%08d%n", employeeObject.getEmployeeID());
									output.printf("%08d%n", employeeObject.getEmployeeID());
									break;
								case "5":
									inputScanner.nextLine();
									employeeObject.setName(inputScanner.nextLine());
									break;
								case "6":
									inputScanner.nextLine();
									employeeObject.setAddress(inputScanner.nextLine());
									break;
								case "7":
									// Check if license number contains two upper-case letters followed by six digits.
									// If not, throw an error and halt program.
									
									licenseNumber = inputScanner.nextLine();
									
									if (licenseNumber.length() == 8 && Character.isUpperCase(licenseNumber.charAt(0)) 
											&& Character.isUpperCase(licenseNumber.charAt(1)) && Character.isDigit(licenseNumber.charAt(2)) 
											&& Character.isDigit(licenseNumber.charAt(3)) && Character.isDigit(licenseNumber.charAt(4)) 
											&& Character.isDigit(licenseNumber.charAt(5)) && Character.isDigit(licenseNumber.charAt(6)) 
											&& Character.isDigit(licenseNumber.charAt(7)))
										{
											employeeObject.setLicenseNumber(licenseNumber);
										}
										else
										{
											System.out.println("error");
											output.println("error");
											inputScanner.close();
											output.close();
											System.exit(0);
										}
									break;
								case "8":
									employeeObject.setEmployeeID(inputScanner.nextInt());
									inputScanner.nextLine();
									break;
								default:
									System.out.println("error");
									output.println("error");
									inputScanner.close();
									output.close();
									System.exit(0);
							}
						}
					}
					catch(NoSuchElementException exception)
					{
						System.out.println("error");
						output.println("error");
						inputScanner.close();
						output.close();
						System.exit(0);
					}
				}
				
				else
				{
					System.out.println("error");
					output.println("error");
					inputScanner.close();
					output.close();
					System.exit(0);	
				}
			}
			
			else if (objectName.equals("Loan"))
			{
				constructorNumber = inputScanner.nextLine();
				
				if (constructorNumber.equals("1"))
				{
					try
					{
						Loan loanObject = new Loan (inputScanner.nextLine());
						
						notZero = true;
						
						while(notZero)
						{
							methodNumber = inputScanner.next();
							
							switch(methodNumber)
							{
								case "0":
									notZero = false;
									inputScanner.nextLine();
									break;
								case "1":
									
									// Outputs accountBalance as rounded to two decimal places.
									
									System.out.printf("%.2f%n", loanObject.getAccountBalance());
									output.printf("%.2f%n", loanObject.getAccountBalance());
									break;
								case "2":
									
									// Outputs accountNumber to 10 digits with leading zeros.
									
									System.out.printf("%010d%n", loanObject.getAccountNumber());
									output.printf("%010d%n", loanObject.getAccountNumber());
									break;
								case "3":
									System.out.println(loanObject.getAnnualInterestRate());
									output.println(loanObject.getAnnualInterestRate());
									break;
								case "4":
									System.out.println(loanObject.getNumberOfYears());
									output.println(loanObject.getNumberOfYears());
									break;
								case "5":
									System.out.println(loanObject.getLoanDate());
									output.println(loanObject.getLoanDate());
									break;
								case "6":
									System.out.println(loanObject.getName());
									output.println(loanObject.getName());
									break;
								case "7":
									loanObject.setAccountBalance(inputScanner.nextDouble());
									inputScanner.nextLine();
									break;
								case "8":
									loanObject.setAnnualInterestRate(inputScanner.nextDouble());
									inputScanner.nextLine();
									break;
								case "9":
									loanObject.setNumberOfYears(inputScanner.nextInt());
									inputScanner.nextLine();
									break;
								case "10":
									System.out.printf("%.2f%n", loanObject.getMonthlyPayment());
									output.printf("%.2f%n", loanObject.getMonthlyPayment());
									break;
								case "11":
									System.out.printf("%.2f%n", loanObject.getTotalPayment());
									output.printf("%.2f%n", loanObject.getTotalPayment());
									break;
								default:
									System.out.println("error");
									output.println("error");
									inputScanner.close();
									output.close();
									System.exit(0);
							}
						}
					}
					catch(NoSuchElementException exception)
					{
						System.out.println("error");
						output.println("error");
						inputScanner.close();
						output.close();
						System.exit(0);
					}
				}
				
				else if (constructorNumber.equals("2"))
				{
					try 
					{
						Loan loanObject = new Loan (inputScanner.nextLong(), inputScanner.nextDouble(), 
													inputScanner.nextDouble(), inputScanner.nextInt(), 
													inputScanner.nextLine() + inputScanner.nextLine());
						
						notZero = true;
						
						while(notZero)
						{
							methodNumber = inputScanner.next();
							
							switch(methodNumber)
							{
								case "0":
									notZero = false;
									inputScanner.nextLine();
									break;
								case "1":
									System.out.printf("%.2f%n", loanObject.getAccountBalance());
									output.printf("%.2f%n", loanObject.getAccountBalance());
									break;
								case "2":
									System.out.printf("%010d%n", loanObject.getAccountNumber());
									output.printf("%010d%n", loanObject.getAccountNumber());
									break;
								case "3":
									System.out.println(loanObject.getAnnualInterestRate());
									output.println(loanObject.getAnnualInterestRate());
									break;
								case "4":
									System.out.println(loanObject.getNumberOfYears());
									output.println(loanObject.getNumberOfYears());
									break;
								case "5":
									System.out.println(loanObject.getLoanDate());
									output.println(loanObject.getLoanDate());
									break;
								case "6":
									System.out.println(loanObject.getName());
									output.println(loanObject.getName());
									break;
								case "7":
									loanObject.setAccountBalance(inputScanner.nextDouble());
									inputScanner.nextLine();
									break;
								case "8":
									loanObject.setAnnualInterestRate(inputScanner.nextDouble());
									inputScanner.nextLine();
									break;
								case "9":
									loanObject.setNumberOfYears(inputScanner.nextInt());
									inputScanner.nextLine();
									break;
								case "10":
									System.out.printf("%.2f%n", loanObject.getMonthlyPayment());
									output.printf("%.2f%n", loanObject.getMonthlyPayment());
									break;
								case "11":
									System.out.printf("%.2f%n", loanObject.getTotalPayment());
									output.printf("%.2f%n", loanObject.getTotalPayment());
									break;
								default:
									System.out.println("error");
									output.println("error");
									inputScanner.close();
									output.close();
									System.exit(0);
							}
						}
					}
					catch(NoSuchElementException exception)
					{
						System.out.println("error");
						output.println("error");
						inputScanner.close();
						output.close();
						System.exit(0);
					}
				}
				
				else
				{
					System.out.println("error");
					output.println("error");
					inputScanner.close();
					output.close();
					System.exit(0);	
				}
			}
			
			else if (objectName.equals("Checking"))
			{
				constructorNumber = inputScanner.nextLine();
				
				if (constructorNumber.equals("1"))
				{
					try
					{
						Checking checkingObject = new Checking (inputScanner.nextDouble(), 
																inputScanner.nextLine() + inputScanner.nextLine());
	
						notZero = true;
						
						while(notZero)
						{
							methodNumber = inputScanner.next();
							
							switch(methodNumber)
							{
								case "0":
									notZero = false;
									inputScanner.nextLine();
									break;
								case "1":
									System.out.printf("%.2f%n", checkingObject.getAccountBalance());
									output.printf("%.2f%n", checkingObject.getAccountBalance());
									break;
								case "2":
									System.out.printf("%010d%n", checkingObject.getAccountNumber());
									output.printf("%010d%n", checkingObject.getAccountNumber());
									break;
								case "3":
									checkingObject.setAccountBalance(inputScanner.nextDouble());
									inputScanner.nextLine();
									break;
								case "4":
									System.out.println(checkingObject.getAnnualInterestRate());
									output.println(checkingObject.getAnnualInterestRate());
									break;
								case "5":
									System.out.println(checkingObject.getName());
									output.println(checkingObject.getName());
									break;
								case "6":
									checkingObject.setAnnualInterestRate(inputScanner.nextDouble());
									inputScanner.nextLine();
									break;
								case "7":
									checkingObject.makeDeposit(inputScanner.nextDouble());
									inputScanner.nextLine();
									break;
								case "8":
									double withdrawalAmount = inputScanner.nextDouble();
									
									// Throws overdraft error and halts program 
									// if amount for withdraw and fee is more than account balance.
									
									if(withdrawalAmount + 1 <= checkingObject.getAccountBalance())
									{
										checkingObject.makeWithdrawal(withdrawalAmount);
									}
									else
									{
										System.out.println("overdraft");
										output.println("overdraft");
										inputScanner.close();
										output.close();
										System.exit(0);
									}
									
									inputScanner.nextLine();
									break;
								default:
									System.out.println("error");
									output.println("error");
									inputScanner.close();
									output.close();
									System.exit(0);
							}
						}
					}
					catch(NoSuchElementException exception)
					{
						System.out.println("error");
						output.println("error");
						inputScanner.close();
						output.close();
						System.exit(0);
					}
				}
				
				else if (constructorNumber.equals("2"))
				{
					try
					{
						long accountNumber = inputScanner.nextLong();
						double accountBalance = inputScanner.nextDouble();
						double annualInterestRate = inputScanner.nextDouble();
						String name = inputScanner.nextLine() + inputScanner.nextLine();
						
						// Check if account number is a ten digit number.
						// If not, throw an error and halt program.
						
						if(9999999999L >= accountNumber && accountNumber >= 0L)
						{
							break;
						}
						else
						{
							System.out.println("error");
							output.println("error");
							inputScanner.close();
							output.close();
							System.exit(0);
						}
						
						Checking checkingObject = new Checking (accountNumber, accountBalance, 
																annualInterestRate, name);
						
						notZero = true;
						
						while(notZero)
						{
							methodNumber = inputScanner.next();
							
							switch(methodNumber)
							{
								case "0":
									notZero = false;
									inputScanner.nextLine();
									break;
								case "1":
									System.out.printf("%.2f%n", checkingObject.getAccountBalance());
									output.printf("%.2f%n", checkingObject.getAccountBalance());
									break;
								case "2":
									System.out.printf("%010d%n", checkingObject.getAccountNumber());
									output.printf("%010d%n", checkingObject.getAccountNumber());
									break;
								case "3":
									checkingObject.setAccountBalance(inputScanner.nextDouble());
									inputScanner.nextLine();
									break;
								case "4":
									System.out.println(checkingObject.getAnnualInterestRate());
									output.println(checkingObject.getAnnualInterestRate());
									break;
								case "5":
									System.out.println(checkingObject.getName());
									output.println(checkingObject.getName());
									break;
								case "6":
									checkingObject.setAnnualInterestRate(inputScanner.nextDouble());
									inputScanner.nextLine();
									break;
								case "7":
									checkingObject.makeDeposit(inputScanner.nextDouble());
									inputScanner.nextLine();
									break;
								case "8":
									double withdrawalAmount = inputScanner.nextDouble();
									
									if(withdrawalAmount + 1 <= checkingObject.getAccountBalance())
									{
										checkingObject.makeWithdrawal(withdrawalAmount);
									}
									else
									{
										System.out.println("overdraft");
										output.println("overdraft");
										inputScanner.close();
										output.close();
										System.exit(0);
									}
									
									inputScanner.nextLine();
									break;
								default:
									System.out.println("error");
									output.println("error");
									inputScanner.close();
									output.close();
									System.exit(0);
							}
						}
					}
					catch(NoSuchElementException exception)
					{
						System.out.println("error");
						output.println("error");
						inputScanner.close();
						output.close();
						System.exit(0);
					}
				}
				
				else
				{
					System.out.println("error");
					output.println("error");
					inputScanner.close();
					output.close();
					System.exit(0);	
				}
			}
			
			else if (objectName.equals("Savings"))
			{
				constructorNumber = inputScanner.nextLine();
				
				if (constructorNumber.equals("1"))
				{
					try
					{
						Savings savingsObject = new Savings (inputScanner.nextDouble(), 
															 inputScanner.nextLine() + inputScanner.nextLine());
						
						notZero = true;
						
						while(notZero)
						{
							methodNumber = inputScanner.next();
							
							switch(methodNumber)
							{
								case "0":
									notZero = false;
									inputScanner.nextLine();
									break;
								case "1":
									System.out.printf("%.2f%n", savingsObject.getAccountBalance());
									output.printf("%.2f%n", savingsObject.getAccountBalance());
									break;
								case "2":
									System.out.printf("%010d%n", savingsObject.getAccountNumber());
									output.printf("%010d%n", savingsObject.getAccountNumber());
									break;
								case "3":
									savingsObject.setAccountBalance(inputScanner.nextDouble());
									inputScanner.nextLine();
									break;
								case "4":
									System.out.println(savingsObject.getAnnualInterestRate());
									output.println(savingsObject.getAnnualInterestRate());
									break;
								case "5":
									System.out.println(savingsObject.getName());
									output.println(savingsObject.getName());
									break;
								case "6":
									savingsObject.setAnnualInterestRate(inputScanner.nextDouble());
									inputScanner.nextLine();
									break;
								case "7":
									savingsObject.makeDeposit(inputScanner.nextDouble());
									inputScanner.nextLine();
									break;
								case "8":
									double withdrawalAmount = inputScanner.nextDouble();
									
									if(withdrawalAmount + 1 <= savingsObject.getAccountBalance())
									{
										savingsObject.makeWithdrawal(withdrawalAmount);
									}
									else
									{
										
										System.out.println("overdraft");
										output.println("overdraft");
										inputScanner.close();
										output.close();
										System.exit(0);
									}
									
									inputScanner.nextLine();
									break;
								default:
									System.out.println("error");
									output.println("error");
									inputScanner.close();
									output.close();
									System.exit(0);
							}
						}
					}
					catch(NoSuchElementException exception)
					{
						System.out.println("error");
						output.println("error");
						inputScanner.close();
						output.close();
						System.exit(0);
					}
				}
				
				else if (constructorNumber.equals("2"))
				{	
					try
					{
						long accountNumber = inputScanner.nextLong();
						double accountBalance = inputScanner.nextDouble();
						double annualInterestRate = inputScanner.nextDouble();
						String name = inputScanner.nextLine() + inputScanner.nextLine();
						
						// Check if account number is a ten digit number.
						// If not, throw an error and halt program.
						
						if(9999999999L >= accountNumber && accountNumber >= 0L)
						{
							break;
						}
						else
						{
							System.out.println("error");
							output.println("error");
							inputScanner.close();
							output.close();
							System.exit(0);
						}
						
						Savings savingsObject = new Savings (accountNumber, accountBalance, 
															 annualInterestRate, name);
						
						notZero = true;
						
						while(notZero)
						{
							methodNumber = inputScanner.next();
							
							switch(methodNumber)
							{
								case "0":
									notZero = false;
									inputScanner.nextLine();
									break;
								case "1":
									System.out.printf("%.2f%n", savingsObject.getAccountBalance());
									output.printf("%.2f%n", savingsObject.getAccountBalance());
									break;
								case "2":
									System.out.printf("%010d%n", savingsObject.getAccountNumber());
									output.printf("%010d%n", savingsObject.getAccountNumber());
									break;
								case "3":
									savingsObject.setAccountBalance(inputScanner.nextDouble());
									inputScanner.nextLine();
									break;
								case "4":
									System.out.println(savingsObject.getAnnualInterestRate());
									output.println(savingsObject.getAnnualInterestRate());
									break;
								case "5":
									System.out.println(savingsObject.getName());
									output.println(savingsObject.getName());
									break;
								case "6":
									savingsObject.setAnnualInterestRate(inputScanner.nextDouble());
									inputScanner.nextLine();
									break;
								case "7":
									savingsObject.makeDeposit(inputScanner.nextDouble());
									inputScanner.nextLine();
									break;
								case "8":
									double withdrawalAmount = inputScanner.nextDouble();
									
									if(withdrawalAmount + 1 <= savingsObject.getAccountBalance())
									{
										savingsObject.makeWithdrawal(withdrawalAmount);
									}
									else
									{
										
										System.out.println("overdraft");
										output.println("overdraft");
										inputScanner.close();
										output.close();
										System.exit(0);
									}
									
									inputScanner.nextLine();
									break;
								default:
									System.out.println("error");
									output.println("error");
									inputScanner.close();
									output.close();
									System.exit(0);
							}
						}
					}
					catch(NoSuchElementException exception)
					{
						System.out.println("error");
						output.println("error");
						inputScanner.close();
						output.close();
						System.exit(0);
					}
				}
				
				else
				{
					System.out.println("error");
					output.println("error");
					inputScanner.close();
					output.close();
					System.exit(0);	
				}
			}
			
			else if (objectName.equals("0"))
			{
				// End of program without error
				
				inputScanner.close();
				output.close();
				System.exit(0);		
			}
			
			else
			{
				// Does not match any known object names
				
				System.out.println("error");
				output.println("error");
				inputScanner.close();
				output.close();
				System.exit(0);
			}
		}	
	}
}



