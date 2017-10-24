package adaLab;

import java.util.ArrayList;
import java.util.Scanner;

public class MatrixChainMulitplication {
	
	static ArrayList<Integer> sizeMatrix;
	static int memoMatrix[][];
	
	public static int getSize() {
		return sizeMatrix.size();
	}
	
	public static int getLeastNoOfOperation() {
		return memoMatrix[1][getSize()-1];
	}
	
	public static void display() {
		for(int i=1;i<getSize();i++) {
			for(int j=1;j<getSize();j++) {
				System.out.printf("%5d ", memoMatrix[i][j]);
			}
			System.out.println();
		}
	}
	
	
	public static int getMinValue(int i,int j) {
		int smallest=Integer.MAX_VALUE;
	
		for(int k=i;k<j;k++) {
			int value=memoMatrix[i][k]+memoMatrix[k+1][j]+(sizeMatrix.get(i-1)*sizeMatrix.get(k)*sizeMatrix.get(j));
			if(value<smallest)
				smallest=value;
		}
		return smallest;
	}
	
	public static void calculateMatrix() {
		//case for i=j
		for(int i=1;i<getSize();i++) {
			memoMatrix[i][i]=0;
		}
		
		for(int k=1;k<getSize()-1;k++) {
			for(int i=1;i<(getSize()-k);i++) {
				int j=i+k;
				memoMatrix[i][j]=getMinValue(i,j);
			}
		}
	}
	
	public static void main(String[] args) {
		sizeMatrix=new ArrayList<>();
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the matrix size array in order: (-1 to stop) ");
		
		int input;
		input=s.nextInt();
		while(input!=-1) {
			sizeMatrix.add(input);
			input=s.nextInt();
		}
		
		memoMatrix=new int[getSize()][getSize()];

		calculateMatrix();
		display();
		
		System.out.println("\nMinimum number of multiplications is : "+ getLeastNoOfOperation());
		s.close();
	}
}