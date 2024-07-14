package HIS;

import java.util.ArrayList;

public class floor 
{
	
	String floorname;
	String specialization;
	
	int capacity = 2;
	
	ArrayList<Patient> pl = new ArrayList<Patient>();
	
	long avgtemp,avgpress;
	
	public String getFloorname() {
		return floorname;
	}
	public void setFloorname(String floorname) 
	{
		this.floorname = floorname;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	
	
	
}
