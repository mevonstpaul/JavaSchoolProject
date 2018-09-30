package edu.waketech.csc251.test;

import org.junit.Test;
import edu.waketech.csc251.hr.mgmt.Executive;
import edu.waketech.csc251.hr.mgmt.Manager;
import edu.waketech.csc251.hr.person.Employee;
import edu.waketech.csc251.hr.person.EmployeeOnlyScreen;
import edu.waketech.csc251.hr.mgmt.ManagerOnlyScreen;
import edu.waketech.csc251.hr.mgmt.ExecutiveScreen;
import edu.waketech.csc251.collection.DataSetGeneric;
import static org.junit.Assert.*;

//JUnit tests that test the getList() methods of DataSetGeneric
public class DataSetGenericTester {

	Employee employee = new Employee("dilbert", 20000);
	Manager manager = new Manager("boss", 30000);
	Executive executive = new Executive("CEO", 80000);
	EmployeeOnlyScreen<Employee> employeeScreen = new EmployeeOnlyScreen<Employee>();
	ManagerOnlyScreen<Employee> managerScreen = new ManagerOnlyScreen<Employee>();
	ExecutiveScreen<Employee> executiveScreen = new ExecutiveScreen<Employee>();
	DataSetGeneric<Employee> employeeList = new DataSetGeneric<Employee>();
	
	@Test
	public void testGetList() {
		manager.setDepartment("sales");
		executive.setDepartment("all");
		executive.setBonusRate(.3);
		employeeList.add(employee);
		employeeList.add(manager);
		employeeList.add(executive);
		
		assertTrue (employeeList.equals(employeeList.getList()));
	}
	
	@Test
	public void testGetListScreener() {
		manager.setDepartment("sales");
		executive.setDepartment("all");
		executive.setBonusRate(.3);
		employeeList.add(employee);
		employeeList.add(manager);
		employeeList.add(executive);
		
		assertTrue (employee.equals(employeeList.getList(employeeScreen).get(0)));
	}
	
	@Test
	public void testGetListScreener2() {
		manager.setDepartment("sales");
		executive.setDepartment("all");
		executive.setBonusRate(.3);
		employeeList.add(employee);
		employeeList.add(manager);
		employeeList.add(executive);
		
		assertTrue (manager.equals(employeeList.getList(managerScreen).get(0)));
	}
	
	@Test
	public void testGetListScreener3() {
		manager.setDepartment("sales");
		executive.setDepartment("all");
		executive.setBonusRate(.3);
		employeeList.add(employee);
		employeeList.add(manager);
		employeeList.add(executive);
		
		assertTrue (executive.equals(employeeList.getList(executiveScreen).get(0)));
	}
}
