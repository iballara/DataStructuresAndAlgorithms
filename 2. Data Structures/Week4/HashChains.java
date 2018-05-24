import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class HashChains {

    private FastScanner in;
    private PrintWriter out;
    // store all strings in one list
    private List<List<String>> elems;
    // for hash function
    private int bucketCount;
    private static final int prime = 1000000007;
    private static final int multiplier = 263;

    public static void main(String[] args) throws IOException {
        new HashChains().processQueries();
    }

    private int hashFunc(final String s) {
        long hash = 0;
        for (int i = s.length() - 1; i >= 0; --i) {
            //long a = hash * multiplier + s.charAt(i);
            hash = ((hash * multiplier + s.charAt(i) % prime)+prime)%prime;
        }
        return (int)hash % bucketCount;
    }

    private void writeSearchResult(boolean wasFound) {
        System.out.println(wasFound ? "yes" : "no");
        // Uncomment the following if you want to play with the program interactively.
        // out.flush();
    }

    private void add(final String s) {

        int hash = hashFunc(s);
        final List<String> list = elems.get(hash);
        for (String text : list)
            if (text.equals(s)) return;

        list.add(0, s);
        elems.set(hash, list);
    }

    private boolean find(final String s) {
        int hash = hashFunc(s);
        final List<String> list = elems.get(hash);
        for (String text : list)
            if (text.equals(s)) return true;
        return false;
    }

    private void del(final String s) {
        if (!find(s)) return;
        int hash = hashFunc(s);
        final List<String> list = elems.get(hash);
        list.removeIf(text -> text.equals(s));

        elems.set(hash, list);
    }

    private void check(final int ind) {
        final List<String> list = elems.get(ind);
        if (list.isEmpty()) {
            System.out.print("\n");
            return;
        }
        for(String text : list)
            System.out.print(text + " ");
        System.out.println();
    }

    private void processQuery(Query query) {
        switch (query.type) {
            case "add":
                add(query.s);
                break;
            case "del":
                del(query.s);
                break;
            case "find":
                writeSearchResult(find(query.s));
                break;
            case "check":
                check(query.ind);
                break;
            default:
                throw new RuntimeException("Unknown query: " + query.type);
        }
    }

    private void processQueries() throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        bucketCount = in.nextInt();
        int queryCount = in.nextInt();
        elems = new ArrayList<>(bucketCount);
        for (int i = 0; i < bucketCount; i++)
            elems.add(i, new ArrayList<>());
        for (int i = 0; i < queryCount; ++i) {
            processQuery(readQuery());
        }
        out.close();
    }

    private Query readQuery() throws IOException {
        String type = in.next();
        if (!type.equals("check")) {
            String s = in.next();
            return new Query(type, s);
        } else {
            int ind = in.nextInt();
            return new Query(type, ind);
        }
    }

    static class Query {
        String type;
        String s;
        int ind;

        public Query(String type, String s) {
            this.type = type;
            this.s = s;
        }

        public Query(String type, int ind) {
            this.type = type;
            this.ind = ind;
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
