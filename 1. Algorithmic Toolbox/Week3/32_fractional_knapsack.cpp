#include <iostream>
#include <vector>

using std::vector;

int get_highest_fraction(const vector<int>& weights, const vector<int>& values) {
	
	int highest_index = 0;
	double highest_fraction = 0;
	for (int i = 0; i < weights.size(); ++i) {
		if((double) values[i] / weights[i] > highest_fraction && weights[i] != 0) { 
			highest_fraction = (double) values[i] / weights[i];
			highest_index = i;		
		}
	}
	return highest_index;
}

double get_optimal_value(int capacity, vector<int> weights, vector<int> values) {

	double value = 0.0;
	for (int i = 0; i < values.size(); ++i) {
		if (capacity == 0) return value;
		int max_index = get_highest_fraction(weights, values);	
		int max_value = values[max_index];
		int max_weight = weights[max_index];
		//std::cout << "max_index: " << max_index << ", max_value: " << max_value << ", max_weight: " << max_weight << std::endl;
		if (max_weight <= capacity) {
			/* The whole item into the knapsack */			
			value += max_value;
			capacity -= max_weight;
			weights[max_index] = 0; 
		} else {
			double value_added = ((double) capacity/max_weight) * max_value;
			value += value_added;
			capacity = 0;
			weights[max_index] -= value_added;
		}
	}		

	return value;
}

int main() {
  int n;
  int capacity;
  std::cin >> n >> capacity;
  vector<int> values(n);
  vector<int> weights(n);
  for (int i = 0; i < n; i++) {
    std::cin >> values[i] >> weights[i];
  }

  double optimal_value = get_optimal_value(capacity, weights, values);

  std::cout.precision(10);
  std::cout << optimal_value << std::endl;
  return 0;
}
