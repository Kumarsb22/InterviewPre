package com.interviewpre.array;

import java.util.Arrays;

public class DemoArray {
	public static void main(String[] args) {
		// 1. Find the largest and smallest element in an array
		int[] arr = { 12, 7, 22, 3, 19 };
		findLargAndSmallElInArray(arr);
		// space complexity o(1) time complexity o(n)

		// 2. Find the second largest element in an array
		int[] arr1 = { 10, 20, 4, 45, 99 };
		System.out.println("Second Largest Element is " + findTheSecondLargestElINArray(arr1));
		// space complexity o(1) time complexity o(n)

		// 3. Reverse an array
		int[] arr2 = { 1, 2, 3, 4, 5 };
		System.out.println("Reversing the given array "+Arrays.toString(reverseArray(arr2)));
		//space complexity o(1) time complexity o(log n)
		
		//4. Check if array is sorted
		 int[] arr3 = {1, 2, 3, 4, 5};
		 System.out.println("is Given array sorted or not => "+ isArraySorted(arr3));
		 //space complexity o(1) and time complexity o(n)
		 
		 //5. Remove duplicates from sorted array (in-place)
		  int[] arr4 = {1,1,2,2,3,4,4};
		  
//		  5. Remove duplicates from sorted array (in-place)
//		  public class RemoveDuplicates {
//		      public static int removeDuplicates(int[] nums) {
//		          if (nums.length == 0) return 0;
//		          int j = 0;
//
//		          for (int i = 1; i < nums.length; i++) {
//		              if (nums[i] != nums[j]) {
//		                  j++;
//		                  nums[j] = nums[i];
//		              }
//		          }
//		          return j + 1; // length of unique array
//		      }
//
//		      public static void main(String[] args) {
//		          int[] arr = {1,1,2,2,3,4,4};
//		          int len = removeDuplicates(arr);
//		          for (int i = 0; i < len; i++) {
//		              System.out.print(arr[i] + " ");
//		          }
//		      }
//		  }
//
//
//		  👉 Classic service company interview question (Wipro, TCS, Infosys).
//
//		  6. Find missing number in an array (1 to N)
//		  public class MissingNumber {
//		      public static void main(String[] args) {
//		          int[] arr = {1, 2, 4, 5, 6};
//		          int n = arr.length + 1;
//		          int expectedSum = n * (n + 1) / 2;
//
//		          int actualSum = 0;
//		          for (int num : arr) {
//		              actualSum += num;
//		          }
//		          System.out.println("Missing Number: " + (expectedSum - actualSum));
//		      }
//		  }
//
//		  7. Find duplicate elements in an array
//		  import java.util.HashSet;
//
//		  public class FindDuplicates {
//		      public static void main(String[] args) {
//		          int[] arr = {4, 2, 7, 4, 8, 2};
//		          HashSet<Integer> seen = new HashSet<>();
//		          HashSet<Integer> duplicates = new HashSet<>();
//
//		          for (int num : arr) {
//		              if (!seen.add(num)) {
//		                  duplicates.add(num);
//		              }
//		          }
//		          System.out.println("Duplicates: " + duplicates);
//		      }
//		  }
//
//
//		  👉 Many companies ask with and without extra space.
//
//		  8. Rotate an array (cyclic rotation)
//		  import java.util.Arrays;
//
//		  public class RotateArray {
//		      public static void main(String[] args) {
//		          int[] arr = {1,2,3,4,5};
//		          int k = 2; // rotate by 2
//		          int n = arr.length;
//
//		          k = k % n;
//		          reverse(arr, 0, n-1);
//		          reverse(arr, 0, k-1);
//		          reverse(arr, k, n-1);
//
//		          System.out.println(Arrays.toString(arr));
//		      }
//
//		      static void reverse(int[] arr, int l, int r) {
//		          while (l < r) {
//		              int temp = arr[l];
//		              arr[l] = arr[r];
//		              arr[r] = temp;
//		              l++; r--;
//		          }
//		      }
//		  }
//
//		  9. Find subarray with maximum sum (Kadane’s Algorithm)
//		  public class MaxSubArraySum {
//		      public static void main(String[] args) {
//		          int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
//		          int maxSoFar = arr[0], currMax = arr[0];
//
//		          for (int i = 1; i < arr.length; i++) {
//		              currMax = Math.max(arr[i], currMax + arr[i]);
//		              maxSoFar = Math.max(maxSoFar, currMax);
//		          }
//		          System.out.println("Maximum Subarray Sum: " + maxSoFar);
//		      }
//		  }
//
//
//		  👉 Common in product-based companies, but service MNCs also ask.
//
//		  10. Two Sum Problem
//		  import java.util.HashMap;
//
//		  public class TwoSum {
//		      public static void main(String[] args) {
//		          int[] arr = {2, 7, 11, 15};
//		          int target = 9;
//
//		          HashMap<Integer, Integer> map = new HashMap<>();
//		          for (int i = 0; i < arr.length; i++) {
//		              int diff = target - arr[i];
//		              if (map.containsKey(diff)) {
//		                  System.out.println("Pair: " + diff + ", " + arr[i]);
//		                  return;
//		              }
//		              map.put(arr[i], i);
//		          }
//		      }
//		  }

	}
	private static boolean isArraySorted(int arr[]) {
		boolean isSorted=true;
		for(int i=1;i<arr.length;i++) {
			if(arr[i]<arr[i-1]) {
				isSorted=false;
				break;
			}
		}
		return isSorted;
	}

	private static int[] reverseArray(int[] arr) {
		int left = 0, right = arr.length - 1;
		while (left < right) {
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;
		}
		return arr;
	}

	private static int findTheSecondLargestElINArray(int arr[]) {
		int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
		for (int num : arr) {
			if (num > first) {
				second = first;
				first = num;
			} else if (num > second && num != first)
				second = num;
		}
		return second;
	}

	private static void findLargAndSmallElInArray(int[] arr) {
		int small = arr[0], large = arr[0];
		for (int a : arr) {
			if (small > a)
				small = a;
			if (large < a)
				large = a;
		}
		System.out.println("large element " + large + " small element " + small);
	}
}
