import java.util.*;
import java.util.stream.*;


/*

1. Return the first number greater than 50 in the input order. Return NONE if absent.
Sample Input
[10, 30, 49, 75, 60]
Sample Output
75


2. Determine whether every number in the list is positive.
Sample Input
[2, 4, 8, 10]
Sample Output
true


3. Determine whether at least one employee belongs to Chennai.
Sample Input
[
  {1,"A","Bangalore"},
  {2,"B","Hyderabad"},
  {3,"C","Chennai"}
]
Sample Output
true


4. Given employees with department and salary, return the department having the highest average salary. If tied, return the alphabetically first department.
Sample Input
[
  {1,"A","IT",100000},
  {2,"B","IT",120000},
  {3,"C","HR",130000},
  {4,"D","HR",90000},
  {5,"E","F",115000}
]
Sample Output
IT

5. Return the top two highest-paid employees from every department. Order employees by salary descending and departments alphabetically.
Sample Input
[
  {1,"A","IT",100},
  {2,"B","IT",150},
  {3,"C","IT",120},
  {4,"D","HR",200},
  {5,"E","HR",180},
  {6,"F","HR",160}
]
Sample Output
{HR=[D(200),E(180)], IT=[B(150),C(120)]}





*/



public class Aug24{
	
	public static void main(String args[]){
		
		
		
		List<Integer> numbers = Arrays.asList(10, 30, 49, 75, 60);
		
		System.out.println("1. "+numbers.stream().filter(n->n>50).map(String::valueOf).findFirst().orElse("None"));
		
		
		List<Integer> numbers2 = Arrays.asList(2, 4, 8, 10);
		
		System.out.println("2. "+numbers2.stream().allMatch(n->n>0));
		
		
		List<Employee> emp = Arrays.asList(
									new Employee(1,"A","Bangalore"),
									new Employee(2,"B","Hyderabad"),
									new Employee(3,"C","Chennai")
									
										);
										
		System.out.println("3. "+emp.stream().anyMatch(e -> "Chennai".equals(e.getCity())));
		
		List<Employee> emp1 = Arrays.asList(
										new Employee(1,"A","IT",100000),
										new Employee(2,"B","IT",120000),
										new Employee(3,"C","HR",130000),
										new Employee(4,"D","HR",90000),
										new Employee(5,"E","F",115000)
										);
										
		System.out.println("4. "+emp1.stream().collect(
													   Collectors.groupingBy(
														Employee::getDepartment,
														Collectors.summingDouble(Employee::getSalary)
														)
														)
														.entrySet()
														.stream()
														.sorted(
															Map.Entry.<String, Double>comparingByValue()
															.reversed()
															.thenComparing(Map.Entry.comparingByKey())
														)
														.map(Map.Entry::getKey)
														.findFirst()
														.orElse("NONE")
														
														);
										
										
						
		List<Employee> emp2 = Arrays.asList(
										new Employee(1,"A","IT",100),
										new Employee(2,"B","IT",150),
										new Employee(3,"C","IT",120),
										new Employee(4,"D","HR",200),
										new Employee(5,"E","HR",180),
										new Employee(6,"F","HR",160)
										);
		
		System.out.println("5. "+emp2.stream().collect(
														Collectors.groupingBy(
															Employee::getDepartment,
															TreeMap::new,
															Collectors.collectingAndThen(
																Collectors.toList(),
																list -> list.stream()
																			.sorted(
																				Comparator.comparing(Employee::getSalary)
																				.reversed()
																				)
																			.limit(2)
																			.collect(Collectors.toList())
															
															
															)
														
														
														
														)));
		
	}
}
