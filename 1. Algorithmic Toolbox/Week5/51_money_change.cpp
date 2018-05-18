#include <iostream>
#include <vector>
#include <climits>

int get_change(int money) {

	const std::vector<int> coins = {1, 3, 4};
	std::vector<int> minCoins(money + 1);
	minCoins[0] = 0;
	for (int m = 1; m <= money; m++)
	{
		minCoins[m] = INT_MAX;
		for (int i = 0; i < coins.size(); i++)
		{			
			if(m >= coins[i])
			{
				int num = minCoins[m-coins[i]] + 1;
				if (num < minCoins[m]) 
					minCoins[m] = num;
			}
		}
	}
	return minCoins[money];
}

int main() {
  int m;
  std::cin >> m;
  std::cout << get_change(m) << std::endl;
}
