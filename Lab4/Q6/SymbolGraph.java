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
	public static class DirectedCycle{

		private boolean[] marked;
		private int[] edgeTo;
		private Stack<Integer> cycle; // vertices on a cycle (if one exists)
		private boolean[] onStack; // vertices on recursive call stack

		public DirectedCycle(Digraph G){
			onStack = new boolean[G.V()];
			edgeTo = new int[G.V()];
			marked = new boolean[G.V()];
			for (int v = 0; v < G.V(); v++)
			if (!marked[v]) dfs(G, v);
		}

		private void dfs(Digraph G, int v){
			onStack[v] = true;
			marked[v] = true;
			for (int w : G.adj(v))
			if (this.hasCycle())
				return;
			else if (!marked[w]){
				edgeTo[w] = v;
				dfs(G, w);
			}
			else if (onStack[w])
			{
			cycle = new Stack<Integer>();
			for (int x = v; x != w; x = edgeTo[x])
			cycle.push(x);
			cycle.push(w);
			cycle.push(v);
			}
			onStack[v] = false;
		}

		public boolean hasCycle()
		{ return cycle != null; }

		public Iterable<Integer> cycle()
		{ return cycle; }
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

		//String from = args[0];
		//String to = args[1];

		DirectedCycle cycle = new DirectedCycle(SG.G());

		if (cycle.hasCycle())
			System.out.println("Has Cycle");
		else
			System.out.println("Has no Cycle");
		}
}
