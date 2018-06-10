package Unit1Week3;

import java.util.*;
import static java.lang.System.*;
public class Problem4 {

    private static int[] optimalPoints(Segment[] s)
    {
    	int[] points = new int[s.length+1];
    	Arrays.fill(points, -1);
    	
    	int segmentsTraversed = 0;
    	int maxEnd = s[0].end;
    
    	int counter = 0;
    	points[counter] = maxEnd;
    	while (segmentsTraversed < s.length-1)
    	{
    		segmentsTraversed++;
    		if (maxEnd  < s[segmentsTraversed].start)
    		{
    			counter++;
    			//out.println(maxEnd + " stopped at : " + s[segmentsTraversed].start);
    			points[counter] = s[segmentsTraversed].end;
    			
    			maxEnd = s[segmentsTraversed].end;
    		}
    	}
    	points[s.length] = counter+1;
    	return points;
    	
    }

    private static class Segment {
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }
        public String toString()
        {
        	return start + " " + end;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
       
        int[] points = optimalPoints(sort(segments));
        System.out.println(points[points.length-1]);
        for (int i = 0; i < points.length-1 && points[i] != -1; i++)
        {
        	System.out.print(points[i] + " ");
        }
    }
    
    private static Segment[] sort(Segment[] a)
    {
    	Segment[] b = Arrays.copyOf(a, a.length);
    	int counter = 0;
    	while (counter <= a.length-1)
    	{
    		Segment min = b[counter];
    		int indexMax = counter;
    		for (int i = counter; i < b.length; i++)
    		{
    			if (b[i].end < min.end || (b[i].end==min.end && b[i].start < min.start))
    			{
    				
    				min = new Segment(b[i].start, b[i].end);
    				indexMax = i;
    			}
    		}
    		Segment holder = new Segment(b[indexMax].start, b[indexMax].end);
    		b[indexMax] = new Segment(b[counter].start,b[counter].end);
    		b[counter]=holder;
    		
    		
    		counter++;
    	}
    	return b;
    }
}
 