package Unit1Week3;

import java.util.*;



import static java.lang.System.*;

public class Problem6 {
    private static String largestNumber(String[] a) {
        //write your code here
        String result = "";
        for (int i = 0; i < a.length; i++) {
            result += a[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        out.println(largestNumber(sort(a)));
    }
    private static String[] sort(String[] a)
    {
    	String[] b = Arrays.copyOf(a, a.length);
    	int counter = 0;
    	while (counter <= a.length-1)
    	{
    		String max = b[counter];
    		int indexMax = counter;
    		for (int i = counter; i < b.length; i++)
    		{
    			int first = Integer.parseInt(max + b[i]);
    			int second = Integer.parseInt(b[i] + max);
    			if (second > first)
    			{
    				max = b[i];
    				indexMax = i;
    			}
    			
    		}
    		String holder = b[indexMax];
    		b[indexMax] = b[counter];
    		b[counter]=holder;
    		
    		
    		counter++;
    	}
    	return b;
    }
}

