import java.util.*;
import java.util.stream.*;


public class StreamApiQuestions_02{
	
	public static void main(String args[]){
		
		int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 3);
        List<Integer> numbersMedian = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<String> strings = Arrays.asList("apple", "potato", "banana", "orange", "grape", "chocolateMilk", "kiwi", "oai", "oia", "madam", "12321");
        List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
        List<String> stringsWithNull = Arrays.asList("apple", null, "banana", null, "kiwi", "orange", null, "pear");
        List<String> stringsWithSpaces = Arrays.asList("app le", " banan a ", "ki wi ", "o rang  e ", "p ea r ");
        List<Integer> numbersRepeated = Arrays.asList(1, 2, 3, 3, 4, 4, 4, 5, 5);
        List<String> stringsSamelength = Arrays.asList("potato", "banana", "orange");
        List<String> stringsMaxVowel = Arrays.asList("potato", "banana", "orange");
        List<String> stringsPalindrome = Arrays.asList("potato", "banana", "orange", "banana", "potato");
        List<String> stringsWithNumeric = Arrays.asList("potat23o", "bana34na", "oran121ge", "ban34ana", "potat56o");
        List<Integer> kthLarge = Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6, 5);
		
		
		
		/*
         1.Write a program to find the sum of all elements in a list using Java Stream API
        */
		
		System.out.println("1. "+Arrays.stream(arr).sum());
		System.out.println("1. "+numbers.stream().mapToInt(Integer::intValue).sum());
		System.out.println("1. "+numbers.stream().reduce(0,Integer::sum));
		
		
		/*
         2. Given a list of integers, write a program to find and print the maximum element using Java Stream API
        */
		
		System.out.println("2. "+Arrays.stream(arr).max().getAsInt());
		System.out.println("2. "+numbers.stream().max((o1,o2)->o1-o2).get());
		System.out.println("2. "+numbers.stream().mapToInt(Integer::intValue).max().getAsInt());
		
		
		/*
         3. Write a program to filter out all the even numbers from a list using Java Stream API
        */
		
		int[] evens = Arrays.stream(arr).filter(x -> x % 2 == 0).toArray();
        List<Integer> evenList = numbers.stream().filter(x -> x % 2 == 0).toList();
        System.out.println("3. " + Arrays.toString(evens));
        System.out.println("3. " + evenList);
		
		/*
         4. Given a list of strings, write a program to count the number of strings
               containing a specific character ‘a’ using Java Stream API.
        */
		
		System.out.println("4. "+strings.stream().filter(n->n.contains("a")).count());
		
		/*
         5. Write a program to convert a list of strings to uppercase using Java Stream API.
        */
		
		System.out.println("5. "+strings.stream().map(String::toUpperCase).toList());
		
		/*
        6. Given a list of integers, write a program to calculate the average of all the numbers using Java Stream API.
        */
		
		System.out.println("6. "+numbers.stream().collect(Collectors.averagingDouble(x->x)));
		System.out.println("6. "+numbers.stream().mapToInt(Integer::intValue).average().orElseThrow());
		System.out.println("6. "+Arrays.stream(arr).average().orElseThrow());
		
		/*
        7. Write a program to sort a list of strings in alphabetical order using Java Stream API.
        */
		
		System.out.println("7. "+strings.stream().sorted().toList());
		System.out.println("7. "+strings.stream().sorted(String::compareTo).toList());
		
		/*
        8. Given a list of strings, write a program to concatenate all the strings using Java Stream API.
        */
		
		System.out.println("8. " + strings.stream().reduce("", (x, y) -> x + y));
        System.out.println("8. " + String.join("", strings));
        System.out.println("8. " + strings.stream().collect(Collectors.joining()));
		
		/*
        9. Write a program to find the longest string in a list of strings using Java Stream API.
        */
		
		System.out.println("9. "+strings.stream().sorted(Comparator.comparing(String::length)).toList());
		System.out.println("9. "+strings.stream().sorted((x, y) -> x.length() - y.length()).toList());
		System.out.println("9. "+strings.stream().max((x, y) -> x.length() - y.length()).orElseThrow());

		/*
        10. Given a list of integers, write a program to find and print the second largest number using Java Stream API.
        */
		
		System.out.println("10. "+numbers.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst());
		System.out.println("10. "+numbers.stream().sorted((x, y) -> y - x).skip(1).findFirst().orElseThrow());
		
		/*
        11. Write a program to remove all the duplicate elements from a list using Java Stream API.
        */
		
		System.out.println("11. " +numbers.stream().collect(Collectors.toSet()));
        System.out.println("11. " +numbers.stream().distinct().toList());
		
		/*
        12. Given a list of strings, write a program to find and print the shortest string using Java Stream API.
        */
		
		System.out.println("12. "+strings.stream().sorted(Comparator.comparing(String::length)).findFirst());
		System.out.println("12. " + strings.stream().min((x, y) -> x.length() - y.length()).orElseThrow());
		
		/*
        13. Write a program to convert a list of integers to a list of their squares using Java Stream API.
        */
		
		System.out.println("13. "+numbers.stream().map(n->n*n).toList());
		
		
		/*
        14. Given a list of strings, write a program to find and print the strings starting with
        a specific prefix ‘a’ using Java Stream API.
        */
		
		System.out.println("14. "+strings.stream().filter(n->n.startsWith("a")).toList());
		
		/*
        15. Write a program to find the product of all elements in a list of integers using Java Stream API.
        */
		
		System.out.println("15. " + numbers.stream().reduce(1, (x, y) -> x * y));
		
		/*
        16. Given a list of integers, write a program to find and print the prime numbers using Java Stream API.
        */
		
		System.out.println("16. " + numbers.stream().filter(x -> {
            if (x == 1) return false;
            for (int i = 2; i <= Math.sqrt(x); i++) {
                if (x % i == 0) return false;
            }
            return true;
        }).toList());
		
		/*
        17. Write a program to check if a list of strings contains a specific string using Java Stream API.
        */
		
		System.out.println("17. "+strings.stream().anyMatch(x->x.contains("apple")));
		
		/*
        18. Given a list of strings, write a program to find and print the strings with length greater
        than a specified value 5 using Java Stream API.
        */
		
		System.out.println("18. "+strings.stream().filter(x->x.length()>6).toList());
		
		/*
        19. Write a program to filter out all the elements divisible by 3 and 5 from a list of integers using Java Stream API.
        */
		
		System.out.println("19. "+numbers.stream().filter(x->x%3==0 && x%5 ==0).toList());
		
		/*
        20. Given a list of strings, write a program to find and print the strings with the maximum length using Java Stream API.
        */
		
		System.out.println("20. " + strings.stream().max((x, y) -> x.length() - y.length()).orElseThrow());
        System.out.println("20. " + strings.stream().max(Comparator.comparingInt(String::length)).orElseThrow());
		
		/*
        21. Write a program to reverse a list of strings using Java Stream API.
        */
		
		Collections.reverse(strings);
        System.out.println("21. " + strings);
		System.out.println("21. "+strings.stream().map(x -> new StringBuilder(x).reverse().toString()).toList());
		
		/*
        22. Given a list of integers, write a program to find and print the distinct odd numbers using Java Stream API.
         */

        System.out.println("22. " + numbers2.stream().filter(x -> x % 2 != 0).distinct().toList());

        /*
        23. Write a program to remove all null values from a list of strings using Java Stream API.
         */
		
		System.out.println("23. "+stringsWithNull.stream().filter(Objects::nonNull).toList());
		
		/*
        24. Given a list of integers, write a program to find and print the sum of all odd numbers using Java Stream API.
        */
		
		System.out.println("24. "+numbers2.stream().filter(n->n%2!=0).collect(Collectors.summingDouble(x->x)));
		System.out.println("24. " + numbers2.stream().filter(x -> x % 2 != 0).reduce(0, Integer::sum));
        System.out.println("24. " + numbers2.stream().filter(x -> x % 2 != 0).mapToInt(Integer::intValue).sum());
		
		/*
        25. Write a program to find the intersection of two lists of strings using Java Stream API.
        */
		
		System.out.println("25. " + strings.stream().filter(stringsWithNull::contains).toList());
		
		/*
        26. Given a list of strings, write a program to find and print the strings containing only vowels using Java Stream API.
        */

        List<String> vowels = List.of("A", "E", "I", "O", "U");

        System.out.println("26. " + strings.stream().filter(x -> {
            List<String> list = Arrays.stream(x.toUpperCase().split("")).filter(vowels::contains).toList();
            return list.size() == x.length();
        }).toList());

        System.out.println("26. " + strings.stream().filter(x -> x.toUpperCase().matches("[AEIOU]+")).toList());
		
		
		/*
        27. Write a program to convert a list of strings to a comma-separated string using Java Stream API.
        */

        System.out.println("27. " + strings.stream().reduce("", (x, y) -> x + "," + y).substring(1));
        System.out.println("27. " + strings.stream().collect(Collectors.joining(",")));
        System.out.println("27. " + String.join(",", strings));
		
		/*
        28. Given a list of integers, write a program to find and print the index of the first occurrence
        of a specific number using Java Stream API.
        */
		
		int target = 20;

        int index = IntStream.range(0, numbers.size())
                .filter(i -> numbers.get(i).equals(target))
                .findFirst()
                .orElse(-1);  // returns -1 if not found

        System.out.println("Index of first occurrence: " + index);

	
		/*
        29.Write a program to find the union of two lists of integers using Java Stream API.
        */
		
		System.out.println("28. "+Stream.concat(numbers.stream(), numbers2.stream()).distinct().toList());
		
		/*
        30. Given a list of strings, write a program to find and print the strings containing duplicate characters using Java Stream API.
        */

		System.out.println("30. " + strings.stream().filter(
                x -> {
                    return x.length() != Arrays.stream(x.split("")).distinct().toList().size();
                }
        ).toList());
		
		/*
        31. Write a program to check if all elements in a list of strings are of the same length using Java Stream API.
        */
        System.out.println("31. ");
        System.out.println(
                stringsSamelength.stream().filter(x -> x.length() == stringsSamelength.getFirst().length()).toList().size() == stringsSamelength.size());

        System.out.println(stringsSamelength.stream().map(String::length).distinct().count() == 1);
		
		/*
        32. Given a list of integers, write a program to find and print the difference between the maximum and minimum numbers using Java Stream API.
         */
        System.out.println("32. ");
        System.out.println(numbers.stream().mapToInt(Integer::intValue).max().getAsInt() - numbers.stream().mapToInt(Integer::intValue).min().getAsInt());
		
		System.out.println(numbers.stream().max(Integer::compareTo).orElse(0) - numbers.stream().min(Integer::compareTo).orElse(0));


		/*
        33. Write a program to remove all whitespace from a list of strings using Java Stream API.
        */
		
		System.out.println("33. "+stringsWithSpaces.stream().map(x->x.replaceAll(" ","")).toList());
		
		/*
        34. Given a list of strings, write a program to find and print the strings containing a specific substring using Java Stream API.
        */
		
		System.out.println("34. " + strings.stream().filter(x -> x.contains("an")).toList());
		
		/*
        35. Write a program to find the mode of a list of integers using Java Stream API.
        */
	
		System.out.println("35. " + numbersRepeated.stream()
												   .collect(
												   Collectors.groupingBy(
														n -> n, 
														Collectors.counting()
													)
													)
													.entrySet().stream()
													.max((x, y) -> Math.toIntExact(x.getValue() - y.getValue()))
													.get()
													.getKey());
				
				
		/*
        36. Given a list of strings, write a program to find and print the strings with the minimum length using Java Stream API.
        */
		
		System.out.println("36. "+strings.stream().sorted(Comparator.comparing(String::length)).findFirst());
		
		int minLength = strings.stream().min((x, y) -> x.length() - y.length()).get().length();
        System.out.println("36. " + strings.stream().filter(x -> x.length() == minLength).toList());

        System.out.println("36. " + strings.stream().collect(Collectors.toMap(x -> x, String::length)).entrySet().stream().min((x, y) -> x.getValue() - y.getValue()).get().getKey());
		
		
		/*
        37. Write a program to find the frequency of each element in a list of integers using Java Stream API.
        */
		
		System.out.println("37. "+numbers.stream().collect(Collectors.groupingBy(n->n, Collectors.counting())));
		
		/*
        38. Given a list of strings, write a program to find and print the strings with the maximum number of vowels using Java Stream API.
        */
		
		System.out.println("38. "+strings.stream()
										 .collect(Collectors.toMap(
																s -> s,
																s -> s.toLowerCase()
																		.chars()
																		.filter(c -> "aeiou".indexOf(c) != -1)
																		.count()
												 )).entrySet()
												   .stream()
												   .max(Map.Entry.comparingByValue())
												   .map(Map.Entry::getKey)
												   .orElse("No Data")
												 
												 );										
													
		/*
        39. Write a program to check if a list of integers is sorted in ascending order using Java Stream API.
        */

		System.out.println("39. ");
        List<Integer> sortedList = numbers2.stream().sorted().toList();
        if (sortedList.equals(numbers2))
            System.out.println("true");
        else
            System.out.println("false");
		
		
		/*
		40. Given a list of strings, write a program to find and print the strings with the minimum number of vowels using Java Stream API.
		*/
		
		Map<String, Long> minVow = strings.stream().collect(Collectors.toMap(n->n, x -> x.chars().filter(c -> "AEIOUaeiou".indexOf(c) != -1).count()));
        Long minVowLength = minVow.entrySet().stream().
                min((y, z) -> Math.toIntExact(y.getValue() - z.getValue())).get().getValue();

        System.out.println("40. " + minVow.entrySet().stream().filter(x -> Objects.equals(x.getValue(), minVowLength)).map(Map.Entry::getKey).toList());


		/*
        41. Write a program to find the median of a list of integers using Java Stream API.
        */
		
		System.out.println("41. " + numbers.stream().mapToInt(Integer::intValue).sorted().skip((numbers.size() - 1) / 2).limit(numbers.size() % 2 == 0 ? 2 : 1).average().orElseThrow());
		
		
		/*
        42. Given a list of strings, write a program to find and print the strings containing a specific character at least twice using Java Stream API.
        */
		
		System.out.println("42. " + strings.stream().filter(s -> s.chars().filter(x -> x == 'a').count() >= 2).toList());
		
		
		/*
        43. Write a program to find the kth smallest element in a list of integers using Java Stream API.
        */

        int k = 2;
        System.out.println("43. " + numbers.stream().sorted().skip(k - 1).findFirst().orElseThrow());
		
		/*
        44. Given a list of strings, write a program to find and print the strings with the maximum number of consonants using Java Stream API.
        */
		
		Map<String, Long> maxCon = strings.stream().collect(Collectors.toMap(n->n, x -> x.chars().filter(c -> "bcdfghjklmnpqrstvwxyz".indexOf(c) != -1).count()));

        long maxCoVal = maxCon.values().stream().mapToLong(Long::longValue).max().orElse(0);

        System.out.println("44. " + maxCon.entrySet().stream().filter(x -> x.getValue() == maxCoVal).map(Map.Entry::getKey).toList());
		
		 /*
        45. Write a program to check if a list of strings is palindrome using Java Stream API.
         */

        System.out.println("45. " + stringsPalindrome.stream()
                .skip(stringsPalindrome.size() / 2)
                .allMatch(x -> x.equals(stringsPalindrome.get(stringsPalindrome.size() - 1 - stringsPalindrome.indexOf(x)))));


        /*
        46. Given a list of integers, write a program to find and print the elements with the highest frequency using Java Stream API.
         */

        //if exactly one highest frequency value present
        System.out.println("46. " + numbers.stream().collect(Collectors.groupingBy(n->n, Collectors.counting())).entrySet().stream().max((x, y) -> Math.toIntExact(x.getValue() - y.getValue())).get().getKey());

        //if more than one.

        Map<Integer, Long> collect = numbers.stream().collect(Collectors.groupingBy(n->n, Collectors.counting()));
        long maxFreq = collect.values().stream().mapToLong(Long::longValue).max().orElse(0);

        System.out.println("46. " + collect.entrySet().stream().filter(x -> x.getValue() == maxFreq).map(Map.Entry::getKey).toList());


        /*
        47. Write a program to remove all non-numeric characters from a list of strings using Java Stream API.
         */

        System.out.println("47. " + stringsWithNumeric.stream().map(x -> x.replaceAll("[^0-9]", "")).toList());


        /*
        48. Given a list of strings, write a program to find and print the strings containing only digits using Java Stream API.
         */

        System.out.println("48. " + strings.stream().filter(x -> x.matches("\\d+")).toList());

        /*
         Write a program to find the kth largest element in a list of integers using Java Stream API.
         */

        k = 3;
        System.out.println("49. " + kthLarge.stream().sorted((x, y) -> y - x).skip(k - 1).findFirst().orElseThrow());

        /*
        50. Given a list of integers, write a program to find and print the elements with the lowest frequency using Java Stream API.
         */

        Map<Integer, Long> frequencyMap = numbers.stream().collect(Collectors.groupingBy(n->n, Collectors.counting()));
        long minFrequency = frequencyMap.values().stream().mapToLong(Long::longValue).min().orElse(0);
        System.out.println("50. " + frequencyMap.entrySet().stream()
                .filter(entry -> entry.getValue() == minFrequency)
                .map(Map.Entry::getKey)
                .toList());


		
				
		
	}
	
	
}

