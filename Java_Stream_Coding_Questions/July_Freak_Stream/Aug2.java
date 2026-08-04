import java.util.*;
import java.util.stream.*;

/*
1. Find the second largest number in a list (assume distinct values).
2. Find all duplicate elements in a list (elements that appear more than once).
3. Reverse a list of integers using streams.
4. For each number in a list, compute the sum of its digits.
5. Find the first non-repeated character in a string.
6. Flatten a nested list, remove duplicates, and sort the result.
7. Group a list of words so that anagrams are in the same group
8. Count word frequency in a sentence, then return the top 3 most frequent words.
9. Find all pairs (i,j) where i < j such that nums[i] + nums[j] equals a target.
*/



public class Aug2{
	
	public static void main(String args[]){
		
		
		List<Integer> number = Arrays.asList(12,14,15,10,11,16);
		
		
		System.out.println("1. "+number.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst());
		
		
		List<Integer> nums = Arrays.asList(1,2,1,3,4,5,6,7,8,9,10,5,9,2,8,3);
		
		
		Set<Integer> dup = new HashSet<>();
		
		System.out.println("2. "+nums.stream().filter(n->!dup.add(n)).sorted().toList());
		
		System.out.println("3. "+number.stream().sorted(Comparator.reverseOrder()).toList());
		
		List<Integer> computesum = Arrays.asList(123, 456,789);
		
		System.out.println("4. "+computesum.stream().map(n->{
																int sum=0;
																int last;
																
																while(n>0){
																	last =n%10;
																	sum=sum+last;
																	n=n/10;	
																}
																
																return sum;
			
															}).toList());
															
		String value = "swiss";

		System.out.println("5. "+value.chars()
									  .mapToObj(c-> (char) c)
									  .collect(Collectors.groupingBy(
														c -> c,
														LinkedHashMap::new,
														Collectors.counting()
														)
												).entrySet()
												 .stream()
												 .filter(e->e.getValue() == 1)
												 .map(Map.Entry::getKey)
												 .findFirst()
												);
		
		List<List<Integer>> nested = Arrays.asList(
													Arrays.asList(3,1,4), 
													Arrays.asList(1,5,9),
													Arrays.asList(2,6,5), 
													Arrays.asList(3,5)
												  );
		
		System.out.println("6. "+nested.stream().flatMap(List::stream).sorted().distinct().toList());
		
		List<String> words = Arrays.asList("eat","tea","tan","ate","nat","bat");
		
		System.out.println("7. "+words.stream().collect(Collectors.groupingBy(word->{
																			char[] ch = word.toCharArray(); // ['e','a','t']
 																			Arrays.sort(ch);                // ['a','e','t']
																			return new String(ch);          // aet
																			}
																			)
																			)
																			);
		String sentence = "to be or not to be that is the question to be";
		
		System.out.println("8. "+Arrays.stream(sentence.split("\\s+")).collect(Collectors.groupingBy(
																									word -> word,
																									Collectors.counting()))
																									.entrySet()
																									.stream()
																									.sorted(Map.Entry.<String,Long>comparingByValue().reversed())
																									.limit(3)
																									.collect(Collectors.toList())
																									
																									);
																									
		List<Integer> values = Arrays.asList(1, 4, 2, 7, 3, 6);
		int target = 7;
		
		System.out.println("9. "+IntStream.range(0, nums.size())
										  .boxed()
										  .flatMap(i ->
										  	IntStream.range(i + 1, nums.size())
										  			.filter(j -> nums.get(i) + nums.get(j) == target)
										  			.mapToObj(j -> "(" + nums.get(i) + "," + nums.get(j) + ")")
										  )
										  .collect(Collectors.toList()));
										  
		
		
	}
	
}