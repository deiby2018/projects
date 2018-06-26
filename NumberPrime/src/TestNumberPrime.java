import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

public class TestNumberPrime {

	Random random = new Random();

	@Test
	public void testIsCircularPrime() {
		/**
		 * This test Checks if a number has a circular property
		 */
		for (int j = 1; j < NumberPrimeMethod.range; j++) {

			if (NumberPrimeMethod.IsPrime(j)) {

				System.out.print(j + " ");
				NumberPrimeMethod.arrayPrime.add(j);
			}
		}

		NumberPrimeMethod.arrayPrimeCircular = NumberPrimeMethod
				.rotateNumberAndSearchPrimeCircular(NumberPrimeMethod.arrayPrime);

		assertTrue(NumberPrimeMethod.searchBinary(
				NumberPrimeMethod.arrayPrimeCircular.get(random.nextInt(NumberPrimeMethod.arrayPrimeCircular.size()))));

		System.out.println();
	}

	@Test
	public void testNumberPairIsNotPrime() {
		/**
		 * This test checks that a pair number is not prime
		 */

		for (int j = 1; j < NumberPrimeMethod.range; j++) {

			if (NumberPrimeMethod.IsPrime(j)) {
				System.out.print(j + " ");
				NumberPrimeMethod.arrayPrime.add(j);
			}
		}

		NumberPrimeMethod.arrayPrimeCircular = NumberPrimeMethod
				.rotateNumberAndSearchPrimeCircular(NumberPrimeMethod.arrayPrime);

		assertFalse(NumberPrimeMethod.searchBinary(random.nextInt(500000) * 2));
		System.out.println();
	}

	@Test
	public void testIsPrime() {
		/**
		 * This test checks that numbers generate are primes
		 */
		for (int j = 1; j < NumberPrimeMethod.range; j++) {

			if (NumberPrimeMethod.IsPrime(j)) {
				System.out.print(j + " ");
				NumberPrimeMethod.arrayPrime.add(j);
			}
		}
		assertTrue(NumberPrimeMethod
				.searchBinary(NumberPrimeMethod.arrayPrime.get(random.nextInt(NumberPrimeMethod.arrayPrime.size()))));
	}

}
