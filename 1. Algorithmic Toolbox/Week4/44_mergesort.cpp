#include <iostream>
#include <vector>

using std::vector;

long long inversions(vector<long long> &a, vector<long long> &b, 
					 size_t left, int mid, size_t right) {
  
	size_t i = left, j = mid, k = left;
	long long count = 0;
	while (i <= mid - 1 && j <= right)
 	{
		if (a[i] <= a[j]) b[k++] = a[i++];
		else {
			b[k++] = a[j++];
			count += mid - i;	
		}
	}

	while (i <= mid - 1)  b[k++] = a[i++];
	while (j <= right)    b[k++] = a[j++];
	
	for (i = left; i <= right; i++) a[i] = b[i];

	return count;
}

long long merge_sort(vector<long long>& a, vector<long long>& b, size_t left, size_t right) {

	long long count = 0;
	if (right <= left) return count;
	size_t mid = left + (right - left)/2;
	count += merge_sort(a, b, left, mid);
	count += merge_sort(a, b, mid + 1, right);
	count += inversions(a, b, left, mid + 1, right);

	return count;
}

int main() {
  int n;
  std::cin >> n;
  vector<long long> a(n);
  for (size_t i = 0; i < a.size(); i++) {
    std::cin >> a[i];
  }
  vector<long long> b(a.size());
  std::cout << merge_sort(a, b, 0, a.size() - 1) << '\n';
}
