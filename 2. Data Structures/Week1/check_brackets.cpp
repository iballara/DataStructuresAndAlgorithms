#include <iostream>
#include <stack>
#include <string>

struct Bracket {
    Bracket(char type, int position):
        type(type),
        position(position)
    {}

    bool Matchc(char c) {
        if (type == '[' && c == ']')
            return true;
        if (type == '{' && c == '}')
            return true;
        if (type == '(' && c == ')')
            return true;
        return false;
    }

    char type;
    int position;
};

int main() {
    std::string text;
    getline(std::cin, text);

    std::stack<Bracket> stack;
    for (int position = 0; position < text.length(); ++position) 
	{
        char next = text[position];

        if (next == '(' || next == '[' || next == '{') 
            stack.push(Bracket(next, position));

        if (next == ')' || next == ']' || next == '}') 
            if (!stack.empty())
			{
				Bracket previous = stack.top();
				stack.pop();
				if (!previous.Matchc(next))
				{
					std::cout << position + 1 << std::endl;
					return 0;				
				}
			} 
			else
			{
				std::cout << position + 1 << std::endl;
				return 0;
			}
    }

    if (stack.empty())
    	std::cout << "Success" << std::endl;
	else
		std::cout << stack.top().position + 1 << std::endl;

    return 0;
}
