package com.interviewpre.java8;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DemoJava8 {
	public static void main(String[] args) {

		System.out.println("we cant modify the local variable inside the java 8 code.");
		List<Integer> asList = Arrays.asList(1, 2, 3, 4);
		int sum = 0;
		asList.stream().forEach(System.out::print);
		System.out.println();

		System.out.println("=========================================");
		System.out.println("Declearing the local varible outside and accessing inside the java 8 code");
		String prifix = "Dr. ";
		List<String> asList2 = Arrays.asList("Kumar Balambeed", "Sunil Balambeed");
		asList2.stream().forEach(name -> System.out.println(prifix + name));
		System.out.println("==============================================");

		System.out.println("1) find the dublicate element from the list");
		List<Integer> list = Arrays.asList(1, 2, 3, 2, 4, 5, 1, 6);
		// creating the hashset to store unique element
		HashSet<Integer> unique = new HashSet<>();
		// 1)converting list to stream 2)filtering the element is not present in the set
		// 3) then collecting it in set as dublicate list
		Set<Integer> dublicate = list.stream().filter(n -> !unique.add(n)).collect(Collectors.toSet());
		System.out.println("Dublicate elements" + dublicate);

		System.out.println("2)find the first non reapeated charactor in the string.");
		String input = "programming";

		// 1) converting the string to stream chars 2) converting the chars to object )
		// grouping the objectects based on the occurance
		// 4)geting the entry set converting it into stream 5) based on the occurance
		// checking the and returning the first element.
		Character orElse = input.chars().mapToObj(e -> (char) e)
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().filter(entry -> entry.getValue() == 1).map(Map.Entry::getKey).findFirst()
				.orElse(null);

		System.out.println("first non reapeated charactor in string is " + orElse);

		System.out.println("3) sort the list of string based on the length , alphabetically");
		List<String> names = Arrays.asList("John", "Adam", "Tom", "Smith");
		// 1)using the comparator for sorting first by length then sorting by alphabet
		names.sort(Comparator.comparingInt(String::length).thenComparing(String::compareTo));
		System.out.println(names);

		System.out.println("4) List group of people by city");
		class Person {
			String name;
			String city;

			Person(String name, String city) {
				this.name = name;
				this.city = city;
			}

			@Override
			public String toString() {
				return "Person [name=" + name + ", city=" + city + "]";
			}
		}
		List<Person> people = Arrays.asList(new Person("John", "Delhi"), new Person("Jane", "Mumbai"),
				new Person("Jack", "Delhi"));

		Map<String, List<Person>> collect = people.stream().collect(Collectors.groupingBy(p -> p.city));
		System.out.println(collect);

		System.out.println("5) Convert list of strings to map with string as key and length as value");
		List<String> list1 = Arrays.asList("Java", "Spring", "Hibernate");
		Map<String, Long> collect2 = list1.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(collect2);

		System.out.println("6)FlatMap example – Convert list of list to single list");
		List<List<String>> nested = Arrays.asList(Arrays.asList("a", "b"), Arrays.asList("c", "d"), Arrays.asList("e"));

		List<String> collect3 = nested.stream().flatMap(Collection::stream).collect(Collectors.toList());
		System.out.println("converted the list of list list into single list " + collect3);

		System.out.println("7)Parallel Stream vs Sequential Stream Example");

		List<Integer> numbers = IntStream.range(1, 1000).boxed().collect(Collectors.toList());

		// Sequential
		long start = System.currentTimeMillis();
		numbers.stream().forEach(i -> {
		});
		System.out.println("Sequential: " + (System.currentTimeMillis() - start));

		// Parallel
		start = System.currentTimeMillis();
		numbers.parallelStream().forEach(i -> {
		});
		System.out.println("Parallel: " + (System.currentTimeMillis() - start));

		System.out.println("8) Use of Optional to avoid NullPointerException ");

		Optional<User> user = Optional.ofNullable(getUser());
		String name = user.map(User::getName).orElse("default");
		System.out.println(name);

		System.out.println("9)Count occurrences of each character in a string");
		String input1 = "banana";
		Map<Character, Long> collect4 = input1.chars().mapToObj(e -> (char) e)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(collect4);
	}

	private static User getUser() {
		// TODO Auto-generated method stub
		return null;
	}
}
