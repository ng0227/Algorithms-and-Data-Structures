package adaLab;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class SortingBasicWithTimeComplexity {

	private static final String PARAM_SORTED = "Sorted Array";

	static Scanner s = new Scanner(System.in);
	static ArrayList<Integer> arr;

	public static void setInputArrayRandomly() {
		int size;
		arr = new ArrayList<>();
		System.out.print("Enter the size of array: ");
		size = s.nextInt();

		Random random = new Random();

		for (int i = 0; i < size; i++) {
			arr.add(random.nextInt(0 + (2 * size)));
		}
		display("The randomly generated input array");
	}

	public static void setInputAscending() {
		int size;
		arr = new ArrayList<>();
		System.out.print("Enter the size of array: ");
		size = s.nextInt();

		for (int i = 0; i < size; i++) {
			arr.add(i + 2);
		}

		display("Ascending Input Array");
	}

	public static void setInputDescending() {
		int size;
		arr = new ArrayList<>();
		System.out.print("Enter the size of array: ");
		size = s.nextInt();

		for (int i = size; i > 0; i--) {
			arr.add(i);
		}
		display("Descending Input Array");
	}

	public static void display(String message) {
		System.out.println("\n" + message + " : ");
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

		String choiceToContinue = "y";
		while (choiceToContinue.equalsIgnoreCase("y")) {
			inputTimeComlexityCaseWise();

			long startTime = System.nanoTime();

			for (int i = 0; i < arr.size(); i++) {
				for (int j = 0; j < arr.size() - i - 1; j++) {
					if (arr.get(j) > arr.get(j + 1)) {
						int temp = arr.get(j);
						arr.set(j, arr.get(j + 1));
						arr.set(j + 1, temp);
					}
				}
			}

			long endTime = System.nanoTime();
			long duration = (endTime - startTime) / 1000000;
			display(PARAM_SORTED);
			System.out.println("\nThe time taken to sort the given array is: " + duration + " milliseconds");
			System.out.print("\nDo you want to continue with input menu? (y or n): ");
			choiceToContinue = s.next();
		}
	}

	public static void selectionSort() {

		String choiceToContinue = "y";
		while (choiceToContinue.equalsIgnoreCase("y")) {
			inputTimeComlexityCaseWise();

			long startTime = System.nanoTime();

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

			long endTime = System.nanoTime();
			long duration = (endTime - startTime) / 1000000;
			display(PARAM_SORTED);
			System.out.println("\nThe time taken to sort the given array is: " + duration + " milliseconds");
			System.out.print("\nDo you want to continue with input menu? (y or n): ");
			choiceToContinue = s.next();
		}
	}

	public static void insertionSort() {

		String choiceToContinue = "y";
		while (choiceToContinue.equalsIgnoreCase("y")) {
			inputTimeComlexityCaseWise();

			long startTime = System.nanoTime();

			for (int i = 1; i < arr.size(); i++) {
				int j = i - 1;
				int temp = arr.get(i);
				while (j >= 0 && temp < arr.get(j)) {
					arr.set(j + 1, arr.get(j));
					j--;
				}
				arr.set(j + 1, temp);
			}

			long endTime = System.nanoTime();
			long duration = (endTime - startTime) / 1000000;
			display(PARAM_SORTED);
			System.out.println("\nThe time taken to sort the given array is: " + duration + " milliseconds");
			System.out.print("\nDo you want to continue with input menu? (y or n): ");
			choiceToContinue = s.next();
		}
	}

	public static void inputTimeComlexityCaseWise() {

		System.out.print(
				"\nINPUT MENU\n" + "1.BestCase\n" + "2.Average Case\n" + "3. Worst Case\n" + "Enter your choice: ");
		int choice = s.nextInt();
		switch (choice) {
		case 1:
			setInputAscending();
			break;
		case 2:
			setInputArrayRandomly();
			break;
		case 3:
			setInputDescending();
			break;
		}
	}

	public static void main(String[] args) {
		int choice;
		String choiceToContinue = "y";

		while (choiceToContinue.equalsIgnoreCase("y")) {
			choice = displayMenu();
			switch (choice) {
			case 1:
				bubbleSort();
				break;
			case 2:
				selectionSort();
				break;
			case 3:
				insertionSort();
				break;
			}
			System.out.print("\nDo you want to continue with main menu? (y or n): ");
			choiceToContinue = s.next();
		}
		s.close();
	}
}