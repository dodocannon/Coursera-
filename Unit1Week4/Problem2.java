package Unit1Week4;
import java.util.*;
import java.io.*;

public class Problem2 {
    private static int getMajorityElement(int[] a, int left, int right) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int x : a)
        {
        	map.put(x, (!(map.containsKey(x)) ? 1 : map.get(x)+1));
        	if (map.get(x) > (a.length)/2)
        	{
        		return 1;
        	}
        }
        return -1;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        if (getMajorityElement(a, 0, a.length) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
