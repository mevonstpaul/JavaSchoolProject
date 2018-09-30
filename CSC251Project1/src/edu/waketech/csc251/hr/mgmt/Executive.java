package edu.waketech.csc251.hr.mgmt;

import edu.waketech.csc251.collection.Measurable;

//A subclass of Manager that adds a bonus rate attribute
public class Executive extends Manager implements Measurable {

	private double bonusrate;
	private double execsalary;
	
	public Executive(String nm, double sal) {
		super(nm, sal);
	}

	@Override
	public double getSalary() {
		execsalary = super.getSalary()*(1 + bonusrate);
		return execsalary;
	}
	
	public void setBonusRate(double br) {
		bonusrate = br;
	}
	
	public String toString() {
		String s = "Position: Executive" + "; Department: " + getDepartment() + "; Name: " + getName() + "; Salary: " + getSalary() +  "; Bonus: " + bonusrate;
		return s;
	}
}
