package edu.waketech.csc251.hr.person;

import edu.waketech.csc251.tools.Screener;

//A class that tests if an object is of type Employee
public class EmployeeOnlyScreen<T> implements Screener<T> {

	@Override
	public boolean test(T objectToTest) {
		if (objectToTest.getClass().getSimpleName().equals("Employee")) {
			return true;
		}
		else {
			return false;
		}
	}

}
