package Unit1Week6;

import java.util.*;

import static java.lang.System.out;

import java.io.*;

public class Problem2 {
    private static int partition3(int[] A) {
        int sum = 0;
        
        for (int i : A)
        {
        	sum+= i;
        }
        int n = A.length+1;
        if (sum%3!=0 || A.length < 3)
        {
        	return 0;
        }
       return (subsetSum(A, sum/3) && subsetSum(A, 2*sum/3)) ? 1 : 0;
    	
    }
    private static boolean subsetSum(int[] arr, int x)
    {
    	boolean[][] matrix = new boolean[arr.length][x+1];
    	//intialize the matrix with all slots being false
    	for (boolean[] a : matrix)
    	{
    		for (boolean c : a)
    		{
    			c= false;
    		}
    	}
    	for (int i = 0; i < matrix.length;i++)
    	{
    		matrix[i][0] = true;
    	}
    	//initialize first row of matrix
    	for (int i = 0; i < matrix[0].length; i++)
    	{
    		if (arr[0] == i)
    		{
    			matrix[0][i] = true;
    		}
    	}
    	//recursively filling in the rest of the matrix
    	for (int i = 1; i < matrix.length; i++)
    	{
    		int curr = arr[i-1];
    		for (int j = 1; j < matrix[i].length; j++)
    		{
    			if (j <= curr)
    			{
    				matrix[i][j] = matrix[i-1][j];
    				if (curr == j)
    				{
    					matrix[i][j] = true;
    					
    				}
    			}
    			else
    			{
    				matrix[i][j] = (matrix[i-1][j-curr] || matrix[i-1][j]);
    			}
    			
    		}
    	}
    	//printArray(matrix);
    	return matrix[matrix.length-1][matrix[0].length-1];
    }
    private static void printArray(boolean[][] arr) {
		int l = arr.length;
		for (int i = 0; i < l; i++) {
			for (int k = 0; k < arr[0].length; k++) {
				out.print(arr[i][k]+ " ");
			}
			out.println();
		}
	}

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }
        System.out.println(partition3(A));
    }
}
