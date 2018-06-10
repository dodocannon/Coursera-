package Unit1Week2;
import java.util.Scanner;
import static java.lang.System.*;
public class Problem1 {
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		int x = s.nextInt();
		int[] arr = new int[x+1];
		for (int i = 0; i <= x; i++)
		{
			if (i == 0)
			{
				arr[i] = 0;
			}
			else if (i == 1)
			{
				arr[i] = 1;
			}
			else
			{
				arr[i] = arr[i-2] + arr[i-1];
			}
		}
		out.println(arr[x]);

	}
}
