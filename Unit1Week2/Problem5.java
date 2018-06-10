package Unit1Week2;
import static java.lang.System.*;
import java.util.*;
public class Problem5 {
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		long a = s.nextLong();
		long b = s.nextLong();
		
		out.println(findSpecificPeriod(a%findPeriod(b),b));
		
	}
	//calculates length of pisano period for mod b.
	public static long findPeriod(long b)
	{
		long previous = 0;
		long current = 1;
		for (long i = 1; i != -1; i++)
		{
			long holder = current%b;
			current += previous%b;
			previous = holder;
			if (current%b == 1 && previous%b ==0)
			{
				return i;
			}
		}
		return -1;
	}
	public static long findSpecificPeriod(long a, long b)
	{
		long previous = 0;
		long current = 1;
		if (a == 0)
		{
			return 0;
		}
		for (long i = 1; i != -1; i++)
		{
			long holder = current%b;
			current = current%b;
			current += previous%b;
			previous = holder;
			if (i==a)
			{
				return previous;
			}
			
		}
		return -1;
	}

}
