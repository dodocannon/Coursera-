package Unit2Week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

class Bracket {
    Bracket(char type, int position) {
        this.type = type;
        this.position = position;
    }

    boolean Match(char c) {
        if (this.type == '[' && c == ']')
            return true;
        if (this.type == '{' && c == '}')
            return true;
        if (this.type == '(' && c == ')')
            return true;
        return false;
    }

    char type;
    int position;
}

public class Problem1	 {
    public static void main(String[] args) throws IOException {
        InputStreamReader input_stream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input_stream);
        String text = reader.readLine();
        int counter = 0;

        Stack<Bracket> opening_brackets_stack = new Stack<Bracket>();
        for (int position = 0; position < text.length(); ++position) {
            char next = text.charAt(position);
            counter++;
            if (next == '(' || next == '[' || next == '{') {
                opening_brackets_stack.push(new Bracket(next, position+1));
                
            }

            if (next == ')' || next == ']' || next == '}') {
                if (opening_brackets_stack.isEmpty()) {
                	System.out.println(position+1);
                	return;
                }
                else if (opening_brackets_stack.lastElement().Match(next))
                {
                	opening_brackets_stack.pop();
                }
                else {
                	System.out.println(position+1);
                	return;
                }
            
        }
        
        

        // Printing answer, write your code here
    }
        if (opening_brackets_stack.isEmpty())
        {
        	System.out.println("Success");
        }
        else
        {
        	System.out.println(opening_brackets_stack.lastElement().position);
        	
        }
    }
}