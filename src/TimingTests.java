
public class TimingTests {

	public static void main(String args[]) throws InterruptedException{
		
		long startTime = System.nanoTime();
		FactorFindingMain.findFactorsMulti(999999999999999988L,1);
		long endTime = System.nanoTime();
		System.out.println("Execution time for 1 thread is: " + ((endTime - startTime) / 1000000) + "ms");
		
		startTime = System.nanoTime();
		FactorFindingMain.findFactorsMulti(999999999999999988L,2);
		endTime = System.nanoTime();
		System.out.println("Execution time for 2 threads is: " + ((endTime - startTime) / 1000000) + "ms");
		
		startTime = System.nanoTime();
		FactorFindingMain.findFactorsMulti(999999999999999988L,3);
		endTime = System.nanoTime();
		System.out.println("Execution time for 3 threads is: " + ((endTime - startTime) / 1000000) + "ms");
		
		startTime = System.nanoTime();
		FactorFindingMain.findFactorsMulti(999999999999999988L,4);
		endTime = System.nanoTime();
		System.out.println("Execution time for 4 threads is: " + ((endTime - startTime) / 1000000) + "ms");
		
		startTime = System.nanoTime();
		FactorFindingMain.findFactorsMulti(999999999999999988L,8);
		endTime = System.nanoTime();
		System.out.println("Execution time for 8 threads is: " + ((endTime - startTime) / 1000000) + "ms");
		
		startTime = System.nanoTime();
		FactorFindingMain.findFactorsMulti(999999999999999988L,16);
		endTime = System.nanoTime();
		System.out.println("Execution time for 16 threads is: " + ((endTime - startTime) / 1000000) + "ms");
		
		startTime = System.nanoTime();
		FactorFindingMain.findFactorsMulti(999999999999999988L,32);
		endTime = System.nanoTime();
		System.out.println("Execution time for 32 threads is: " + ((endTime - startTime) / 1000000) + "ms");
		
		startTime = System.nanoTime();
		FactorFindingMain.findFactorsMulti(999999999999999988L,100000);
		endTime = System.nanoTime();
		System.out.println("Execution time for 100K threads is: " + ((endTime - startTime) / 1000000) + "ms");
		
		startTime = System.nanoTime();
		FactorFindingMain.findFactorsMulti(999999999999999988L,1000000);
		endTime = System.nanoTime();
		System.out.println("Execution time for 1M threads is: " + ((endTime - startTime) / 1000000) + "ms");
	}
	
}
