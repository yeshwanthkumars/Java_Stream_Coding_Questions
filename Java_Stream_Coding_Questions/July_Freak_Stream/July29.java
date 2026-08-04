import java.util.*;
import java.util.stream.*;


/*
1. Count the number of elements in each group using groupingBy + counting().
2. Join languages with " | " separator, prefix "Languages: [", suffix "]".
3. Compute the total salary of all employees using Collectors.summingInt().
4. Calculate the average of a list of integers using Collectors.averagingInt().
5. Count the number of employees in each department.
6. Find the employee with the highest salary in each department using groupingBy + maxBy().
7. Create a map: word → UPPERCASE using Collectors.toMap().
8. Group sales records by salesperson, then by quarter, and sum the amounts.
9. Collect a list of integers, remove duplicates, sort them, and return an unmodifiable list using collectingAndThen().
10. Count the frequency of each word in a list using Collectors.toMap() with a merge function.
*/




public class July29{
	
	public static void main(String args[]){
		
		
		List<String> fruits = Arrays.asList("apple","banana","cherry","apple","cherry","apple","kiwi","banana");
		
		System.out.println("1. "+fruits.stream().collect(Collectors.groupingBy(
																				word -> word,
																				Collectors.counting())));
		
		List<String> languages = Arrays.asList("Java","Python","Go","C");
		
		System.out.println("2. "+languages.stream().collect(Collectors.joining(" | ", "Languages: [ "," ]")));
		
		List<Employee> emp = Arrays.asList(
											new Employee(1, "Yeshwanth", 25000, 27,"Developer"),
											new Employee(2, "Vishal", 30000, 26,"QA"),
											new Employee(3, "Gokul", 40000, 29,"Manager"),
											new Employee(4, "Kumar", 66000, 27,"Developer"),
											new Employee(5, "Raj", 66000, 27,"IT"),
											new Employee(6, "Vish", 40000, 26,"Devops"),
											new Employee(7, "Yesh", 90000, 26,"QA")
			
										  );
										  
		System.out.println("3. "+emp.stream().collect(Collectors.summingDouble(Employee::getSalary)));
		
		
		List<Integer> nums = Arrays.asList(10,20,30,40,50);
		
		System.out.println("4. "+nums.stream().collect(Collectors.averagingInt(Integer::intValue)));
		
		System.out.println("5. "+emp.stream().collect(Collectors.groupingBy(
																		Employee::getDepartment, 
																		Collectors.counting())));
																		
		System.out.println("6. "+emp.stream().collect(Collectors.groupingBy(
																		Employee::getDepartment, 
																		Collectors.maxBy(Comparator.comparing(Employee::getSalary)))));																
		System.out.println("7. "+languages.stream().collect(Collectors.toMap(word -> word, word -> word.toUpperCase())));
		
		List<Sales> sales = Arrays.asList(
										new Sales("John", "Q1", 1000),
										new Sales("John", "Q1", 1500),
										new Sales("John", "Q2", 2000),
										new Sales("Alice", "Q1", 1200),
										new Sales("Alice", "Q2", 1800),
										new Sales("Alice", "Q2", 700)
										);
										
		System.out.println("8. "+sales.stream().collect(
														Collectors.groupingBy(
															Sales:: getPerson,
															Collectors.groupingBy(
																Sales:: getQuarter,
																Collectors.summingDouble(Sales::getAmount)
															)
														)
													  ));
													  
		List<Integer> numbers = Arrays.asList(5, 3, 1, 2, 5, 4, 3, 2, 1);
		
		
		System.out.println("9. "+numbers.stream().collect(Collectors.collectingAndThen(
																Collectors.toCollection(TreeSet::new),
																list -> Collections.unmodifiableList(new ArrayList<>(list))
																)));	
																	
		System.out.println("10. "+fruits.stream().collect(Collectors.toMap(word -> word, word -> 1L, Long::sum)));
		
																		
		
	}
}


class Sales{
	String person;
	String quarter;
	int amount;
	
	public Sales(String person, String quarter, int amount){
		this.person =person;
		this.quarter = quarter;
		this.amount=amount;
	}
	
	public String getPerson(){
		return person;
	}
	
	public void setPerson(String person){
		this.person = person;
	}
	
	public String getQuarter(){
		return quarter;
	}
	
	public void setQuarter(String quarter){
		this.quarter=quarter;
	}
	
	public int getAmount(){
		return amount;
	}
	
	public void setAmount(int amount){
		this.amount = amount;
	}
	
	public String toString(){
		return "Sales: [ Person: " +getPerson()+ " , Quarter:  "+ getQuarter() + " , Amount: "+ getAmount() +" ]";
	}
}