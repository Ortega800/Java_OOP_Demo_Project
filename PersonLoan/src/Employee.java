public class Employee extends Person
{
	int employeeID;
	
	public Employee(String name, String address, 
					String licenseNumber, int employeeID)
	{
		this.name = name;
		this.address = address;
		this.licenseNumber = licenseNumber;
		this.employeeID = employeeID;
	}
	
	public int getEmployeeID()
	{
		return employeeID;
	}
	
	public void setEmployeeID(int employeeID)
	{
		this.employeeID = employeeID;
	}
	
}
