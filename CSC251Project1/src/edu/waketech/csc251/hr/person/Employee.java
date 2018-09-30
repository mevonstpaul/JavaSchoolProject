package edu.waketech.csc251.hr.person;

import edu.waketech.csc251.collection.Measurable;

public class Employee implements Measurable {

	private String name;
	private double salary;
	
	public Employee(String nm, double sal) {
		name = nm;
		salary = sal;
	}
	
	public String getName() {
		return name;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public String toString() {
		String s = "Position: Employee; Name: " + getName() + "; Salary: " + getSalary();
		return s;
	}
	
	@Override
	public int getMeasure() {
		return (int)salary;
	}

}
