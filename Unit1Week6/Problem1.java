package Unit1Week6;

import static java.lang.System.out;

import java.util.*;

public class Problem1 {
    private static int optimalWeight(int W, int[] w) {
        int[][] m = new int[w.length][w.length];
        for (int[] x: m)
        {
        	Arrays.fill(x, 0);
        }
        Arrays.fill(m[0], w[0] );
        for (int i = 1; i < w.length; i++)
        {
        	m[i][0] = w[i];
        }
        for (int i = 1; i < m.length; i++)
        {
        	for (int k = 1 ; k < m[0].length; k++)
        	{
        		int row = i-1;
        		int col = k-1;
        		int next = 0;
        		if (m[i][k-1] + m[row][col] <= W)
        		{
        			m[i][k] += m[i][k-1] + m[row][col];
        			continue;
        		}
        		while (m[i][k-1] + m[row][col] > W)
        		{
        		
        			if (row == 0)
        			{
        				next = 0;
        				break;
        			}
        			if (col > 0)
        			{
        				col--;
        			}
        			row--;
        			next = m[row][col];
        			
        		}
        		m[i][k] = m[i][k-1] + next;
        		
        	}
        }
        printArray(m);
        return 0;
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
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }
    
}
