#include <algorithm>
#include <iostream>
#include <vector>

using std::vector;

long long max_dot_product(vector<int> a, vector<int> b) {
	std::sort(begin(a), end(a)); std::sort(begin(b), end(b));
	int size = a.size();
	long long sum = 0;				
	for (int i = 0; i < size; i++) {
		sum += (long long) a[i]*b[i];
	}		
	return sum;
}

int main() {
  size_t n;
  std::cin >> n;
  vector<int> a(n), b(n);
  for (size_t i = 0; i < n; i++) {
    std::cin >> a[i];
  }
  for (size_t i = 0; i < n; i++) {
    std::cin >> b[i];
  }
  std::cout << max_dot_product(a, b) << std::endl;
}
