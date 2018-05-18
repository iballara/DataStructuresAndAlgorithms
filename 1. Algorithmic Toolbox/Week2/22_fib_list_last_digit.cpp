#include <iostream>
#include <vector>

using namespace std;

int fib_list(int n) {
    vector<int> numbers(n+1);
    numbers[0] = 0;
    numbers[1] = 1;
    for (int i = 2; i <= n; i++) {
		numbers[i] = (numbers[i-1]+numbers[i-2])%10;
    }
    return numbers[n];
}

int main() {
    
    int n;
    cin >> n;
    cout << fib_list(n) << endl;
    return 0;
}
