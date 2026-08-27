import java.util.*;
import java.util.stream.*;


/*
1. Calculate the sum of all integers in the list.
Sample Input
[5,10,15,20]
Sample Output
50

2. Calculate the product of all integers in the list.
Sample Input
[2,3,4,5]
Sample Output
120

3. Return the longest string. If multiple strings have the same length, return the first one.
Sample Input
["Java","Spring","Kafka","Microservice"]
Sample Output
Microservice

4. Find the maximum integer using a single aggregate result from the sequence.
Sample Input
[15,4,99,20,75]
Sample Output
99

5. Given transactions containing type CREDIT or DEBIT and amount, calculate the final balance starting from 1000. Credits increase the balance and debits decrease it.
Sample Input
Initial=1000
  Transactions=[(CREDIT,500),(DEBIT,200),(DEBIT,150),(CREDIT,100)]
Sample Output
1250

*/


public class Aug27{

	public static void main(String args[]){
	
		
		List<Integer> numbers = Arrays.asList(5,10,15,20);
		
		System.out.println("1. "+numbers.stream().mapToInt(Integer::intValue).sum());
		
		
		List<Integer> numbers2 = Arrays.asList(2,3,4,5);
		
		System.out.println("2. "+numbers2.stream().reduce(1,(a,b)->a*b));
		
		
		List<String> words = Arrays.asList("Java","Spring","Kafka","Microservice");
		
		System.out.println("3. "+words.stream().max(Comparator.comparing(String::length)).orElse("NONE"));
	
		List<Integer> numbers3 = Arrays.asList(15,4,99,20,75);
		
		System.out.println("4. "+numbers3.stream().mapToInt(Integer::intValue).max());
		
		
		List<Transaction> transactions = Arrays.asList(
                new Transaction("CREDIT", 500),
                new Transaction("DEBIT", 200),
                new Transaction("DEBIT", 150),
                new Transaction("CREDIT", 100)
        );
		
		
		System.out.println("5. "+transactions.stream().reduce(
															1000,
															(balance,transaction) -> {
																if (transaction.getType().equals("CREDIT")) {
																	return balance + transaction.getAmount();
																} else {
																	return balance - transaction.getAmount();
																}	
															},
															Integer::sum
															));
		
		
	
	
	}
}

class Transaction {
    private String type;
    private int amount;

    public Transaction(String type, int amount) {
        this.type = type;
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public int getAmount() {
        return amount;
    }
}