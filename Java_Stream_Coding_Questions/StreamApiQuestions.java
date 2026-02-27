import java.util.*;
import java.util.stream.*;


public class StreamApiQuestions{

	public static void main(String args[]){
		
		
		
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,56,123,900);
		List<String> fruits = Arrays.asList("Apple","Avocado","Orange","Grapes","Lime","Banana");
		List<String> withnullList = Arrays.asList("Apple", null, "Banana",null, "Orange");
		List<String> withemptyList = Arrays.asList("Apple", "", "Banana","", "Orange");
		List<Employee> employees = Arrays.asList(
                new Employee(101, "Alice", "IT", 75000, "alice@example.com", 9876543210L,34),
                new Employee(102, "Bob", "HR", 50000, "bob@example.com", 9876543211L,54),
                new Employee(103, "Charlie", "Finance", 60000, "charlie@example.com", 9876543212L,23),
                new Employee(104, "Diana", "IT", 80000, "diana@example.com", 9876543213L,28),
                new Employee(105, "Eve", "Marketing", 55000, "eve@example.com", 9876543214L,42)
        );
		
		List<Integer> withduplicatenumbers = Arrays.asList(6,7,1,2,1,4,5,1,2,3,4,5,0,100,40);
		Set<Integer> seen = new HashSet<>();
		List<String> smallletters = Arrays.asList("a","b","c");
		List<String> capitalletters = Arrays.asList("A","B","C");
		List<String> names = Arrays.asList("Yeshwanth","Gokul","Vishal");
		String namesarray[] = {"Yeshwanth","Vishal","Gokul"};
		List<String> listofstring = Arrays.asList("I am", "Java Developer");
		Map<String, Integer> mapdata = Map.of(
										"A", 30,
										"B", 10,
										"C", 20
		);
		
		List<Integer> frequencylist = Arrays.asList(4, 5, 6, 5, 4, 3);
		List<List<Integer>> listOfLists = Arrays.asList(
												Arrays.asList(1, 2, 3),
												Arrays.asList(4, 5),
												Arrays.asList(6, 7, 8)
		);
		List<Person> persons = Arrays.asList(
				new Person("Vishal", Arrays.asList("111-111", "222-222")),
				new Person("Gokul", Arrays.asList("333-333")),
				new Person("Yeshwanth", Arrays.asList("444-444", "555-555"))
		);
		
		Company company = new Company(Arrays.asList(
									new Department("IT", Arrays.asList(
									new Employee(1, "John", "IT", 60000.0, "111-111", 1234567890L, 0),
									new Employee(2, "Mike", "IT", 55000.0, "222-222", 1234567891L, 0)
									)),
									new Department("HR", Arrays.asList(
									new Employee(3, "Sara", "HR", 70000.0, "333-333", 1234567892L, 0),
									new Employee(4, "Jane", "HR", 65000.0, "444-444", 1234567893L, 0)
								))
		));
		
		List<Integer> list1 = Arrays.asList(1, 2, 3);
		List<Integer> list2 = Arrays.asList(4, 5, 6,1,2);
		
		
		//Creating a Streams
		
		//1.Stream of Collections
		
		Stream<Integer> intstreams = numbers.stream();
		intstreams.forEach(System.out::println);
		
		
		//2.Arrays of Stream
		String[] array = {"A","B","C"};
		Stream<String> arraysofStream = Arrays.stream(array);
		arraysofStream.forEach(System.out::println);
		
		//3.Empty Stream
		Stream<String> emptyStream = Stream.empty();
        emptyStream.forEach(System.out::println);
		
		//4.Infite Stream
		Stream.iterate(1, n -> n + 1)
                .limit(5)
                .forEach(System.out::println);

        Random random = new Random();

        Stream.generate(() -> random.nextInt(100))
                .limit(5)
                .forEach(System.out::println);
		
		
		//5.Stream.of
		
		Stream<Integer> intstreamof = Stream.of(1,2,3,4,5);
		intstreamof.forEach(System.out::println);
		
		Stream<String> stringstreamof = Stream.of("A","B","C","D");
		
		String[] arr = {"X", "Y", "Z"};

        Stream.of(arr)
                .forEach(System.out::println);
		
		//6.Primitive Stream
		IntStream.of(1,2,3,4)
                .forEach(System.out::println);

        DoubleStream.of(1.2,2.3,4.5)
                .forEach(System.out::println);

        LongStream.of(100002222,200000330,478393022)
                .forEach(System.out::println);

        //range
        System.out.println("---range---");
        IntStream.range(1, 5)
                .forEach(System.out::println);  //op: 1,2,3,4

        //rangeclosed
        System.out.println("---rangeclosed---");
        IntStream.rangeClosed(1, 5)
                .forEach(System.out::println); //op: 1,2,3,4,5
		
		
	
		/*********************
		 Coding Questions
		**********************/
		
		//CATEGORY 1: Filtering Problems
		
		 /*
         1.Filter even numbers from a list.
        */
		
