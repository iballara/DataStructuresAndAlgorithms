import java.util.*;
import java.io.*;

public class is_bst_hard {
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

    public class IsBST {
        class Node {
            int key;
            int left;
            int right;

            Node(int key, int left, int right) {
                this.left = left;
                this.right = right;
                this.key = key;
            }
        }

        int nodes;
        Node[] tree;

        void read() throws IOException {
            FastScanner in = new FastScanner();
            nodes = in.nextInt();
            tree = new Node[nodes];
            for (int i = 0; i < nodes; i++) {
                tree[i] = new Node(in.nextInt(), in.nextInt(), in.nextInt());
            }
        }

		private void inOrderTraversal(final List<Integer> result, int node) {
			if (node == -1) return;
			inOrderTraversal(result, tree[node].left);
			result.add(node);
			inOrderTraversal(result, tree[node].right);
		}

		private Integer[] inOrder() {
			final List<Integer> result = new ArrayList<>();
			inOrderTraversal(result, 0);
			return result.toArray(new Integer[result.size()]);
		}

        boolean isBinarySearchTree() {
			if (tree.length > 1) {
				Integer[] result = inOrder();
				for (int i = 0; i < result.length - 1; i++) {
					if (tree[result[i+1]].key < tree[result[i]].key) 
						return false;
					if (tree[result[i]].key == tree[result[i+1]].key 
						&& tree[result[i+1]].left == result[i]) 
						return false;
				}					
			}
	        return true;
        }
    }

    static public void main(String[] args) throws IOException {
        new Thread(null, new Runnable() {
            public void run() {
                try {
                    new is_bst_hard().run();
                } catch (IOException e) {
                }
            }
        }, "1", 1 << 26).start();
    }
    public void run() throws IOException {
        IsBST tree = new IsBST();
        tree.read();
        if (tree.isBinarySearchTree()) {
            System.out.println("CORRECT");
        } else {
            System.out.println("INCORRECT");
        }
    }
}
