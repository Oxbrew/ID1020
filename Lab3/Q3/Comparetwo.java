import java.util.*;
import java.io.*;

public class Comparetwo<Key extends Comparable<Key>, Value> {

    private Node root; // root of BST

    private class Node {
        private Key key; // key
        private Value val; // associated value
        private Node left, right; // links to subtrees
        private int N; // # nodes in subtree rooted here

        public Node(Key key, Value val, int N) {
            this.key = key;
            this.val = val;
            this.N = N;
        }
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) return 0;
        else return x.N;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) { // Return value associated with key in the subtree rooted at x;
// return null if key not present in subtree rooted at x.
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else return x.val;
    }

    public void put(Key key, Value val) {
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val) {
// Change key’s value to val if key in subtree rooted at x.
// Otherwise, add new node to subtree associating key with val.
        if (x == null) return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = put(x.left, key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else x.val = val;
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public int rank(Key key)
    { return rank(key, root); }
    private int rank(Key key, Node x)
    { // Return number of keys less than x.key in the subtree rooted at x.
        if (x == null) return 0;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return rank(key, x.left);
        else if (cmp > 0) return 1 + size(x.left) + rank(key, x.right);
        else return size(x.left);
    }

    public boolean contains(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("Argument to contains() cannot be null");
        }
        return get(key) != null;
    }

    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> queue = new LinkedList<>();
        keys(root, queue, lo, hi);
        return queue;
    }

    private void keys(Node x, Queue<Key> queue, Key lo, Key hi) {
        if (x == null)
            return;
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);
        if (cmplo < 0)
            keys(x.left, queue, lo, hi);
        if (cmplo <= 0 && cmphi >= 0)
            queue.add(x.key);
        if (cmphi > 0)
            keys(x.right, queue, lo, hi);
    }

        public Key min ()
        {
            return min(root).key;
        }
        private Node min (Node x)
        {
            if (x.left == null) return x;
            return min(x.left);
        }

        public Key max ()
        {
            return max(root).key;
        }
        private Node max (Node x)
        {
            if (x.right == null) return x;
            return max(x.right);
        }
        public Key floor (Key key)
        {
            Node x = floor(root, key);
            if (x == null) return null;
            return x.key;
        }
        private Node floor (Node x, Key key)
        {
            if (x == null) return null;
            int cmp = key.compareTo(x.key);
            if (cmp == 0) return x;
            if (cmp < 0) return floor(x.left, key);
            Node t = floor(x.right, key);
            if (t != null) return t;
            else return x;
        }
		public boolean contains_word(String[] words, String word) {
	for (int i = 0; i < words.length; i++) {
		if (word.equals(words[i])) {
			return true;
		}
	}
	return false;
}

public static void main(String[] args) {
	class Stopwatch {

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

int minlen = 0; // key-length cutoff

Comparetwo<String, Integer> st = new Comparetwo<String, Integer>();

while (sc.hasNext()) { // Build symbol table and count frequencies.
	String word = sc.next();
	if (word.length() < minlen)
				  continue; // Ignore short keys.
	if (!st.contains(word))
				  st.put(word, 1);
	else
	st.put(word, st.get(word) + 1);
}

String[] frequencyList = new String[97]; // Set this to array size SET to 10 for assignment 3

		String max = "";
		st.put(max, 0);
		Stopwatch timer = new Stopwatch();
		String[] maxes = new String[97]; //Set this to array size SET TO 10 for assignment 3
		int index = 0;

		for (String word : st.keys()) {
			if (st.get(word) > st.get(max)) {
				max = word;
			}
		}
		System.out.println(max + " " + st.get(max));
		double time = timer.elapsedTime();
		System.out.println("The time it took in algorithm 3.3 is:" + time);
		// here starts assignment 3

		frequencyList[0] = max; // put that key at index 0 in the list
		maxes[index] = max;
		index++;
		max = "";

		for (int i = 1; i < frequencyList.length; i++) { // now find the other key that occures most often and store i in array
			for (String word : st.keys()) {
				if (st.get(word) >= st.get(max) && st.get(word) <= st.get(frequencyList[i - 1])) { // if value bigger than max and smaller than the value before
					if (!st.contains_word(maxes, word)) {
						max = word;
					}
				}
			}
			frequencyList[i] = max; // update the list with the key

			maxes[index] = max;
			index++;

			max = ""; // reset max
		}
		int total = 0;

		for (int i = (1 - 1); i < 97; i++) { // print the list at the given interval  SET TO E.G (6-1) WHEN ARRAY IS between 6-10 to get correct.
			System.out.println((i + 1) + ". " + frequencyList[i] + "  " + st.get(frequencyList[i]));
		}
	}
}
