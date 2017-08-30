package adaLab;

import java.util.ArrayList;
import java.util.Scanner;

// This program includes bubble, insertion and selection sort

public class SortingBasic {

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
		System.out.println("Sorted Array: ");
		for (int i = 0; i < arr.size(); i++) {
			System.out.print(arr.get(i) + " ");
		}
	}

	public static int displayMenu() {
		System.out.print(
				"\nMENU\n" + "1.Bubble Sort\n" + "2.Selection Sort\n" + "3.Insertion Sort\n" + "Enter your choice: ");
		int choice = s.nextInt();
		return choice;
	}

	public static void bubbleSort() {
		for (int i = 0; i < arr.size(); i++) {
			for (int j = 0; j < arr.size() - i - 1; j++) {
				if (arr.get(j) > arr.get(j + 1)) {
					int temp = arr.get(j);
					arr.set(j, arr.get(j + 1));
					arr.set(j + 1, temp);
				}
			}
		}
	}

	public static void selectionSort() {
		int smallestPos;
		for (int i = 0; i < arr.size(); i++) {
			smallestPos = i;
			for (int j = i; j < arr.size(); j++) {
				if (arr.get(smallestPos) > arr.get(j)) {
					smallestPos = j;
				}
			}

			int temp = arr.get(i);
			arr.set(i, arr.get(smallestPos));
			arr.set(smallestPos, temp);
		}
	}

	public static void insertionSort() {
		for (int i = 1; i < arr.size(); i++) {
			int j = i - 1;
			int temp = arr.get(i);
			while (j >= 0 && temp < arr.get(j)) {
				arr.set(j + 1, arr.get(j));
				j--;
			}
			arr.set(j + 1, temp);
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
				bubbleSort();
				display();
				break;
			case 2:
				selectionSort();
				display();
				break;
			case 3:
				insertionSort();
				display();
				break;
			}
			System.out.print("\nDo you want to continue? (y or n): ");
			choiceToContinue = s.next();
		}
		s.close();
	}
}