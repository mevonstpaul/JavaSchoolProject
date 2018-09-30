package edu.waketech.csc251.hr.test;

import org.junit.Test;
import edu.waketech.csc251.hr.mgmt.Executive;
import edu.waketech.csc251.hr.mgmt.Manager;
import edu.waketech.csc251.hr.person.Employee;
import edu.waketech.csc251.hr.person.EmployeeOnlyScreen;
import edu.waketech.csc251.hr.mgmt.ManagerOnlyScreen;
import edu.waketech.csc251.hr.mgmt.ExecutiveScreen;
import static org.junit.Assert.*;

//JUnit tests to test screener methods
public class HRTester {

	Employee employee = new Employee("dilbert", 20000);
	Manager manager = new Manager("boss", 30000);
	Executive executive = new Executive("CEO", 80000);
	EmployeeOnlyScreen<Employee> employeeScreen = new EmployeeOnlyScreen<Employee>();
	ManagerOnlyScreen<Employee> managerScreen = new ManagerOnlyScreen<Employee>();
	ExecutiveScreen<Employee> executiveScreen = new ExecutiveScreen<Employee>();
	
	@Test
	public void testEmployeeOnlyTest() {
		assertTrue (employeeScreen.test(employee));
	}
	
	@Test
	public void testEmployeeOnlyTest2() {
		assertFalse (employeeScreen.test(manager));
	}
	
	@Test
	public void testEmployeeOnlyTest3() {
		assertFalse (employeeScreen.test(executive));
	}
	
	@Test
	public void testManagerOnlyTest() {
		assertFalse (managerScreen.test(employee));
	}
	
	@Test
	public void testManagerOnlyTest2() {
		assertTrue (managerScreen.test(manager));
	}
	
	@Test
	public void testManagerOnlyTest3() {
		assertFalse (managerScreen.test(executive));
	}
	
	@Test
	public void testExecutiveTest() {
		assertFalse (executiveScreen.test(employee));
	}
	
	@Test
	public void testExecutiveTest2() {
		assertFalse (executiveScreen.test(manager));
	}
	
	@Test
	public void testExecutiveTest3() {
		assertTrue (executiveScreen.test(executive));
	}

}
