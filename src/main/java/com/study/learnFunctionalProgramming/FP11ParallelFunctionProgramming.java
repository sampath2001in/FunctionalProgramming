import java.util.List;
import java.util.stream.LongStream;

public class FP11ParallelFunctionProgramming {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		long startTime = System.currentTimeMillis();
		System.out.println(
				LongStream.range(0, 2099999999L).sum()
				);
		//System.out.println(System.currentTimeMillis() - startTime); //5158 millisecs
		
		
		//with parallelization
		long startTime1 = System.currentTimeMillis();
		LongStream.range(0, 2099999999L).parallel().sum();
		System.out.println(System.currentTimeMillis() - startTime1); //227 millisecs
		
		// look at the difference, 227 Mill secs with parallelization.
		
		//***************Another example of parallel***************************************		
		
		List<Integer> nums = List.of(1,6,8,9,1234,66,79);
		
		/*
		 * System.out.println( nums.stream().reduce(0, Integer::sum) );
		 */
		
		
		System.out.println(
				nums.stream().reduce(0, (x,y) -> (x+y))
		);
		
		//with parallelization
		
		System.out.println(
				nums.stream().parallel().reduce(0, (x,y) -> (x+y))
		);
	}

}
