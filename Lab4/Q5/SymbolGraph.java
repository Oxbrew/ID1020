/*
*@author: Majority of code taken from Robert Sedgewick + Kevin Wayne. Additions by: Philipe Granhäll
*Algorithms & Datastructures: KTH ID1020
*Lab4 Q5
*
*Input: Two states (abbreviated, separated with a space) + < Text file (data)
*Output: Either Has path or Does not have path.
*
*/

import java.util.*;

public class SymbolGraph {
	private ST<String, Integer> st; 	// String -> index :: Symbol table where strings are vertex names and ints are indices
	private String[] keys; 				// index -> String :: Array inverted index , gives vertex name associated with each int index
	private Digraph G;			 		// the graph

	public SymbolGraph(String stream, String sp) { 		//sp is a delimiter, in our case we use a " "
		st = new ST<String, Integer>();
		Scanner in = new Scanner(stream); 				// First pass
		while (in.hasNextLine()){ 						// builds the index

			String[] a = in.nextLine().split(sp); 		// by reading strings
			for (int i = 0; i < a.length; i++) 			// to associate each
			if (!st.contains(a[i])) 					// distinct string
			st.put(a[i], st.size());		 			// with an index.
		}

		keys = new String[st.size()]; // Inverted index
		for (String name : st.keys()) // to get string keys
			keys[st.get(name)] = name; // is an array.
		G = new Digraph(st.size());
		in = new Scanner(stream); // Second pass

		while (in.hasNextLine()) { // builds the graph

			String[] a = in.nextLine().split(sp); // by connecting the
			int v = st.get(a[0]); // first vertex
			for (int i = 1; i < a.length; i++) // on each line
			G.addEdge(v, st.get(a[i])); // to all the others.
		}
	}

	public boolean contains(String s) {
		return st.contains(s);
	}

	public int index(String s) {
		return st.get(s);
	}

	public String name(int v) {
		return keys[v];
	}

	public Digraph G() {
		 return G;
	}


	/* BELOW IS THE DEPTH FIRST SEARCH ALGORITHM*/
	public static class DirectedDFS{

        private boolean[] marked;

        public DirectedDFS(Digraph G, int s){
            marked = new boolean[G.V()];
            dfs(G, s);
        }

        public DirectedDFS(Digraph G, Iterable<Integer> sources){
            marked = new boolean[G.V()];
            for (int s : sources)
            if (!marked[s]) dfs(G, s);
        }

        private void dfs(Digraph G, int v){
            marked[v] = true;
            for (int w : G.adj(v))
            if (!marked[w]) dfs(G, w);
        }

        public boolean marked(int v)
        { return marked[v]; }
    }

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		while(in.hasNextLine()){
			sb.append(in.nextLine());
			sb.append('\n');
		}
		String out = sb.toString();

		SymbolGraph SG = new SymbolGraph(out, " ");

		String from = args[0];
		String to = args[1];

		DirectedDFS search = new DirectedDFS(SG.G(), SG.index(from));

		System.out.println(from + " -> " + to + ": ");
		//for (int v = 0; v < G.V(); v++)
		if (search.marked(SG.index(to)))
			System.out.println("Path exists ");
		else
			System.out.println("Path does not exist");
		System.out.println();
		}
}