		List<Integer> evennumbers = numbers.stream()
										   .filter(n->n%2==0)
										   .collect(Collectors.toList());
		System.out.println("Even Numbers: "+evennumbers);
		
		
		/*
		2.Filter odd numbers from a list.
		*/
		
		List<Integer> oddnumbers = numbers.stream()
										   .filter(n->n%2!=0)
										   .collect(Collectors.toList());
		System.out.println("Odd Numbers: "+oddnumbers);
		
		
		/*
		3.Filter numbers greater than 50.
		*/
		
		List<Integer> greaterThan50 = numbers.stream()
											 .filter(n->n>50)
											 .collect(Collectors.toList());
		System.out.println("Greater than 50: "+greaterThan50);									 
											 
		
		/*
		4.Filter numbers less than 100.
		*/
		
		List<Integer> lessThan100 = numbers.stream()
											 .filter(n->n<100)
											 .collect(Collectors.toList());
		System.out.println("Less than 100: "+lessThan100);
		
		/*
		5.Filter strings starting with "A".
		*/
		
		List<String> startingWithA = fruits.stream()
											.filter(n->n.startsWith("A"))
											.collect(Collectors.toList());
		System.out.println("Starts With A: "+startingWithA);
		
		
		/*
		6.Filter strings ending with "e".
		*/
		
		List<String> endingWithE = fruits.stream()
											.filter(n->n.endsWith("e"))
											.collect(Collectors.toList());
		System.out.println("Ends with E: "+endingWithE);
		
		/*
		7.Remove null values from a list..
		*/
		
		List<String> nonnullList = withnullList.stream()
											   .filter(Objects::nonNull)
											   .collect(Collectors.toList());
		System.out.println("Non Null List: "+nonnullList);
		
		/*
		8.Remove empty strings from a list.
		*/
		
		List<String> removeemptyString = withemptyList.stream()
											   .filter(s -> !s.isEmpty())
											   .collect(Collectors.toList());
		System.out.println("Non empty List: "+removeemptyString);
		
		
		/*
		9.Filter employees with salary > 50000.
		*/
		
		List<Employee> salarygreaterThan50k = employees.stream()
														.filter(e->e.getSalary()>50000)
														.collect(Collectors.toList());
		System.out.println("Employee salary greater than 50: "+salarygreaterThan50k);
		
		
		/*
		10.Filter duplicate elements from a list.
		*/
		
		List<Integer> filterduplicates = withduplicatenumbers.stream()
														 .filter(e->! seen.add(e))
														 .distinct()
														 .collect(Collectors.toList());
																
		System.out.println("Filter Duplicate Elements: "+filterduplicates);
		
		
		Set<Integer> duplicatesvalues = withduplicatenumbers.stream()
										.collect(Collectors.groupingBy(
												n->n,
												Collectors.counting()))
										.entrySet().stream()
										.filter(e->e.getValue() > 1)
										.map(Map.Entry::getKey)
										.collect(Collectors.toSet());
										
		System.out.println("Filter Duplicate Elements by Map Method: "+duplicatesvalues);
		
		
		//CATEGORY 2: Mapping Problems
		
		/*
		11.Convert list of strings to uppercase.
		*/
		
		List<String> uppercase = smallletters.stream()
											 .map(String::toUpperCase)
											 .collect(Collectors.toList());
		System.out.println("Upper case: "+uppercase);
		
		
		/*
		12.Convert list of strings to lowercase.
		*/
		
		List<String> lowercase = smallletters.stream()
											 .map(String::toLowerCase)
											 .collect(Collectors.toList());
		
		System.out.println("Lower case: "+lowercase);
		
		/*
		13.Convert List<Integer> to List<String>.
		*/
		
		List<String> listToString = numbers.stream()
											.map(n -> n.toString())
											.collect(Collectors.toList());
											
		System.out.println("List to String: "+listToString);
		
		/*
		14.Multiply each number by 2.
		*/
		
		List<Integer> multiplyby2 = numbers.stream()
											.map(n->n*2)
											.collect(Collectors.toList());
											
		System.out.println("List multiply by 2: "+multiplyby2);
		
		
		/*
		15.Square each number in a list.
		*/
		
		List<Integer> squareNumber = numbers.stream()
											.map(n->n*n)
											.collect(Collectors.toList());
		System.out.println("Square Numbers: "+squareNumber);
		
		
		/*
		16.Extract employee names from List<Employee>.
		*/
		
		List<String> empNames = employees.stream()
										 .map(e->e.getName())
										 .collect(Collectors.toList());
										 
		System.out.println("Employee Names: "+empNames);
		
		/*
		17.Extract employee salaries from List<Employee>.
		*/
		
		List<Double> empSalaries = employees.stream()
											.map(Employee::getSalary)
											.collect(Collectors.toList());
		
		System.out.println("Employee Salary:" +empSalaries);
		
		/*
		18.Add prefix "Mr." to each name.
		*/
		List<String> nameswithMr = names.stream()
										.map(s->"Mr."+s)
										.collect(Collectors.toList());
		System.out.println("Names with Mr.: "+nameswithMr);
		
		
		/*
		19.Get length of each string in list.
		*/
		
