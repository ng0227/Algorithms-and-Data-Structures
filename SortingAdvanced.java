package adaLab;

import java.util.ArrayList;
import java.util.Scanner;

public class SortingAdvanced {

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

	public static void display(ArrayList<Integer> arr) {
		System.out.println("Sorted Array: ");
		for (int i = 0; i < arr.size(); i++) {
			System.out.print(arr.get(i) + " ");
		}
	}

	public static int displayMenu() {
		System.out.print("\nMENU\n" + "1.Quick Sort\n" + "2.Merge Sort\n" + "Enter your choice: ");
		int choice = s.nextInt();
		return choice;
	}

	// returns pivot index represented as pi
	// first element is taken as pivot
	private static int partition(int start, int end) {

		int pivot = arr.get(start);
		int leftMark = start;
		int rightMark = end;
		int temp;

		while (leftMark < rightMark) {
			while (leftMark < arr.size() && arr.get(leftMark) <= pivot)
				leftMark++;

			while (arr.get(rightMark) > pivot) // equal to is not here as only one partition can consider it.
				rightMark--;

			if (leftMark < rightMark) {
				// swap the elements
				temp = arr.get(leftMark);
				arr.set(leftMark, arr.get(rightMark));
				arr.set(rightMark, temp);
			} else {
				arr.set(start, arr.get(rightMark));
				arr.set(rightMark, pivot);
			}
		}
		return rightMark;
	}

	public static void quickSort(int start, int end) {

		if (start < end) {
			int pi = partition(start, end);
			quickSort(0, pi - 1);
			quickSort(pi + 1, end);
		}
	}

	public static void mergeSort(int start, int end) {
		if (start == end)
			return;

		int mid = (start + end) / 2;
		mergeSort(start, mid);
		mergeSort(mid + 1, end);
		merge(start, mid, end);
	}

	private static void merge(int start, int mid, int end) {

		ArrayList<Integer> leftSubArray=new ArrayList<>();
		ArrayList<Integer> rightSubArray=new ArrayList<>();
		
		int i = mid-start+1;
		int j = end-mid;
		
		for(int x=0;x<i;x++) {
			leftSubArray.add(arr.get(start+x));
		}
		for(int y=0;y<j;y++) {
			rightSubArray.add(arr.get(mid+1+y));
		}
		
		int x=0,y=0;
		int k=start;
		while (x<i && y<j) {
			if (leftSubArray.get(x) > rightSubArray.get(y)){
				arr.set(k,rightSubArray.get(y));
				y++;
			} else {
				arr.set(k, leftSubArray.get(x));
				x++;
			}
			k++;
		}

		while (x <i) {
			arr.set(k, leftSubArray.get(x));
			x++;
			k++;
		}
		while (y <j) {
			
			arr.set(k, rightSubArray.get(y));
			y++;
			k++;
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
				quickSort(0, arr.size() - 1);
				display(arr);
				break;
			case 2:
				mergeSort(0, arr.size() - 1);
				display(arr);
				break;
			}
			System.out.print("\nDo you want to continue? (y or n): ");
			choiceToContinue = s.next();
		}
		s.close();
	}
}
