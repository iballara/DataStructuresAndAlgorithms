#include <iostream>

long long get_pisano_period(long long m) {
	
	long long F1 = 0, F2 = 1, F = F1 + F2;
	for (int i = 0; i < m*m; i++) {
		F = (F1 + F2) % m;
		F1 = F2;
		F2 = F;
		if (F1 == 0 && F2 == 1) return i + 1;
	}
}

long long get_fib_huge(long long n, long long m) {
	
	long long period = get_pisano_period(m);
	long long remainder = n % period;
	long long F1 = 0, F2 = 1, F = remainder;
	for (int i = 1; i < remainder; i++) {
		F = (F1 + F2) % m;
		F1 = F2;
		F2 = F;
    	}
	return F % m;
}

int main() {

	long long n, m;
	std::cin >> n >> m;
	std::cout << get_fib_huge(n, m) << std::endl;
	return 0;
}
