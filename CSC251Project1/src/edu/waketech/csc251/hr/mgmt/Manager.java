package edu.waketech.csc251.hr.mgmt;

import edu.waketech.csc251.hr.person.Employee;
import edu.waketech.csc251.collection.Measurable;

//A subclass of Employee that adds a department attribute
public class Manager extends Employee implements Measurable {

private String department;
	
	public Manager(String nm, double sal) {
		super(nm, sal);
	}
	
	public void setDepartment(String dept) {
		department = dept;
	}
	
	public String getDepartment() {
		return department;
	}
	
	public String toString() {
		String s = "Position: Manager; Department: " + getDepartment() + "; Name: " + getName() + "; Salary: " + getSalary();
		return s;
	}
	
	@Override
	public int getMeasure() {
		return super.getMeasure();
	}

}
