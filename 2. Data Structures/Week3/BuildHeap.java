import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class BuildHeap {

    private int[] data;
    private List<Swap> swaps;

    private FastScanner in;
    private PrintWriter out;

    public static void main(String[] args) throws IOException {
        new BuildHeap().solve();
    }

    private void readData() throws IOException {
        int n = in.nextInt();
        data = new int[n];
        for (int i = 0; i < n; ++i) {
          data[i] = in.nextInt();
        }
    }

    private void writeResponse() {
        out.println(swaps.size());
        for (Swap swap : swaps) {
          out.println(swap.index1 + " " + swap.index2);
        }
    }

    private void generateSwaps() {
    	swaps = new ArrayList<Swap>();
		// BuildHeap
		int n = data.length/2;
		for (int i = n; i >= 0; i--)
			siftDown(i);
    }

	private void siftDown(int i) {
		int minIndex = i;
		int left = leftChild(i);
		int right = rightChild(i);		
		if (left < data.length && data[left] < data[minIndex])   minIndex = left;
		if (right < data.length && data[right] < data[minIndex]) minIndex = right;
		if (i != minIndex) {
			swap(i, minIndex);
			siftDown(minIndex);
		}
	}
	
	private void swap(int a, int b) {
		swaps.add(new Swap(a, b));
		int aux = data[a];
		data[a] = data[b];
		data[b] = aux;
	}

	private int leftChild(int i) {
		return 2*i + 1;
	}

	private int rightChild(int i) {
		return leftChild(i) + 1;
	}

    public void solve() throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        readData();
        generateSwaps();
        writeResponse();
        out.close();
    }

    static class Swap {
        int index1;
        int index2;

        public Swap(int index1, int index2) {
            this.index1 = index1;
            this.index2 = index2;
        }
    }

    static class FastScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
        }

        public String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}
