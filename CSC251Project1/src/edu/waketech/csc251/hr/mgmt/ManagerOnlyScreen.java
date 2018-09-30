package edu.waketech.csc251.hr.mgmt;

import edu.waketech.csc251.tools.Screener;

//A class that tests if an object is of type Manager
public class ManagerOnlyScreen<T> implements Screener<T> {

	@Override
	public boolean test(T objectToTest) {
		if (objectToTest.getClass().getSimpleName().equals("Manager")) {
			return true;
		}
		else {
			return false;
		}
	}

}
