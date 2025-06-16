package com.interviewpre.string;

public class StringDemo {
	public static void main(String[] args) {
		swapStringWTV("Hello", "World");

	}

	private static void swapStringWTV(String s1, String s2) {
		System.out.println("Before swap");
		System.out.println(s1 + " " + s2);
		s1 = s1 + s2;
		s2 = s1.substring(0, s1.length() - s2.length());
		s1=s1.substring(s2.length(),s1.length());
		System.out.println("Ofter swap");
		System.out.println(s1 + " " + s2);

	}
}
