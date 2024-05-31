import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;

public class FP13Files {

	public static void main(String[] args) throws IOException {
		
		// To get the distinct words from the file
		System.out.println(
		Files.lines(Paths.get("file.txt")) //file keep it under the root of the proj and not under src.
		.distinct() //this will print distinct lines in the file
		.map(str -> str.split(" ")) // split the entire file with space delimiter and gives stream of string array
		//articulated output for the above line: [This] [file] [has] [got] [contents] .......
		.flatMap(Arrays::stream)
		.distinct()
		.collect(Collectors.toList()) 
		//output Stream of strings
		//From stream of String array To Stream of Strings:
		//[This, file, has, got, contents., Contents, contain, good, content., Content, is, about, data., Data, valuable., Highly]
		);
		
		
		//To print the directory files
		Files.list(Paths.get("."))
		.forEach(System.out::println);
		
		
	}
	
}
