package com.interviewpre.recursion;

public class DemoRecursion {
	public static void main(String[] args) {
		System.out.println(fact(5));
		naturalNum(10);

	}

	private static int fact(int n) {
		if (n == 0 || n == 1)
			return 1;
		return fact(n - 1) * n;
	}

	private static void naturalNum(int n) {
		if (n == 0)
			return;

		naturalNum(n - 1);
		System.out.print(n + " ");
	}
}
