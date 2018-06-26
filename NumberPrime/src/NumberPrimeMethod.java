import java.util.ArrayList;

public class NumberPrimeMethod {

	public static ArrayList<Integer> arrayPrime = new ArrayList<Integer>();
	public static ArrayList<Integer> arrayPrimeCircular = new ArrayList<Integer>();
	public static int range = 1000000;

	/**
	 * This Method check if a number is prime
	 * 
	 * @param n:is a number that will be check
	 * @return true or false if n is prime
	 */
	public static boolean IsPrime(int n) {

		if (n > 2 && n % 2 == 0) {

			return false;
		}

		int top = (int) Math.sqrt(n) + 1;

		for (int i = 3; i < top; i += 2) {

			if (n % i == 0) {

				return false;

			}

		}

		return true;

	}

	/**
	 * This Method search if a number is contained into arrayprime
	 * 
	 * @param b: number will be check if contain into array prime
	 * @return true or false if b is into array prime
	 */
	public static boolean searchBinary(int b) {

		int size = arrayPrime.size();

		int k;

		int i = 0;

		int j = size - 1;

		do {

			k = (i + j) / 2;

			if (arrayPrime.get(k) <= b)

				i = k + 1;

			if (arrayPrime.get(k) >= b)

				j = k - 1;

		} while (i <= j);

		if (arrayPrime.get(k) == b)
			return true;
		else
			return false;

	}

	/**
	 * This Method receive array of primes and find Circular Prime Numbers
	 * 
	 * @param arrayPrime contains all number primes of 1 -1000000
	 * @return arrayCircular contains all numbers with Circular property
	 */

	public static ArrayList<Integer> rotateNumberAndSearchPrimeCircular(ArrayList<Integer> arrayPrime) {

		ArrayList<Integer> arrayCircular = new ArrayList<Integer>();

		int size = arrayPrime.size();

		for (int i = size - 1; i >= 0; i--) {
			int number = arrayPrime.get(i);
			int start = number;

			int numdigits = (int) Math.log10((double) number);
			int multiplier = (int) Math.pow(10.0, (double) numdigits);

			while (true) {
				int r = number % 10;

				number = number / 10;
				number = number + multiplier * r;

				if (searchBinary(number) != true)
					break;
				if (number == start) {
					arrayCircular.add(number);
					break;
				}
			}

		}

		return arrayCircular;
	}

}
