import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FP02BehaviourLogicParameterizationExercises {

	List<String> al = new ArrayList<String>(Arrays.asList("str","sab"));
	
	public static void main(String[] args) {
		
		List<Integer> numbers =  new ArrayList<Integer>(Arrays.asList(2,5,6,4,234,345));
		
		/*
		 * Problem: write a behaviour parameterization for squares/cubes etc of a number.
		 *  numbers.stream().map(x -> x*x).forEach(System.out::println);
		 *  we need to write a behaviour parameterization for x-> x*x
		 */
		
		//numbers.stream().map(x -> x*x).forEach(System.out::println);
		
		// Step 1: : Create a local variable Functional interface by right clicking on the exprn x -> x*x
		//Function interface would be created as it is a map
		
		Function<Integer,Integer> multiplyNumbers = x -> x*x;
		numbers.stream().map(multiplyNumbers).forEach(System.out::println);
		
		
		//Step 2: now select and right click on the entire numbers.stream().map(multiplyNumbers); and refactor -> create method and 
		// multiplyNumbersFunction would be created
		 
		
		//numbers.stream().map(multiplyNumbers).forEach(System.out::println);
		System.out.println("Doubling numbers");
		multiplyNumbersFunction(numbers, multiplyNumbers).forEach(System.out::println);
		
		//Step 3: use the same method multiplyNumbersFunction for different inputs here cube of numbers.
		
		Function<? super Integer, ? extends Integer> tripleNumbers = x -> x*x*x;
		//numbers.stream().map(tripleNumbers).forEach(System.out::println);
		System.out.println("Tripling numbers");
		multiplyNumbersFunction(numbers, tripleNumbers).forEach(System.out::println);
		
		// quad numbers
		multiplyNumbersFunction(numbers, x -> x*x*x*x).forEach(System.out::println);
	}

	//look at the bigger picture, we send function as a parameter here
	private static Stream<? extends Integer> multiplyNumbersFunction(List<Integer> numbers,
			Function<? super Integer, ? extends Integer> multiplyNumbers) {
		return numbers.stream().map(multiplyNumbers);
	}	
}
