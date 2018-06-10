package Unit1Week3;
import java.util.Scanner;
import static java.lang.System.*;
public class Problem1 {
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		long n = s.nextLong();
		out.println(getChange(n));
		
	}
	private static long getChange(long n)
	{
		long a = 0;
		long coins = 0;
		while (a <= n)
		{
			if (a==n)
			{
				return coins;
			}
			coins++;
			if (n-a >= 10)
			{
				a+=10;
			}
			else if (n-a >= 5)
			{
				a+=5;
			}
			else
			{
				a+=1;
			}
			
		}
		return coins;
	}
}	
