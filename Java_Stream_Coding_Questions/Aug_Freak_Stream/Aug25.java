import java.util.*;
import java.util.stream.*;


/*
1. Return distinct strings while preserving their first-seen order.
Sample Input
["java","spring","java","kafka","spring"]
Sample Output
["java","spring","kafka"]


2. Sort employees by salary ascending. If salaries are equal, sort by name.
Sample Input
[(A,50000),(B,40000),(C,50000),(D,30000)]
Sample Output
[(D,30000),(B,40000),(A,50000),(C,50000)]


3. Given a list and N, return the N largest distinct numbers in descending order.
Sample Input
Numbers=[4,9,2,9,7,8,3], N=3
Sample Output
[9, 8, 7]


4. Group words by their length. Within each group, sort words alphabetically and return groups ordered by length.
Sample Input
["java","code","spring","api","kafka","go"]
Sample Output
{2=[go], 3=[api], 4=[code, java], 5=[kafka], 6=[spring]}


5. Find the highest-paid employee from the supplied list and return the employee name. If the list is empty, return NONE.
Sample Input
[(A,50000),(B,90000),(C,70000)]
Sample Output
B

*/





public class Aug25{
	
	public static void main(String args[]){
		
		
		
		List<String> names = Arrays.asList("java","spring","java","kafka","spring");
		
		System.out.println("1. "+names.stream().distinct().toList());
		
		List<Employee> emp = Arrays.asList(
										new Employee(1,"A","IT",50000),
										new Employee(2,"B","IT",40000),
										new Employee(3,"C","IT",50000),
										new Employee(3,"D","IT",30000)
										);
										
		System.out.println("2. "+emp.stream().sorted(Comparator.comparing(Employee::getSalary).thenComparing(Employee::getName)).toList());
		
		
		List<Integer> numbers = Arrays.asList(4,9,2,9,7,8,3);
		int N=3;
		System.out.println("3. "+numbers.stream().sorted(Comparator.reverseOrder()).distinct().limit(N).toList());
		
		
		List<String> words = Arrays.asList("java","code","spring","api","kafka","go");
		
		System.out.println("4. "+words.stream().collect(
														Collectors.groupingBy(
																			String::length,
																			Collectors.collectingAndThen(
																				Collectors.toList(),
																				list -> list.stream().sorted().toList()
																			)
														)
														)
														);
		List<Employee> emp1 = Arrays.asList(
										new Employee(1,"A","IT",50000),
										new Employee(2,"B","IT",90000),
										new Employee(3,"C","IT",70000)
										);
										
		System.out.println("5. "+emp1.stream().max(Comparator.comparing(Employee::getSalary)).map(Employee::getName).orElse("NONE"));
	
	}
}