import java.util.*;
import java.util.stream.*;

/*
1. Flatten a List<List<Integer>> into a single List<Integer>.
2. Split each sentence on spaces and collect all words into a flat list.
3. Extract all unique characters from a list of strings (as a sorted list).
4. Unwrap a list of Optional<Integer> and collect only present values.
5. Given a list of Orders (each having a list of items), collect all item names into one list
6. Count the total number of words across all sentences
7. Find all distinct words that appear across a list of sentences.
8. Sum all integers nested inside a list of int arrays using flatMapToInt().
9. Flatten sublists of words and compute the frequency of each word across all sublists.
10. For each department and its employees, produce a flat list of "Dept:Employee" strings.
*/



public class July26{
	
	public static void main(String args[]){
		
		
		List<List<Integer>> listoflist = Arrays.asList(
													Arrays.asList(1,2),
													Arrays.asList(3,4,5),
													Arrays.asList(6,7,8),
													Arrays.asList(9,10)
													);
		
		
		System.out.println("1. "+listoflist.stream().flatMap(List::stream).toList());
		
		
		List<String> sentences = Arrays.asList("Java Streams", "Hello World", "Flatmap Example");
		
		System.out.println("2. "+sentences.stream().flatMap(sentence->Arrays.stream(sentence.split(" "))).toList()
													);
		
		
		List<String> words = Arrays.asList("abc","bcd","cde");
		
		
		System.out.println("3. "+words.stream().flatMap(word->word.chars().mapToObj(c->(char)c)).distinct().sorted().toList());
		
		
		List<Optional<Integer>> numbers = Arrays.asList(
														Optional.of(10),
														Optional.empty(),
														Optional.of(20),
														Optional.of(30),
														Optional.empty()
													);

		System.out.println("4. "+
			numbers.stream()
				.flatMap(Optional::stream)
				.collect(Collectors.toList())
		);
		
		List<Order> listoforders = Arrays.asList(
												new Order("1", Arrays.asList("pen","pencil")),
												new Order("2", Arrays.asList("eraser","sharpner")),
												new Order("3", Arrays.asList("scale","notes"))
												);
		
		System.out.println("5. "+listoforders.stream().flatMap(order -> order.getItems().stream()).toList());
		
		System.out.println("6. "+sentences.stream().flatMap(s -> Arrays.stream(s.split(" "))).collect(Collectors.counting()));
		
		
		List<String> letters = Arrays.asList("the cat sat on the mat", "the dog sat on the log");
		
		System.out.println("7. "+letters.stream().flatMap(s->Arrays.stream(s.split(" "))).distinct().toList());
		
		List<int[]> arrs = Arrays.asList(new int[] {1,2,3}, new int[] {4,5});
		
		System.out.println("8. "+arrs.stream().flatMapToInt(arr -> Arrays.stream(arr)).sum());
		
		List<List<String>> all = Arrays.asList(
								Arrays.asList("apple","banana"),
								Arrays.asList("cherry","apple"),
								Arrays.asList("banana","date"));
								
		System.out.println("9. "+all.stream().flatMap(List::stream).collect(Collectors.groupingBy(
																							word->word,
																							Collectors.counting())));
																							
		List<Employee> emp = Arrays.asList(
											new Employee(1, "Yeshwanth", 25000, 27,"Developer"),
											new Employee(2, "Vishal", 30000, 26,"QA"),
											new Employee(3, "Gokul", 40000, 29,"Manager"),
											new Employee(4, "Kumar", 26000, 27,"Developer")
			
										  );
										  
		System.out.println("10. "+emp.stream().map(e -> e.getDepartment() + ":" + e.getName()).toList());

		
	}
}

class Order{
	
	String id;
	List<String> items;
	
	
	public Order(String id, List<String> items){
		this.id = id;
		this.items = items;
	}
	
	public String getId(){
		return id;
	}
	
	public void setId(String id){
		this.id =id;
	}
	
	public List<String> getItems(){
		return items;
	}
	
	public void setIterms(List<String> items){
		this.items=items;
	}
	
	public String toString(){
			
		return "Order = {Id= "+ getId() + ", Orders= " +getItems()+" }";
	
	}
	









}