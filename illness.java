package HIS;

public class illness 
{
	String name;
	String department;
	
	public illness(String name, String department) 
	{
		super();
		this.name=name;
		this.department=department;
	}
	@Override
	public String toString() {
		
		return ("Illness Name: " + name + ", Department: " + department);
	}

}