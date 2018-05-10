import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

import org.junit.Test;


public class FactorFindingMainTest {

	/** Helper method to test if two collections are equal to one another 
	 * in the "set" data structure sense (i.e. they contain the same elements, 
	 * but order doesn't matter) 
	 * 
	 * Java note: this is how you make a "generic" static method (with parameterized type T)
	 * */
	public static <T> boolean checkSetEquality(Collection<T> c1, Collection<T> c2) {
		return new HashSet<T>(c1).equals(new HashSet<T>(c2));
	}
	
	@Test
	public void testFactorSingleThreaded() {
		System.out.println("Note: this test could take a minute to run");
		
		assertTrue(checkSetEquality(FactorFindingMain.findFactors(1), Arrays.asList(1L)));
		assertTrue(checkSetEquality(FactorFindingMain.findFactors(2), Arrays.asList(1L,2L)));
		assertTrue(checkSetEquality(FactorFindingMain.findFactors(3), Arrays.asList(1L,3L)));
		assertTrue(checkSetEquality(FactorFindingMain.findFactors(4), Arrays.asList(1L,2L,4L)));
		assertTrue(checkSetEquality(FactorFindingMain.findFactors(5), Arrays.asList(1L,5L)));
		assertTrue(checkSetEquality(FactorFindingMain.findFactors(15), Arrays.asList(1L,3L,5L,15L)));
		assertTrue(checkSetEquality(FactorFindingMain.findFactors(24), Arrays.asList(1L,2L,3L,4L,6L,8L,12L,24L)));
		assertTrue(checkSetEquality(FactorFindingMain.findFactors(25), Arrays.asList(1L,5L,25L)));
		
		assertTrue(checkSetEquality(FactorFindingMain.findFactors(999999999999999988L), 
				Arrays.asList(1L,999999999999999988L,2L,499999999999999994L,4L,249999999999999997L,11L,90909090909090908L,22L,45454545454545454L,44L,22727272727272727L)));
		assertTrue(checkSetEquality(FactorFindingMain.findFactors(999999999999999989L), Arrays.asList(1L,999999999999999989L)));
		assertTrue(checkSetEquality(FactorFindingMain.findFactors(1236239552244530611L), 
				Arrays.asList(1L,1236239552244530611L,1000003L,1236235843537L,1003001L,1232540697611L,1232537L,1003004009003L)));
	}

