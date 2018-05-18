import java.util.Scanner;

class MaximumPairwiseProduct {

	public static long maxPairwiseProductFast(final int[] numbers) {
		long max = 0;
		long max2 = 0;
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] >= max) { 
				max2 = max;				
				max = numbers[i];
			} else if (numbers[i] > max2 && numbers[i] != max) { 
				max2 = numbers[i]; 
			}
		}
		return (long) max * max2;		
	}

	public static void main(String[] args) {
		
		final Scanner s = new Scanner(System.in);
		int numElem = s.nextInt();

		int[] numbers = new int[numElem];
		
		for (int i = 0; i < numElem; i++) {
			numbers[i] = s.nextInt();		
		}

		System.out.println(maxPairwiseProductFast(numbers));
	}
}
