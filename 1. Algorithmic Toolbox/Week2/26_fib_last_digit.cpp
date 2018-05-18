#include <iostream>

int fibonacci_sum_last_digit(long long n) {
    
	if (n <= 1)	return n;
	int previous = 0;
	int current = 1;
	
	for (int i = 0; i < n - 1; ++i) {
		int tmp_previous = previous % 10;
		previous = current % 10;
		current = tmp_previous + current % 10;
	}
	return current % 10;
}

int main() {
    long long n;
    std::cin >> n;
    std::cout << fibonacci_sum_last_digit(n) << std::endl;
}
