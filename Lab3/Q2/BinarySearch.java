import java.util.*;

/*
*@author: Majority of code taken from Robert Sedgewick + Kevin Wayne. Additions by: Philipe Granhäll
*Algorithms & Datastructures: KTH ID1020
*Lab3 Q2
*
*Input: Text file
*Output: frequency test
*
*/

public class BinarySearch<Key extends Comparable<Key>, Value> {

    private Key[] keys;
    private Value[] vals;
    private int N;

    public BinarySearch(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        vals = (Value[]) new Object[capacity];
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public Value get(Key key) {
        if (isEmpty())
            return null;
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0)
            return vals[i];
        else
            return null;
    }

    public void put(Key key, Value val) { // Search for key. Update value if found; grow table if new.
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) {
            vals[i] = val;
            return;
        }
        for (int j = N; j > i; j--) {
            keys[j] = keys[j - 1];
            vals[j] = vals[j - 1];
        }
        keys[i] = key;
        vals[i] = val;
        N++;
    }

    public int rank(Key key) {
        int lo = 0, hi = N - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0)
                hi = mid - 1;
            else if (cmp > 0)
                lo = mid + 1;
            else
                return mid;
        }
        return lo;
    }

    public boolean contains(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("Argument to contains() cannot be null");
        }
        return get(key) != null;
    }

    public Key min() {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty symbol table");
        }

        return keys[0];
    }

    public Key max() {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty symbol table");
        }

        return keys[N - 1];
    }

    public Iterable<Key> keys(Key low, Key high) {
        if (low == null || high == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        Queue<Key> queue = new LinkedList<>();
        for (int i = rank(low); i < rank(high); i++) {
            queue.add(keys[i]);
        }
        if (contains(high)) {
            queue.add(keys[rank(high)]);
        }
        return queue;
    }

    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    public static void main(String[] args) {
		class Stopwatch { //Stopwatch class.
			private final long start;

			public Stopwatch() {
				start = System.currentTimeMillis();
			}

			public double elapsedTime() {
				long now = System.currentTimeMillis();
				return (now - start) / 1000.0;
			}
		}

        Scanner sc = new Scanner(System.in);
        int minlen = 2; // key-length cutoff

        BinarySearch<String, Integer> st = new BinarySearch<String, Integer>(100000);
        while (sc.hasNext()) { // Build symbol table and count frequencies.
            String word = sc.next();
            if (word.length() < minlen)
                continue; // Ignore short keys.
            if (!st.contains(word))
                st.put(word, 1);
            else
                st.put(word, st.get(word) + 1);
        }
        // Find a key with the highest frequency count.
		Stopwatch timer = new Stopwatch(); //Timer

		String max = "";
        st.put(max, 0);
        for (String word : st.keys())
            if (st.get(word) > st.get(max))
                max = word;
        System.out.println(max + " " + st.get(max));

		double time = timer.elapsedTime();
		System.out.println("Algorithm 3.2 Binary Search time: " + time);
    }
}
