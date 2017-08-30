package adaLab;


import java.util.ArrayList;
import java.util.Scanner;

//This program shows linear search and binary search

public class Searching {

	static Scanner s = new Scanner(System.in);
	static ArrayList<Integer> arr;

	public static void setInputArray() {
		int size;
		arr = new ArrayList<>();
		System.out.print("Enter the size of array: ");
		size = s.nextInt();
		System.out.println("Enter array elements:");
		for (int i = 0; i < size; i++) {
			System.out.print("Ele " + (i + 1) + ": ");
			arr.add(s.nextInt());
		}
	}

	public static void display() {
		System.out.println("Input Array: ");
		for (int i = 0; i < arr.size(); i++) {
			System.out.print(arr.get(i) + " ");
		}
	}

	public static int displayMenu() {
		System.out.print("\nMENU\n" + "1.Linear Search\n" + "2.Binary Search\n" + "Enter your choice: ");
		int choice = s.nextInt();
		return choice;
	}

	public static void linearSearch() {
		int searchEle, flag = 0, pos = -1;
		System.out.print("\nEnter the number to be searched : ");
		searchEle = s.nextInt();
		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i) == searchEle) {
				flag = 1;
				pos = i + 1;
				break;
			}
		}
		if (flag == 0) {
			System.out.println("/nNumber not found..!!");
		} else {
			System.out.println("First occurence of " + searchEle + " is found at position " + pos);
		}
	}

	public static void binarySearch() {

		int searchEle, first, last, middle;
		System.out.print("\nEnter the number to be searched : ");
		searchEle = s.nextInt();
		first = 0;
		last = arr.size() - 1;
		middle = (first + last) / 2;
		while (first <= last) {
			if (arr.get(middle) < searchEle) {
				first = middle + 1;

			} else if (arr.get(middle) == searchEle) {
				System.out.println("" + searchEle + " found at location " + (middle + 1));
				break;
			} else {
				last = middle - 1;
			}
			middle = (first + last) / 2;
		}
		if (first > last) {
			System.out.println("Not found! " + searchEle + " is not present in the list.");
		}
	}

	public static void main(String[] args) {
		int choice;
		String choiceToContinue = "y";

		while (choiceToContinue.equalsIgnoreCase("y")) {
			choice = displayMenu();
			setInputArray();
			switch (choice) {
			case 1:
				display();
				linearSearch();

				break;
			case 2:
				display();
				binarySearch();
				break;
			}
			System.out.print("\nDo you want to continue? (y or n): ");
			choiceToContinue = s.next();
		}
		s.close();
	}
}
