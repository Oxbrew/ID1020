/*
*@author: Majority of code taken from Robert Sedgewick + Kevin Wayne. Additions by: Philipe Granhäll
*Algorithms & Datastructures: KTH ID1020
*Lab4 Q1
*
* Directed Graph API used for Q5+
*
*/
import java.util.*;

public class Digraph{

	private final int V;
	private int E;
	private  ArrayList<LinkedList<Integer>>adj; //Bag<Integer>[] adj;

	public Digraph(int V){
		this.V = V;
		this.E = 0;
		adj = new ArrayList<LinkedList<Integer>>();//(Bag<Integer>[]) new Bag[V];
		for (int v = 0; v < V; v++)
		adj.add(new LinkedList<Integer>());//adj[v] = new Bag<Integer>();
	}

	public int V() { return V; }

	public int E() { return E; }

	public void addEdge(int v, int w){
		adj.get(v).add(w); //adj[v].add(w);
		E++;
	}

	public Iterable<Integer> adj(int v) { return adj.get(v);} //adj[v]; }

	public Digraph reverse(){
		Digraph R = new Digraph(V);
		for (int v = 0; v < V; v++)
		for (int w : adj(v))
		R.addEdge(w, v);
		return R;
	}
}
