import java.util.ArrayList;
//import java.util.ImmutableCollections;
import java.util.List;

public class FP12FPMakesJavaEasy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> courses = List.of("Spring", "Spring Boot", "API" , "Microservices","AWS", "PCF","Azure", 
				"Docker", "Kubernetes");

		//List created using List.of is immutable
		/*
		 * static <E> List<E> of(E e1, E e2, E e3, E e4, E e5, E e6, E e7, E e8, E e9) {
		 * return ImmutableCollections.listFromTrustedArray(e1, e2, e3, e4, e5, e6, e7,
		 * e8, e9); }
		 */
		//System.out.println(
				//courses.replaceAll(course -> course.toUpperCase()); //exception: Immutable collection
		//);		
				
		//No streams here only List
		//List created using new ArrayList is mutable.
		//the methods like replaceAll and removeIf are added to the List after Java 8.
		List<String> modifiableCourses = new ArrayList(courses); //.replaceAll(course -> course.toUpperCase());
		modifiableCourses.replaceAll(course -> course.toUpperCase());
		System.out.println(modifiableCourses);
		//output: [SPRING, SPRING BOOT, API, MICROSERVICES, AWS, PCF, AZURE, DOCKER, KUBERNETES]
		
		//removeIf
		System.out.println(
				modifiableCourses.removeIf(course -> course.length() < 5)
		); //output: true
		
		System.out.println(modifiableCourses);
		//output: [SPRING, SPRING BOOT, MICROSERVICES, AZURE, DOCKER, KUBERNETES]

		
	}

}
