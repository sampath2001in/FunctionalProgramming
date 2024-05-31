import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class Course {
	private String name;
	private String category;
	private int reviewScore;
	private int noOfStudents;

	public Course() {
		
	}
	public Course(String name, String category, int reviewScore, int noOfStudents) {
		super();
		this.name = name;
		this.category = category;
		this.reviewScore = reviewScore;
		this.noOfStudents = noOfStudents;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getReviewScore() {
		return reviewScore;
	}

	public void setReviewScore(int reviewScore) {
		this.reviewScore = reviewScore;
	}

	public int getNoOfStudents() {
		return noOfStudents;
	}

	public void setNoOfStudents(int noOfStudents) {
		this.noOfStudents = noOfStudents;
	}

	public String toString() {
		return name + ":" + noOfStudents + ":" + reviewScore;
	}

}


public class FP08CustomClassFunctionalProgramming {

	List<String> al = new ArrayList<String>(Arrays.asList("str","sab"));
	
	public static void main(String[] args) {
		
		List<Course> courseList = List.of(
							new Course("Spring", "Framework", 98, 20000),
							new Course("Spring Boot", "Framework", 95, 18000), 
							new Course("API", "Microservices", 97, 22000),
							new Course("Microservices", "Microservices", 96, 25000),
							new Course("FullStack", "FullStack", 91, 14000), 
							new Course("AWS", "Cloud", 92, 21000),
							new Course("Azure", "Cloud", 99, 21000), 
							new Course("Docker", "Cloud", 92, 20000),
							new Course("Kubernetes", "Cloud", 91, 20000)
				);
				
		Predicate<? super Course> reviewScoreMorethan95Predicate = course -> course.getReviewScore() > 95;
		
		Predicate<? super Course> reviewScoreMorethan90Predicate = course -> course.getReviewScore() > 90;

		Predicate<? super Course> reviewScoreMorethan100Predicate = course -> course.getReviewScore() >= 100;

		//ALLMATCH, NONEMATCH, ANYMATCH
		
		//allMatch if the particular predicate or condition matches for all the list items
		//Here checking for all the matches more than 95 reviewscore - it will return false as we have less than 95 
		System.out.println(courseList.stream().allMatch(reviewScoreMorethan95Predicate));
		
		System.out.println(courseList.stream().allMatch(reviewScoreMorethan90Predicate));
		
		//anyMatch if the particular predicate or condition matches with atleast one of the list items
		//Here checking for at least one of them more than 90 reviewscore - it will return true as we have it
		System.out.println(courseList.stream().anyMatch(reviewScoreMorethan90Predicate));
		
		System.out.println(courseList.stream().anyMatch(reviewScoreMorethan100Predicate));
		
		//noneMatch if the particular predicate or condition does not match with any of the list items.
		//Here we dont have any review score more than or equal to 100, so it will return true.
		System.out.println(courseList.stream().noneMatch(reviewScoreMorethan100Predicate));

		
		//SORTED - COMPARATOR
		//Comparing the courses using comparator
		//numbers.stream().sorted(Comparator.comparing(str -> str.length())).forEach(System.out::println);

		Comparator<Course> comparingByReviewScore = Comparator.comparing(Course::getReviewScore);
		
		System.out.println(
				courseList.stream()
				.sorted(comparingByReviewScore)
				.collect(Collectors.toList()));
		//[FullStack:14000:91, Kubernetes:20000:91, AWS:21000:92, Docker:20000:92, Spring Boot:18000:95, Microservices:25000:96, API:22000:97, Spring:20000:98, Azure:21000:99]


		System.out.println(
				courseList.stream()
				.sorted(comparingByReviewScore.reversed())
				.collect(Collectors.toList()));
		//[Azure:21000:99, Spring:20000:98, API:22000:97, Microservices:25000:96, Spring Boot:18000:95, AWS:21000:92, Docker:20000:92, FullStack:14000:91, Kubernetes:20000:91]
		
		//Using two attributes for sorting
		
		//Multiple Column sorts and compare

		Comparator<Course> comparingByReviewScoreAndNoOfStudents = 
				Comparator.comparing(Course::getReviewScore).thenComparing(Course::getNoOfStudents);

		System.out.println(
				courseList.stream()
				.sorted(comparingByReviewScoreAndNoOfStudents)
				.collect(Collectors.toList()));
		//[FullStack:14000:91, Kubernetes:20000:91, Docker:20000:92, AWS:21000:92, Spring Boot:18000:95, Microservices:25000:96, API:22000:97, Spring:20000:98, Azure:21000:99]
		
		
		//LIMIT, SKIP, TAKEWHILE, DROPWHILE FUNCTIONS
		//full list:[FullStack:14000:91, Kubernetes:20000:91, Docker:20000:92, AWS:21000:92, Spring Boot:18000:95, 
		//Microservices:25000:96, API:22000:97, Spring:20000:98, Azure:21000:99]
		
		//LIMIT -> will limit the no of results to that number, here it is 5
		System.out.println(
				courseList.stream()
				.sorted(comparingByReviewScoreAndNoOfStudents)
				.limit(5)
				.collect(Collectors.toList()));
		//FullStack:14000:91, Kubernetes:20000:91, Docker:20000:92, AWS:21000:92, Spring Boot:18000:95]

		
		//SKIP -> will Skip the no of results here it is 3, after that it will print whatever it is in the list
		System.out.println(
				courseList.stream()
				.sorted(comparingByReviewScoreAndNoOfStudents)
				.skip(5)
				.collect(Collectors.toList()));
		//[Microservices:25000:96, API:22000:97, Spring:20000:98, Azure:21000:99]
		
		
		//Skip and limit
		System.out.println(
				courseList.stream()
				.sorted(comparingByReviewScoreAndNoOfStudents)
				.skip(5)
				.limit(1)
				.collect(Collectors.toList()));
		//[Microservices:25000:96]
		
		
		
		//TAKEWHILE -> will take the values till the condition is satisfied (like while loop condition)
		// while/till this condition is met, will take the value from the stream,
		// even if one element breaks the criteria, it will skip the elements after that.
	
		System.out.println("takewhile: " + courseList);
		
		//takewhile Input: [Spring:20000:98, Spring Boot:18000:95, API:22000:97, Microservices:25000:96, FullStack:14000:91, 
		//AWS:21000:92, Azure:21000:99, Docker:20000:92, Kubernetes:20000:91]
		System.out.println("takewhile: " + courseList.stream()
		.takeWhile(course -> course.getReviewScore() >= 95)
		.collect(Collectors.toList()));
		//takewhile output: [Spring:20000:98, Spring Boot:18000:95, API:22000:97, Microservices:25000:96]



		//DROPWHILE -> will drop the values from the list till the condition is satisfied
		// while/till this condition is met, will drop the value from the stream.
		// even if one element breaks the criteria, it will add all the elements after that.
		
		System.out.println("dropwhile: " + courseList);
		//dropwhile input: [Spring:20000:98, Spring Boot:18000:95, API:22000:97, Microservices:25000:96, 
		//FullStack:14000:91, AWS:21000:92, Azure:21000:99, Docker:20000:92, Kubernetes:20000:91]
		
		System.out.println("filtereddropwhile: " + courseList.stream()
		.dropWhile(course -> course.getReviewScore() >= 95)
		.collect(Collectors.toList()));
		//dropwhile output: [FullStack:14000:91, AWS:21000:92, Azure:21000:99, Docker:20000:92, Kubernetes:20000:91]

		
		//GETTING A SINGLE ELEMENT LIKE MAX/TOP COURSE Aggregate functions
		
		//GETTING MAX FROM LIST BY USING COMPARATOR
		System.out.println(courseList.stream().max(comparingByReviewScore)); //output: Optional[Azure:21000:99]
		
		//GETTING MIN FROM LIST BY USING COMPARATOR
		System.out.println(courseList.stream().min(comparingByReviewScore)); //output: Optional[FullStack:14000:91]

		//GETTING FINDFIRST FROM LIST BY USING COMPARATOR
		System.out.println(courseList.stream().findFirst());	//Optional[Spring:20000:98]
		
		/*
		 * //GETTING FINDany FROM LIST BY USING COMPARATOR 
		 * The behavior of this operation is explicitly nondeterministic; it is free to select any element in
		 * the stream.
		 */
		System.out.println(courseList.stream().findAny());	//Optional[Spring:20000:98]
		
		/******** OPTIONAL*************************** 
		 * The Optional class used to wrap our data and avoid the classical null checks.
		 * The above functions max,min,findAny,findFirst all of them return Optional<T>
		 * 
		 */		
		//GETTING FINDFIRST and optional.orElse
		// Here if we dont have anything for findFirst method, which returns optional there we can fill it up with 
		//default value.
		System.out.println(courseList.stream().findFirst()
				.orElse(new Course("Azure", "Cloud", 99, 21000) ));	//Optional[Spring:20000:98]
		
		
		/*
		 * //Sum
		 * sum is the method on numbers or int so apply like that
		 * instead of map, we have used mapToInt, as we know the course.getNoOfStudents() is an int, so to avoid 
		 * Boxing and Unboxing issue in Wrapper class, we can choose to use mapToInt or mapToDouble accordingly.
		 * 
		 */		
		System.out.println(courseList.stream().mapToInt(course -> course.getNoOfStudents()).sum()); 
		//Output: 181000
		//or using method reference where in we dont have parenthesis after getNoOfStudents method 
		System.out.println(courseList.stream().mapToInt(Course::getNoOfStudents).sum()); 

		
		//Average - Average is the method on numbers or int so apply like that
		
		System.out.println(courseList.stream().mapToInt(course -> course.getNoOfStudents()).average()); 
		//Output: OptionalDouble[20111.11111111111]
		
		//Count
		System.out.println(courseList.stream().mapToInt(course -> course.getNoOfStudents()).count()); 
		//output: 9 -> lists the no. of courses but i dont understand.
		
		//Getting a single result end
		
		
		//GROUPING BY
		
		//group by course category with entire COurse Object
		System.out.println("Group by Category");
		System.out.println(courseList.stream()
				.collect(Collectors.groupingBy(course -> course.getCategory())));
		//Or the above can also be written as
		//System.out.println(courseList.stream().collect(Collectors.groupingBy(Course::getName)));
		//Output:
		//Group by Category
		//{
		//	Cloud=[AWS:21000:92, Azure:21000:99, Docker:20000:92, Kubernetes:20000:91], 
		//	FullStack=[FullStack:14000:91], Microservices=[API:22000:97, Microservices:25000:96], 
		//	Framework=[Spring:20000:98, Spring Boot:18000:95]
		//}
		
		
		//group by courses category with count (count(*) in sql)
		
		System.out.println("Group by Category and then count");
		System.out.println(courseList.stream()
				.collect(Collectors.groupingBy(course -> course.getCategory(),
						Collectors.counting())));
		//Output:
		//Group by Category and then count
		//{Cloud=4, FullStack=1, Microservices=2, Framework=2}
		
		
		//group by course category and finding the max review score on that group
		System.out.println("Group by Category and then finding the max review score on that group");
		System.out.println(courseList.stream()
			.collect(Collectors.groupingBy(Course::getCategory,
					Collectors.maxBy(Comparator.comparing(course -> course.getReviewScore())))));
					// or we can use this also for the above statement using lambda instead of method reference
					//Collectors.maxBy(Comparator.comparing(course -> course.getReviewScore()))));
		//Output:
		//{
		// Cloud=Optional[Azure:21000:99], meaning: in cloud category, Azure has the highest review score like that. 
		// FullStack=Optional[FullStack:14000:91],            ditto similar
		// Microservices=Optional[API:22000:97], 			  ditto similar
		// Framework=Optional[Spring:20000:98]				  ditto similar	
		//}
		
		
		////group by course category with course name alone and not the entire Course Object
		System.out.println(
		courseList.stream()
			.collect(Collectors.groupingBy(course -> course.getCategory(),
						Collectors.mapping(course -> course.getName(), Collectors.toList()))));
		//Output:
		//{Cloud=[AWS, Azure, Docker, Kubernetes], 
		//FullStack=[FullStack], 
		//Microservices=[API, Microservices], 
		//Framework=[Spring, Spring Boot]}
		
		//All The above methods (especially group by) are very effective, it will take atleast 20 to 30 lines to write
		//in normal java procedural programming.
		
		
		
		//Just tried to recap Function functional interface.
		//Function<? super Course, ? extends String> classifier = course -> course.getName();
		//System.out.println(courseList.stream().collect(Collectors.groupingBy(classifier)));
		//System.out.println(classifier.apply(new Course("ex","matt",100, 1000)));
		
		
	}
	
}
