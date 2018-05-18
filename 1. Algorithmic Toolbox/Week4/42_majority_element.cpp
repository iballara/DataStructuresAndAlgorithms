#include <iostream>
#include <map>
#include <vector>

using std::vector;
using std::map;

int get_majority_element(const vector<long long> &a, int left, int right) {

	map<long long, unsigned int> m;
  
	for (size_t i = left; i < right; i++)
	{
		if (m.find(a[i]) != m.end()) 
		{
			m.at(a[i])++;
		}
		else
		{
			m.insert(std::pair<long long, unsigned int>(a[i], 1));	
		}
	}

	vector<unsigned int> v;
	for(map<long long, unsigned int>::iterator it = m.begin(); it != m.end(); ++it) 
	{
		v.push_back(it->second);
	}

	unsigned int max = 0;
	for (size_t i = 0; i < v.size(); i++) 
	{
		if (v[i] > max) max = v[i];
	}
	//std::cout << "max: " << max << std::endl;
	if (max > (int)a.size()/2) return 1;
	return -1;
}

int main() {
  int n;
  std::cin >> n;
  vector<long long> a(n);
  for (size_t i = 0; i < a.size(); ++i) {
    std::cin >> a[i];
  }
  std::cout << (get_majority_element(a, 0, a.size()) != -1) << std::endl;
}
