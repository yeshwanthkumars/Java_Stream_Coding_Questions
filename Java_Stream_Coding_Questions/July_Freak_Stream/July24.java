import java.util.*;
import java.util.stream.*;
import java.util.function.Function;

/*
1. Filter even numbers and collect them into an ArrayList
2. Collect elements from a list with duplicates into a Set (removes duplicates).
3. Join a list of strings with a ", " delimiter.
4. Join strings with delimiter ", " and wrap with prefix "[" and suffix "]".
5. Create a Map<String, Integer> mapping each word to its length.
6. Collect statistics (count, sum, min, max, avg) for a list of integers.
7. Sort numbers and collect into an unmodifiable List
8. Collect a list of words to a Map<String,Integer> (word → length). When two words share the same key, keep the first.
9. Sort words alphabetically and collect to a LinkedHashMap preserving insertion order.
10. Collect a list to a List, then wrap it as unmodifiable using collectingAndThen().
*/


public class July24{
	
	public static void main(String args[]){
		
		
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		
		System.out.println("1. "+numbers.stream().filter(n->n%2==0).toList());
		
		
		List<Integer> withduplicates = Arrays.asList(1,2,3,2,1,4,6,5,3,7,8,9,10,8,9,7);
		
		
		System.out.println("2. "+withduplicates.stream().sorted().collect(Collectors.toSet()));
		
		List<String> names = Arrays.asList("Java", "is", "a", "Programming Language");
		
		System.out.println("3. "+names.stream().collect(Collectors.joining(", ")));
		
		System.out.println("4. "+names.stream().collect(Collectors.joining(", ","[", "]")));
		
		
		System.out.println("5. "+names.stream().collect(Collectors.toMap(
																Function.identity(),
																s->s.length())));
																
		IntSummaryStatistics statistics = numbers.stream().collect(Collectors.summarizingInt(Integer::intValue));
		
		System.out.println("6. "+
							
							"1.Count: "+statistics.getCount()+ ", " +
							"2.Sum: "+statistics.getSum()+ ", " +
							"3.Min: "+statistics.getMin()+ ", " +
							"4.Max: "+statistics.getMax()+ ", " +
							"5.Avg: "+statistics.getAverage()
							);
		
		
		System.out.println("7. "+numbers.stream().collect(Collectors.toUnmodifiableList()));
		
		
		List<String> words = Arrays.asList("one","two","three","one");
		
		System.out.println("8. "+words.stream().collect(Collectors.toMap(
															word -> word,
															word -> word.length(),
															(oldValue, newValue) -> oldValue)));
		

		List<String> alphawords = Arrays.asList("banana","apple","cucumber");
																
		System.out.println("9. "+words.stream().sorted().collect(Collectors.toMap(
																			Function.identity(),
																			String::length,
																			(oldValue, newValue) -> oldValue,
																			LinkedHashMap::new)));
		
		List<Integer> nums = Arrays.asList(3,1,4,1,5,9,2,6);
		
		System.out.println("10. "+nums.stream().collect(Collectors.collectingAndThen(
																				Collectors.toList(),
																				Collections::unmodifiableList)));
		
	}
}