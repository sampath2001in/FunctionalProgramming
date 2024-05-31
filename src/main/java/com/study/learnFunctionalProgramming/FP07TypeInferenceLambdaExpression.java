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

public class FP07TypeInferenceLambdaExpression {

	List<String> al = new ArrayList<String>(Arrays.asList("str","sab"));
	
	public static void main(String[] args) {
		
		List<Integer> numbers =  new ArrayList<Integer>(Arrays.asList(2,5,6,4,234,345));
		
		BinaryOperator<Integer> binObj = (x,y) -> x + y;
		System.out.println(binObj.apply(5, 7));
		
		//with type inference
		BinaryOperator<Integer> binObj1 = (Integer x, Integer y) -> x * y;
		System.out.println(binObj1.apply(5, 7));
		
		
	}

}
