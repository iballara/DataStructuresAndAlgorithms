import java.util.Scanner;
import java.util.Arrays;

class DotProduct {

    private static long maxDotProduct(final int[] a, final int[] b) {
		
		Arrays.sort(a); Arrays.sort(b);
		int size = a.length;
		int sum = 0;				
		for (int i = 0; i < size; i++) {
			sum += a[i]*b[i];
		}		
		return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }
        System.out.println(maxDotProduct(a, b));
    }
}

