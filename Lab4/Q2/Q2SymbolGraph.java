/*
*@author: Majority of code taken from Robert Sedgewick + Kevin Wayne. Additions by: Philipe Granhäll
*Algorithms & Datastructures: KTH ID1020
*Lab4 Q2
*
*Input: Two states (abbreviated, separated with a space) + < Text file (data)
*Output: Path from State 1 -> 2, order of vertices attained through BREADTH first serach.
*
*/

import java.util.*;

public class Q2SymbolGraph {

	private ST<String, Integer> st; 	// String -> index :: Symbol table where strings are vertex names and ints are indices
	private String[] keys; 				// index -> String :: Array inverted index , gives vertex name associated with each int index
	private Graph G;			 		// the graph

	public Q2SymbolGraph(String stream, String sp) { 		//sp is a delimiter, in our case we use a " "
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
		G = new Graph(st.size());
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

	public Graph G() {
		 return G;
	}


	/* BELOW IS THE BREADTH FIRST SEARCH ALGORITHM*/

	public static class BFS {
		private boolean[] marked; // Is a shortest path to this vertex known?
		private int[] edgeTo; // last vertex on known path to this vertex
		private final int s;
		// source
		public BFS(Graph G, int s) {
			marked = new boolean[G.V()];
			edgeTo = new int[G.V()];
			this.s = s;
			bfs(G, s);
		}
		private void bfs(Graph G, int s) {
			LinkedList<Integer> queue = new LinkedList<Integer>();
			marked[s] = true;// Mark the source
			queue.add(s); //and put it on the queue.
			while (!queue.isEmpty()) {
				int v = queue.remove(); // Remove next vertex from the queue.
				for (int w : G.adj(v))
				if (!marked[w]){ // For every unmarked adjacent vertex,
					edgeTo[w] = v; // save last edge on a shortest path,
					marked[w] = true; //mark it because path is known,
					queue.add(w); //and add it to the queue.
				}
			}
		}
		public boolean hasPathTo(int v)
		{ return marked[v]; }

			public Iterable<Integer> pathTo(int v) {
				if (!hasPathTo(v))
					return null;
				LinkedList<Integer> path = new LinkedList<Integer>();
				for (int x = v ; x != s ; x = edgeTo[x])
					path.addFirst(x);
				path.addFirst(s);

				return path;
			}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		while(in.hasNextLine()){
			sb.append(in.nextLine());
			sb.append('\n');
		}
		String out = sb.toString();

		Q2SymbolGraph SG = new Q2SymbolGraph(out, " ");

		String from = args[0];
		String to = args[1];

		BFS search = new BFS(SG.G(), SG.index(from));

		System.out.println(from + " -> " + to + ": ");
		if (search.hasPathTo(SG.index(to))) {
			for (int i : search.pathTo(SG.index(to)) ) {
				if (SG.name(i).equals(from))
					System.out.print(SG.name(i));
				else
				System.out.print(" - " + SG.name(i) + " ");

			}
		System.out.println();
		}
	}
}
