import java.util.*;
import java.util.stream.*;

/*
1. Sum all integers in a list using reduce() with an identity value.
2. Find the maximum element in a list using reduce().
3. Find the minimum element in a list using reduce().
4. Concatenate a list of strings into a single string using reduce().
5. Calculate the product of all numbers in the list using reduce().
6. Find the longest string in a list using reduce().
7. Calculate the sum of squares of all numbers using map() then reduce()
8. Re-implement count() using only reduce() — without using the count() terminal operation.
9. Use reduce() to build a Map<String, Integer> where key = word and value = its length.
10. Use the three-argument reduce(identity, accumulator, combiner) to sum integers, demonstrating the combiner for parallel-stream compatibility.

*/


public class July23{
	
	public static void main(String args[]){
		
		List<Integer> numbers = Arrays.asList(1,2,3,4,5);
		
		System.out.println("1. "+numbers.stream().reduce((a,b) -> a+b));
		
		System.out.println("2. "+numbers.stream().reduce(Integer::max));
		
		System.out.println("3. "+numbers.stream().reduce(Integer::min));
		
		List<String> sentence = Arrays.asList("I", "am", "Yeshwanth");
		
		System.out.println("4. "+sentence.stream().reduce("",(a,b)->a+" "+b));
		System.out.println("4. "+sentence.stream().collect(Collectors.joining(" ")));
		
		System.out.println("5. "+numbers.stream().reduce(1, (a,b) -> a*b));
		
		List<String> words = Arrays.asList("java", "streams", "are", "powerful", "tools");
		
		System.out.println("6. "+words.stream().reduce((s1,s2) -> s1.length() > s2.length() ? s1 : s2));
		
		System.out.println("7. "+numbers.stream().map(n->n*n).reduce(Integer::sum));
		
		System.out.println("8. "+numbers.stream().reduce(0,(total, element) -> total+1, Integer::sum));
		
		System.out.println("9. " + words.stream()
            .reduce(
                    new HashMap<String, Integer>(),
                    (result, word) -> {
                        result.put(word, word.length());
                        return result;
                    },
                    (map1, map2) -> {
                        map1.putAll(map2);
                        return map1;
                    }
            )
		);
		
		System.out.println("10. "+numbers.stream().reduce(0,(a,b)-> a+b, Integer::sum));
		
		
		
		
		
		
		
		
		
		
	}
}