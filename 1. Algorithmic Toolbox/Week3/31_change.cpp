#include <iostream>

int get_change(int m) {
  
	int sum = 0;
	int ofTen = m/10;
	sum += ofTen;
	m = m - ofTen * 10;
	int ofFive = m/5;
	sum += ofFive;
	m = m - ofFive * 5;
	
	return sum + m;
}

int get_change_better(int m) {

	int coins[] = {10, 5, 1};
	int sum = 0;
	for (int i = 0; m > 0; ++i) {
		sum += m / coins[i];
		m %= coins[i];
	}
	return sum;
}

int main() {
	int m;
	std::cin >> m;
	std::cout << get_change_better(m) << '\n';
	return 0;
}
