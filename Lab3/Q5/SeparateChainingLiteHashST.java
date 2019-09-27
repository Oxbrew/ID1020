/******************************************************************************
 *  Compilation:  javac SeparateChainingLiteHashST.java
 *  Execution:    java SeparateChainingLiteHashST
 *  Dependencies: StdIn.java StdOut.java
 *
 *  A symbol table implemented with a separate-chaining hash table.
 *
 *  Note 1: does not support delete().
 *  Note 2: does not do resizing.
 *
 *  % java SeparateChainingLiteHashST < tinyTale.txt
 *
 ******************************************************************************/
//import edu.princeton.cs.algs4.StdIn;
//import edu.princeton.cs.algs4.StdOut;
import java.util.*;
@SuppressWarnings("unchecked")

public class SeparateChainingLiteHashST<Key, Value> {

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
    public SeparateChainingLiteHashST() {
        this(997);
    }

    // create separate chaining hash table with m lists
    public SeparateChainingLiteHashST(int m) {
        this.m = m;
        st = new Node[m];
    }


    // hash value between 0 and m-1
    private int hash(Key key) { //hash function
        return (key.hashCode() & 0x7fffffff) % m;
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

    /***************************************************************************
     *  Unit test client.
     ***************************************************************************/
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        SeparateChainingLiteHashST<String, Integer> st = new SeparateChainingLiteHashST<String, Integer>(97); //138883
        for (int i = 0; sc.hasNext(); i++) {
            String key = sc.next();
            st.put(key, i);
        }
		st.printHT();

    /*    // print keys
		int count = 0;

        for (String s : st.keys())
            //System.out.println(s + " " + st.get(s)); //UNCOMMENT FOR 5
			count++;


		int [] countedHash = new int[count];
		int index = 0;
		for (String s : st.keys()) {
			countedHash[index] = st.get(s);
			index++;
		}
		for (int i = 0; i < countedHash.length ; i++ ) {
			System.out.println( countedHash[i]%97); // size of hash table being the provided hash
		}*/

	}

}
