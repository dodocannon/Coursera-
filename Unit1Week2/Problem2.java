package Unit1Week2;
import java.util.Scanner;
import static java.lang.System.*;
public class Problem2 {
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		int x = s.nextInt();
		int curr = 1;
		int first = 1;
		if (x == 0)
		{
			out.println("0");
		}
		for (int i = 3; i <= x; i++)
		{
			//out.println(curr);
			int holder = curr;
			curr = (curr + first)%10;
			
			first = holder;
		}
		out.println(curr);
	

	}
}
