import java.util.*;
import java.util.stream.*;


/*
1. Return all positive integers from the supplied list.
Sample Input
[-5, 4, 0, 8, -2, 10]
Sample Output
[4, 8, 10]


2. Given distinct integers, return their squares sorted in ascending order.
Sample Input
[5, 2, 4, 1]
Sample Output
[1, 4, 16, 25]


3. Find the second-highest distinct integer in the list. Assume at least two distinct values exist.
Sample Input
[10, 40, 20, 40, 30, 10]
Sample Output
30

4. Return all values that occur more than once, with each duplicate appearing once and the result sorted ascending.
Sample Input
[5,1,2,5,3,2,4,2]
Sample Output
[2, 5]


5. Given a lowercase string, return each character and its frequency in the order in which each distinct character first appears.
Sample Input
"programming"
Sample Output
{p=1, r=2, o=1, g=2, a=1, m=2, i=1, n=1}



*/


public class Aug22{
	
	public static void main(String args[]){
		
		
		List<Integer> numbers = Arrays.asList(-5, 4, 0, 8, -2, 10);
		
		System.out.println("1. "+numbers.stream().filter(n->n>0).collect(Collectors.toList()));
		
		List<Integer> numbers1 = Arrays.asList(5, 2, 4, 1);
		
		System.out.println("2. "+numbers1.stream().map(n->n*n).distinct().sorted().toList());
		
		List<Integer> numbers2 = Arrays.asList(10, 40, 20, 40, 30, 10);
		
		System.out.println("3. "+numbers2.stream().sorted(Comparator.reverseOrder()).distinct().skip(1).findFirst());
		
		
		List<Integer> numbers3 = Arrays.asList(5,1,2,5,3,2,4,2);
		
		Set<Integer> set = new HashSet<>();
		
		System.out.println("4. "+numbers3.stream().filter(n->!set.add(n)).distinct().sorted().toList());
		
		String word = "programming";
		
		System.out.println("5. "+word.chars().mapToObj(c-> (char) c).collect(Collectors.groupingBy(
																				w->w, 
																				LinkedHashMap::new,
																				Collectors.counting())));
																				
																				
		String rev = "hello world";
		
		System.out.println("6. "+Arrays.stream(rev.split(" "))
										.map(w-> new StringBuilder(w).reverse().toString())
										.collect(Collectors.joining(" ")));
		
		String sentence = "How are you?";
		
		System.out.println("7. "+Arrays.stream(sentence.split(" ")).filter(w->w.contains("?")).map(w->w.replace("?","")).collect(Collectors.joining()));
		
		
		
																				
		
		
		
		
		
		
	}
	
	
	
	
}