        List<Integer> lengths = names.stream()
                                     .map(String::length)
                                     .collect(Collectors.toList());

        System.out.println("Lengths: " + lengths);
		
		Map<String, Integer>  lengthofEachString = names.stream()
														.collect(Collectors.toMap(
														s->s,
														s->s.length()
														));
		System.out.println("Length of each Strings: "+lengthofEachString);
		
		
		/*
		20.Convert array to list using Stream.
		*/
		
		List<String> arraytoList = Arrays.stream(namesarray)
										 .collect(Collectors.toList());
		
		System.out.println("Arrays to List: "+arraytoList);
		
		
		//CATEGORY 3: Sorting Problems
		
		/*
		21.Sort numbers in ascending order.
		*/
		
		List<Integer> ascendingorder = numbers.stream()
											  .sorted()
											  .collect(Collectors.toList());
		
		System.out.println("Ascending order: "+ascendingorder);
		
		/*
		22.Sort numbers in descending order.
		*/
		
		List<Integer> descendingorder = numbers.stream()
											  .sorted(Comparator.reverseOrder())
											  .collect(Collectors.toList());
		
		System.out.println("Descending order: "+descendingorder);
		
		
		/*
		23.Sort strings alphabetically.
		*/
		
		List<String> alphabeticalNames = names.stream()
											  .sorted()
											  .collect(Collectors.toList());
											  
		System.out.println("Alphabetical order: "+alphabeticalNames);
		
		
		/*
		24.Sort strings by length.
		*/
		
		List<String> sortbyLength = names.stream()
										 .sorted(Comparator.comparing(String::length))
										 .collect(Collectors.toList());
		
		System.out.println("Sort By Length: "+sortbyLength);
		
		
		/*
		25.Sort employees by salary.
		*/
		
		List<Employee> sortBySalary = employees.stream()
											   .sorted(Comparator.comparing(Employee::getSalary))
											   .collect(Collectors.toList());
											   
		System.out.println("Sort By Employee Salary: "+sortBySalary);
											 
		
		/*
		26.Sort employees by name.
		*/
		
		List<Employee> sortByName = employees.stream()
											 .sorted(Comparator.comparing(Employee::getName))
											 .collect(Collectors.toList());
											   
		System.out.println("Sort By Employee Name: "+sortByName);
		
		
		/*
		27.Sort numbers and remove duplicates.'
		*/
		
		List<Integer> sortAndRemoveDuplicates = withduplicatenumbers.stream()
																	.sorted()
																	.distinct()
																	.collect(Collectors.toList());
																	
		
		System.out.println("Sorted and removed duplicates: "+sortAndRemoveDuplicates);
		
		
		/*
		28.Reverse sorted list.
		*/
		
		List<Integer> reversesortedList = sortAndRemoveDuplicates.stream()
														   .sorted(Comparator.reverseOrder())
														   .collect(Collectors.toList());
																	
		
		System.out.println("Reverse a sorted list: "+reversesortedList);
		
		/*
		29.Sort list without modifying original list.
		*/
		
		List<Integer> sortedlist = sortAndRemoveDuplicates.stream()
														   .sorted()
														   .collect(Collectors.toList());
																	
		
		System.out.println("Sorted List: "+sortedlist);
		System.out.println("Unsorted List: "+reversesortedList);
		
		
		/*
		30.Custom sort integers (like largest number formation logic – basic level).
		*/
		
		
		
		
		//CATEGORY 4: Terminal Operations
		
		/*
		31.Count total elements in list.
		*/
		
		long count = numbers.stream().count();
		System.out.println("Total Count: "+count);
		
		
		/*
		32.Count even numbers.
		*/
		
		long evennumberscount = numbers.stream()
								.filter(e->e%2==0)
								.count();
								
		System.out.println("Even numbers Count: "+evennumberscount);
		
		
		/*
		33.Find maximum number.
		*/
		
		int max = numbers.stream()
                 .max(Integer::compareTo)
                 .get();  

		System.out.println("Maximum: " + max);
		
		/*
		34.Find minimum number.
		*/
		
		int min = numbers.stream()
                 .min(Integer::compareTo)
                 .get();

		System.out.println("Minimum: " + min);
		
		/*
		35.Find first element.
		*/
		
		Optional<Integer> findFirstElement = numbers.stream()
													.findFirst();
		
		findFirstElement.ifPresent(first -> System.out.println("First element: " + first));
		
		
		/*
		36.Find first even number.
		*/
		
		Optional<Integer> findFirstEvenElement = numbers.stream()
													.filter(n->n%2==0)
													.findFirst();
		
		findFirstEvenElement.ifPresent(first -> System.out.println("First even no: " + findFirstEvenElement));
		
		
		/*
		37.Find any element from stream.
		*/
		
		Optional<Integer> findAnyElement = numbers.stream()
													.findAny();
		
		findAnyElement.ifPresent(first -> System.out.println("Find any no: " + findAnyElement));
		
		
		/*
		38.Check if all numbers are even.
		*/
		
		boolean allEven = numbers.stream()
                         .allMatch(n -> n % 2 == 0);

