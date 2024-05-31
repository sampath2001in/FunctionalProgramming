import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FP02Functionalnterfaces {

	List<String> al = new ArrayList<String>(Arrays.asList("str","sab"));
	
	public static void main(String[] args) {
		
		List<Integer> numbers =  new ArrayList<Integer>(Arrays.asList(2,5,6,4,234,345));
		
		/*
		 * numbers.stream() .
		 * filter(x -> x%2==0) .
		 * map(x -> x*x)
		 * .forEach(System.out::println);
		 
		//The above statement from line 16 to line 19 is transformed like below internally using functional interfaces.
		
		
		 * numbers.stream() .filter(isEvenpredicate) .map(squareFunction)
		 * .forEach(sysOut);
		 * 
		 * numbers.stream() .filter(isEvenPredicate2) .map(squareFunction2)
		 * .forEach(sysOut2);
		 * 
		 * numbers.stream().filter(x -> x%2==0).map(x -> x*x).forEach(System.out::println); IS THE SAME AS
		 * numbers.stream().filter(isEvenpredicate).map(squareFunction).forEach(sysOut);   IS THE SAME AS 
		 * numbers.stream().filter(isEvenpredicate2).map(squareFunction2).forEach(sysOut2);
			
			x -> x%2==0 			IS CONVERTED TO Predicate<Integer> isEvenpredicate = x -> x%2 == 0 (Predicate Functional Interface)
			x -> x*x    			IS CONVERTED TO Function<Integer, Integer> squareFunction = x -> x*x; (Function Functional Interface)
			System.out::println     IS CONVERTED TO Consumer<? super Integer> sysOut = System.out::println;
		 */		
		
		
		// PREDICATE INTERFACE: Represents a predicate (boolean-valued function) of one argument
		
		/*
		 * 
		 * What is functional interface? public @interface FunctionalInterface {}
		 * 		Conceptually, a functional interface has exactly one abstract method.
		 * 
		 * What is a Predicate?
		 * 	predicate is a @FunctionalInterface 
		 * @FunctionalInterface
			public interface Predicate<T> where T is the type of Input
		 * 	Represents a predicate (boolean-valued function) of one argument.
		 */
		Predicate<Integer> isEvenpredicate = x -> x%2 == 0;
		//internally the above codes might convert like the below
		Predicate<Integer> isEvenPredicate2 =  new Predicate<Integer>() {
			
			@Override
			public boolean test(Integer t) { //// overriding one abstract function of Predicate interface
				return t%2 == 0;
			}
		};
		
		
		// FUNCTION INTERFACE: Represents a function that accepts one argument and produces a result.
		
		/*
		 * What is functional interface? public @interface FunctionalInterface {}
		 * 		Conceptually, a functional interface has exactly one abstract method.
		 * 
		 * What is a Function?
		 * 	Function is a @FunctionalInterface
		 * @FunctionalInterface
			public interface Function<T, R>  where T is the type of input and R is the Result
		 *   * Represents a function that accepts one argument and produces a result.
		 */
		
		Function<Integer, Integer> squareFunction = x -> x*x;
		//internally the above codes might convert like the below
		Function<Integer,Integer> squareFunction2 = new Function<Integer, Integer>() {
			
			@Override
			public Integer apply(Integer t) { // overriding one abstract function of Function interface
				return t * t;
			}
		};
		
		
		//CONSUMER INTERFACE: Represents an operation that accepts a single input argument and returns no result
		
		/*
		 * What is functional interface? public @interface FunctionalInterface {}
		 * 		Conceptually, a functional interface has exactly one abstract method.
		 * 
		 * What is a Consumer?
		 * 	Consumer is a Functional Interface
		 * 	@FunctionalInterface
			public interface Consumer<T> { where T is the type of the input
			Represents an operation that accepts a single input argument and returns no result
			This one will consume the input and display in console or save in db etc/ 
		 */
		Consumer<? super Integer> sysOut = System.out::println;
		
		Consumer<Integer> sysOut2 = new Consumer<Integer>() {

			@Override
			public void accept(Integer t) { // overriding one abstract function of Consumer interface
				System.out.println(t);
			}
			
		};
		
		//both the below statements will produce the same result.
		
		numbers.stream()
		.filter(isEvenpredicate)
		.map(squareFunction)
		.forEach(sysOut);   
		
		numbers.stream()
		.filter(isEvenPredicate2)
		.map(squareFunction2)
		.forEach(sysOut2);
		
		
	}	
}
