import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class FP02AllFunctionalnterfaces {

	List<String> al = new ArrayList<String>(Arrays.asList("str","sab"));
	
	public static void main(String[] args) {
		
		List<Integer> numbers =  new ArrayList<Integer>(Arrays.asList(2,5,6,4,234,345));
		
		/*
		 * ALL THE FUNCTIONAL INTERFACES ARE PRESENT IN THE PACKAGE JAVA.UTIL.FUNCTION
		 */
		
		/**************PREDICATE FUNCTIONAL INTERFACE**************************
		 *Get one input (here Integer) and gives boolean as output, as the output is always boolean hence
		 *it is not explicitly mentioned like Predicate<Integer, Boolean>
		 * Always refer the corresponding class/interface for further understanding.
		 * 
		 ************Predicate's single abstract function is test()**********************
		  /**
		 	* Evaluates this predicate on the given argument.
		 	*
		 	* @param t the input argument
		 	* @return {@code true} if the input argument matches the predicate,
		 	* otherwise {@code false}
     			boolean test(T t);
		 	* 
		 */
		
		Predicate<Integer> isEven = x -> x%2 == 0;
		System.out.println(isEven.test(6)); //Output: true
		
		
		/************FUNCTION FUNCTIONAL INTERFACE ************************
		 * 
		 */
		/* Function Functional Interface
		 * Function<Input, Output> squareFn;
		 * Get one input (here Integer) and gives one output (here integer)
		 * In the second example
		 *  Get one input (here Integer) and gives one output (here String)
		 *  Function<Integer, String>
		 *  
		 ****************** Function's single abstract function is apply********************************  
		 *  /**
		 	* Applies this function to the given argument.
		 	*
		 	* @param t the function argument
		 	* @return the function result
		 	*	R apply(T t);
		 *  
		 */
		
		Function<Integer, Integer> squareFn = x -> x*x;
		numbers.stream().map(x -> x*x);
		numbers.stream().map(squareFn);
		
		System.out.println(squareFn.apply(7)); //Output: 49
		
		
		Function<Integer, String> inputIntOutputString = x -> x + "";
		
		
		/*********** CONSUMER FUNCTIONAL INTERFACE*******************
		 * Consumer<Input> variablename;
		 * Get only one Input(here Integer) and no output as it is used to print in console or persist in db.
		 * 
		 ***********Consumer;s Single abstract function is accept*********************************************
		 *      * @param t the input argument
		 *
		 *		void accept(T t);
		 * 
		 */
		
		Consumer<Integer> sysOutConsumer = x -> System.out.println(x);
		sysOutConsumer.accept(20000); // Output: 20000
		
		
		/****************BINARY OPERATOR FUNCTIONAL INTERFACE******************************
		 * BinaryOperator<Input> variableName;
		 * Get only 2 Inputs and it gives the same data type as Output that is why no explicit output parameter is given 
		 * here
		 * Whenever Operator is there, the input and the output data type will be the same.
		 * BinaryOperator's Single abstract function is apply (refer binaryoperator interface as well)
		 */
		
		BinaryOperator<Integer> sumBinaryOperator = (x,y) -> x + y;
		System.out.println(sumBinaryOperator.apply(26, 24)); // Output: 50
		
		
		/***********SUPPLIER FUNCTIONAL INTERFACE*****************************************
		 * No input but some output.
		 * Supplier<Output> variableName;
		 * Supplier is the opposite of Consumer, no input is given but output will be supplied
		 * eg: FactoryPattern, a new db connection where there is no input, a new singleton class where there is no input etc.
		 * 
		 */
		
		Supplier<Integer> fixedInt = () -> 2; // No input is specifed with empty brackets
		System.out.println(fixedInt.get()); // Output: 2
		
		Supplier<Integer> randomIntGenerator = () -> {    //Anonymous 
			Random num = new Random();
			return num.nextInt(100);
		};
		System.out.println(randomIntGenerator.get()); // Output: some random number within 100 (as it is set in the above line below 100).
		
		
		/*******************UNARY OPERATOR******************************
		 * similar to Binaryoperator which takes 2 inputs and gives the output but in 
		 * UnaryOperator it takes one input and gives one output.
		 * Get only one Input and it gives the same data type as Output that is why no explicit output parameter is given
		 * UnaryOperator<Input> unaryops = x -> 4*x;
		 * Whenever Operator is there, the input and the output data type will be the same.
		 */
		
		UnaryOperator<Integer> unaryOps = x -> 3*x;
		System.out.println(unaryOps.apply(20)); //Output: 60
		
		
		/***********************BIPREDICATE FUNCTIONAL INTERFACE**************************************888
		 * 
		 * Similar to Predicate but this has 2 inputs instead of 1 input.
		 * 1st example: Get 2 inputs (here Integer, String) and gives boolean as output, as the output is always boolean, not explicit mentioned in the class defn
		 * 2nd example: Get 2 inputs (here Integer, Integer) and gives boolean as output
		 * Always refer the corresponding class/interface for further understanding.
		 * 
		 ************BiPredicate's single abstract function is test()********************** 
		 * 
		 * 
		 */
		
	
		 BiPredicate<Integer, String> bipredicateObj = (inte1, str) -> {
			 return inte1 > 10 && str.length() > 5;
		 };
		 System.out.println(bipredicateObj.test(14, "Immigration")); //Output: true

		BiPredicate<Integer, Integer> bipredicateObj1 = (int1, int2) -> int1 > int2;
		System.out.println(bipredicateObj1.test(5, 10)); //Output: false
		
		
		/************BIFUNCTION FUNCTIONAL INTERFACE ************************
		 * similar to Function functional interface but this one has 2 inputs instead of 1 input. 
		 */
		/* BiFunction Functional Interface
		 * Function<Input, Input, Output> squareFn;
		 * Get 2 inputs (here Integer, Integer) and gives one output (here integer)
		 * 
		 * In the second example
		 * Get one input (here Integer, String) and gives one output (here String)
		 * Function<Integer, String>
		 */
		
		 BiFunction<Integer, Integer, Integer> biFuncObj = (x,y) -> x+y;
		 System.out.println(biFuncObj.apply(15,75)); //Output: 90
		 
		 //second example
		 
		 BiFunction<Integer, Integer, String> biFuncObj1 = (x,y) -> {
			 return x+y+"limbo";
		 };
		 System.out.println(biFuncObj1.apply(15,75)); //Output: 90limbo
		 
		
		 /*********** BICONSUMER FUNCTIONAL INTERFACE*******************
			 * Similar to Consumer function interface but this one has 2 inputs instead of 1 input in Consumer interface/
			 * Consumer<Input, Input> variablename;
			 * Get two Inputs(here Integer, Integer) and no output as it is used to print in console or persist in db.
			 * 
		 */
		 
		 BiConsumer<Integer, Integer> biConsObj = (x,y) -> {
			System.out.println(x+y);
			System.out.println(y);
			// return y; Void methods cannot return a value
		 };
		
		 biConsObj.accept(24, 24);  //Output: prints 48 and 24
	}
}
