package edu.waketech.csc251.hr;

import java.util.ArrayList;
import java.util.Scanner;

import edu.waketech.csc251.collection.DataSetGeneric;
import edu.waketech.csc251.hr.mgmt.Executive;
import edu.waketech.csc251.hr.mgmt.ExecutiveScreen;
import edu.waketech.csc251.hr.mgmt.Manager;
import edu.waketech.csc251.hr.mgmt.ManagerOnlyScreen;
import edu.waketech.csc251.hr.person.Employee;
import edu.waketech.csc251.hr.person.EmployeeOnlyScreen;
import edu.waketech.csc251.tools.Utils;

//This program allows the user to add different types of employees to a DataSetGeneric store, and then display various information or filtered versions of the store
public class Payroll {

   // Possible User Actions.
   public static final String MENU_EXIT = "Exit";
   public static final String MENU_ADD_EMPLOYEE = "Add Employee";
   public static final String MENU_ADD_MANAGER = "Add Manager";
   public static final String MENU_ADD_EXECUTIVE = "Add Executive";
   public static final String MENU_LIST_ALL = "List All";
   public static final String MENU_LIST_EMPLOYEE = "List (Regular) Employees";
   public static final String MENU_LIST_MANAGER = "List Managers";
   public static final String MENU_LIST_EXECUTIVE = "List Executives";
   public static final String MENU_SHOW_HIGHEST_SALARY_PERSON = "Show Highest Salary Person";
   public static final String MENU_GENERATE_PAYROLL = "Generate Payroll";

   // Menu for user actions
   public static final String[] MAIN_MENU = { MENU_EXIT, MENU_ADD_EMPLOYEE, MENU_ADD_MANAGER, MENU_ADD_EXECUTIVE,
         MENU_LIST_ALL, MENU_LIST_EMPLOYEE, MENU_LIST_MANAGER, MENU_LIST_EXECUTIVE, MENU_SHOW_HIGHEST_SALARY_PERSON,
         MENU_GENERATE_PAYROLL, };

   public static void main(String[] args) {
      Scanner kybd = new Scanner(System.in);
      DataSetGeneric<Employee> hrdb = new DataSetGeneric<>();

      String userChoice = Utils.userChoose(kybd, MAIN_MENU);
      while (!MENU_EXIT.equals(userChoice)) {
         if (MENU_ADD_EMPLOYEE.equals(userChoice)) {
            addEmployee(kybd, hrdb);
         } else if (MENU_ADD_MANAGER.equals(userChoice)) {
            addManager(kybd, hrdb);
         } else if (MENU_ADD_EXECUTIVE.equals(userChoice)) {
            addExecutive(kybd, hrdb);
         } else if (MENU_LIST_ALL.equals(userChoice)) {
            displayEverybody(kybd, hrdb);
         } else if (MENU_LIST_EMPLOYEE.equals(userChoice)) {
            displayOnlyEmployees(kybd, hrdb);
         } else if (MENU_LIST_MANAGER.equals(userChoice)) {
            displayOnlyManagers(kybd, hrdb);
         } else if (MENU_LIST_EXECUTIVE.equals(userChoice)) {
            displayOnlyExecutives(kybd, hrdb);
         } else if (MENU_SHOW_HIGHEST_SALARY_PERSON.equals(userChoice)) {
            displayHighestSalary(kybd, hrdb);
         } else if (MENU_GENERATE_PAYROLL.equals(userChoice)) {
            generatePayroll(kybd, hrdb);
         }

         userChoice = Utils.userChoose(kybd, MAIN_MENU);
      }
      System.out.println("Bye");
   }

   /**
    * Add a regular employee to the data store
    * 
    * @param input
    *           incoming data stream
    * @param dataStore
    *           will hold the new employee
    */
   public static void addEmployee(Scanner input, DataSetGeneric<Employee> dataStore) {
	   System.out.print("Name: ");
	   String name = input.next();
	   System.out.println();
	   System.out.print("Salary: ");
	   double salary = input.nextDouble();
	   
	   Employee employee = new Employee(name, salary);
	   dataStore.add(employee);
   }

   /**
    * Add an executive to the data store
    * 
    * @param input
    *           incoming data stream
    * @param dataStore
    *           will hold the new executive
    */
   public static void addExecutive(Scanner input, DataSetGeneric<Employee> dataStore) {
	   System.out.print("Name: ");
	   String name = input.next();
	   System.out.println();
	   System.out.print("Salary: ");
	   double salary = input.nextDouble();
	   System.out.println();
	   System.out.print("Department Managed: ");
	   String department = input.next();
	   System.out.println();
	   System.out.print("Enter Bonus: ");
	   double bonus = input.nextDouble();
	   
	   Executive executive = new Executive(name, salary);
	   executive.setBonusRate(bonus);
	   executive.setDepartment(department);
	   dataStore.add(executive);
   }

