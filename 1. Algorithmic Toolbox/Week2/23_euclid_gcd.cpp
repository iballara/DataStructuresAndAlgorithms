#include <iostream>

long long gcd(long a, long b) {
	if (b == 0) return a;
	long long a_prime = a % b;
	return gcd(b, a_prime);
}

int main() {
	long long a;
	long long b;
	std::cin >> a;
	std::cin >> b;
	std::cout << gcd(a,b) << std::endl;
	return 0;
}
