package Unit1Week1;
import java.util.Scanner;
public class maxProduct {
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		long[] arr = new long[size];
		for (int i = 0; i < size; i++)
		{
			arr[i] = s.nextLong();
		}
		long max = -1;
		long max2 = -1;
		int index = -1;
		if (size == 1)
		{
			System.out.println(arr[0]);
		}
		for (int i = 0; i < size; i++)
		{
			if (arr[i] > max)
			{
				max = arr[i];
				index = i;
			}
		}
		for (int i = 0; i < size; i++)
		{
			if (i == index)
			{
				continue;
			}
			if (arr[i] > max2)
			{
				max2 = arr[i];
			}
		}
		
		
		
		
		System.out.println(max2 * max);
		
	}
}
