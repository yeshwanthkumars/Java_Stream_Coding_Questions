import java.util.*;
import java.util.stream.*;


/*
1. Sort a list of integers in ascending (natural) order.
2. Sort a list of strings alphabetically.
3. Sort a list of integers in descending order using Comparator.reverseOrder().
4. Sort a list of strings by their length (ascending).
5. Sort Employee objects by salary in ascending order.
6. Sort employees first by department (alphabetically), then by salary (ascending) within each department.
7. Sort a list in ascending order and return only the 3 smallest elements.
8. Sort a list of strings in natural order but treat null values as the smallest (appear first).
9. Sort employees by age ascending; for same age, sort by name alphabetically.
10. Sort strings by their last character. If two strings have the same last character, sort them by string length (ascending)..

*/


public class July22{
	
		public static void main(String args[]){
			
			
			List<Integer> numbers = Arrays.asList(3,6,1,7,9,10,2,5,4,8);
			
			
			System.out.println("1. "+numbers.stream().sorted().toList());
			
			
			List<String> fruits = Arrays.asList("banana","cherry","apple","mango");
			
			System.out.println("2. "+fruits.stream().sorted().toList());
			
			System.out.println("3. "+numbers.stream().sorted(Comparator.reverseOrder()).toList());
			
			
			List<String> names = Arrays.asList("Vishal","Kumar","Raj","Gokul","Yeshwanth");
			
			System.out.println("4. "+names.stream().sorted(Comparator.comparing(String::length)).toList());
			
			List<Employee> emp = Arrays.asList(
											new Employee(1, "Yeshwanth", 25000, 27,"Developer"),
											new Employee(2, "Vishal", 30000, 26,"QA"),
											new Employee(3, "Gokul", 40000, 29,"Manager"),
											new Employee(4, "Kumar", 26000, 27,"Developer")
			
										  );
			
			System.out.println("5. "+emp.stream().sorted(Comparator.comparing(Employee::getSalary)).toList());
			
			System.out.println("6. "+emp.stream().sorted(Comparator
															.comparing(Employee::getDepartment)
															.thenComparing(Employee::getSalary))
															.toList());
			
			
			System.out.println("7. "+numbers.stream().sorted().limit(3).toList());
			
			List<String> words = Arrays.asList("apple", null, "banana", "cherry", null);
			
			System.out.println("8. "+words.stream().sorted(Comparator.nullsFirst(Comparator.naturalOrder())).toList());
			
			
			System.out.println("9. "+emp.stream().sorted(Comparator.comparing(Employee::getAge)
																   .thenComparing(Employee::getName)).toList());
													
			List<String> strings = Arrays.asList("apple", "banana", "cat", "dog", "grape", "bee", "kite");											
																   
			System.out.println("10. "+strings.stream().sorted(Comparator
															.comparing((String s) -> s.charAt(s.length()-1))
															.thenComparing(String::length)
															)
															.toList());
			
			
		}
	
}