#include <iostream>
#include <vector>

using namespace std;

long long fib_list(int n) {
    vector<long long> numbers(n+1);
    numbers[0] = 0;
    numbers[1] = 1;
    for (int i = 2; i <= n; i++) {
		numbers[i] = numbers[i-1]+numbers[i-2];
    }
    return (long long) numbers[n];
}

int main() {
    
    int n;
    cin >> n;
    cout << fib_list(n) << endl;
    return 0;
}
