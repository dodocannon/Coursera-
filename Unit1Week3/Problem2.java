package Unit1Week3;

import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;

public class Problem2 {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
       
        
    	double value = 0;
        int c = 0;
        while (c <= capacity)
        {
        	if (c==capacity)
        	{
        		return value;
        	}
        	double maxValue = -1;
        	int indexMax = -1;
        	for (int i = 0; i < values.length; i++)
        	{
        		double currValue = (double) values[i]/weights[i];
        		
        		if (currValue > maxValue)
        		{
        			maxValue = currValue;
        			indexMax = i;
        		}
        	}
        	if (capacity -c >= weights[indexMax])
        	{
        		
        		c += weights[indexMax];
        		value += values[indexMax];
        		values[indexMax] = 0;
        	}
        	else
        	{
        		
        		value +=  values[indexMax] * ((double) (capacity -c)/weights[indexMax]);
        		c = capacity;
        	}
        }

        return value;
    }
    private static void sort(int[] values, int[] weights)
    {
    	
    }
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.printf("%.4f",getOptimalValue(capacity, values, weights));
    }
    
} 