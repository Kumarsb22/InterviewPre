package com.interviewpre.string;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class StringDemo {
	public static void main(String[] args) {
		swapStringWTV("Hello", "World");
		System.out.println("abba is Palindrome");
		System.out.println(isPalindrom("abba"));

		System.out.println("The String is Anogram or not");
		System.out.println(areAnogramsPM("listen", "silent"));
		System.out.println(areAnograms("listen", "silent"));
		System.out.println("Length of longest subString");
		System.out.println(lengthOfLogestSubString("Kumar"));
		System.out.println("first non repeatin char");
		System.out.println(firstNonRepeatingChar("Kumar"));
		System.out.println("Reverse The sentence ");
		System.out.println(reversWord("Hello Kumar Balambeed Java Developer "));
		System.out.println("String is contains the number or not");
		System.out.println(isDigit("Kumar Balambeed"));
		
		System.out.println("Count and remove the dublicate from string");
		System.out.println(countDublicRemove("Kumara"));
	}

	private static Map<Character, Integer> countDublicRemove(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for (Character c : s.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		return map.entrySet().stream().filter(e -> e.getValue() > 1)
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
	}

	private static boolean isDigit(String s) {
		return s.matches("\\d+");
	}

	private static String reversWord(String s) {
		// new StringBuilder(s).reverse();
		StringBuilder builder = new StringBuilder();
		String[] split = s.trim().split(" ");
		for (String s1 : split) {
			builder.append(new StringBuilder(s1).reverse().append(" "));
		}
		return builder.toString();
		// Collections.reverse(Arrays.asList(split));
		// return String.join(" ", split);
		// return new StringBuilder(s).reverse().toString();
	}

	private static char firstNonRepeatingChar(String str) {
		Map<Character, Integer> map = new LinkedHashMap<>();
		for (char c : str.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			if (entry.getValue() == 1)
				return entry.getKey();
		}
		return '0';
	}

	private static int lengthOfLogestSubString(String s) {
		Map<Character, Integer> map = new HashMap<>();
		int maxLen = 0;
		for (int start = 0, end = 0; end < s.length(); end++) {
			char ch = s.charAt(end);
			if (map.containsKey(end)) {
				start = Math.max(map.get(ch), start);
			}
			map.put(ch, end);
			maxLen = Math.max(maxLen, end - start + 1);
		}
		return maxLen;
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
		int left = 0, rigth = s.length() - 1;
		while (left < rigth) {
			if (s.charAt(left++) != s.charAt(rigth--))
				return false;
		}
		return true;
	}

	private static boolean areAnogramsPM(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		char[] charArray1 = s1.toCharArray();
		char[] charArray2 = s2.toCharArray();
		Arrays.sort(charArray2);
		Arrays.sort(charArray1);
		// time complexity o(n log n) Auxilary Space o(n) + o(n)
		return Arrays.equals(charArray1, charArray2);
	}

	private static boolean areAnograms(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		int count[] = new int[256];
		for (int i = 0; i < s1.length(); i++) {
			count[s1.charAt(i)]++;
			count[s2.charAt(i)]--;
		}
		for (int i : count) {
			if (i != 0)
				return false;
		}
		return true;
	}
}
