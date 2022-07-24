import java.io.FileNotFoundException;
import java.io.PrintWriter;

public abstract class Person
{
	String licenseNumber;
	String name;
	String address;
	
	public String getName()
	{
		return name;
	}
	
	public String getLicenseNumber()
	{
		return licenseNumber;
	}
	
	public String getAddress()
	{
		return address;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setLicenseNumber(String licenseNumber) throws FileNotFoundException
	{
			this.licenseNumber = licenseNumber;
	}
	
	public void setAddress(String address)
	{
		this.address = address;
	}
	
}
