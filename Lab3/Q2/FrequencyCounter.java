import java.util.*;

public class FrequencyCounter{

	public static void main(String[] args) {
		int minlen = Integer.parseInt(args[0]); // key-length cutoff
		BST<String, Integer> st = new BST<String, Integer>();
		Scanner StdIn = new Scanner(System.in);
		while (StdIn.hasNext()) { // Build symbol table and count frequencies.
			String word = StdIn.next();
			if (word.length() < minlen) continue; // Ignore short keys.
			if (!st.contains(word)) st.put(word, 1);
			else st.put(word, st.get(word) + 1);
		}
// Find a key with the highest frequency count.
		String max = "";
		st.put(max, 0);
		for (String word : st.keys())
		if (st.get(word) > st.get(max))
		max = word;
		System.out.println(max + " " + st.get(max));
	}
}
