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

public class FP10FlatMap {

	List<String> al = new ArrayList<String>(Arrays.asList("str","sab"));
	List<String> a2 = new ArrayList<String>(List.of("a","b"));
	List<Integer> numbers = List.of(1,2,3,4,5,6);
	List<String> a3 = List.of("a","b");
	List<String> a4 = new ArrayList<String>(List.of("a","b"));
	String[] str = {"sam", "l"};
	List<String> a5 = new ArrayList<String>();
	//a5.add("immi");
	
	public static void main(String[] args) {

		List<String> courses = List.of("Spring", "Spring Boot", "API" , "Microservices","AWS", "PCF","Azure", 
								"Docker", "Kubernetes");

		List<String> courses2 = List.of("Spring", "Spring Boot", "API" , "Microservices","AWS", "PCF","Azure", 
								"Docker", "Kubernetes");
		
		System.out.println(courses.stream().collect(Collectors.joining(" ")));
		//output: Spring Spring Boot API Microservices AWS PCF Azure Docker Kubernetes
		
		System.out.println(courses.stream().map(course -> course.split(""))); //java.util.stream.ReferencePipeline$3@5674cd4d
		
		System.out.println(courses.stream().map(course -> course.split("")).collect(Collectors.toList()));
		/* output:* [[Ljava.lang.String;@33c7353a, [Ljava.lang.String;@681a9515,[Ljava.lang.String;@3af49f1c, 
		 * [Ljava.lang.String;@19469ea2,[Ljava.lang.String;@13221655, [Ljava.lang.String;@2f2c9b19,
		 * [Ljava.lang.String;@31befd9f, [Ljava.lang.String;@1c20c684, [Ljava.lang.String;@1fb3ebeb]
		 */
		
		//Flatmap: flattens the output 
		//*) Stream of string arrays to Stream of Strings  using flatMap we can do this.
		//Input:["Spring", "Spring Boot", "API" , "Microservices","AWS", "PCF","Azure", 
		//"Docker", "Kubernetes"]
		System.out.println(courses.stream().map(course -> course.split(""))
				.flatMap(Arrays::stream)
				.collect(Collectors.toList()));
		//output:[S, p, r, i, n, g, S, p, r, i, n, g,  , B, o, o, t, A, P, I, M, i, c, r, o, s, e, r, v, i, c, e, s,
			//A, W, S, P, C, F, A, z, u, r, e, D, o, c, k, e, r, K, u, b, e, r, n, e, t, e, s]
		
		//with space string
		System.out.println("with space string");
		System.out.println(courses.stream().map(course -> course.split(" "))
				.flatMap(Arrays::stream)
				.collect(Collectors.toList()));
		//output:
		//with space string
		//[Spring, Spring, Boot, API, Microservices, AWS, PCF, Azure, Docker, Kubernetes]

		
		// Start: Need to revisit the below example of usage of Flatmap
		
		//distinct() to get distinct
		System.out.println(courses.stream().map(course -> course.split(""))
				.flatMap(Arrays::stream).distinct()
				.collect(Collectors.toList()));
		//output: [S, p, r, i, n, g,  , B, o, t, A, P, I, M, c, s, e, v, W, C, F, z, u, D, k, K, b]
		
		
		System.out.println(
				courses.stream().flatMap(
						course -> courses2.stream().filter(
								course2 -> course2.length()==course.length())
								.map(course2 -> List.of(course,course2))
						).collect(Collectors.toList())
				);
		
		//output: Same length values from list1 and list2 with duplicates
		/*
		 * [[Spring, Spring], [Spring, Docker], [Spring Boot, Spring Boot], [API, API],
		 * [API, AWS], [API, PCF], [Microservices, Microservices], [AWS, API], [AWS,
		 * AWS], [AWS, PCF], [PCF, API], [PCF, AWS], [PCF, PCF], [Azure, Azure],
		 * [Docker, Spring], [Docker, Docker], [Kubernetes, Kubernetes]]
		 */
		
		System.out.println(courses.stream().flatMap(
				course -> courses2.stream().filter(
						course2 -> course2.length()==course.length())
						.map(course2 -> List.of(course,course2))
				)
				.filter(list -> !list.get(0).equals(list.get(1))).collect(Collectors.toList())
			);
		
	//Output:  Same length values from list1 and list2 with out duplicates
	//[[Spring, Docker], [API, AWS], [API, PCF], [AWS, API], [AWS, PCF], [PCF, API], [PCF, AWS], [Docker, Spring]]

		// End: Need to revisit the below example of usage of Flatmap
				
	}
}