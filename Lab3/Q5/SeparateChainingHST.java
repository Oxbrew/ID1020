/*
*@author: Majority of code taken from Robert Sedgewick + Kevin Wayne. Additions by: Philipe Granhäll
*Algorithms & Datastructures: KTH ID1020
*Lab3 Q5
*
*Input: Text file
*Output: List of arrays and how many keys are stored withing: to demonstrate how even inbuilt hashing is.
*
*/
import java.util.*;

public class SeparateChainingHST<Key, Value> {

    private int n;       // number of key-value pairs
    private int m;       // hash table size
    private Node[] st;   // array of linked-list symbol tables

    // a helper linked list data type
    private static class Node {
        private Object key;
        private Object val;
        private Node next;

        public Node(Object key, Object val, Node next)  {
            this.key  = key;
            this.val  = val;
            this.next = next;
        }
    }

    // create separate chaining hash table
    public SeparateChainingHST() {
        this(997);
    }

    // create separate chaining hash table with m lists
    public SeparateChainingHST(int m) {
        this.m = m;
        st = new Node[m];
    }


    // hash value between 0 and m-1
    private int hash(Key key) { //hash function
        return (key.hashCode() & 0x7fffffff) % m; //in-built hashcode, returns integer value from hashing algorithm.
    }

    // return number of key-value pairs in symbol table
    public int size() {
        return n;
    }

    // is the symbol table empty?
    public boolean isEmpty() {
        return size() == 0;
    }

    // is the key in the symbol table?
    public boolean contains(Key key) {
        return get(key) != null;
    }

    // return value associated with key, null if no such key
    public Value get(Key key) {
        int i = hash(key);
        for (Node x = st[i]; x != null; x = x.next) {
            if (key.equals(x.key)) return (Value) x.val;
        }
        return null;
    }

    // insert key-value pair into the table
    public void put(Key key, Value val) {
        if (val == null) {
            delete(key);
            return;
        }
        int i = hash(key);
        for (Node x = st[i]; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.val = val;
                return;
            }
        }
        n++;
        st[i] = new Node(key, val, st[i]);
    }

    // delete key (and associated value) from the symbol table
    public void delete(Key key) {
        throw new UnsupportedOperationException("delete not currently supported");
    }

    // return all keys as an Iterable
    public Iterable<Key> keys()  {
        LinkedList<Key> queue = new LinkedList<Key>();
        for (int i = 0; i < m; i++) {
            for (Node x = st[i]; x != null; x = x.next) {
                queue.add((Key) x.key);
            }
        }
        return queue;
    }

	public void printHT () {
		for (int i = 0; i < st.length ; i++) {
			int value = 0;
			Node frequencies = st[i];
			while( frequencies != null){
				value++;
				frequencies = frequencies.next;
			}
			System.out.println("Index: " + i + " has: " + value);
		}
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

        SeparateChainingHST<String, Integer> st = new SeparateChainingHST<String, Integer>(97); //138883

		Stopwatch timer = new Stopwatch();

		for (int i = 0; sc.hasNext(); i++) {
            String key = sc.next();
            st.put(key, i);
        }
		st.printHT();
	/* //UNCOMMENT FOR 5
        // print keys
		int count = 0;

		Stopwatch timer = new Stopwatch();

		for (String s : st.keys()){
            System.out.println(s + " " + st.get(s));
			count++;
		}
		*/
		double time = timer.elapsedTime();
		System.out.println("SeparateChaining time: " + time);

	}
}
