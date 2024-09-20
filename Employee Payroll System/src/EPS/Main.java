package EPS;

import java.util.ArrayList;
import java.util.Iterator;

abstract class Employee{
	private int id;
	private String name;
	
	public Employee(int id, String name) {
		this.id=id;
		this.name=name;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
		
	}
	public abstract double salaryCalculate();
	
	@Override
	public String toString() {
		return "Employee[ id= "+id+" name= "+name+" salary = " +salaryCalculate()+"}";
	}
		
}

class FullTimeEmployee extends Employee{
	
	private double monthlySalary;

	public FullTimeEmployee(int id, String name, double monthlySalary) {
		super(id, name);
		this.monthlySalary=monthlySalary;		
	}

	@Override
	public double salaryCalculate() {
		return monthlySalary;
	}
	
}


class PartTimeEmployee extends Employee{
	
	private int workday;
	private int perdayrates;

	public PartTimeEmployee(int id, String name, int workday, int perdayrates) {
		super(id, name);
		this.workday=workday;
		this.perdayrates=perdayrates;
		
	}

	@Override
	public double salaryCalculate() {
		return workday * perdayrates;
	}
	
}

class PayRoll{
	private ArrayList<Employee> employeeList;
	
	public PayRoll() {
		employeeList =new ArrayList<Employee>();
	}
	
	public void addEmployee(Employee employee) {
		employeeList.add(employee);
		
	}
	public void removeEmployee(int id) {
	 Employee employeeToRemove=null;
	 for (Employee employee : employeeList) {
		if (employee.getId()==id) {
			employeeToRemove=employee;
			break;
			
		}
	}
	 if (employeeToRemove!=null) {
		 employeeList.remove(employeeToRemove);
		
	}
		
	}
	public void display() {
		for (Employee employee : employeeList) {
			System.out.println(employee);
		}
		
	}
	
}

public class Main {


	public static void main(String[] args) {
		PayRoll payRoll=new PayRoll();
		FullTimeEmployee emp1 = new FullTimeEmployee(1, "Sk", 1000000);
		PartTimeEmployee emp2= new PartTimeEmployee(2, "Jabid", 20, 700);
		payRoll.addEmployee(emp1);
		payRoll.addEmployee(emp2);
		payRoll.display();
		System.out.println();
		System.out.println();
		payRoll.removeEmployee(1);
		payRoll.display();

	}

}
