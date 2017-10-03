package adaLab;

import java.util.ArrayList;
import java.util.Scanner;


/*
Steps: 
1. Consider the array as complete binary tree(see the definition of complete binary tree)
2. heapify(parent node is greater than child nodes or vice versa) all the parents node that is upto size/2-1
3.now remove the top element and replace the top ele with last leaf and again heapify
4. refer to source https://www.programiz.com/dsa/heap-sort best explanation so far


 */

public class HeapSort {

	static ArrayList<Integer> inputArray;
	
	public static void main(String[] args) {
		HeapSort.input();
		HeapSort.sort();
		HeapSort.display();
		
	}
	
	public static void display() {
		for(int i=0;i<inputArray.size();i++) {
			System.out.print(inputArray.get(i)+" ");
		}
	}
	
	public static void sort() {
		int size=inputArray.size();
		for(int i=(size/2)-1;i>=0;i--) {
			heapify(size,i);
		}
		
		for(int i=size-1;i>=0;i--) {
			int temp=inputArray.get(i);
			inputArray.set(i,inputArray.get(0));
			inputArray.set(0,temp);
			heapify(i,0);
		}
	}
	
	public static void heapify(int size,int currentNode) {
		int largest=currentNode;
		int lchild=2*currentNode+1;
		int rchild=2*currentNode+2;
		
		if(lchild<size && inputArray.get(lchild)>inputArray.get(largest))
			largest=lchild;
		
		if(rchild<size && inputArray.get(rchild)>inputArray.get(largest))
			largest=rchild;
		
		if(largest!=currentNode) {
			int temp=inputArray.get(currentNode);
			inputArray.set(currentNode,inputArray.get(largest));
			inputArray.set(largest,temp);
			heapify(size,largest);
		}
	}
	
	public static void input() {
		inputArray=new ArrayList<Integer>();
		System.out.println("Enter your input array: Enter -1 to stop ");
		Scanner s=new Scanner(System.in);
		int var=s.nextInt();
		while(var!=-1) {
		inputArray.add(var);
		var=s.nextInt();
		}
		s.close();
	}
}