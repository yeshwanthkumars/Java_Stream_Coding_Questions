import java.util.*;
import java.util.stream.*;

/*
1. Count the number of vowels in a string using chars().
2. Split a sentence on spaces and print each word in UPPERCASE.
3. Find and print all unique characters in a string in the order they first appear.
4. Reverse each word in a sentence (do not reverse word order).
5. Count the frequency of each character in a string.
6. Find the character that appears most often in a string.
7. Use streams to determine if a string is a palindrome
8. Determine if two words are anagrams using streams (sort characters and compare).
9. Extract all integers from a string and calculate their sum.
10. Find the top 3 most frequent words in a sentence (case-insensitive).
*/


public class July30{
	
	
	public static void main(String args[]){
		
		
		String str = "Hello World";
		Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
		
		
		System.out.println("1. "+str.toLowerCase().chars().filter(ch-> "aeiou".indexOf(ch) != -1).count());
		System.out.println("1. "+str.toLowerCase().chars().mapToObj(ch -> (char) ch).filter(vowels::contains).count());
		
		
		String str2 = "Java 8 streams are powerful";
		
		System.out.println("2. "+Arrays.stream(str2.split("\\s+")).map(w->w.toUpperCase()).toList());
		
		
		String str3 = "programming";
		
		System.out.println("3. "+str3.chars().mapToObj(c-> (char) c).distinct().toList());
		
		String str4 = "Hello World Java";
		
		System.out.println("4. "+Arrays.stream(str4.split("\\s+")).map(s-> new StringBuilder(s).reverse().toString()).collect(Collectors.joining(" ")));
		
		
		String str5 = "mississippi";
		
		System.out.println("5. "+str5.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(word -> word, Collectors.counting())));
		
		String str6 = "abracadabra";
		
		System.out.println("6. "+str6.chars().mapToObj(c->(char)c).collect(
																			Collectors.groupingBy(
																					word -> word,
																					Collectors.counting()))
																	.entrySet().stream()
																	.max(Map.Entry.comparingByValue())
																	.map(Map.Entry::getKey)
																	.orElse(null));
		
		String str7="racecar";
		
		System.out.println("7. "+IntStream.range(0,str7.length()/2).allMatch(i->str7.charAt(i) == str7.charAt(str7.length()-1-i)));
		
		String w1 = "listen"; 
		String w2 = "silent";
		
		System.out.println("8. "+(w1.length() == w2.length()&& 
											w1.chars()
											  .sorted()
											  .boxed()
											  .collect(Collectors.toList())
											  .equals(
													w2.chars()
													.sorted()
													.boxed()
													.collect(Collectors.toList())
											  )
											  ));
											  
		String str8 = "I have 3 cats and 12 dogs and 1 rabbit";
		
		System.out.println("9. "+Arrays.stream(str8.split("\\D+")).filter(s->!s.isEmpty()).mapToInt(Integer::parseInt).sum());
		
		
		String sentence = "the quick brown fox jumps over the lazy dog the fox";
		
		System.out.println("10. "+Arrays.stream(sentence.split("\\s+")).collect(Collectors.groupingBy
																		(
																			word->word,
																			Collectors.counting()
																		)
																		)
																		.entrySet()
																		.stream()
																		.sorted(Map.Entry.<String, Long> comparingByValue().reversed())
																		.limit(3)
																		.collect(Collectors.toList())
																		);
		
	}
}