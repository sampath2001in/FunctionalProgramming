import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class FP01MethodReferenceStreams {

	List<String> al = new ArrayList<String>(Arrays.asList("str","sab"));
	
	public static void main(String[] args) {
		//printinTraditionalMode(List.of(5,67,8,9,3,4,8,10));
		printinFunctionalMode(List.of(5,67,8,9,3,4,8,10,88));
		//FP01MethodReferenceStreams obj = new FP01MethodReferenceStreams();		
		//obj.reduceMethodinFunctionalMode(List.of(5,67,8,9,3,4,8,10,88));
		//reduce
		System.out.println("sum is: " + reduceMethodinFunctionalMode(List.of(5,67,8,9,3,4,8,10,88)));
		//sort
		sortinFunctionalMode(List.of("ga","bdfd","abfe","dea","frtyu","zuu","ower","victory"));
		
		//Using collect method to collect the items and put in the list.
		List<Integer> collectedList = collectToAnotherListinFunctionalMode(List.of(5,67,8,9,3,4,8,10,88));
		System.out.println("collect: " + collectedList);
		
		
		//Method reference works on both instance method and custom defined static method.
		List<String> strList = List.of("ga","bdfd","abfe","dea","frtyu","zuu","ower","victory");
		strList.stream()
		.map(str -> str.toUpperCase()) //example of Method reference works on instance method
		// this is a custom defined static method, but wont work on custom defined non static method
		.forEach(FP01MethodReferenceStreams::printStr);   
		
		
		Supplier<String> supp = () -> "sam";
		System.out.println(supp.get());
		
		Supplier<String> supp1 = () -> new String("Immig");
		System.out.println(supp1.get());
		
		//Constructor reference (like method reference - but not fully understood)
		Supplier<String> supp2 = String::new;
		System.out.println(supp2.get());

	}
	
	private static void printStr(String str) {
		System.out.println(str);
	}

	
	private static List<Integer> collectToAnotherListinFunctionalMode(List<Integer> numbers) {
		return numbers.stream().map(x -> x*x).collect(Collectors.toList());	
	}


	private static void printinTraditionalMode (List<Integer> numbers) {
		//in structured/traditional, how to do the loop
		for (int number:numbers) {
			System.out.println("trad: " + number);
		}
	}

	private static void print(int number) {
		System.out.println(number);
	}
	
	
	private static boolean isEven (int number) {
		return number%2==0;
	}
	
	/*
	 * //MethodReference --> Classname::MethodName
	 * converts List to stream and what to to do with each number
	 * lambda expression: can also be used to do what needs to be done with each item in list
	 * lambda expression: A methods logic can be completely defined here
	 * Method Reference: we create a method and inside we define a logic.
	 * filter is a method using which we can filter. .filter(number -> number%2 == 0)
	 * filter with lambda exprn for filtering. .map(number -> number * number)
	 * map with lambd exprn for operational purposes
	 */	
	private static void printinFunctionalMode (List<Integer> numbers) {
		//"what to do" approach with each number
		
		//in functional what to do with each number from the stream
		//Static reference
		//This (print) method is the method to be called for each number.
		//IN functional programming, we check "what to do" with each element
		
		//		Predicate<? super Integer> Evenpredicate = number -> number%2 == 0;
		numbers.stream()  //converting list to stream
		//.forEach(FP01MethodReferenceStreams::print); //Method Reference
		.filter(number -> number%2 == 0) //lambda expression,a method, can also be used to do what needs to be done with each item in list
		.map(number -> number * number) //lambda exprn with map, map used for operation, to map one value to another value
		.forEach(System.out::println); //Method Reference
	}
	
	
	private static int sum (int aggregator, int nextNumber) {
		System.out.println("aggregator: " + aggregator + " " + "Next number: "  + nextNumber);
		/*
		 * aggregator: 0 Next number: 5 
		 * aggregator: 5 Next number: 67 
		 * aggregator: 72 Next number: 8 
		 * aggregator: 80 Next number: 9 
		 * aggregator: 89 Next number: 3
		 * aggregator: 92 Next number: 4 
		 * aggregator: 96 Next number: 8 
		 * aggregator: 104 Next number: 10 
		 * aggregator: 114 Next number: 88 
		 * sum is: 202
		 */
		return aggregator + nextNumber;
	}

	private static int reduceMethodinFunctionalMode(List<Integer> numbers) {
		//reduce: Reduce the list of values to a single number
		// initial value is set to 0
		
		//Using Methodreference by using custom class
		//int num = numbers.stream().reduce(0, FP01MethodReferenceStreams::sum);
		
		//Another way Using Methodreference by using Integer class
		int number = numbers.stream().reduce(0, Integer::sum);
		
		//Another way Using lambda expression
		int num = numbers.stream().reduce(0, (x,y) -> x+y);
		
		return num;
	}
	
	
	private static void sortinFunctionalMode(List<String> numbers) {
		//numbers.stream().sorted(Comparator.naturalOrder()).forEach(System.out::println);
		//numbers.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
		numbers.stream().sorted(Comparator.comparing(str -> str.length())).forEach(System.out::println);
	}

}
