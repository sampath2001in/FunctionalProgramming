import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntConsumer;
import java.util.function.IntUnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class FP09DifferentStreamsCreation {

	List<String> al = new ArrayList<String>(Arrays.asList("str","sab"));
	List<String> a2 = new ArrayList<String>(List.of("a","b"));
	
	public static void main(String[] args) {

		List<Integer> numbers = List.of(1,2,3,4,5,6);
		List<String> a3 = List.of("a","b");
		List<String> a2 = new ArrayList<String>(List.of("a","b"));
		String[] str = {"sam", "l"};
		List<String> a4 = new ArrayList<String>();
		a4.add("immi");
		
		//System.out.println(a3);
		//System.out.println(a2);
		System.out.println(
				numbers.stream()); //output: java.util.stream.ReferencePipeline$Head@4617c264

		//Other way of Creating Stream using Stream.of
		System.out.println(
				Stream.of(1,2,3,4,5,6)); //output: java.util.stream.ReferencePipeline$Head@36baf30c

		//Both the above statements give the output as Stream ReferencePipeline and it is wrapper object
		//but not the primitive types hence boxing and unboxing will happen
		//so to avoid that, we create streams using primitive type 
		// Creating streams for Primitive using Arrays
		int[] numberArr = {1,2,3,4};
		System.out.println(
				Arrays.stream(numberArr)); //output: java.util.stream.IntPipeline$Head@5ca881b5
		
		System.out.println(
				Arrays.stream(numberArr).sum()); //output: 10
		
		//Creating Primitives streams using inbuilt classes with algo like 
		//streams created with even no, odd no, squares etc.
		
		System.out.println(
			IntStream.range(1,20)); //output: java.util.stream.IntPipeline$Head@5674cd4d

		System.out.println(
				IntStream.range(1,20).sum()); //190 
		
		//rangeclosed will include the last number as well here it is 20
		System.out.println(
				IntStream.rangeClosed(1,20).sum()); //output: 210

		
		//IntStream.iterate(1,int1);//(1, e -> e +2);
		
		//dynamic odd numbers stream generation using lambda
		//peek used to see the numbers in the list.
		IntStream.iterate(1, e -> e +2).limit(10).peek(System.out::println).sum();
		//output:
		/*
		 * 1 3 5 7 9 11 13 15 17 19
		 */
		
		//dynamic even number generation using Functional Interface
		IntUnaryOperator twoAdditionOperator = e -> e+2;
		IntConsumer intConsumer = System.out::println;
		System.out.println(IntStream.iterate(0, twoAdditionOperator).limit(10).sum()); //output:90
		IntStream.iterate(0, twoAdditionOperator).limit(10).peek(intConsumer).sum();
		//output:  
		/*
		 *0 2 4 6 8 10 12 14 16 18
		 */
		
		//Squared number stream generation
		System.out.println("*******");
		IntStream.iterate(2, e -> e*2).limit(10).peek(System.out::println).sum();
		
		

		//Squared number stream generation and making it to list
		//collectors
		System.out.println("*******");
		IntStream.iterate(2, e -> e*2).limit(10).peek(System.out::println).sum();
		//Collectors.toList() will accept only objects and not primitives to accept integer
		// need to use boxed() like below:
		System.out.println(
				IntStream.iterate(2, e -> e*2).
				limit(10).
				boxed().
				collect(Collectors.toList()));
	
		//Likewise we have streams for other primitive like LongStream
		
		//Factorial using LongStream
		//2*3*4*5*6*7*8*9*10
		
		System.out.println(
				LongStream.rangeClosed(1,13).
				reduce(1,(x,y) -> x*y)
				);
		System.out.println(Long.MAX_VALUE); //output: 9223372036854775807
		
		System.out.println(
				LongStream.rangeClosed(1,30).
				reduce(1,(x,y) -> x*y)
				);
		System.out.println(Long.MAX_VALUE); //output: for -8764578968847253504
		//Typically for more numbers like 40! or 50!(factorial) Long cant hold, it will give in negative values
		//so need to use mapToObj() to map to other objects like BigInteger
		//BigInteger big;
		System.out.println(
		LongStream.rangeClosed(1,40).
			mapToObj(BigInteger::valueOf)
			.reduce(BigInteger.ONE, BigInteger::multiply)
		); //output: 815915283247897734345611269596115894272000000000
	}
}