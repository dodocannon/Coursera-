package Unit1Week2;

import java.util.*;

public class Problem6 {
    private static long getFibonacciSumNaive(long n) {
       if (n <= 1)
       {
    	   return n;
       }
       return (10 + (fib(n%60+2))%10 -1)%10;
    }
    private static long fib(long n)
    {
    	if (n <= 1)
    	{
    		return n;
    	}
    	long previous = 0;
    	long current = 1;
    	for (int i = 0; i < n-1; i++)
    	{
    		long holder = current;
    		current += previous;
    		previous = holder;
    	}
    	return current;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        System.out.println(getFibonacciSumNaive(n));
    }
}