	@Test
	public void testFactorMultiThreaded() throws InterruptedException {
		System.out.println("Note: this test could take a minute to run");
		
		assertTrue(checkSetEquality(FactorFindingMain.findFactorsMulti(1,1), Arrays.asList(1L)));
		assertTrue(checkSetEquality(FactorFindingMain.findFactorsMulti(2,4), Arrays.asList(1L,2L)));
		assertTrue(checkSetEquality(FactorFindingMain.findFactorsMulti(3,2), Arrays.asList(1L,3L)));
		assertTrue(checkSetEquality(FactorFindingMain.findFactorsMulti(4,1), Arrays.asList(1L,2L,4L)));
		assertTrue(checkSetEquality(FactorFindingMain.findFactorsMulti(5,2), Arrays.asList(1L,5L)));
		assertTrue(checkSetEquality(FactorFindingMain.findFactorsMulti(15,4), Arrays.asList(1L,3L,5L,15L)));
		assertTrue(checkSetEquality(FactorFindingMain.findFactorsMulti(24,4), Arrays.asList(1L,2L,3L,4L,6L,8L,12L,24L)));
		assertTrue(checkSetEquality(FactorFindingMain.findFactorsMulti(25,1), Arrays.asList(1L,5L,25L)));
		assertTrue(checkSetEquality(FactorFindingMain.findFactorsMulti(25,2), Arrays.asList(1L,5L,25L)));
		assertTrue(checkSetEquality(FactorFindingMain.findFactorsMulti(25,3), Arrays.asList(1L,5L,25L)));
		assertTrue(checkSetEquality(FactorFindingMain.findFactorsMulti(25,4), Arrays.asList(1L,5L,25L)));
		assertTrue(checkSetEquality(FactorFindingMain.findFactorsMulti(25,5), Arrays.asList(1L,5L,25L)));
		assertTrue(checkSetEquality(FactorFindingMain.findFactorsMulti(25,6), Arrays.asList(1L,5L,25L)));
		assertTrue(checkSetEquality(FactorFindingMain.findFactorsMulti(25,7), Arrays.asList(1L,5L,25L)));
		assertTrue(checkSetEquality(FactorFindingMain.findFactorsMulti(25,8), Arrays.asList(1L,5L,25L)));
		assertTrue(checkSetEquality(FactorFindingMain.findFactorsMulti(25,9), Arrays.asList(1L,5L,25L)));
		
		assertTrue(checkSetEquality(FactorFindingMain.findFactorsMulti(999999999999999988L,4), 
				Arrays.asList(1L,999999999999999988L,2L,499999999999999994L,4L,249999999999999997L,11L,90909090909090908L,22L,45454545454545454L,44L,22727272727272727L)));
		assertTrue(checkSetEquality(FactorFindingMain.findFactorsMulti(999999999999999989L,8), Arrays.asList(1L,999999999999999989L)));
		assertTrue(checkSetEquality(FactorFindingMain.findFactorsMulti(1236239552244530611L,6), 
				Arrays.asList(1L,1236239552244530611L,1000003L,1236235843537L,1003001L,1232540697611L,1232537L,1003004009003L)));
	}

	
	@Test
	public void testPrimeSingleThreaded() {
		System.out.println("Note: this test could take a minute to run");
		assertFalse(FactorFindingMain.isPrime(1));
		assertTrue(FactorFindingMain.isPrime(2));
		assertTrue(FactorFindingMain.isPrime(3));
		assertFalse(FactorFindingMain.isPrime(4));
		assertTrue(FactorFindingMain.isPrime(5));
		assertTrue(FactorFindingMain.isPrime(7));
		assertFalse(FactorFindingMain.isPrime(9));
		assertTrue(FactorFindingMain.isPrime(11));
		assertTrue(FactorFindingMain.isPrime(13));
		assertFalse(FactorFindingMain.isPrime(15));
		
		assertFalse(FactorFindingMain.isPrime(1236239552244530611L));
		assertFalse(FactorFindingMain.isPrime(999999874000003969L));
		assertTrue(FactorFindingMain.isPrime(999999999999999989L));
	}

	@Test
	public void testPrimeMultiThreaded() throws InterruptedException {
		System.out.println("Note: this test could take a minute to run");
		assertFalse(FactorFindingMain.isPrimeMulti(1,4));
		assertTrue(FactorFindingMain.isPrimeMulti(2,2));
		assertTrue(FactorFindingMain.isPrimeMulti(3,4));
		assertFalse(FactorFindingMain.isPrimeMulti(4,3));
		assertTrue(FactorFindingMain.isPrimeMulti(5,8));
		assertTrue(FactorFindingMain.isPrimeMulti(7,5));
		assertFalse(FactorFindingMain.isPrimeMulti(9,2));
		assertTrue(FactorFindingMain.isPrimeMulti(11,3));
		assertTrue(FactorFindingMain.isPrimeMulti(13,4));
		assertFalse(FactorFindingMain.isPrimeMulti(15,5));
		assertFalse(FactorFindingMain.isPrimeMulti(25,1));
		assertFalse(FactorFindingMain.isPrimeMulti(25,2));
		assertFalse(FactorFindingMain.isPrimeMulti(25,3));
		assertFalse(FactorFindingMain.isPrimeMulti(25,4));
		assertFalse(FactorFindingMain.isPrimeMulti(25,5));
		assertFalse(FactorFindingMain.isPrimeMulti(25,6));
		assertFalse(FactorFindingMain.isPrimeMulti(25,7));
		
		assertFalse(FactorFindingMain.isPrimeMulti(1236239552244530611L,3));
		assertFalse(FactorFindingMain.isPrimeMulti(999999874000003969L,4));
		assertTrue(FactorFindingMain.isPrimeMulti(999999999999999989L,5));
	}

}