		System.out.println("All numbers are even? " + allEven);
		
		/*
		39.Check if any number is greater than 100.
		*/
		
		boolean anyGreaterThan100 = numbers.stream()
                                   .anyMatch(n -> n > 100);

		System.out.println("Any number > 100? " + anyGreaterThan100);
		
		/*
		40.Check if none of the numbers are negative.
		*/
		
		boolean noneNegative = numbers.stream()
                              .noneMatch(n -> n < 0);

		System.out.println("No negative numbers? " + noneNegative); 
		
		
		//CATEGORY 5: Basic Collectors
		
		/*
		41.Join list of strings with comma.
		*/
		
		String stringwithcomma = listofstring.stream()
											.collect(Collectors.joining(", "));
											
		System.out.println("String with Comma: "+stringwithcomma);
		
		
		/*
		42.Join list of strings with hyphen.
		*/
		
		String stringwithhypen = listofstring.stream()
											.collect(Collectors.joining("-"));
											
		System.out.println("String with hypen: "+stringwithhypen);
		
		
		/*
		43.Sum of all numbers in list.
		*/
		
		int sumvalue = numbers.stream()
							.collect(Collectors.summingInt(x->x));
							
		System.out.println("Sum Value: "+sumvalue);
		
		int sumvalue1 = numbers.stream()
								.mapToInt(Integer::intValue)
								.sum();
								
		System.out.println("Sum Value1: "+sumvalue1);
		
		
		/*
		44.Average of numbers in list.
		*/
		
		double avgvalue = numbers.stream()
							  .collect(Collectors.averagingDouble(x->x));
		
		System.out.println("Average Value: "+avgvalue);
		
		
		/*
		45.Find second highest number (basic way).
		*/
		
		Optional<Integer> secondlargetNumber = numbers.stream()
										.sorted(Comparator.reverseOrder())
										.skip(1)
										.findFirst();
								
		
		secondlargetNumber.ifPresent(n->System.out.println("Second Largest Number: "+n));
		
		
		/*
		46.Get distinct elements.
		*/
		
		List<Integer> distinctElements = withduplicatenumbers.stream()
															 .distinct()
															 .collect(Collectors.toList());
															 
		System.out.println("Distinct Elements: "+distinctElements);
		
		/*
		47.Convert list to Set.
		*/
		
		Set<Integer> listtoset = withduplicatenumbers.stream()
													 .collect(Collectors.toSet());
		
		System.out.println("List to Set: "+listtoset);
		
		
		/*
		48.Convert list to Map (id → name).
		*/
		
		Map<Integer,String> listtomap = names.stream()
											 .collect(Collectors.toMap(
											 s->s.length(),
											 s->s));
											 
		System.out.println("List to Map: "+listtomap);
		
		
		/*
		49.Partition numbers into even and odd.
		*/
		
		Map<Boolean, List<Integer>> partitionnumber = numbers.stream()
															 .collect(Collectors.partitioningBy(
																n->n%2==0));
																
		System.out.println("Partioning By Numbers into odd and even: "+partitionnumber);
		
		
		/*
		50.Group strings by their length.
		*/
		
		Map<Integer, List<String>> groupbylength = names.stream()
													    .collect(Collectors.groupingBy( s->s.length()));
														
		System.out.println("Group string by their length: "+groupbylength);
		
		
		
		
		//MEDIUM LEVEL QUESTIONS
		
		/*
		51.Find duplicate elements in a list.
		*/
		
		Set<Integer> duplicateElements = withduplicatenumbers.stream()
															 .collect(Collectors.groupingBy(
																n->n,
																Collectors.counting()))
															 .entrySet().stream()
															 .filter(e->e.getValue()>1)
															 .map(Map.Entry::getKey)
															 .collect(Collectors.toSet());
										
		System.out.println("Find Duplicate Element in a List: "+duplicateElements);
		
		
		/*
		52.Find first non-repeated character in a string.
		*/
		
		
		
		/*
		53.Find all numbers that appear more than once.
		*/
		
		List<Integer> appearmorethanonce = withduplicatenumbers.stream()
															   .collect(Collectors.groupingBy(
																	n->n,
																	Collectors.counting()))
															   .entrySet().stream()
															   .filter(e->e.getValue()>1)
															   .map(Map.Entry::getKey)
															   .collect(Collectors.toList());
										
		System.out.println("Find all numbers that appear more than once: "+appearmorethanonce);
		
		
		/*
		54.Remove duplicates but preserve insertion order.
		*/
		
		List<Integer> uniqueList = withduplicatenumbers.stream()
													  .distinct()
													  .collect(Collectors.toList());
													  
		System.out.println("Before Remove Duplicates: "+withduplicatenumbers);
		System.out.println("After Remove Duplicates: "+uniqueList);
										
															 
		/*
		55.Find elements occurring only once.
		*/
		
		List<Integer> occuronlyonce = withduplicatenumbers.stream()
														  .collect(Collectors.groupingBy(
															n->n,
															Collectors.counting()
														  ))
														  .entrySet().stream()
														  .filter(e->e.getValue()==1)
														  .map(Map.Entry::getKey)
														  .collect(Collectors.toList());
														  
