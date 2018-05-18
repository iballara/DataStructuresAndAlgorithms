import java.util.*;

public class Knapsack {
    
	static int optimalWeight(int W, int[] w) {
        
		int[] a =  new int[W+1];
		for (int i = 0; i < w.length; ++i) 
			for(int j = W; j - w[i] >= 0; --j) 
				a[j] = Math.max(a[j], a[j - w[i]] + w[i]);
		return a[W];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W = scanner.nextInt();
        int n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }
}

