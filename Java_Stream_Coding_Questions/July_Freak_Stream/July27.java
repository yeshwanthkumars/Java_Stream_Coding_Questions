import java.util.*;
import java.util.stream.*;

/*
1. Find the first element greater than 4 in the list.
2. Check if any string in the list contains the substring "an".
3. Verify that all numbers in the list are even.
4. Confirm that none of the numbers in the list is even.
5. Find the first employee whose salary exceeds 60 000.
6. Find the first number greater than 10 from the list; return -1 if none exists.
7. In a parallel stream of 1–10, find any even number (result is non-deterministic but must be even).
8. Find the first employee who belongs to the IT department AND has a salary greater than 52000.
9. Check whether every employee in the list with department "IT" earns at least 50 000.
10. Find the first fruit whose name has length > 5; return "none" if not found.
*/



public class July27{
	
	public static void main(String args[]){
		
		
		List<Integer> number = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		System.out.println("1. "+number.stream().filter(n->n>4).findFirst());
		
		List<String> sentence = Arrays.asList("Banana","apple","cherry");
		
		System.out.println("2. "+sentence.stream().filter(s->s.contains("an")).findAny());
		
		System.out.println("3. "+number.stream().allMatch(s->s%2==0));
		
		System.out.println("4. "+number.stream().noneMatch(s->s%2==0));
		
		List<Employee> emp = Arrays.asList(
											new Employee(1, "Yeshwanth", 25000, 27,"Developer"),
											new Employee(2, "Vishal", 30000, 26,"QA"),
											new Employee(3, "Gokul", 40000, 29,"Manager"),
											new Employee(4, "Kumar", 66000, 27,"Developer"),
											new Employee(5, "Raj", 66000, 27,"IT")
			
										  );
		
		System.out.println("5. "+emp.stream().filter(e->e.getSalary() > 60000).findFirst());
		
		System.out.println("6. "+number.stream().filter(n->n>10).findFirst().orElse(-1));
		
		System.out.println("7. "+number.parallelStream().filter(n->n%2==0).findAny());
		
		System.out.println("8. "+emp.stream().filter(e->e.getDepartment().contains("IT") && e.getSalary()>52000).findFirst());
		
		System.out.println("9. "+emp.stream().allMatch(e->e.getDepartment().contains("IT") && e.getSalary()>52000));
		
		System.out.println("10. "+sentence.stream().filter(n->n.length()>5).findFirst().orElse("None"));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}