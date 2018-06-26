
public class PrimeNumber {

	public static void main(String[] args) {

		long start = System.nanoTime();

		for (int j = 1; j < NumberPrimeMethod.range; j++) {

			if (NumberPrimeMethod.IsPrime(j)) {

				System.out.print(j + " ");
				NumberPrimeMethod.arrayPrime.add(j);
			}
		}

		NumberPrimeMethod.arrayPrimeCircular = NumberPrimeMethod
				.rotateNumberAndSearchPrimeCircular(NumberPrimeMethod.arrayPrime);

		System.out.println();

		for (int i = 0; i < NumberPrimeMethod.arrayPrimeCircular.size(); i++) {
			System.out.println("The number : " + NumberPrimeMethod.arrayPrimeCircular.get(i) + " is circilar prime");
		}
		long end = System.nanoTime();
		System.out.println();
		System.out.println("The amount of Circular Prime Number is: " + NumberPrimeMethod.arrayPrimeCircular.size());
		System.out.println();
		System.out.println("The time is: " + (end - start) + " in nano secounds");

	}

}