package Unit1Week3;
import static java.lang.System.*;
import java.util.*;
import static java.lang.System.*;
public class Problem3 {
    private static long maxDotProduct(long[] a, long[] b) {
        long result = 0;
        Arrays.sort(a);
        Arrays.sort(b);
         for (int i = 0; i< a.length;i++)
         {
        	 
        	 result +=  (long) a[i] * b[i];
         }
    
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextLong();
        }
        long[] b = new long[n];
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextLong();
        }
        System.out.println(maxDotProduct(a, b));
    }
    
}
