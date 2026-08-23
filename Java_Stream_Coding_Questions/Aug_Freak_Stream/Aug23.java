import java.util.*;
import java.util.stream.*;

/*
1. Return all strings whose length is greater than 5.
Sample Input
["spring","java","microservice","kafka","backend"]
Sample Output
["spring","microservice","backend"]


2. Convert all names to uppercase and preserve their order.
Sample Input
["arun","priya","karthik"]
Sample Output
["ARUN","PRIYA","KARTHIK"]


3. Calculate the average of all positive numbers. Return 0 when no positive number exists.
Sample Input
[-2, 10, 20, -5, 30]
Sample Output
20.0


4. Return names of employees who belong to IT and earn more than 100000, sorted alphabetically.
Sample Input
[
  {1,"Arun","IT",90000},
  {2,"Bala","IT",125000},
  {3,"Cathy","HR",150000},
  {4,"Dinesh","IT",110000}
]
Sample Output
[Bala, Dinesh]


5. For each department, calculate total salary and average salary. Order departments alphabetically.
Sample Input
[
  {1,"A","IT",100000},
  {2,"B","IT",120000},
  {3,"C","HR",80000},
  {4,"D","HR",100000}
]
Sample Output
{HR={total=180000, average=90000.0}, IT={total=220000, average=110000.0}}


*/



public class Aug23{
	
	
	public static void main(String args[]){
		
		
		List<String> words = Arrays.asList("spring","java","microservice","kafka","backend");
		
		System.out.println("1. "+words.stream().filter(s->s.length()>5).toList());
		
		List<String> names = Arrays.asList("arun","priya","karthik");
		
		System.out.println("2. "+names.stream().map(s->s.toUpperCase()).toList());
		
		List<Integer> numbers = Arrays.asList(-2, 10, 20, -5, 30);
		
		System.out.println("3. "+numbers.stream().filter(n->n>0).mapToInt(Integer::intValue).average().orElse(0));
		
		
		List<Employee> emp = Arrays.asList(
										new Employee(1,"Arun","IT",90000),
										new Employee(2,"Bala","IT",125000),
										new Employee(3,"Cathy","HR",150000),
										new Employee(4,"Dinesh","IT",110000)
										  );
		
		System.out.println("4. "+emp.stream().filter(e-> e.getDepartment()=="IT" && e.getSalary()>100000).map(e->e.getName()).sorted().toList());
		
		
		List<Employee> emp2 = Arrays.asList(
										new Employee(1,"A","IT",100000),
										new Employee(2,"B","IT",120000),
										new Employee(3,"C","HR",80000),
										new Employee(4,"D","HR",100000)
										  );
										
		System.out.println("5. "+emp2.stream()
									  .collect(Collectors.groupingBy(
									  	Employee::getDepartment,
									  	TreeMap::new,
									  	Collectors.collectingAndThen(
									  		Collectors.summarizingDouble(Employee::getSalary),
									  		stats -> {
									  			Map<String, Double> salaryDetails = new LinkedHashMap<>();
									     
									  			salaryDetails.put("total", stats.getSum());
									  			salaryDetails.put("average", stats.getAverage());
									     
									  			return salaryDetails;
									  		}
									  	)
									  )));										
		
		
		
	}
}