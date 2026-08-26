import java.util.*;
import java.util.stream.*;

/*
1. Given an ordered list, skip the first K elements and return the next N elements.
Sample Input
Numbers=[10,20,30,40,50,60,70], K=2, N=3
Sample Output
[30,40,50]

2. Return the first five distinct values from the list while preserving encounter order.
Sample Input
[1,2,2,3,4,3,5,6,1,7]
Sample Output
[1,2,3,4,5]


3. Count employees in each department and return the result ordered by department name.
Sample Input
[(A,IT),(B,HR),(C,IT),(D,Finance),(E,HR)]
Sample Output
{Finance=1, HR=2, IT=2}


4. For every department, find the second-highest distinct salary. Departments with fewer than two distinct salaries must be omitted.
Sample Input
[(A,IT,100),(B,IT,150),(C,IT,150),(D,HR,90),(E,HR,110),(F,Finance,200)]
Sample Output
{HR=90, IT=100}


5. Find the department containing the largest number of employees. If tied, return the alphabetically first department.
Sample Input
[(A,IT),(B,HR),(C,IT),(D,Finance),(E,HR),(F,IT),(G,HR)]
Sample Output
HR

*/


public class Aug26{
	
	public static void main(String args[]){
		
		
		
		List<Integer> numbers = Arrays.asList(10,20,30,40,50,60,70);
		
		int K=2, N=3;
		
		System.out.println("1. "+numbers.stream().skip(K).limit(N).toList());
		
		
		List<Integer> numbers2 = Arrays.asList(1,2,2,3,4,3,5,6,1,7);
		
		System.out.println("2. "+numbers2.stream().distinct().limit(5).toList());
		
		
		List<Employee> emp = Arrays.asList(
										new Employee(1,"A","IT",50000),
										new Employee(2,"B","HR",40000),
										new Employee(3,"C","HR",50000),
										new Employee(3,"D","Finance",30000)
										);
		
		System.out.println("3. "+emp.stream().collect(Collectors.groupingBy(
																			Employee::getDepartment,
																			Collectors.counting())));
		
		List<Employee> emp2 = Arrays.asList(
										new Employee(1,"A","IT",100),
										new Employee(2,"B","IT",150),
										new Employee(3,"C","IT",150),
										new Employee(3,"D","HR",90),
										new Employee(3,"E","HR",110),
										new Employee(3,"F","Finance",200)
										);
										
										
		System.out.println("4. "+emp2.stream().collect(
														Collectors.groupingBy(
															Employee::getDepartment,
															Collectors.collectingAndThen(
																Collectors.toList(),
																list-> list.stream()
																		   .map(Employee::getSalary)
																		   .distinct()
																		   .sorted(Comparator.reverseOrder())
																		   .skip(1)
																		   .findFirst()
															)
														)
														)
														.entrySet()
														.stream()
														.filter(entry -> entry.getValue().isPresent())
														.collect(Collectors.toMap(
															Map.Entry::getKey,
															entry -> entry.getValue().get(),
															(a, b) -> a,
															TreeMap::new
														))
														);
		
		System.out.println("5. "+emp2.stream().collect(
														Collectors.groupingBy(
															Employee::getDepartment,
															Collectors.counting()
														
														)
														
													)
													.entrySet()
													.stream()
													.sorted(Map.Entry.<String, Long>comparingByValue()
															.reversed()
													)
													.map(Map.Entry::getKey)
													.findFirst()
													.orElse("NONE")
													
													);
		
		
	}
	

}