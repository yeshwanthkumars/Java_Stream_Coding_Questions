import java.util.*;
import java.util.stream.*;

/*
1. Get the names of employees whose salary exceeds 55 000.
2. Get a sorted list of distinct departments from the employee list.
3. Count how many employees are in each department.
4. Find the employee with the highest salary.
5. Compute total salary, average salary, and max salary per department.
6. Get the top 3 highest-paid employees as a sorted list
7. Classify employees into salary buckets: LOW (<50k), MEDIUM (50k–65k), HIGH (>65k).
8. For each department, find the employee with the highest salary.
9. Compute total spending per customer; sort result by spending descending.
10. Parse a semicolon-delimited CSV string into Employee objects, then group by department.
*/


public class July31{
	
	public static void main(String args[]){
		
		List<Employee> emp = Arrays.asList(
											new Employee(1, "Yeshwanth", 25000, 27,"Developer"),
											new Employee(2, "Vishal", 30000, 26,"QA"),
											new Employee(3, "Gokul", 40000, 29,"Manager"),
											new Employee(4, "Kumar", 66000, 27,"Developer"),
											new Employee(5, "Raj", 66000, 27,"IT"),
											new Employee(6, "Vish", 40000, 26,"Devops"),
											new Employee(7, "Yesh", 90000, 26,"QA")
			
										  );
										  
		System.out.println("1. "+emp.stream().filter(e->e.getSalary()>55000).map(e->e.getName()).toList());
		
		System.out.println("2. "+emp.stream().map(e->e.getDepartment()).distinct().sorted().toList());
		
		System.out.println("3. "+emp.stream().collect(Collectors.groupingBy(
																			Employee::getDepartment,
																			Collectors.counting()
																			)));
		
		System.out.println("4. "+emp.stream().collect(Collectors.maxBy(Comparator.comparing(Employee::getSalary))));
		
		
		System.out.println("5. Total Salary= "+emp.stream().collect(Collectors.groupingBy(
																			Employee::getDepartment,
																			Collectors.summingDouble(Employee::getSalary))));
		
		System.out.println("5. Average Salary=  "+emp.stream().collect(Collectors.groupingBy(
																			Employee::getDepartment,
																			Collectors.averagingDouble(Employee::getSalary))));
																			
		System.out.println("5. Max Salary= "+emp.stream().collect(Collectors.groupingBy(
																			Employee::getDepartment,
																			Collectors.maxBy(Comparator.comparing(Employee::getSalary)))));

		System.out.println("6. "+emp.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).limit(3).toList());

		
		System.out.println("7. "+emp.stream().collect(Collectors.groupingBy(
																	e -> {
																		if (e.getSalary() < 50000)
																			return "LOW";
																		else if (e.getSalary() <= 65000)
																			return "MEDIUM";
																		else
																			return "HIGH";
																	},
																	Collectors.mapping(
																			Employee::getName,
																			Collectors.toList()
																	)
															)));
		System.out.println("8. "+emp.stream().collect(Collectors.groupingBy(
																			Employee::getDepartment,
																			Collectors.maxBy(Comparator.comparing(Employee::getSalary)))));
															
		
		List<order> orders = Arrays.asList(
								new order("1","Yeshwanth",20000),
								new order("2","Gokul",25000),
								new order("3","Yeshwanth",20000),
								new order("4","Vishal",70000));
								
		
		System.out.println("9. "+orders.stream().collect(Collectors.groupingBy(
																				order::getCustomer,
																				Collectors.summingInt(order::getAmount)))
																				.entrySet()
																				.stream()
																				.sorted(Map.Entry.<String,Integer>comparingByValue().reversed())
																				.collect(Collectors.toList())
																	
																				);
																				
		String csv = "1,Alice,IT,50000;" + "2,Bob,HR,60000;" + "3,Charlie,IT,55000";
		
		System.out.println("10. "+Arrays.stream(csv.split(";"))
										.map(record -> record.split(","))
										.map(data -> new Employee(
												Integer.parseInt(data[0]),      // id
												data[1],                        // name
												Double.parseDouble(data[3]),    // salary
												0,                              // age (default)
												data[2]                         // department
										))
										.collect(Collectors.groupingBy(Employee::getDepartment))
						);
		
	}

}

class order{
	
	String id;
	String customer;
	int amount;
	
	
	public order(String id, String customer, int amount){
		this.id = id;
		this.customer=customer;
		this.amount=amount;
	}
	
	public String getId(){
		return id;
	}
	
	public void setId(String id){
		this.id = id;
	}
	
	public String getCustomer(){
		return customer;
	}
	
	public void setCustomer(String customer){
		this.customer=customer;
	}
	
	public int getAmount(){
		return amount;
	}
	
	public void setAmount(int amount){
		this.amount=amount;
	}
	
	public String toString(){	
		return "Order ={Id= " +getId()+ " , Customer= " +getCustomer()+ ", Amount= "+getAmount()+ " }";
	}
}