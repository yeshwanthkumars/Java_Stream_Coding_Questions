
import java.util.*;
import java.util.stream.*;

public class StreamAPITest{

	public static void main(String args[]){
		
		
		List<Integer> numbers = Arrays.asList(10, 20, 10, 30, 40, 20, 50);
		List<String> names = Arrays.asList("Arun", "Bala", "Anu", "David", "Ajay");
		List<Integer> numbers1 = Arrays.asList(5, 1, 9, 3, 14, 9, 7);
		List<String> words = Arrays.asList("apple", "bat", "car", "elephant", "dog");
		String input = "java stream";
		List<Employee> employees = Arrays.asList(
                new Employee(101, "Alice", "IT", 75000, "alice@example.com", 9876543210L,34,"Male"),
                new Employee(102, "Bob", "HR", 50000, "bob@example.com", 9876543211L,54,"Male"),
                new Employee(103, "Charlie", "Finance", 60000, "charlie@example.com", 9876543212L,23,"Male"),
                new Employee(104, "Diana", "IT", 80000, "diana@example.com", 9876543213L,28,"Female"),
                new Employee(105, "Eve", "Marketing", 55000, "eve@example.com", 9876543214L,42,"Female")
        );
		List<String> items = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple", "kiwi");
		List<List<Integer>> numbers2 = Arrays.asList(
										Arrays.asList(1, 2, 3),
										Arrays.asList(3, 4, 5),
										Arrays.asList(5, 6, 7)
		);
		
		
	
		//Date: 02/03/2026
		
		//1.Remove Duplicates from a List
		
		System.out.println("1. "+numbers.stream().distinct().toList());
		
		//2.Count Strings Starting with 'A'
	
		System.out.println("2. "+names.stream().filter(a->a.startsWith("A")).count());
		
		//3.Find Second Highest Number
		
		System.out.println("3. "+numbers1.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst());
	
		//4.Group Words by Length
		
		System.out.println("4. "+words.stream().collect(Collectors.groupingBy(n->n.length())));
		
		//5.Find Frequency of Each Character in a String
		
		System.out.println("5. "+input.chars()
									  .filter(c -> c != ' ')
									  .mapToObj(c -> (char) c)
									  .collect(Collectors.groupingBy(
									  		c -> c,
									  		LinkedHashMap::new,
									  		Collectors.counting()
									  )));
		
		
		//6.Partition Numbers into Even and Odd
		
		System.out.println("6. "+numbers1.stream().collect(Collectors.partitioningBy(n->n%2==0)));
	
		//7.Find Employee with Highest Salary
	
		System.out.println("7. "+employees.stream().max(Comparator.comparing(Employee::getSalary)));
		
		//8.Find Top 3 Most Frequent Elements
		
		System.out.println("8. "+items.stream().collect(Collectors.groupingBy(n->n, Collectors.counting()))
												.entrySet().stream()
												.sorted(Map.Entry.<String, Long>comparingByValue().reversed())
												.limit(3)
												.map(Map.Entry::getKey)
												.toList());
												
		//9.Flatten Nested List and Find Unique Sorted Values
		
		System.out.println("9. "+numbers2.stream().flatMap(List::stream).distinct().sorted().toList());
		
		//10.Multilevel grouping i) First by department ii) Then by gender, iii)Then calculate average salary
		
		System.out.println("10. "+employees.stream().collect(Collectors.groupingBy(
																Employee::getDepartment,
																Collectors.groupingBy(
																	Employee::getGender,
																	Collectors.averagingDouble(Employee::getSalary)
																)
															)));
		
		
		
	
	}
}