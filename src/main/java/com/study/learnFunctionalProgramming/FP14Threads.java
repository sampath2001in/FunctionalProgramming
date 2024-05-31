public class FP14Threads {

	public static void main(String[] args) {
		
		// Normal Threads
		Runnable Opn = new Runnable() {

			@Override
			public void run() {
				for (int i =1; i <100; i++) {
					System.out.println(Thread.currentThread().getName() + " :"  + i);
				}
			}
			
		};
		
		Thread t1 = new Thread(Opn);
		t1.start();
		
		Thread t2 = new Thread(Opn);
		t2.start();
	
	
	
		//Threads with Functional Programming
		//We avoid the usage of explicitly defining the run() method using FP.
		Runnable funcProgRunnable = () -> {
			for (int i =1; i <100; i++) {
				System.out.println(Thread.currentThread().getName() + " Functional Programming: "  + i);
			}
		};
		
		Thread t3 = new Thread(funcProgRunnable);
		t3.start();


	}
	

}
