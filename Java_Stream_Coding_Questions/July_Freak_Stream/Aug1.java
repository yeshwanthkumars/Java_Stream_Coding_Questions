import java.util.*;
import java.util.stream.*;
import java.util.concurrent.*;

/*
1. Sum a list of integers using parallelStream() and confirm the result equals the sequential sum.
2. Merge two integer streams into one using Stream.concat().
3. Use peek() to print each element as it passes through the pipeline, then collect even numbers
4. Show how to convert a parallel stream back to sequential and vice-versa.
5. Collect even numbers from a parallel stream into a thread-safe result using Collectors.toList().
6. Use the three-argument reduce() to sum a list correctly in a parallel stream
7. Use peek() at each stage of a multi-step pipeline to trace element flow
8. Demonstrate why collecting to ArrayList via parallelStream() without Collectors is unsafe, then show the correct approach.
9. From a list of 20 employees, use a parallel stream to find the top 5 highest earners.
10. Explain how to run a parallel stream on a custom ForkJoinPool with a specific parallelism level, and demonstrate with a sum.
*/



public class Aug1{
	
	public static void main(String args[]){
		
		
		List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);
		
		System.out.println("1. "+((numbers.stream().mapToInt(Integer::intValue).sum()) == (numbers.parallelStream().mapToInt(Integer::intValue).sum())));
		
		Stream<Integer> s1 = Stream.of(1,2,3);
		Stream<Integer> s2 = Stream.of(4,5,6);
		
		System.out.println("2. "+Stream.concat(s1,s2).collect(Collectors.toList()));
		
		List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		nums.stream().filter(n->n%2==0).peek(n->System.out.println("3. "+n)).collect(Collectors.toList());
		
		nums.stream().parallel().forEach(n->System.out.println(Thread.currentThread().getName() + " : " + n));
		nums.parallelStream().sequential().forEach(n->System.out.println(Thread.currentThread().getName() + " : " + n));
		
		System.out.println("5. "+nums.parallelStream().filter(n->n%2==0).collect(Collectors.toList()));
		
		
		System.out.println("6. "+nums.parallelStream().reduce(0,(a,b)->a+b,(x,y)->x+y));
		
		nums.stream().peek(n->System.out.println(n)).filter(n->n%2==0).peek(n->System.out.println(n)).collect(Collectors.toList());
		
		
		List<Integer> nums1 = IntStream.rangeClosed(1, 10000)
                              .boxed()
                              .collect(Collectors.toList());

		List<Integer> result = new ArrayList<>();

		nums1.parallelStream().forEach(result::add);     

		System.out.println(result.size());
		
		List<Integer> result1 = new CopyOnWriteArrayList<>();

		nums1.parallelStream()
			.forEach(result1::add);
		
		System.out.println(result1.size());
		
		List<Employee> employees = Arrays.asList(
												  new Employee(1,"A",45000,25,"IT"),
												  new Employee(2,"B",85000,28,"HR"),
												  new Employee(3,"C",65000,30,"IT"),
												  new Employee(4,"D",95000,29,"QA"),
												  new Employee(5,"E",35000,24,"HR"),
												  new Employee(6,"F",70000,27,"IT"),
												  new Employee(7,"G",90000,31,"DevOps"),
												  new Employee(8,"H",55000,26,"QA"),
												  new Employee(9,"I",72000,29,"IT"),
												  new Employee(10,"J",80000,30,"HR"),
												  new Employee(11,"K",50000,25,"IT"),
												  new Employee(12,"L",99000,32,"Manager"),
												  new Employee(13,"M",87000,28,"QA"),
												  new Employee(14,"N",43000,23,"IT"),
												  new Employee(15,"O",62000,27,"HR"),
												  new Employee(16,"P",58000,29,"DevOps"),
												  new Employee(17,"Q",91000,33,"IT"),
												  new Employee(18,"R",76000,30,"QA"),
												  new Employee(19,"S",88000,31,"HR"),
												  new Employee(20,"T",53000,26,"IT")
												);

        System.out.println("9. "+employees.parallelStream()
											.sorted(Comparator.comparing(Employee::getSalary).reversed())
										    .limit(5)
										    .collect(Collectors.toList()));
		
		
		
		
	}
	
}