		System.out.println("Elements occuring only once: "+occuronlyonce);
		
		/*
		56.Convert List<String> to Map<String, Integer> (string → length).
		*/
		
		Map<String,Integer> listtomapconversion = names.stream()
														.collect(Collectors.toMap(
														n->n,
														n->n.length()));
		
		System.out.println("Convert List to Map: "+listtomapconversion);		
		
		
		/*
		57.Convert List<Employee> to Map<Id, Name>.
		*/
		
		Map<Integer,String> convertListEmptoMap = employees.stream()
													  .collect(Collectors.toMap(
														n->n.getId(),
														n->n.getName()
													  ));
													  
		System.out.println("Convert List Emp to Map: "+convertListEmptoMap);	


		/*
		58.Handle duplicate keys while converting List to Map.
		*/
		
		Map<Integer,String> convertListEmptoMapHandleDupKey = employees.stream()
													  .collect(Collectors.toMap(
														n->n.getId(),
														n->n.getName(),
														(existing,newvalue) -> newvalue
													  ));
													  
		System.out.println("Convert List Emp to Map handle duplicate key: "+convertListEmptoMapHandleDupKey);
															
													
		/*
		59.Find top 3 highest numbers from a list.
		*/
		
		List<Integer> top3HighestNumbers = numbers.stream()
												  .sorted(Comparator.reverseOrder())
												  .limit(3)
												  .collect(Collectors.toList());
												  
		System.out.println("Find top 3 highest numbers from a list: "+top3HighestNumbers);
		
		
		/*
		60.Find second highest number using Stream.
		*/
		
		Integer secondHighest = numbers.stream()
									   .distinct()
                                       .sorted(Comparator.reverseOrder())
                                       .skip(1)
                                       .findFirst()
                                       .orElseThrow(() -> new RuntimeException("Not enough elements"));

		System.out.println("Second Highest: " + secondHighest);
		
		
		//CATEGORY 2: Grouping Problems
		
		/*
		61.Group employees by department.
		*/
		
		Map<String, List<Employee>> groupbydepartment = employees.stream()
																 .collect(Collectors.groupingBy(
																	emp->emp.getDepartment()
																	));
																	
		System.out.println("Group employees by department: "+groupbydepartment);
		
		
		/*
		62.Count employees in each department.
		63.Group employees by department and count.
		*/
		
		Map<String, Long> countempdepartment = employees.stream()
														   .collect(Collectors.groupingBy(
																emp->emp.getDepartment(),
																Collectors.counting()
														   ));
														   
		System.out.println("Count employees in each department: "+countempdepartment);												   
																
																		
		/*
		64.Group strings by length.
		*/
		
		Map<Integer, List<String>> groupstringbylength = names.stream()
														.collect(Collectors.groupingBy(
															n->n.length()
														));
														
		System.out.println("Group strings by length: "+groupstringbylength);	
		
		
		/*
		65.Group numbers by even/odd.
		*/
		
		Map<String, List<Integer>> groupevenodd = numbers.stream()
														 .collect(Collectors.groupingBy(
															n->n%2==0 ? "Even" : "Odd"
														 ));
														 
		System.out.println("Group numbers by even/odd: "+groupevenodd);	

		
		/*
		66.Partition employees based on salary > 50k.
		*/
		
		Map<Boolean, List<Employee>> partitionbyemp50k = employees.stream()
															.collect(Collectors.partitioningBy(
															e->e.getSalary()>50000
															));
															
		System.out.println("Partition employees based on salary > 50k: "+partitionbyemp50k);
		
		
		/*
		67.Group employees by department and list names.
		*/
		
		Map<String, List<String>> empnamesbydept = employees.stream()
															.collect(Collectors.groupingBy(
																Employee::getDepartment,
																Collectors.mapping(
																	Employee::getName,
																	Collectors.toList()
																)
															));
															
										
		System.out.println("Group employees by department and list names: "+empnamesbydept);
		
		
		/*
		68.Group employees by department and sum salaries.
		*/
		
		Map<String, Double> departmentsumsalary = employees.stream()
															.collect(Collectors.groupingBy(
																Employee::getDepartment,
																Collectors.summingDouble(Employee::getSalary)										
															));
															
		System.out.println("Group employees by department and sum salaries: "+departmentsumsalary);
		
		
		/*
		69.Group employees by department and average salary.
		*/
		
		Map<String, Double> departmentavgsalary = employees.stream()
															.collect(Collectors.groupingBy(
																Employee::getDepartment,
																Collectors.averagingDouble(Employee::getSalary)										
															));
															
		System.out.println("Group employees by department and average salary: "+departmentavgsalary);
		
		/*
		70.Group employees by designation  - refer Problem no 62, 63
		*/
		
		
		//CATEGORY 3: Aggregation Problems
		
		/*
		71.Find highest salary employee.
		*/
		
