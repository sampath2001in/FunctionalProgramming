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

public class FP02BehaviourLogicParameterization {

	List<String> al = new ArrayList<String>(Arrays.asList("str","sab"));
	
	public static void main(String[] args) {
		
		List<Integer> numbers =  new ArrayList<Integer>(Arrays.asList(2,5,6,4,234,345));
		
		Predicate<? super Integer> divisiblebyTwoPredicate = x -> x%2 == 0;
		numbers.stream().filter(divisiblebyTwoPredicate); // for even number
		numbers.stream().filter(x -> x%2 != 0); // for odd number
		numbers.stream().filter(x -> x%3 == 0); // for numbers divisible by 3.
		
		/*
		 *If you see the above statements, the logic is mostly redundant
		 *so we are going to wrap this logic/behaviour and send this as a parameter to other method. 
		 */
		
		/*
		 * step 1: Create a local variable predicate by right clicking on the exprn x -> x%2 != 0 
		 * 				Predicate<? super Integer> divisiblebyTwoPredicate = x -> x%2 == 0;

		 * step 2: then you will get like this with the logic replaced by predicate
		 * 			numbers.stream().filter(divisiblebyTwoPredicate); // for even number

		 * step 3: now select and right click on the entire numbers.stream().filter(divisibleByTwoPredicate); and 
		 * create a function and you will get something like this
		 * 
		 * 	private static Stream<Integer> numberPredicate(List<Integer> numbers, Predicate<? super Integer> predicate) {
				return numbers.stream().filter(predicate);
			}
		 * 
		 * This is a function which can be used for any number divisible logic.
		 * 
		 * Thumbrule: Select and right click the expression then refactor -> extract variable to create a local variable
		 * 			  Select and right click the entire logic then refactor -> extract method to create a method.
		 */	
		
		Predicate<? super Integer> oddPredicate = extracted();
		numberPredicate(numbers, oddPredicate); // for odd numbers
		
		
		numberPredicate(numbers, (Predicate<? super Integer>) x -> x%2 == 0); // for even number
		
		
		numberPredicate(numbers, x -> x%3 == 0); // for divisible by 3.
		
		
		
	}

	private static Predicate<? super Integer> extracted() {
		Predicate<? super Integer> oddPredicate = x -> x%2 != 0;
		return oddPredicate;
	}

	//look at the bigger picture. we send logic as a parameter here.
	//moreover, we also return a logic/function (return numbers.stream().filter(predicate);) from this function numberPredicate and it is called 
	//higher order function: When a function returns another function (or logic)
	private static Stream<Integer> numberPredicate(List<Integer> numbers, Predicate<? super Integer> predicate) {
		return numbers.stream().filter(predicate);
	}
	
}
