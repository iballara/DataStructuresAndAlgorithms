import java.util.*;
import java.io.*;

public class tree_orders {
    class FastScanner {
		StringTokenizer tok = new StringTokenizer("");
		BufferedReader in;

		FastScanner() {
			in = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() throws IOException {
			while (!tok.hasMoreElements())
				tok = new StringTokenizer(in.readLine());
			return tok.nextToken();
		}
	
		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
	}

	public class TreeOrders {
		int n;
		int[] key, left, right;
		
		void read() throws IOException {
			FastScanner in = new FastScanner();
			n = in.nextInt();
			key = new int[n];
			left = new int[n];
			right = new int[n];
			for (int i = 0; i < n; i++) { 
				key[i] = in.nextInt();
				left[i] = in.nextInt();
				right[i] = in.nextInt();
			}
		}

		List<Integer> inOrder() {
            if (key == null || key.length == 0) return Collections.emptyList();  
			final ArrayList<Integer> result = new ArrayList<Integer>();
			inOrderTraversal(result, 0);			
			return result;
		}

		private void inOrderTraversal(final List<Integer> result, final int node) {
			if (node == -1) return;
			inOrderTraversal(result, left[node]);
			result.add(key[node]);
			inOrderTraversal(result, right[node]);
		}

		List<Integer> preOrder() {
			if (key == null || key.length == 0) return Collections.emptyList();  
			final ArrayList<Integer> result = new ArrayList<Integer>();
			preOrderTraversal(result, 0);			
			return result;
		}

		private void preOrderTraversal(final List<Integer> result, final int node) {
			if (node == -1) return;
			result.add(key[node]);
			preOrderTraversal(result, left[node]);
			preOrderTraversal(result, right[node]);
		}

		List<Integer> postOrder() {
			if (key == null || key.length == 0) return Collections.emptyList();  
			final ArrayList<Integer> result = new ArrayList<Integer>();
			postOrderTraversal(result, 0);			
			return result;
		}

		private void postOrderTraversal(final List<Integer> result, final int node) {
			if (node == -1) return;
			postOrderTraversal(result, left[node]);
			postOrderTraversal(result, right[node]);
			result.add(key[node]);
		}
	}

	static public void main(String[] args) throws IOException {
            new Thread(null, new Runnable() {
                    public void run() {
                        try {
                            new tree_orders().run();
                        } catch (IOException e) {
                        }
                    }
                }, "1", 1 << 26).start();
	}

	public void print(List<Integer> x) {
		for (Integer a : x) {
			System.out.print(a + " ");
		}
		System.out.println();
	}

	public void run() throws IOException {
		TreeOrders tree = new TreeOrders();
		tree.read();
		print(tree.inOrder());
		print(tree.preOrder());
		print(tree.postOrder());
	}
}
