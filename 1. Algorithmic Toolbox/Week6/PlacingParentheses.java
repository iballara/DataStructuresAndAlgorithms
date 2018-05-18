import java.util.Scanner;

public class PlacingParentheses {

    private static long getMaximValue(String exp) {
      
		long max = 0;
		char[] op = new char[exp.length() / 2];
		int[] digit = new int[exp.length() / 2 + 1];
		int dig = 0, operator = 0;
	    for (int i = 0; i < exp.length(); i++)
			if (i % 2 == 0) digit[dig++] = exp.charAt(i) - '0';
			else			op[operator++] = exp.charAt(i);
	
		int n = digit.length;
		long[][] m = new long[n][n];
		long[][] M = new long[n][n];
		for(int i = 0;i<n;i++) {
			m[i][i] = digit[i];
			M[i][i] = digit[i];
		}
		for(int s = 1; s < n; s++) 
			for(int i = 0; i < n-s; i++) {
				int j = i+s;
				long [] temp = new long[2];
				temp = minAndMax(i,j,op,m,M);
				m[i][j] = temp[0];
				M[i][j] = temp[1];
			}
		return M[0][n-1];
	}

	private static long[] minAndMax(int i, int j, char[] op, long[][] m, long[][] M) {
		
		long min = Long.MAX_VALUE;
		long max = Long.MIN_VALUE; 
		for (int k = i; k < j; k++) {
			long a = eval(M[i][k], M[k+1][j], op[k]);
			long b = eval(M[i][k], m[k+1][j], op[k]);
			long c = eval(m[i][k], M[k+1][j], op[k]);
			long d = eval(m[i][k], m[k+1][j], op[k]);
			min = Math.min(Math.min(Math.min(Math.min(min, a), b), c), d);
			max = Math.max(Math.max(Math.max(Math.max(max, a), b), c), d);
		}

		long[] result = new long[2];
		result[0] = min; result[1] = max;
		return result;
	}

    private static long eval(long a, long b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == '*') {
            return a * b;
        } else {
            assert false;
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.next();
        System.out.println(getMaximValue(exp));
    }
}

