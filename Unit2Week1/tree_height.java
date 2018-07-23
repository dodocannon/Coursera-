package Unit2Week1;

import java.util.*;
import java.io.*;

public class tree_height {
    class FastScanner {
		StringTokenizer tok = new StringTokenizer("");
		BufferedReader in;

		FastScanner() {
			in = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() throws IOException {
			while (!tok.hasMoreElements())
				tok = new StringTokenizer(in.readLine());
			return tok.nextToken();
		}
		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
	}

	public class TreeHeight {
		int n;
		int parent[];
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer,ArrayList<Integer>>();
		
		void read() throws IOException {
			FastScanner in = new FastScanner();
			n = in.nextInt();
			parent = new int[n];
			for (int i = 0; i < n; i++) {
				int c = in.nextInt();
				if (map.containsKey(c))
				{
					map.get(c).add(i);
				}
				else
					
				{
					ArrayList<Integer> list = new ArrayList<Integer>();
					list.add(i);
					map.put(c, list);
				}
			}
		}

		int computeHeight() {
			
			Queue<Integer> queue = new LinkedList<Integer>();
			HashSet<Integer> set = new HashSet<Integer>();
			queue.add(map.get(-1).get(0));
			
			int height = 0;
			
			while (true)
			{
				int nodeCount = queue.size();
				
				if (nodeCount == 0)
				{
					return height;
				}
				
				height++;
				
				
				while (nodeCount > 0)
				{
					int a = queue.remove();
					if (map.containsKey(a))
					{
						ArrayList<Integer> curr = map.get(a);
					
						for (int i : curr)
						{
							queue.add(i);
						}
					}
					nodeCount--;
				}
				
			}
			

                       
                       
		}
	}

	static public void main(String[] args) throws IOException {
            new Thread(null, new Runnable() {
                    public void run() {
                        try {
                            new tree_height().run();
                        } catch (IOException e) {
                        }
                    }
                }, "1", 1 << 26).start();
	}
	public void run() throws IOException {
		TreeHeight tree = new TreeHeight();
		tree.read();
		System.out.println(tree.computeHeight());
	}
}