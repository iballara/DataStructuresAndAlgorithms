import java.util.Scanner;

class EuclidGCD {

	public static long euclidGCD(final long a, final long b) {
		if (b == 0) return a;
		return euclidGCD(b, a % b);
	}

	public static void main(String[] args) {
		final Scanner in = new Scanner(System.in);
		long a = in.nextLong();
		long b = in.nextLong();
		System.out.println(euclidGCD(a,b));
	}
}