   /**
    * Add a manager to the data store
    * 
    * @param input
    *           incoming data stream
    * @param dataStore
    *           will hold the new manager
    */
   public static void addManager(Scanner input, DataSetGeneric<Employee> dataStore) {
	   System.out.print("Name: ");
	   String name = input.next();
	   System.out.println();
	   System.out.print("Salary: ");
	   double salary = input.nextDouble();
	   System.out.println();
	   System.out.print("Department Managed: ");
	   String department = input.next();
	   
	   Manager manager = new Manager(name, salary);
	   manager.setDepartment(department);
	   dataStore.add(manager);
   }

   /**
    * Display everybody in the data store
    * 
    * @param kybd
    *           incoming data stream so the user can verify that the data has been
    *           seen
    * @param dataStore
    *           containing the employees to be displayed
    */
   public static void displayEverybody(Scanner kybd, DataSetGeneric<Employee> dataStore) {
	   ArrayList<Employee> everybody = dataStore.getList();
	   for (int i = 0; i < everybody.size(); i++) {
		   System.out.println(everybody.get(i).toString());
	   }
	   System.out.println();
	   System.out.println("Press any key and enter to continue.");
	   kybd.next();
   }

   /**
    * Display the person with the highest salary
    * 
    * @param kybd
    *           incoming data stream so the user can verify that the data has been
    *           seen
    * @param dataStore
    *           containing the employees to be displayed
    */
   public static void displayHighestSalary(Scanner kybd, DataSetGeneric<Employee> dataStore) {
	   Employee highestSalary = dataStore.getMax();
	   System.out.println("Highest Salary: " + highestSalary.toString());
	   System.out.println();
	   System.out.println("Press any key and enter to continue.");
	   kybd.next();
   }

   /**
    * Display only the regular employees
    * @param kybd
    *           incoming data stream so the user can verify that the data has been
    *           seen
    * @param dataStore
    *           containing the employees to be displayed
    */
   public static void displayOnlyEmployees(Scanner kybd, DataSetGeneric<Employee> dataStore) {
	   EmployeeOnlyScreen<Employee> employeeScreen = new EmployeeOnlyScreen<Employee>();
	   ArrayList<Employee> onlyEmployees = dataStore.getList(employeeScreen);
	   for (int i = 0; i < onlyEmployees.size(); i++) {
		   System.out.println(onlyEmployees.get(i).toString());
	   }
	   System.out.println();
	   System.out.println("Press any key and enter to continue.");
	   kybd.next();
   }

   /**
    * Display only the executives
    * @param kybd
    *           incoming data stream so the user can verify that the data has been
    *           seen
    * @param dataStore
    *           containing the employees to be displayed
    */
   public static void displayOnlyExecutives(Scanner kybd, DataSetGeneric<Employee> dataStore) {
	   ExecutiveScreen<Employee> executiveScreen = new ExecutiveScreen<Employee>();
	   ArrayList<Employee> onlyExecutives = dataStore.getList(executiveScreen);
	   for (int i = 0; i < onlyExecutives.size(); i++) {
		   System.out.println(onlyExecutives.get(i).toString());
	   }
	   System.out.println();
	   System.out.println("Press any key and enter to continue.");
	   kybd.next();
   }

   /**
    * Display on the managers
    * @param kybd
    *           incoming data stream so the user can verify that the data has been
    *           seen
    * @param dataStore
    *           containing the employees to be displayed
    */
   public static void displayOnlyManagers(Scanner kybd, DataSetGeneric<Employee> dataStore) {
	   ManagerOnlyScreen<Employee> managerScreen = new ManagerOnlyScreen<Employee>();
	   ArrayList<Employee> onlyManagers = dataStore.getList(managerScreen);
	   for (int i = 0; i < onlyManagers.size(); i++) {
		   System.out.println(onlyManagers.get(i).toString());
	   }
	   System.out.println();
	   System.out.println("Press any key and enter to continue.");
	   kybd.next();
   }

   /**
    * Generate the payroll
    * @param kybd
    *           incoming data stream so the user can verify that the data has been
    *           seen
    * @param dataStore
    *           containing the employees 
    */
   public static void generatePayroll(Scanner kybd, DataSetGeneric<Employee> dataStore) {
	   for (int i = 0; i < dataStore.size(); i++) {
		   System.out.println("[" + i + "] Pay " + dataStore.get(i).getName() + " $" + dataStore.get(i).getSalary());
	   }
	   System.out.println("Press any key and enter to continue.");
	   kybd.next();
   }
}