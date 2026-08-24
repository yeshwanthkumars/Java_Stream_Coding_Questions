import java.util.*;
import java.util.stream.*;


/*
1. Given a list of integers, return all even numbers in their original order.
	Sample Input [1, 8, 3, 10, 7, 12, 5]
	Sample Output [8, 10, 12]

2. Given a list of integers and a threshold T, return all numbers greater than T in ascending order.
	Sample Input Numbers = [12, 45, 7, 31, 18, 50], T = 20
	Sample Output [31, 45, 50]

3. Given a list of employees, return the names of employees whose salary is at least 100000, sorted by salary descending.
	Sample Input
	[
	{101,"Arun","IT","Chennai",90000},
	{102,"Priya","HR","Bangalore",70000},
	{103,"Karthik","IT","Chennai",120000},
	{104,"Meena","Finance","Chennai",95000},
	{105,"Ravi","IT","Hyderabad",110000}
	]
	Sample Output [Karthik, Ravi]

4. Given a list of employee salaries, return the top three distinct salaries in descending order. If fewer than three distinct salaries exist, return all available values.
	Sample Input	[90000, 120000, 120000, 110000, 95000, 110000, 80000]
	Sample Output	[120000, 110000, 95000]

5. Given a list of employees with id, name, department and salary, return the highest-paid employee from each department. Display department and employee name, ordered by department.
Sample Input
[
  {1,"Asha","IT",90000},
  {2,"Bala","IT",120000},
  {3,"Cathy","HR",80000},
  {4,"Deepak","HR",95000},
  {5,"Esha","Finance",100000}
]
Sample Output
[Finance=Esha, HR=Deepak, IT=Bala]


*/

public class Aug20{
	
	public static void main(String args[]){
		
		
		List<Integer> numbers = Arrays.asList(1, 8, 3, 10, 7, 12, 5);
		
		System.out.println("1. "+numbers.stream().filter(n->n%2==0).toList());
		
		List<Integer> numbers1 = Arrays.asList(12, 45, 7, 31, 18, 50);
		
		System.out.println("2. "+numbers1.stream().filter(n->n>20).toList());
		
		List<Employee> emp = Arrays.asList(
									new Employee(101, "Arun", "IT", "Chennai", 90000),
									new Employee(102, "Priya", "HR", "Bangalore", 70000),
									new Employee(103, "Karthik", "IT", "Chennai", 120000),
									new Employee(104, "Meena", "Finance", "Chennai", 95000),
									new Employee(105, "Meera", "Finance", "Chennai", 95000),
									new Employee(106, "Ravi", "IT", "Hyderabad", 110000)
									);
		
		System.out.println("3. "+emp.stream().filter(e->e.getSalary()>100000).map(Employee::getName).toList());
		
		System.out.println("4. "+emp.stream().map(e->e.getSalary()).sorted(Comparator.reverseOrder()).distinct().toList());
		
		List<Employee> emp2 = Arrays.asList(
									new Employee(1, "Asha", "IT", 90000),
									new Employee(2, "Bala", "IT", 120000),
									new Employee(3, "Cathy", "HR", 80000),
									new Employee(4, "Deepak", "HR", 95000),
									new Employee(5, "Esha", "Finance", 100000)
									);
		
		
		
		System.out.println("5. "+emp2.stream().collect(Collectors.groupingBy(
																			Employee::getDepartment,
																			Collectors.collectingAndThen(
																				Collectors.maxBy(Comparator.comparing(Employee::getSalary)),
																				e -> e.get().getName()
																			)															
																			)));
		
		
		
		
		
		
		
	}
	
	
	
	
}


class Employee{
	
	int id;
	String name;
	String department;
	String city;
	double salary;
	
	public Employee(int id, String name, String department, String city, double salary){
		this.id = id;
		this.name = name;
		this.department = department;
		this.city = city;
		this.salary = salary;
	}
	
	public Employee(int id, String name, String department, double salary){
		this.id = id;
		this.name = name;
		this.department = department;
		this.salary = salary;
	}
	
	public Employee(int id, String name, String department){
		this.id = id;
		this.name = name;
		this.city = city;
	}
	
	public void setId(int id){
		this.id=id;
	}
	
	public int getId(){
		return id;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public void setDepartment(String department){
		this.department=department;
	}
	
	public String getDepartment(){
		return department;
	}
	
	public void setCity(String city){
		this.city = city;
	}
	
	public String getCity(){
		return city;
	}
	
	public void setSalary(double salary){
		this.salary=salary;
	}
	
	public double getSalary(){
		return salary;
	}
	
	
	public String toString(){
		
		return "Employee= { Id: " +getId() + ", Name: "+getName()+ ", Department: " +getDepartment()+ ", City: "+ getCity() +", Salary: "+ getSalary() ;
		
	}
	
	
}