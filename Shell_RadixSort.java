package adaLab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Shell_RadixSort {

	static ArrayList<Integer> inputArray;
	static Scanner s = new Scanner(System.in);
	
	
	public static void shellSort() {
		int size=inputArray.size();
		for (int gap = size/2; gap > 0; gap /= 2)
        {
            for (int i = gap; i < size; i += 1)
            {
                int temp = inputArray.get(i);
 
                int j;
                for (j = i; j >= gap && inputArray.get(j - gap) > temp; j -= gap)
                    inputArray.set(j, inputArray.get(j - gap)); 
    
                inputArray.set(j,temp);
            }
        }
	}
	
	//RadixSort
	
    static int getMax()
    {
    	
        int mx = inputArray.get(0);
        for (int i = 1; i < inputArray.size(); i++)
            if (inputArray.get(i) > mx)
                mx = inputArray.get(i);
        return mx;
    }
 
    static void countSort(int exp)
    {
    	int size=inputArray.size();
        int output[] = new int[size]; 
        int i;
        int count[] = new int[10];
        Arrays.fill(count,0);
 
        for (i = 0; i < size; i++)
            count[ (inputArray.get(i)/exp)%10 ]++;
 
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];
 
        for (i = size - 1; i >= 0; i--)
        {
            output[count[ (inputArray.get(i)/exp)%10 ] - 1] = inputArray.get(i);
            count[ (inputArray.get(i)/exp)%10 ]--;
        }
 
        for (i = 0; i < size; i++)
            inputArray.set(i,output[i]);
    }
 
    static void radixSort()
    {
        int m = getMax();
        
        for (int exp = 1; m/exp > 0; exp *= 10)
            countSort(exp);
    }

	public static void main(String[] args) {
			
		int choice;
		String choiceToContinue = "y";

		while (choiceToContinue.equalsIgnoreCase("y")) {
			choice = displayMenu();
			input();
			switch (choice) {
			case 1:
				shellSort();
				display();
				break;
			case 2:
				radixSort();
				display();
				break;
			}
			System.out.print("\nDo you want to continue? (y or n): ");
			choiceToContinue = s.next();
		}
		s.close();
	}
	
	
	public static int displayMenu() {
		System.out.print("\nMENU\n" + "1.Shell Sort\n" + "2.Radix Sort\n" + "Enter your choice: ");
		int choice = s.nextInt();
		return choice;
	}
	
	public static void input() {
		inputArray=new ArrayList<Integer>();
		System.out.println("Enter your input array: Enter -1 to stop ");
		int var=s.nextInt();
		while(var!=-1) {
		inputArray.add(var);
		var=s.nextInt();
		}
	}
	
	public static void display() {
		for(int i=0;i<inputArray.size();i++) {
			System.out.print(inputArray.get(i)+" ");
		}
	}
}
