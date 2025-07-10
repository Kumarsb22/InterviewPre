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
		System.out.println("The Number is armstrong = " + isArmstrongNum(153));
		System.out.println("The Number is Strong = " + isStrongNumber(145));
		System.out.println("The Power of the Numbern is " + powerNumber(2, 3));
		System.out.println("The number is palidrome " + isNumberPalindrome(12321));
		System.out.println("Reverse the number " + reverseNumber(123));
		System.out.println("Digit count " + digitCount(12345));
		System.out.println("Binary count " + binaryCount(123401010));
		quatRem(12, 4);
		System.out.println(revStringUFor("I Love Myself"));
		System.out.println(revStrinUWhileAndisStringPalindrom("gadag"));

	}

	private static String revStringUFor(String s) {
		StringBuilder builder = new StringBuilder();
		for (int i = s.length() - 1; i >= 0; i--) {
			builder.append(s.charAt(i));
		}
		return builder.toString();
	}

	private static boolean revStrinUWhileAndisStringPalindrom(String s) {
		String s2 = s;
		int n = s.length() - 1;
		StringBuilder builder = new StringBuilder();
		while (n >= 0) {
			builder.append(s.charAt(n--));
		}
		System.out.println("Reversed the String using while loop " + builder.toString());
		return builder.toString().equals(s2);
	}

	private static String revStriWiLoops(String s) {
		char[] charArray = s.toCharArray();
		int i = 0, j = s.length() - 1;

		return s;
	}

	private static void quatRem(int a, int b) {
		System.out.println("Quotient " + (a / b));
		System.out.println("Remender " + (a % b));
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
		int count = 0, copy = n, sum = 0;
		while (copy != 0) {
			count++;
			copy /= 10;
		}
		copy = n;
		while (copy != 0) {
			int rem = copy % 10;
			sum += Math.pow(rem, count);
			copy /= 10;
		}
		return sum == n;
	}

	private static boolean isStrongNumber(int n) {
		int sum = 0, m = n;
		while (m != 0) {
			int rem = m % 10;
			int fact = 1;
			for (int i = 1; i <= rem; i++)
				fact *= i;
			sum += fact;
			m /= 10;
		}
		return n == sum;
	}

	private static int binaryCount(int n) {
		int count = 0;
		while (n != 0) {
			int rem = n % 10;
			if (rem == 0 || rem == 1)
				count++;
			n /= 10;
		}
		return count;
	}

	private static int digitCount(int n) {
		int count = 0;
		while (n != 0) {
			n = n / 10;
			count++;
		}
		return count;
	}

	private static int reverseNumber(int n) {
		int rev = 0;
		while (n != 0) {
			int rem = n % 10;
			rev = rev * 10 + rem;
			n = n / 10;
		}
		return rev;
	}

	private static boolean isNumberPalindrome(int n) {
		int rev = 0, m = n;
		while (m != 0) {
			int rem = m % 10;
			rev = rev * 10 + rem;
			m = m / 10;
		}
		return n == rev;
	}

	private static double powerNumber(int n, int p) {
		return Math.pow(n, p);
	}

}
