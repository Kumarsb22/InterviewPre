package com.interviewpre.string;

public class StringDemo {
	public static void main(String[] args) {
		swapStringWTV("Hello", "World");
	    System.out.println("abba is Palindrome");
		System.out.println(isPalindrom("abba"));
       
	}

	private static void swapStringWTV(String s1, String s2) {
		System.out.println("Before swap");
		System.out.println(s1 + " " + s2);
		s1 = s1 + s2;
		s2 = s1.substring(0, s1.length() - s2.length());
		s1 = s1.substring(s2.length(), s1.length());
		System.out.println("Ofter swap");
		System.out.println(s1 + " " + s2);
		
	}

	private static boolean isPalindrom(String s) {
		int left = 0, rigth = s.length()-1;
		while (left < rigth) {
			if (s.charAt(left++) != s.charAt(rigth--))
				return false;
		}
		return true;
	}
}
