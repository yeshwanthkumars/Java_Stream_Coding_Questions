import java.util.*;
import java.util.stream.*;


/*
1. Partition a list of integers into even and odd groups.
2. Group a list of strings by their first character.
3. Group employees by department.
4. Partition numbers into two groups: those >= 10 and those < 10.
5. Count how many times each element appears in the list.
6. Calculate the average salary for each department.
7. Group strings by their length.
8. Group employees by department and get the count of employees in each department.
9. Find the maximum salary in each department.
10. Partition numbers into >5 and <=5, then compute the sum of each partition.
*/



public class July25{
	
	public static void main(String args[]){
		
		List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		System.out.println("1. "+nums.stream().collect(Collectors.partitioningBy(n->n%2==0)));
		
		List<String> words = Arrays.asList("apple", "avocado","banana","cherry");
		
		System.out.println("2. "+words.stream().collect(Collectors.groupingBy(
															word -> word.charAt(0))));
															
																
		List<Employee> emp = Arrays.asList(
											new Employee(1, "Yeshwanth", 25000, 27,"Developer"),
											new Employee(2, "Vishal", 30000, 26,"QA"),
											new Employee(3, "Gokul", 40000, 29,"Manager"),
											new Employee(4, "Kumar", 26000, 27,"Developer")
			
										  );
										  
		System.out.println("3. "+emp.stream().collect(Collectors.groupingBy(Employee::getDepartment,
																			Collectors.mapping(
																			Employee::getName,
																			Collectors.toList()))));
		
		List<Integer> numbers = Arrays.asList(10,20,1,2,3,15,16,5,6);
		
		System.out.println("4. "+numbers.stream().collect(Collectors.partitioningBy(n->n>=10)));
		
		
		List<String> elements = Arrays.asList("apple","banana","cherry","banana","apple","grapes");
		
		
		System.out.println("5. "+elements.stream().collect(Collectors.groupingBy(word -> word, Collectors.counting())));
		
		System.out.println("6. "+emp.stream().collect(Collectors.groupingBy(
																	Employee::getDepartment,
																	Collectors.averagingDouble(Employee::getSalary)
																	)
																	));
																	
		
		System.out.println("7. "+words.stream().collect(Collectors.groupingBy(word->word.length())));
		
		System.out.println("8. "+emp.stream().collect(Collectors.groupingBy(
																	Employee::getDepartment,
																	Collectors.counting()
																	)
																	));
		
		System.out.println("9. "+emp.stream().collect(Collectors.groupingBy(
																	Employee::getDepartment,
																	Collectors.collectingAndThen(
																		Collectors.maxBy(
																		Comparator.comparing(Employee::getSalary)
																		),
																		e -> e.get().getSalary()
																	)
																	)
																	));
																	
		System.out.println("10. "+numbers.stream().collect(Collectors.partitioningBy(
																n->n>=5,
																Collectors.summingInt(Integer::intValue))));
		
		
	}
}