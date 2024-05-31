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

public class FP02FunctionalnterfacesExercises {

	List<String> al = new ArrayList<String>(Arrays.asList("str","sab"));
	
	public static void main(String[] args) {
		
		List<Integer> numbers =  new ArrayList<Integer>(Arrays.asList(2,5,6,4,234,345));
		
		System.out.println(numbers.stream().reduce(0, (x,y) -> x + y));
		
		/*
			What is the functional interface behind the above lambda expression (x,y) -> x + y).?
			@FunctionalInterface
			public interface BinaryOperator<T> extends BiFunction<T,T,T>  
		 *  Represents an operation upon two operands of the same type, producing a result
  			of the same type as the operands.
		*/
		
		BinaryOperator<Integer> binaryOperatorAccumulator = (x,y) -> x + y;
		numbers.stream().reduce(0, binaryOperatorAccumulator);
		

		
	}
	
}
