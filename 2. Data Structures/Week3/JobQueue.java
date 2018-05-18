import java.io.*;
import java.util.*;

public class JobQueue {
    
	private int numWorkers;
    private long[] jobs;

    private int[] assignedWorker;
    private long[] startTime;

    private FastScanner in;
    private PrintWriter out;

    public static void main(String[] args) throws IOException {
        new JobQueue().solve();
    }

    private void readData() throws IOException {
        this.numWorkers = in.nextInt();
        int m = in.nextInt();
        this.jobs = new long[m];
        for (int i = 0; i < m; ++i) {
            jobs[i] = in.nextInt();
        }
    }

    private void writeResponse() {
        for (int i = 0; i < jobs.length; ++i) {
            out.println(assignedWorker[i] + " " + startTime[i]);
        }
    }

	private void assignJobs() {

		assignedWorker = new int[jobs.length];
		startTime = new long[jobs.length];
/*		
		final Comparator<Pair<Integer, Long>> comparator = 
			(Pair<Integer, Long> a, Pair<Integer, Long> b) -> 
				{
					if (a.getValue() == b.getValue())
						return Integer.compare(a.getKey(), b.getKey());
					return  Long.compare(a.getValue(), b.getValue());
				};
*/
		final Comparator<Pair<Integer, Long>> comparator = 
			Comparator.<Pair<Integer, Long>>comparingLong(Pair::getValue)
				.thenComparingInt(Pair::getKey);

		final Queue<Pair<Integer, Long>> workerFinishTime = 
			new PriorityQueue(numWorkers, comparator);

		for (int i = 0; i < numWorkers; i++) 
			workerFinishTime.offer(new Pair<Integer, Long>(i, 0L));

		for (int i = 0; i < jobs.length; ++i) {
			final Pair<Integer, Long> pair = workerFinishTime.poll();
			int nextWorker = pair.getKey();
			long duration = jobs[i];
			assignedWorker[i] = nextWorker;			
			startTime[i] = pair.getValue();
			workerFinishTime.offer(new Pair(pair.getKey(), pair.getValue() + duration));
		}	
	}

    private void _assignJobs() {
        // Replace this code with a faster algorithm.
        assignedWorker = new int[jobs.length];
        startTime = new long[jobs.length];
        long[] nextFreeTime = new long[numWorkers];
        for (int i = 0; i < jobs.length; i++) {
            long duration = jobs[i];
            int bestWorker = 0;
            for (int j = 0; j < numWorkers; ++j) {
                if (nextFreeTime[j] < nextFreeTime[bestWorker])
                    bestWorker = j;
            }
            assignedWorker[i] = bestWorker;
            startTime[i] = nextFreeTime[bestWorker];
            nextFreeTime[bestWorker] += duration;
        }
    }

    public void solve() throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        readData();
        assignJobs();
        writeResponse();
        out.close();
    }

	static class Pair<K, V> {
		
		private K key;
		private V value;

		Pair(K key, V value) {
			this.key = key;
			this.value = value;
		}

		K getKey() { return this.key; }
		V getValue() { return this.value; }
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
