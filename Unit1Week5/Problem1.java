package Unit1Week5;

import static java.lang.System.out;

import java.util.Arrays;
import java.util.Scanner;

public class Problem1 {
    private static int getChange(int m) {
        int[][] matrix = new int[3][m];
        for (int i = 0; i < m; i++)
        {
        	matrix[0][i] = i+1;
        }
        
        int x = 1;
       
        while (x <= 3)
    	{
        	if (x == 3)
        	{
        		matrix[1][x-1] = 1;
        	}
        	else
        	{
        		matrix[1][x-1] = x;
        	}
        	x++;
    	}
        while (x <= m)
        {
        	matrix[1][x-1] = Math.min(matrix[1][x-4], matrix[0][x-4])+1;
        	x++;
        }
        int a = 1;
        while (a <= 4)
    	{
        	if (a == 4)
        	{
        		matrix[2][a-1] = 1;
        	}
        	else
        	{
        		matrix[2][a-1] = a;
        	}
        	a++;
    	}
        while (a <= m)
        {
        	
        	
        matrix[2][a-1] = Math.min(matrix[1][a-1],minCol(a-5, matrix)+1);
        	
        	a++;
        }
        //printArray(matrix);
        return matrix[2][m-1];
        
        
        
        
        
    }
    private static int minCol(int col, int[][] arr)
    {
    	int[] arr2 = new int[arr.length];
    	for (int i = 0 ; i < arr.length; i++)
    	{
    		arr2[i] = arr[i][col];
    	}
    	int min = Integer.MAX_VALUE;
    	
    	for (int i : arr2)
    	{
    		if (i < min)
    		{
    			min = i;
    		}
    	}
    	return min;
    }
    public static void printArray(int[][] arr) {
		int l = arr.length;
		for (int i = 0; i < l; i++) {
			for (int k = 0; k < arr[0].length; k++) {
				out.print(arr[i][k]);
			}
			out.println();
		}
	}
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        if (m < 4)
        {
        	if (m==3)
        	{
        		System.out.println(1);
        	}
        	else
        	{
        	System.out.print(m);
        	}
        }
        else
        {
        System.out.println(getChange(m));
        }

    }
}

