package Unit1Week2;
import static java.lang.System.*;
import java.util.*;
public class Problem4 {
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		long a = s.nextLong();
		long b =s.nextLong();
		out.println(lcm(a,b));
	}
	private static long lcm(long a, long b)
	{
		long x = findGCD(a, b);
		return b * (a/x);
	}
	public static long findGCD(long a, long b)
	{
		if (a%b == 0)
		{
			return b;
		}
		else
		{
			return findGCD(b, a%b);
		}
	}
	
}
