//package Unit2Week2;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class BuildHeap {
    private int[] data;
    private List<Swap> swapList;

    private FastScanner in;
    private PrintWriter out;

    public static void main(String[] args) throws IOException {
        new BuildHeap().solve();
    }

    private void readData() throws IOException {
        int n = in.nextInt();
        data = new int[n];
        for (int i = 0; i < n; ++i) {
          data[i] = in.nextInt();
        }
    }

    private void writeResponse() {
        out.println(swapList.size());
        for (Swap swap : swapList) {
          out.println(swap.index1 + " " + swap.index2);
        }
    }

    private void generateSwaps() {
      swapList = new ArrayList<Swap>();
      // The following naive implementation just sorts 
      // the given sequence using selection sort algorithm
      // and saves the resulting sequence of swaps.
      // This turns the given array into a heap, 
      // but in the worst case gives a quadratic number of swaps.
      //
      // TODO: replace by a more efficient implementation
      /*for (int i = 0; i < data.length; ++i) {
        for (int j = i + 1; j < data.length; ++j) {
          if (data[i] > data[j]) {
            swaps.add(new Swap(i, j));
            int tmp = data[i];
            data[i] = data[j];
            data[j] = tmp;
          }
        }
      }	*/
      
      int starter_node = log2(data.length)/2;
     // int starter_node = 0;
      
      for (int i = starter_node; i >= 0; i--)
      {
    	  siftDown(i,data);
      }
      
      
    }
    private int log2(int x)
    {
    	return (int) (Math.floor(Math.log(x)/Math.log(2)));
    }
    private void siftDown(int index, int[] arr)
    {
    	int tree_height = log2(arr.length) +1; //effectively retrieves tree height
    	int swaps = 0;
    	
    	while (swaps < tree_height-1)
    	{
    		int parent_node = arr[index];
    		int indexLeft = (index+1)*2-1;
    		int indexRight = (index+1) * 2;
    		if (indexLeft > arr.length-1)
    		{
    			break;
    		}
    		
    		if (indexRight > arr.length-1) //if the node doesnt have a sub right node
    		{
    			if (parent_node > arr[indexLeft]) //if the parent node is greater than the only left child node
    			{
    				swap(indexLeft, index,arr);
    				swapList.add(new Swap(indexLeft, index));
    				index = indexLeft;
    				swaps++;
    			}
    			
    			
    		}
    		else // if both subnodes exist
    		{
    			if (Math.min(arr[indexLeft], arr[indexRight]) == arr[indexLeft]) //if the left child node is the smallest
    			{
    				if (parent_node > arr[indexLeft]) //if the parent node is greater than the smallest of the child nodes
    				{
    					swap(index, indexLeft, arr);
    					swapList.add(new Swap(index, indexLeft));
    					index = indexLeft;
    					swaps++;
    				}
    				
    			}
    			else // if the right child node is the smallest
    			{
    				if (parent_node > arr[indexRight])
    				{
    					swap(index, indexRight, arr);
    					swapList.add(new Swap(index, indexRight));
    					index = indexRight;
    					swaps++;
    				}
    				
    		}
    		
    		
    	}
    	}
    
    }
    private void swap (int i , int j, int[] arr)
    {
    	int temp =arr[i];
    	
    	arr[i] = arr[j];
    	arr[j] = temp;
    }
    
    

    public void solve() throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        readData();
        generateSwaps();
        writeResponse();
        out.close();
    }

    static class Swap {
        int index1;
        int index2;

        public Swap(int index1, int index2) {
            this.index1 = index1;
            this.index2 = index2;
        }
    }

    static class FastScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
        }

        public String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}