		Optional<Employee> highestSalary = employees.stream()
												.collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));
												
		highestSalary.ifPresent(n-> System.out.println("Highest Salaried Employee: "+n));
		
		/*
		72.Find lowest salary employee.
		*/
		
		Optional<Employee> lowestSalary = employees.stream()
												.collect(Collectors.minBy(Comparator.comparingDouble(Employee::getSalary)));
												
		lowestSalary.ifPresent(n-> System.out.println("Lowest Salaried Employee: "+n));
		
		
		/*
		73.Department-wise highest salary employee.
		*/
		
		Map<String, Optional<Employee>> deptwisehighestsalary = employees.stream()
																		.collect(Collectors.groupingBy(
																			Employee::getDepartment,
																			Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))
																		));
		
		System.out.println("Department-wise highest salary employee: "+deptwisehighestsalary);	
		
		
		/*
		74.Department-wise lowest salary employee.
		*/
		
		Map<String, Optional<Employee>> deptwiselowestsalary = employees.stream()
																		.collect(Collectors.groupingBy(
																			Employee::getDepartment,
																			Collectors.minBy(Comparator.comparingDouble(Employee::getSalary))
																		));
		
		System.out.println("Department-wise lowest salary employee: "+deptwiselowestsalary);	
		
		
		/*
		75.Department-wise total salary - - refer Problem no 68
		*/
		
		/*
		76.Find employee with max age.
		*/
		
		Optional<Employee> maxage = employees.stream()
											 .collect(Collectors.maxBy(Comparator.comparingInt(Employee::getAge)));
											 
		maxage.ifPresent(n->System.out.println("Employee with Max age: "+n));
		
		
		/*
		77.Find employee with min age.
		*/
		
		Optional<Employee> minage = employees.stream()
											 .collect(Collectors.minBy(Comparator.comparingInt(Employee::getAge)));
											 
		maxage.ifPresent(n->System.out.println("Employee with Min age: "+n));
		
		
		/*
		78.Find sum of all employee salaries.
		*/
		
		double sumallempsalary = employees.stream()
										  .collect(Collectors.summingDouble(Employee::getSalary));
											
		System.out.println("Sum of all Employee Salaries: "+sumallempsalary);
										
		
		/*
		79.Find average salary by department. - Refer prob no 69
		*/
		
		
		/*
		80.Find department having highest total salary.
		*/
		
		Map<String, Double> depthavinghigeshtsalary = employees.stream()
															   .collect(Collectors.groupingBy(
																	Employee::getDepartment,
																	Collectors.summingDouble(Employee::getSalary)
															   ));
															   
		System.out.println("Highest Salary: "+depthavinghigeshtsalary);
		
		Optional<Map.Entry<String, Double>> deptWithMaxSalary = depthavinghigeshtsalary.entrySet().stream()
        .max(Map.Entry.comparingByValue());

		deptWithMaxSalary.ifPresent(entry -> 
		System.out.println("Department with highest total salary: " + entry.getKey() + " -> " + entry.getValue()));
		
		
		//CATEGORY 4: Sorting & Comparator Logic
		
		/*
		81.Sort employees by salary ascending.
		*/
		
		List<Employee> salaryascending = employees.stream()
												  .sorted(Comparator.comparing(Employee::getSalary))
												  .collect(Collectors.toList());
												  
		System.out.println("Salary Ascending: "+salaryascending);
		
		/*
		82.Sort employees by salary descending.
		*/
		
		List<Employee> salarydescending = employees.stream()
												  .sorted(Comparator.comparing(Employee::getSalary).reversed())
												  .collect(Collectors.toList());
												  
		System.out.println("Salary Descending: "+salarydescending);
		
		/*
		83.Sort employees by department then salary.
		*/
		
		List<Employee> sortingdeptthensalary = employees.stream()
														.sorted(Comparator.comparing(Employee::getDepartment)
																.thenComparing(Employee::getSalary)
														)
														.collect(Collectors.toList());
														
		System.out.println("Sort employees by department then salary: "+sortingdeptthensalary);
		
		
		
		/*
		84.Sort employees by salary descending then name ascending.
		*/
		
		List<Employee> sortsalarydesthenname = employees.stream()
														.sorted(Comparator.comparing(Employee::getSalary)
																.reversed()
																.thenComparing(Employee::getName)
																)
														.collect(Collectors.toList());
														
		System.out.println("Sort employees by salary descending then name ascending: "+sortsalarydesthenname);
		
		
		/*
		85.Sort map by values.
		*/
		
		Map<String, Integer> sortedvaluesmap = mapdata.entrySet().stream()
													  .sorted(Map.Entry.comparingByValue())
													  .collect(Collectors.toMap(
															Map.Entry::getKey,
															Map.Entry::getValue,
															(e1, e2) -> e1,
															LinkedHashMap::new
													  )
													  );
													  
		System.out.println("Sort map by values: "+sortedvaluesmap);
		
		
		/*
		86.Sort map by keys.
		*/
		
		Map<String, Integer> sortedkeysmap = mapdata.entrySet().stream()
													  .sorted(Map.Entry.comparingByKey())
													  .collect(Collectors.toMap(
															Map.Entry::getKey,
															Map.Entry::getValue,
															(e1, e2) -> e1,
															LinkedHashMap::new
													  )
													  );
													  
		System.out.println("Sort map by keys: "+sortedkeysmap);
		
		/*
		87.Sort list based on custom condition (even first, then odd).
		*/
		
		List<Integer> sortlistevenodd = numbers.stream()
												.sorted(Comparator.comparingInt(n->n%2))
												.collect(Collectors.toList());
												
		System.out.println("Sort list based on custom condition (even first, then odd): "+sortlistevenodd);
		
		
		/*
		88.Sort list by string length descending.
		*/
		
		List<String> sortliststringdesc = names.stream()
											   .sorted(Comparator.comparing(String::length).reversed())
											   .collect(Collectors.toList());
											   
		System.out.println("Sort list by string length descending: "+sortliststringdesc);
		
		
		/*
		89.Sort employees by multiple fields.  - Refer prob no 84.
		*/
		
		/*
		90.Sort numbers based on frequency.
		*/
		
		Map<Integer, Long> freqMap = frequencylist.stream()
												  .collect(Collectors.groupingBy(n -> n, Collectors.counting()));

		List<Integer> sortedvalue = frequencylist.stream()
											.sorted(Comparator.comparingLong(freqMap::get))
											.collect(Collectors.toList());
											
		System.out.println("Sort numbers based on frequency: "+sortedvalue);
		
		
		//CATEGORY 5: flatMap & Complex Transformations
		
		/*
		91.Flatten List<List<Integer>> into List<Integer>.
		*/
		
		List<Integer> flatternlist = listOfLists.stream()
												.flatMap(List::stream)
												.collect(Collectors.toList());
												
		System.out.println("Flatten List<List<Integer>> into List<Integer>: "+flatternlist);
		
		
		/*
		92.Flatten list of employees' phone numbers.
		*/
		
		List<String> flatternmobno = persons.stream()
											 .flatMap(p->p.getPhoneNumbers().stream())
											 .collect(Collectors.toList());
											 
		System.out.println("Flatten list of employees' phone numbers: "+flatternmobno);
		
		
		/*
		93.Convert List<Employee> → Map<Dept, List<Employee>>.
		*/
		
		Map<String, List<Employee>> empmap = employees.stream()
													  .collect(Collectors.groupingBy(
														Employee::getDepartment
													  ));
													  
		System.out.println("Convert List<Employee> → Map<Dept, List<Employee>>: "+empmap);									
													  
													
		/*
		94.Convert List<Employee> → Map<Dept, List<String>> (only names).
		*/
		
		Map<String, List<String>> empnamesdeptmap = employees.stream()
															 .collect(Collectors.groupingBy(
																	Employee::getDepartment,
																	Collectors.mapping(Employee::getName,Collectors.toList())
															 ));
															 
		System.out.println("Convert List<Employee> → Map<Dept, List<String>> (only names): "+empnamesdeptmap);
		
		
		/*
		95.Convert nested object structure into flat list.
		*/
		
		List<Employee> flatEmployeeList = company.getDepartments().stream()
												 .flatMap(dept -> dept.getEmployees().stream())
								                 .collect(Collectors.toList());

		System.out.println("Convert nested object structure into flat list: "+flatEmployeeList);
		
		
		/*
		96.Merge two lists using Stream.
		*/

		List<Integer> mergedList = Stream.concat(list1.stream(), list2.stream())
										 .collect(Collectors.toList());

		System.out.println("Merge two lists using Stream: "+mergedList);
		
		
		/*
		97.Find common elements between two lists.
		*/
		
		List<Integer> commonelements = list1.stream()
											.filter(list2::contains)
											.collect(Collectors.toList());
											
		System.out.println("Find common elements between two lists: "+commonelements);
		
		
		/*
		98.Find union of two lists.
		*/
		
		List<Integer> unionDistinct = Stream.concat(list1.stream(), list2.stream())
											.distinct()
											.collect(Collectors.toList());

		System.out.println("Union (distinct): " + unionDistinct);
		
		
		/*
		99.Find intersection of two lists.
		*/
		
		List<Integer> intersection = list1.stream()
										  .filter(list2::contains)
									      .collect(Collectors.toList());

		System.out.println("Intersection: " + intersection);
		
		
		/*
		100.Transform list into custom DTO using map().
		*/
		
		List<EmployeeDTO> empDto = employees.stream()
											.map(emp -> new EmployeeDTO(emp.getName(),emp.getSalary()))
											.collect(Collectors.toList());
											
		System.out.println("Transform list into custom DTO using map(): "+empDto);
		
		
		/*
		101.Retrieve Employee whose department is HR.
		*/
		
		List<Employee> retrieveempdepthr = employees.stream()
													.filter(emp->emp.getDepartment().equals("HR"))
													.collect(Collectors.toList());
													
		System.out.println("Retrieve Employee whose department is HR: "+retrieveempdepthr);
		
		/*
		102.Implement Min and Max functions on an Integer array using the Java Stream API.
		*/
		
		Integer[] arrnumbers = {10, 5, 20, 8, 30};
		
		int minvalue = Arrays.stream(arrnumbers)
						.mapToInt(Integer::intValue)
						.min()
						.orElseThrow();

		int maxvalue = Arrays.stream(arrnumbers)
						.mapToInt(Integer::intValue)
						.max()
						.orElseThrow();

		System.out.println("Min: " + minvalue);
		System.out.println("Max: " + maxvalue);
		
		
		/*
		103.How would you find the sum of the squares of all even numbers in a list using Java 8 streams
		*/
		
		List<Integer> sumofsquare = numbers.stream()
										   .filter(n->n%2==0)
										   .map(n->n*n)
										   .collect(Collectors.toList());
										   
		System.out.println("Sum of the Square of all even numbers: "+sumofsquare);
		
		
		/*
		104.Given a list of employees, how would you find the average salary by age range (e.g., 18-25) using Java 8 streams?
		*/
		
		double averagesalaryagerange = employees.stream()
												.filter(e->e.getAge()>=18 && e.getAge()<=25)
												.collect(Collectors.averagingDouble(Employee::getSalary));
		
		System.out.println("Average salary by age range: "+averagesalaryagerange);
		
		
		/*
		105.Given a list of employees, how would you accomplish the following using Java streams: group employees by salary, find the maximum or minimum salary in each department, calculate the sum of salaries in each department, print all employees belonging to a specific department, and count the number of employees in a particular group?
		*/
		
		Map<Double,List<Employee>> empbysalary = employees.stream()
											  .collect(Collectors.groupingBy(Employee::getSalary));
											  
		System.out.println("Employee by salary: "+empbysalary);
		
		
		Map<String, Double> deptMaxSalary = employees.stream()
													 .collect(Collectors.groupingBy(
														Employee::getDepartment,
														Collectors.collectingAndThen(
															Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)),
															opt -> opt.map(Employee::getSalary).orElse(0.0)
                )
        ));

		System.out.println("Maximum Salary in each departement: "+deptMaxSalary);
		
		
		Map<String, Double> deptMinSalary = employees.stream()
													 .collect(Collectors.groupingBy(
														Employee::getDepartment,
														Collectors.collectingAndThen(
															Collectors.minBy(Comparator.comparingDouble(Employee::getSalary)),
															opt -> opt.map(Employee::getSalary).orElse(0.0)
                )
        ));

		System.out.println("Minimum Salary in each departement: "+deptMinSalary);
		
		Map<String, Double> sumofsalarydept = employees.stream()
													   .collect(Collectors.groupingBy(
															Employee::getDepartment,
															Collectors.summingDouble(Employee::getSalary)
													   ));
													   
		System.out.println("Sum of Salary in each departement: "+sumofsalarydept);
		
		List<Employee> employeebelongsto = employees.stream()
													.filter(emp->emp.getDepartment().equals("HR"))
													.collect(Collectors.toList());
												 
		System.out.println("Employee belongs to: "+employeebelongsto);
		System.out.println("Employee count: "+employeebelongsto.size());
	}
}

