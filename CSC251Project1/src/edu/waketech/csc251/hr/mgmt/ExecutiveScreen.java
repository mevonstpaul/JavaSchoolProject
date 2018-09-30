package edu.waketech.csc251.hr.mgmt;

import edu.waketech.csc251.tools.Screener;

//A class that tests if an object is of type Executive
public class ExecutiveScreen<T> implements Screener<T> {

	@Override
	public boolean test(T objectToTest) {
		if (objectToTest.getClass().getSimpleName().equals("Executive")) {
			return true;
		}
		else {
			return false;
		}
	}

}
