import java.util.*;
import java.util.stream.*;

/*

1. Create a stream from a List and print all elements using forEach().
2. Count the total number of elements in a list using stream.
3. Filter only even numbers from a list and collect to a new List.
4. Create a stream using Stream.of() for a set of strings and print them.
5. Filter strings that start with the letter 'a' (case-insensitive) from a list.
6. Count how many numbers are greater than 10 in the list.
7. Check if any string in the list has a length greater than 5.
8. Create an infinite stream starting at 1, doubling each value, and collect the first 8 elements.
9. Use Stream.generate() with Math::random to produce 5 random doubles, each rounded to 2 decimal places.
10. From numbers 1–20, find all numbers divisible by 3 AND greater than 9 using a compound Predicate.


*/

public class July20{

    public static void main(String args[]){

        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		List<String> names = Arrays.asList("Apple", "Orange", "Pine", "avacado","Grapes","guava");
		List<Integer> nums = Arrays.asList(15, 3, 22, 8, 45, 12, 6, 33);
		List<String> animals = Arrays.asList("cat", "dog", "elephant", "fox");
		
		list.stream().forEach(n->System.out.println("1. "+n));
		
		
		System.out.println("2. "+list.stream().count());
		
		
		System.out.println("3. "+list.stream().filter(n->n%2==0).toList());
		
		
		Stream.of("Java", "C", "C++", "Python").forEach(n->System.out.println("4. "+n));
		
		System.out.println("5. "+names.stream().map(name -> name.toLowerCase()).filter(name ->name.startsWith("a")).toList());
		
		System.out.println("6. "+nums.stream().filter(n->n >10).toList());
		
		System.out.println("7. "+animals.stream().anyMatch(n->n.length()>5));
		
		Stream.iterate(1, n -> n * 2)
                .limit(8)
                .forEach(n-> System.out.println("8. "+n));
		
		
		Random random = new Random();

       Stream.generate(Math::random)
              .limit(5)
              .map(d -> Math.round(d * 100.0) / 100.0)
              .forEach(n-> System.out.println("9. "+n));
		
		
		IntStream.rangeClosed(1,20)
			.filter(n-> n%3==0 && n>9)
			.forEach(n-> System.out.println("10. "+n));

    }
}