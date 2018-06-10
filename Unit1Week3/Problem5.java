package Unit1Week3;
import java.util.*;
import static java.lang.System.*;
public class Problem5 {
    private static List<Integer> optimalSummands(int n) {
        List<Integer> summands = new ArrayList<Integer>();
        int sum = 0;
        int lastMax = 0;
        while (sum <= n)
        {
        	if (sum == n)
        	{
        		return summands;
        	}
        	
        	if (2*lastMax + 3 > n - sum)
        	{
        		summands.add(n-sum);
        		
        		sum += n-sum;
        	}
        	else
        	{
        		summands.add(lastMax+1);
        		lastMax++;
        		sum += lastMax;
        	}
        }
        return summands;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> summands = optimalSummands(n);
        System.out.println(summands.size());
        for (Integer summand : summands) {
            System.out.print(summand + " ");
        }
    }
}
