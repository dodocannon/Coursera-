package Unit1Week5;

import static java.lang.System.out;

import java.util.*;

public class Problem2 {
    private static List<Integer> optimal_sequence(int n) {
        List<Integer> sequence = new ArrayList<Integer>();
        sequence.add(n);
        if (n == 1 || n==2 || n==3)
        {
        	if (n!=1)
    		{
        		sequence.add(1);
    		}
        	Collections.reverse(sequence);
        	return sequence;
        }
        int[][] matrix = new int[3][n];
        matrix[0][0] = 1;
        matrix[0][1] = 2;
        matrix[0][2] = 3;
        matrix[1][0] = 1;
        matrix[1][1] = 1;
        matrix[1][2] = 2;
        matrix[2][0] = 1;
        matrix[2][1] = 1;
        matrix[2][2] = 1;
        for (int i = 4; i <= n; i++)
        {
        	matrix[0][i-1] = matrix[0][i-2]+1;
        	
        	if (i%2 == 0)
        	{
        		matrix[1][i-1] = matrix[1][i/2-1]+1;
        	}
        	else
        	{
        		matrix[1][i-1] = matrix[1][i-2]+1;	
        	}
        	int prevValue = minCol(i-2,matrix);
        	
        	if (i%3 == 0)
        	{
        		
        		matrix[2][i-1] = (minCol(i/3-1,matrix) < prevValue) ? minCol(i/3-1,matrix)+1 : prevValue+1;
        	}
        	else if (i%2 == 0)
        	{
        		matrix[2][i-1] = (minCol(i/2-1,matrix) < prevValue) ? minCol(i/2-1,matrix)+1 : prevValue +1 ;
        	}
        	else
        	{
        		matrix[2][i-1] = prevValue+1;
        	}
        	
        	
        	
        	
        }
        int c = n-1;
        while (matrix[2][c] != 1)
        {
        	
        	if (matrix[2][c-1] >= matrix[2][c])
        	{
        		if (n%3 == 0)
        		{
        			n/=3;
        		
        		}
        		else 
        		{
        			n/=2;
        		}
        	}
        	else
        	{
        		n--;
        	}
        	c = n-1;
        	sequence.add(n);
        	
        }
        sequence.add(1);
        //printArray(matrix);
        Collections.reverse(sequence);
        //sequence.add(matrix[2][n-1]);
        return sequence;
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
    private static void printArray(int[][] arr) {
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
        List<Integer> sequence = optimal_sequence(n);
        System.out.println(sequence.size()-1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
    }
}

