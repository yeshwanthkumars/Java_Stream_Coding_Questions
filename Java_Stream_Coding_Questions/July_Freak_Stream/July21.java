import java.util.*;
import java.util.stream.*;

/*

1. Convert all strings in a list to UPPERCASE.
2. Double each number in the list using map().
3. Remove duplicate numbers from a list using distinct().
4. Convert a list of strings to a list of their respective lengths.
5. Given a list of Employee objects, extract only their names into a List<String>.
6. Square each integer, then keep only squares greater than 20
7. Skip the first 2 elements and then take the next 5 elements.
8. Trim whitespace, convert to lowercase, then keep only strings with length > 4.
9. Parse a list of number strings to integers and compute their sum.
10. Map each word to a record of (word, length, uppercase) and collect as Map<String, String>.
	O/P={apple=APPLE(5), banana=BANANA(6), cherry=CHERRY(6)}


*/


public class July21{
	
	public static void main(String args[]){
		
		
		List<String> words = Arrays.asList("hello", "world","java","stream","hi");
		
		System.out.println("1. "+words.stream().map(String::toUpperCase).toList());
		
		
		List<Integer> numbers = Arrays.asList(1,2,3,4,5);
		
		System.out.println("2. "+numbers.stream().map(n->n*2).toList());
		
		
		List<Integer> dup = Arrays.asList(1,2,3,4,5,1,1,3,4,5,7,8,6,7,9,10,8,9);
		
		System.out.println("3. "+dup.stream().distinct().toList());
		
		
		System.out.println("4. "+words.stream().map(m->m.length()).toList());
		
		
		List<Employee> emp = Arrays.asList(
											new Employee(1, "Yeshwanth", 25000, 27),
											new Employee(2, "Vishal", 30000, 26),
											new Employee(3, "Gokul", 40000, 29)
			
										  );
		
		System.out.println("5. "+emp.stream().map(Employee::getName).toList());
		
		List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7);
		
		System.out.println("6. "+ nums.stream().map(n->n*n).filter(sq-> sq>20).toList());
		
		System.out.println("7. "+nums.stream().skip(2).toList());
		
		List<String> raw = Arrays.asList(" Hello", "  World  ", "Java  ","   Stream");
		
		System.out.println("8. "+raw.stream().map(w->w.trim()).map(String::toLowerCase).filter(m->m.length()>4).toList());
		
		List<String> strNums = Arrays.asList("1","2","3","4","5");
		
		System.out.println("9. "+strNums.stream().map(Integer::parseInt).mapToInt(Integer::intValue).sum());
		
		
		System.out.println("10. "+ words.stream().collect(Collectors.toMap(
														word -> word,
														word -> word.toUpperCase() + "(" + word.length() + ")"
														)
														));
		
	}	
}


class Employee{
	
	int id;
	String name;
	double salary;
	int age;
	String department;
	
	public Employee(int id, String name, double salary, int age){
			this.id = id;
			this.name = name;
			this.salary = salary;
			this.age = age;	
	}
	
	public Employee(int id, String name, double salary, int age,String department){
			this.id = id;
			this.name = name;
			this.salary = salary;
			this.age = age;	
			this.department = department;
	}
	
	public int getId(){
		return id;
	}
	
	public void setId(int id) {
        this.id = id;
    }
	
	public String getName() {
        return name;
    }
	
	public void setName(String name) {
        this.name = name;
    }
	
	public double getSalary() {
        return salary;
    }
	
	public void setSalary(double salary) {
        this.salary = salary;
    }
	
	public int getAge() {
        return age;
    }
	
	public void setAge(int age) {
        this.age = age;
    }
	
	public String getDepartment(){
	
		return department;
	}
	
	public void setDepartment(String department){
		this.department = department;
			
	}
	
	public String toString(){
		return "Employee= {Name: "+ name + ", Salary: " + salary + ", Age: " + age + ", Department: "  +department+   "}"; 

	}

}