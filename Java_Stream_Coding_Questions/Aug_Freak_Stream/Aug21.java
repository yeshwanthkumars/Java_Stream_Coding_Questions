import java.util.*;
import java.util.stream.*;


/*
1. Given a list of names, return names beginning with the letter A, preserving input order.
Sample Input
["Alex","John","Andrew","David","Anita","Sam"]
Sample Output
["Alex","Andrew","Anita"]


2. Given a sentence, return distinct words in case-insensitive alphabetical order.
Sample Input
"Java stream Java API stream collection"
Sample Output
["api","collection","java","stream"]


3. Given a list of integers, return the frequency of each number. Output entries in ascending key order.
Sample Input
[4,2,4,3,2,4,5,3]
Sample Output
{2=2, 3=2, 4=3, 5=1}


4. Given a string containing lowercase letters, return the first character that occurs exactly once. Return NONE if no such character exists.
Sample Input
"swiss"
Sample Output
w


5. Given a sentence containing lowercase words separated by spaces, return the word with the highest frequency. If multiple words tie, return the lexicographically smallest one.
Sample Input
"java spring java kafka spring java kafka"
Sample Output
java





*/


public class Aug21{
	
	public static void main(String args[]){
		
		
		
		List<String> names = Arrays.asList("Alex","John","Andrew","David","Anita","Sam");
		
		System.out.println("1. "+names.stream().filter(s->s.startsWith("A")).toList());
		
		
		String sentence = "Java stream Java API stream collection";
		
		System.out.println("2. "+Arrays.stream(sentence.toLowerCase().split(" ")).distinct().sorted().toList());
		
		List<Integer> numbers = Arrays.asList(4,2,4,3,2,4,5,3);
		
		System.out.println("3. "+numbers.stream().collect(Collectors.groupingBy(
																				s->s,
																				Collectors.counting())));
																				
		String word = "swiss";
		
		System.out.println("4. "+word.chars().mapToObj(c->(char) c).collect(
																			Collectors.groupingBy(
																			c->c, 
																			LinkedHashMap::new,
																			Collectors.counting())
																			)
																			.entrySet()
																			.stream()
																			.filter(e->e.getValue()==1)
																			.map(Map.Entry::getKey)
																			.findFirst()
																			.orElse(null)
																			
																			);
		
		
		String sentence2 = "java spring java kafka spring java kafka";
		
		System.out.println("5. "+Arrays.stream(sentence2.split(" ")).collect(
																				Collectors.groupingBy(
																				w->w,
																				Collectors.counting()
																				))
																				.entrySet()
																				.stream()
																				.sorted(Map.Entry.<String, Long>comparingByValue()
																						.reversed()
																						.thenComparing(Map.Entry.comparingByKey())
																				)
																				.map(Map.Entry::getKey)
																				.findFirst()
																				.orElse("NONE")
																				);
																			
		
		
		
		
	}
}