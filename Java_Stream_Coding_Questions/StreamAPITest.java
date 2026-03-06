
import java.util.*;
import java.util.stream.*;

public class StreamAPITest{

	public static void main(String args[]){
		
		
		List<Integer> numbers = Arrays.asList(10, 20, 10, 30, 40, 20, 50,33,44,55);
		List<String> names = Arrays.asList("Arun", "Bala", "Anu", "David", "Ajay");
		List<Integer> numbers1 = Arrays.asList(5, 1, 9, 3, 14, 9, 7);
		List<String> words = Arrays.asList("apple", "bat", "car", "elephant", "dog","app","cat","flower","goat");
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
		
		List<String> stringelement = Arrays.asList("A", "B", "A", "C", "D","B","C","F","G","I","C","D","A","R","Z","W");
		List<Integer> numberselement = Arrays.asList(10, 20, 10, 30, 40, 20, 50,10,30,40,50,1,3,4,5,7,3,8,12,4,3,2,9,40,3,3);
		
		int[] arr = {1,2,3,4,5};
		int[] arr1 = {10, 5, 20, 8, 15};
		int[] arr2 = {2,5,8,11,14,17};
		int[] duparray = {1,2,2,3,4,4,5};
		int[] sortarray = {7,2,9,1,5};
		int[] missingarray = {2,3,1,6,4};
		int[] rangenos = {5,12,18,50,65,42,33};
		int[] oddfreq = {1,2,3,2,3,1,3,4,4};
		String[] arraywords ={"apple", "bat", "car", "elephant", "dog","app","cat","flower","goat"};
		String[] dupstringarr = {"apple","banana","apple","orange","banana","grape"};
		String[] highestarr = {"java","springboot","microservices","api"};
		
	
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
		
		//03-03-2026
		
		//11. Return a list conitaing only even numbers from a list of intergers.
		
		System.out.println("11. "+numbers.stream().filter(n->n%2==0).toList());
		
		//12. Find the maximum value in a list of intergers
		
		System.out.println("12. "+numbers.stream().max(Integer::compare));
		System.out.println("12. "+numbers.stream().sorted(Comparator.reverseOrder()).findFirst());
		System.out.println("12. "+numbers.stream().max(Comparator.comparing(Integer::intValue)));
		
		//13. Convert list of string to upper case
		
		System.out.println("13. "+words.stream().map(String::toUpperCase).toList());
		
		//14. Filter strings starting with the letter A using java 8
		
		System.out.println("13. "+names.stream().filter(a->a.startsWith("A")).toList());
		
		//15. Remove Duplicates from the list using java 8
		
		System.out.println("14. "+numbers.stream().distinct().toList());
		
		//16. Sort a list of integers in ascending order
		
		System.out.println("15. "+numbers1.stream().sorted().toList());
		
		
		//17. Sort a list of integers in descending order
		
		System.out.println("15. "+numbers1.stream().sorted(Comparator.reverseOrder()).toList());
		
		//18. Count the number of strings with elength greater thatn 3 using java 8.
		
		System.out.println("16. "+names.stream().filter(s->s.length()>3).count());
		
		//19. Join a list of string with a comma using java 8
		
		System.out.println("17. "+names.stream().collect(Collectors.joining(", ")));
		
		//20. Convert list of integers to set using java 8
		
		System.out.println("18. "+numbers.stream().collect(Collectors.toSet()));
		
		//21. Find the first element of a list using java 8
		
		System.out.println("19. "+numbers.stream().findFirst());
		System.out.println("19. "+names.stream().findFirst());
		
		//22. Find sum of all integers in a list
		
		System.out.println("20. "+numbers.stream().mapToInt(Integer::intValue).sum());
		System.out.println("20. "+numbers.stream().collect(Collectors.summingInt(n->n)));
		
		
		//23. Count elements in a list that are greater than 5
		
		System.out.println("23. "+numberselement.stream().filter(n->n>5).count());
		
		//24. Retrieve all distinct elements from a list
		
		System.out.println("24. "+numbers.stream().distinct().toList());
		
		//25. skip the first two elements of a list and return the rest.
		
		System.out.println("25. "+numbers.stream().skip(2).toList());
		
		//26. Group elements by a specific property such as age.
		
		System.out.println("26. "+employees.stream().collect(Collectors.groupingBy(Employee::getAge)));
		
		//27. Find the lowest and highest number in a stream using summary statictics
		
		IntSummaryStatistics stats = numbers.stream()
                                            .mapToInt(Integer::intValue)
                                            .summaryStatistics();

        System.out.println("27. Lowest number: " + stats.getMin());
        System.out.println("27. Highest number: " + stats.getMax());
		
		//28. Create a Map of even and odd numbers using stream.
		
		System.out.println("28.  "+numbers.stream().collect(Collectors.groupingBy(
															n->n%2==0 ? "Even" : "Odd"
														)));
		
		//29.Find the Nth highest salary or age from a List
		
		System.out.println("29. "+employees.stream()
										   .map(Employee::getSalary)
								           .distinct()
								           .sorted(Comparator.reverseOrder())
								           .skip(2)
								           .findFirst());
										   
		System.out.println("29. "+employees.stream()
										   .map(Employee::getAge)
								           .distinct()
								           .sorted(Comparator.reverseOrder())
								           .skip(2)
								           .findFirst());
		
		
		//30. Sort employees by name, age or salary using comparator and lambdas
		
		System.out.println("30. "+employees.stream().sorted(Comparator.comparing(Employee::getName)).toList());
		
		
		
		//31. Filter employees based on department, experience or salary range
		
		System.out.println("31. "+employees.stream().filter(e -> e.getDepartment().equalsIgnoreCase("IT")).toList());
		System.out.println("31. "+employees.stream().filter(e -> e.getSalary() >= 30000 && e.getSalary() <= 60000).toList());
		
		
		//04-03-2026
		
		//31. Sum of Array Elements
		
		System.out.println("31. "+Arrays.stream(arr).sum());
		
		//32.Find Maximum Element
		
		System.out.println("32 "+Arrays.stream(arr).max());
		
		//33.Find Minimum Element
		
		System.out.println("33 "+Arrays.stream(arr).min());
		
		//34.Count Even Numbers
		
		System.out.println("34 "+Arrays.stream(arr1).filter(n->n%2==0).count());
		
		//35.Square Each Element
		
		
		System.out.println("35. " +Arrays.toString(
											Arrays.stream(arr)
												  .map(n -> n * n)
												  .toArray()
											)
						  );
						  
		//36. Remove Duplicates
		
		System.out.println("36. "+Arrays.toString(
											Arrays.stream(duparray).distinct().toArray()
						
						  ));
	
		//37. Sort Array Ascending
		
		System.out.println("37. "+Arrays.stream(arr2).boxed().sorted().toList());
		
		//38.Sort Array Descending
		
		System.out.println("38. "+Arrays.stream(arr2).boxed().sorted(Comparator.reverseOrder()).toList());
		
		//39.Find Second Largest Number
		
		System.out.println("39. "+Arrays.stream(arr1).distinct().boxed().sorted(Comparator.reverseOrder()).skip(1).findFirst());
		
		//40.Find Sum of Even Numbers
		
		System.out.println("40. "+Arrays.stream(arr).filter(n->n%2==0).sum());
		
		//41.Find Average of Numbers
		
		System.out.println("41. "+Arrays.stream(arr).average());
		
		//42.Find Numbers Greater Than 10
		
		System.out.println("42. "+Arrays.toString(Arrays.stream(arr1).filter(n->n>10).toArray()));

		//43.Find First Element Greater Than 10
		
		System.out.println("43. "+Arrays.stream(arr1).filter(n->n>10).findFirst());
		
		//44.Convert int[] → List<Integer>
		
		System.out.println("44. "+Arrays.stream(arr1).boxed().toList());
		System.out.println("44. "+Arrays.stream(arr1).boxed().collect(Collectors.toList()));
		
		//45.Find Top 3 Largest Numbers
		
		System.out.println("45. "+Arrays.stream(arr1).distinct().boxed().sorted(Comparator.reverseOrder()).limit(3).toList());
		
		//46.Partition Even and Odd
		
		System.out.println("46. "+Arrays.stream(arr2).boxed().collect(Collectors.groupingBy(
																			n->n%2==0 ? "Even" :"Odd")));
																			
		//47.Find Duplicate Numbers

		System.out.println("47. "+Arrays.stream(duparray).boxed()
														.collect(Collectors.groupingBy(
																n->n,
																Collectors.counting()
														))
														.entrySet().stream()
														.filter(e->e.getValue()>1)
														.map(Map.Entry::getKey)
														.toList()
						  );
						  
		//48.Find Missing Number
		
		Set<Integer> set = Arrays.stream(missingarray).boxed().collect(Collectors.toSet());
		
		System.out.println("48. "+IntStream.rangeClosed(1,6).filter(i-> !set.contains(i)).boxed().toList());
		
		
		
		//49.Find Frequency of Elements
		
		System.out.println("49. "+Arrays.stream(duparray).boxed()
														.collect(Collectors.groupingBy(
																n->n,
																Collectors.counting()
														))
												
						  );
		
		//50.Find First Non-Repeating Element
		
		System.out.println("50. "+Arrays.stream(duparray).boxed()
														.collect(Collectors.groupingBy(
																n->n,
																LinkedHashMap::new,
																Collectors.counting()
														))
														.entrySet().stream()
														.filter(e->e.getValue()==1)
														.map(Map.Entry::getKey)
														.findFirst()
						  );
						  
		//05-03-2026
		
		//51.Find All Numbers Appearing More Than Once
		
		System.out.println("51. "+Arrays.stream(duparray).boxed()
														.collect(Collectors.groupingBy(
																n->n,
																LinkedHashMap::new,
																Collectors.counting()
														))
														.entrySet().stream()
														.filter(e->e.getValue()>1)
														.map(Map.Entry::getKey)
														.toList()
						  );
		
		//52.Find Sum of Squares of Even Numbers
		
		System.out.println("52. "+Arrays.stream(arr1).filter(n->n%2==0).map(n->n*n).sum());
		
		//53.Find Numbers Between Range (10–50)
		
		System.out.println("53. "+Arrays.stream(rangenos).boxed().filter(n-> n>=10 && n<=50).toList());
		
		
		//54.Find the Product of All Elements
		
		System.out.println("54. "+Arrays.stream(arr).reduce(1,(a,b) -> a*b));
		
		//55.Find Numbers Divisible by 3 and 5
		
		System.out.println("55. "+Arrays.stream(rangenos).filter(n->n%3==0 && n%5==0).boxed().toList());
		System.out.println("55. "+Arrays.stream(rangenos).boxed().collect(Collectors.partitioningBy(n -> n % 3 == 0 && n % 5 == 0)));
		System.out.println("55. "+Arrays.stream(rangenos)
										.boxed()
										.collect(Collectors.groupingBy(n -> {
											if (n % 3 == 0 && n % 5 == 0) return "Divisible by 3 and 5";
											else if (n % 3 == 0) return "Divisible by 3";
											else if (n % 5 == 0) return "Divisible by 5";
											else return "Others";
										})));
		
		//56. Find Numbers With Odd Frequency
		
		System.out.println("56. "+Arrays.stream(oddfreq).boxed()
														.collect(Collectors.groupingBy(
																n->n,
																LinkedHashMap::new,
																Collectors.counting()
														))
														.entrySet().stream()
														.filter(e->e.getValue()%2!=0)
														.map(Map.Entry::getKey)
														.toList()
						  );
		
		//57.Find Sum of Unique Elements Only
		
		System.out.println("57. "+Arrays.stream(duparray).boxed()
														.collect(Collectors.groupingBy(
																n->n,
																LinkedHashMap::new,
																Collectors.counting()
														))
														.entrySet().stream()
														.filter(e->e.getValue()==1)
														.map(Map.Entry::getKey)
														.mapToInt(Integer::intValue)
														.sum()
						  );
		
		//58.Find all employees whose names contain the letter ‘a’ (case-insensitive) and sort them by salary descending.
		
		System.out.println("58. "+employees.stream().filter(e->e.getName().toLowerCase().startsWith("a"))
												    .sorted(Comparator.comparing(Employee::getSalary).reversed())
													.toList()					
						  );
						  
		//59.Find the sum of squares of all odd numbers in a list of integers.
		
		System.out.println("59. "+Arrays.stream(arr1).filter(n->n%2!=0).map(n->n*n).sum());
		
		//60.Group words by their first character and count how many words start with each letter.
		
		System.out.println("60. "+Arrays.stream(arraywords).collect(Collectors.groupingBy(e->e.charAt(0),Collectors.counting())));
		
		
		//06-03-2026
		
		//61.Find Duplicate Words
		
		System.out.println("61. "+Arrays.stream(dupstringarr)
														.collect(Collectors.groupingBy(
																n->n,
																LinkedHashMap::new,
																Collectors.counting()
														))
														.entrySet().stream()
														.filter(e->e.getValue()>1)
														.map(Map.Entry::getKey)
														.toList()
						  );
						  
		//62. Count Words Starting With a Vowel
		
		System.out.println("62. "+Arrays.stream(dupstringarr).filter(word->{
															char ch = Character.toLowerCase(word.charAt(0));
															return ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u';
															})
															.count());
															
		//63.Convert All Words to Uppercase
		
		System.out.println("63. "+Arrays.stream(dupstringarr).map(String::toUpperCase).toList());
		
		//64.Find Longest Word
		
		System.out.println("64. "+Arrays.stream(highestarr).max(Comparator.comparing(String::length)));
		
		//65.Group Words by Length
		
		System.out.println("65. "+Arrays.stream(highestarr).collect(Collectors.groupingBy(String::length)));
		
		//66.Find Frequency of Each Word
		
		System.out.println("66. "+Arrays.stream(highestarr).collect(Collectors.groupingBy(
																	n->n,
																	Collectors.counting()
																	))
																	);
																	
		//67.Find First Non-Repeating Word

		System.out.println("67. "+Arrays.stream(dupstringarr).collect(Collectors.groupingBy(
																		n->n,
																		LinkedHashMap::new,
																		Collectors.counting()
																	 ))
																	 .entrySet().stream()
																	 .filter(e->e.getValue()==1)
																	 .map(Map.Entry::getKey)
																	 .findFirst()
																	 );
																	 
		//68.Flatten Words Into Characters
		
		System.out.println("68. "+Arrays.stream(highestarr).flatMap(word -> word.chars().mapToObj(c -> (char) c)).toList());
		
		//69.Find Top 2 Longest Words
		
		System.out.println("69. "+Arrays.stream(highestarr).sorted(Comparator.comparing(String::length).reversed()).limit(2).toList());
		
		//70.Join Words With Comma
		
		System.out.println("70. "+Arrays.stream(highestarr).collect(Collectors.joining(",")));
		
		
		
	}
}