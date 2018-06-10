package Unit1Week5;

import static java.lang.System.out;

import java.util.*;

public class Problem4 {

    private static int lcs2(int[] a, int[] b) {
        int[][] arr = new int[a.length][b.length];
        for (int[] x : arr)
        {
        	Arrays.fill(x, 0);
        }
        boolean match= false;
        for (int i = 0; i < a.length; i++)
        {
        	if (a[i] == b[0] || match)
        	{
        		match = true;
        		arr[i][0]++;
        	}
        }
        match = false;
        for (int i = 1; i < b.length; i++)
        {
        	
        	if (b[i] == a[0] || match)
        	{
        		arr[0][i]++;
        		match = true;
        	}
        }
        for (int i = 1 ; i < a.length; i++)
        {
        	for (int j = 1; j < b.length; j++)
        	{
        		if (a[i] == b[j])
        		{
        			arr[i][j] = arr[i-1][j-1]+1;
        		}
        		else
        		{
        			arr[i][j] = Math.max(arr[i-1][j], arr[i][j-1]);
        		}
        	}
        }
        //printArray(arr);
        return arr[a.length-1][b.length-1];
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
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }

        System.out.println(lcs2(a, b));
    }
}

