import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

class Bracket {

	final char type;
    final int position;

    Bracket(char type, int position) {
        this.type = type;
        this.position = position;
    }

    boolean match(char c) {
        if (this.type == '[' && c == ']')
            return true;
        if (this.type == '{' && c == '}')
            return true;
        if (this.type == '(' && c == ')')
            return true;
        return false;
    }
}

class check_brackets {

    public static void main(String[] args) throws IOException {
        InputStreamReader input_stream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input_stream);
        String text = reader.readLine();

        final Stack<Bracket> stack = new Stack<Bracket>();
        for (int position = 0; position < text.length(); ++position) {
            final char next = text.charAt(position);

            if (next == '(' || next == '[' || next == '{') {
                stack.push(new Bracket(next, position));
            }

            if (next == ')' || next == ']' || next == '}') {

				if (!stack.empty()) {			                
					final Bracket previous = stack.pop();
					if(!previous.match(next)) {
						System.out.println(position + 1);
						return;
					}
				} else {
					System.out.println(position + 1);
					return;
				}
            }
        }
		if (stack.empty())
        	System.out.println("Success");
    	else
			System.out.println(stack.pop().position + 1);
	}

}
