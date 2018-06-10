package Unit1Week2;
import static java.lang.System.*;
import java.util.Scanner;
public class Problem7 {
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		long a = s.nextLong();
		long b =s.nextLong();
		
		out.println(fibmod(a,b));
	}
	public static long fibmod(long a, long b)
	{
		if (a == 0)
		{
			return getFibonacciSumNaive(b);
		}
		return (10+ getFibonacciSumNaive(b) - getFibonacciSumNaive(a-1))%10;
	}
	private static long getFibonacciSumNaive(long n) {
	       if (n <= 1)
	       {
	    	   return n;
	       }
	       return (fib(n%60+2))%10 -1;
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
}
