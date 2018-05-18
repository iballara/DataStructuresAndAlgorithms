#include <iostream>
#include <vector>
#include <math.h>

int greedy_change(float money) {
	
	const std::vector<float> coins = {0.50f, 0.25f, 0.10f, 0.05f, 0.01f};
	int change = 0;
	for (int i = 0; i < coins.size(); i++) {
		int division = roundf(money / coins[i] * 100) / 100;			
		change += division;
		money -= division * coins[i];
		std::cout << "for coin " << i << " division = " << division 
		<< ", money left: " << roundf(money*100)/100 << std::endl;
	}
	return change;
}

int main()
{
	float prize;
	std::cout << "Prize: ";
	std::cin >> prize;
	float money;
	std::cout << "Money given: ";
	std::cin >> money;
	if (prize > money) {
		std::cout << "Not enough money" << std::endl;
		return 0;	
	}
	std::cout << "Change required: " << money-prize << std::endl;
	std::cout << "Minimum coins: " << greedy_change(money-prize) << std::endl;
}
