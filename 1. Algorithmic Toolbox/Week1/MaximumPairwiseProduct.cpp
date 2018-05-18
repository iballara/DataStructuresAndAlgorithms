#include <iostream>
#include <vector>

using std::vector;
using std::cin;
using std::cout;
using std::endl;

long long maxPairwiseProduct(const vector<int> &numbers) {
	
	int n = numbers.size();
	//cout << "Size: " << n << endl;
	int first = 0;
	int second = 0;
	
	for (int i = 0; i < n; ++i) {
		if (numbers[i] >= first) {
			second = first;
			first = numbers[i];
		} else if (numbers[i] != first && numbers[i] > second) {
			second = numbers[i];
		}	
	}
	//cout << "first: " << first << ", second: " << second << endl;
	return (long long) first * second;
	
}

int main() {
	
	int n;
	cin >> n;
	vector<int> numbers(n);
	for (int i = 0; i < n; ++i) {
		cin >> numbers[i];
	}

	cout << maxPairwiseProduct(numbers) << endl;
	return 0;

}