class Employee {
		private int id;
		private String name;
		private String department;
		private double salary;
		private String email;
		private long mobileno;
		private int age;
	
		// Constructor
		public Employee(int id, String name, String department, double salary, String email, long mobileno, int age) {
			this.id = id;
			this.name = name;
			this.department = department;
			this.salary = salary;
			this.email = email;
			this.mobileno = mobileno;
			this.age=age;
		}
	
		// Getters and Setters
		public int getId() { return id; }
		public void setId(int id) { this.id = id; }
	
		public String getName() { return name; }
		public void setName(String name) { this.name = name; }
	
		public String getDepartment() { return department; }
		public void setDepartment(String department) { this.department = department; }
	
		public double getSalary() { return salary; }
		public void setSalary(double salary) { this.salary = salary; }
	
		public String getEmail() { return email; }
		public void setEmail(String email) { this.email = email; }
	
		public long getMobileno() { return mobileno; }
		public void setMobileno(long mobileno) { this.mobileno = mobileno; }
		
		public int getAge() { return age; }
		public void setAge(int age) { this.age = age; }
	
		// toString method
		@Override
		public String toString() {
			return "Employee{" +
					"id=" + id +
					", name='" + name + '\'' +
					", department='" + department + '\'' +
					", salary=" + salary +
					", email='" + email + '\'' +
					", mobileno=" + mobileno +
					", age=" + age +
					'}';
		}
}		


class Person {
    private String name;
    private List<String> phoneNumbers;

    public Person(String name, List<String> phoneNumbers) {
        this.name = name;
        this.phoneNumbers = phoneNumbers;
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }
}

class Department {
    private String name;
    private List<Employee> employees;

    public Department(String name, List<Employee> employees) {
        this.name = name;
        this.employees = employees;
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}

class Company {
    private List<Department> departments;

    public Company(List<Department> departments) {
        this.departments = departments;
    }

    public List<Department> getDepartments() {
        return departments;
    }
}

class EmployeeDTO {
    private String name;
    private double salary;

    public EmployeeDTO(String name, double salary){
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString(){ return name + " - " + salary; }
}