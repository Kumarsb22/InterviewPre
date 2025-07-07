package com.interviewpre.number;

public class DemoNumber {
	public static void main(String[] args) {
		evenOrOdd(2);
		fact(5);
		fibonici(10);
		System.out.println();
		System.out.println("number is prime " + prime(1));
		printNPrime(100);
		System.out.println();
		System.out.println("Sum of the digits is " + sumOfDigit(12345));

	}

	private static void evenOrOdd(int num) {
		if (num % 2 == 0)
			System.out.println(num + " is the even number");
		else
			System.out.println(num + " is the odd number");
	}

	private static void fact(int num) {
		int fact = 1;
		for (int i = 1; i < num; i++)
			fact = fact * i;
		System.out.println(num + " factorial is " + fact);
//		fact=num*(num-1)+1/2;
//		System.out.println(fact);

	}

	private static void fibonici(int num) {
		System.out.println("using for loop");
		int a = 0, b = 1;
		for (int i = 1; i <= num; i++) {
			int c = a + b;
			System.out.print(" " + a);
			b = a;
			a = c;
		}
		System.out.println();
		System.out.println("using while loop");

		int i = 1, a1 = 0, b1 = 1;
		while (i <= num) {
			i++;
			int c = a1 + b1;
			System.out.print(" " + a1);
			a1 = b1;
			b1 = c;
		}
	}

	private static boolean prime(int n) {
		if (n == 0 || n == 1)
			return false;
		int count = 0;
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % 2 == 0)
				count++;
			if (count > 0)
				return false;
		}

		return true;
	}

	private static void printNPrime(int n) {
		for (int i = 2; i < n; i++) {
			if (prime(i))
				System.out.print(i + " ");
		}

	}

	private static int sumOfDigit(int n) {
		int sum = 0;
		while (n != 0) {
			sum += n % 10;
			n = n / 10;
		}
		return sum;
	}

	private static boolean isArmstrongNum(int n) {
		int count = 0, copy = n;
		while (copy != 0) {
			count++;
			copy /= 10;
		}
		copy=n;
		while(copy!=0) {
			int rem=copy%10;
		}
		return false;

	}
}
