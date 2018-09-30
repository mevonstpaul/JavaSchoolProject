This project contains the following files:

Interfaces:
Measurable
Screener

Classes:
Payroll(main method)
Employee
Manager
Executive
DataSetGeneric
EmployeeOnlyScreen
ManagerOnlyScreen
ExecutiveScreen
Utils
HRTester
DataSetGenericTester

The purpose of this program is to demonstrate the use of various Java topics, including inheritance, interfaces, packages, and JUnit.

The class DataSetGeneric extends ArrayList and stores objects that implement the Measurable interface (in this case that's Employee, Manager, and Executive).

The Screener classes, along with the method getList(Screener<E> elementScreener) in the DataSetGeneric class, allow for creation of a filtered version of the DataSetGeneric object.

Upon running the program, the user can add various types of employees, display a complete or filtered list of employees, display the employee with the highest salary, and display a payroll list.