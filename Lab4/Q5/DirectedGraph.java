import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;

public class DirectedGraph{

	public static class Digraph{

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

    public static class DepthFirstOrder{

        private boolean[] marked;
        private Queue<Integer> pre; // vertices in preorder
        private Queue<Integer> post; // vertices in postorder
        private Stack<Integer> reversePost; // vertices in reverse postorder

        public DepthFirstOrder(Digraph G){
            pre = new LinkedList<Integer>();
            post = new LinkedList<Integer>();
            reversePost = new Stack<Integer>();
            marked = new boolean[G.V()];
            for (int v = 0; v < G.V(); v++)
            if (!marked[v]) dfs(G, v);
        }

        private void dfs(Digraph G, int v){
            pre.add(v);
            marked[v] = true;
            for (int w : G.adj(v))
            if (!marked[w])
            dfs(G, w);
            post.add(v);
            reversePost.push(v);
        }

        public Iterable<Integer> pre()
        { return pre; }

        public Iterable<Integer> post()
        { return post; }

        public Iterable<Integer> reversePost()
        { return reversePost; }
    }

    public static class Topological{

        private Iterable<Integer> order; // topological order

        public Topological(Digraph G){
            DirectedCycle cyclefinder = new DirectedCycle(G);
            if (!cyclefinder.hasCycle())
            {
            DepthFirstOrder dfs = new DepthFirstOrder(G);
            order = dfs.reversePost();
            }
        }

        public Iterable<Integer> order()
        { return order; }

        public boolean isDAG()
        { return order == null; }
    }

    public static void main(String[] args){
        /*Digraph G = new Digraph(new In(args[0]));
        Bag<Integer> sources = new Bag<Integer>();
        for (int i = 1; i < args.length; i++)
        sources.add(Integer.parseInt(args[i]));
        DirectedDFS reachable = new DirectedDFS(G, sources);
        for (int v = 0; v < G.V(); v++)
        if (reachable.marked(v)) StdOut.print(v + " ");
        StdOut.println();*/
    }
}
