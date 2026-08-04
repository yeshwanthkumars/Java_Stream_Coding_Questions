import java.util.*;
import java.util.stream.*;

/*
1. Generate numbers from 1 (inclusive) to 5 (exclusive) using IntStream.range().
2. Generate numbers from 1 to 5 (both inclusive) using IntStream.rangeClosed().
3. Sum integers 1 through 10 using IntStream.
4. Compute the average of the numbers 10, 20, 30, 40, 50.
5. Get full statistics (count, sum, min, max, average) for a list of integers.
6. Sum the salaries of all employees using mapToInt()
7. Generate the first 10 Fibonacci numbers using Stream.iterate() with a two-argument seed
8. Use LongStream to compute the sum of all integers from 1 to 1 000 000.
9. Compute the variance of a set of student marks. Variance = avg((xi - mean)²)
10. Create an IntStream, box each int to Integer, and collect into a List<Integer>.
*/


public class July28{
	
	
	public static void main(String args[]){
		
		
		System.out.println("1. "+IntStream.range(1,4).boxed().toList());
		
		System.out.println("2. "+IntStream.rangeClosed(1,5).boxed().toList());
		
		System.out.println("3. "+IntStream.rangeClosed(1,10).sum());
		
		System.out.println("4. "+IntStream.of(10,20,30,40,50).average());
		
		List<Integer> numbers = Arrays.asList(1,2,3,4,5);
		
		IntSummaryStatistics statistics = numbers.stream().mapToInt(Integer::intValue).summaryStatistics();
		
		System.out.println("5. "+ 
						"Count: "+statistics.getCount()+ ", "+
						"sum: "+statistics.getSum()+ ", "+
						"min: "+statistics.getMin()+ ", "+
						"max: "+statistics.getMax()+ ", "+
						"average: "+statistics.getAverage());
						
		System.out.println("5. "+numbers.stream().collect(Collectors.summarizingInt(Integer::intValue)));
						
		
		List<Employee> emp = Arrays.asList(
											new Employee(1, "Yeshwanth", 25000, 27,"Developer"),
											new Employee(2, "Vishal", 30000, 26,"QA"),
											new Employee(3, "Gokul", 40000, 29,"Manager"),
											new Employee(4, "Kumar", 66000, 27,"Developer"),
											new Employee(5, "Raj", 66000, 27,"IT")
			
										  );
										  
										  
		System.out.println("6. "+emp.stream().mapToDouble(Employee::getSalary).sum());
		
		System.out.println("7. "+
							Stream.iterate(
										new int[]{0, 1},
										fib -> new int[]{fib[1], fib[0] + fib[1]}
								)
								.limit(10)
								.map(fib -> fib[0])
								.toList()
							);
		
		
		System.out.println("8. "+LongStream.rangeClosed(1,1_000_000).sum());
		
		List<Integer> marks = Arrays.asList(80, 90, 70, 60, 100);

		// Step 1: Calculate Mean
		double mean = marks.stream()
						.mapToInt(Integer::intValue)
						.average()
						.orElse(0.0);
		
		// Step 2: Calculate Variance
		double variance = marks.stream()
							.mapToDouble(mark -> Math.pow(mark - mean, 2))
							.average()
							.orElse(0.0);
		
		System.out.println("Mean     : " + mean);
		System.out.println("Variance : " + variance);
		
		
		System.out.println("10. "+IntStream.rangeClosed(1,5).boxed().toList());
		
		
		
	}
}