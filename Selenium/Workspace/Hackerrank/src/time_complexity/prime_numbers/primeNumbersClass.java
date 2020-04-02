package time_complexity.prime_numbers;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class primeNumbersClass {

	private static final Scanner scanner = new Scanner(System.in);
	private static List<Integer> data;

	public static void main(String[] args) {

		int n = scanner.nextInt();
		data = new ArrayList<>();

		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int counter = 0; counter < n; counter++)
			data.add(scanner.nextInt());

		for (Integer datum : data) {
			System.out.println(checkPrime(datum));
		}

	}

	private static String checkPrime(Integer datum) {
		if (datum == 1)
			return "Not prime";
		if (datum == 2 || datum == 3) {
			return "Prime";
		}
		if (datum / 2 <= 2) {

			if (datum % 2 == 0) {
				return "Not prime";
			} else {
				return "Prime";
			}

		}
		// datum = datum / 2;
		for (int i = 2; i <= datum / 2; i++) {
			System.out.println("datum % i :- " + datum % i);
			if (datum % i == 0) {
				System.out.println(" value of i is " + i);

				return "Not prime";
			}
		}
		return "Prime";
	}

}
