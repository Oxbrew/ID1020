import java.util.*;
import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class RedBlackBST<Key extends Comparable<Key>, Value> {
	private Node root;
	private static final boolean RED = true;
	private static final boolean BLACK = false;

	private class Node {
		Key key;
		Value val;
		Node left, right;
		int N;
		boolean color;

		Node (Key key, Value val, int N, boolean color) {
			this.key = key;
			this.val = val;
			this.N = N;
			this.color = color;
		}
	}

	private Node rotateLeft(Node h) {
		Node x = h.right;
		h.right = x.left;
		x.left = h;
		x.color = h.color;
		h.color = RED;
		x.N = h.N;
		h.N = 1 + size(h.left) + size(h.right);
		return x;
	}
	private Node rotateRight(Node h){
		Node x = h.left;
		h.left = x.right;
		x.right = h;
		x.color = h.color;
		h.color = RED;
		x.N = h.N;
		h.N = 1 + size(h.left) + size (h.right);
		return x;
	}

	private boolean isRed(Node x) {
		if (x == null) return false;
		return x.color == RED;
	}

	private void flipColors(Node h) {
		h.color = RED;
		h.left.color = BLACK;
		h.right.color = BLACK;
	}

	public int size(){
		return size(root);
	}

	private int size(Node x){
		if (x == null) return 0;
		else
		return x.N;
	}

	public void put(Key key, Value val) {
		// Search for key. Update value if found; grow table if new.
		root = put(root, key, val);
		root.color = BLACK;
	}
	private Node put(Node h, Key key, Value val) {
		if (h == null) // Do standard insert, with red link to parent.
		return new Node(key, val, 1, RED);
		int cmp = key.compareTo(h.key);
		if
		(cmp < 0) h.left = put(h.left, key, val);
		else if (cmp > 0) h.right = put(h.right, key, val);
		else h.val = val;
		if (isRed(h.right) && !isRed(h.left))
		h = rotateLeft(h);
		if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
		if (isRed(h.left) && isRed(h.right))
		flipColors(h);
		h.N = size(h.left) + size(h.right) + 1;
		return h;
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

        public Key min () {
            return min(root).key;
        }
        private Node min (Node x) {
            if (x.left == null) return x;
            return min(x.left);
        }

        public Key max () {
            return max(root).key;
        }
        private Node max (Node x) {
            if (x.right == null) return x;
            return max(x.right);
        }


	    public static void main (String[]args){

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
	        int minlen = 2; // key-length cutoff

	        RedBlackBST<String, Integer> st = new RedBlackBST<String, Integer>();
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
	        String max = "";
	        st.put(max, 0);
			Stopwatch timer = new Stopwatch();
	        for (String word : st.keys())
	            if (st.get(word) >= st.get(max))
	                max = word;
	        System.out.println(max + " " + st.get(max));

	        double time = timer.elapsedTime();
	        System.out.println("Algorithm 3.4 BST time: " + time);
	    }
	}
