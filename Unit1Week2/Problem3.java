package Unit1Week2;
import static java.lang.System.*;
import java.util.*;
public class Problem3 {
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		int b = s.nextInt();
		out.println(findGCD(a,b));
	}
	public static int findGCD(int a, int b)
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
