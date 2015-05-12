import java.util.Collection;
import java.util.LinkedList;


public class WeightedGraph {
	private final int V;// кол-во верш
	private int E; // кол-во ребер
	private LinkedList<Edge>[] adj;
	public WeightedGraph(int V) {
		this.V = V;
		E = 0;
		adj = new LinkedList[V];
		for (int v = 0; v < V; v++) {
			adj[v]= new LinkedList<Edge>();
		}
	}
	public int V() {
		return V;
	}
	public int E() {
		return E;
	}
	public void addEdge(Edge e) {
		int v=e.either(), w=e.other(v);
		adj[v].add(e);
		adj[w].add(e);
		E++;
	}
	public Iterable<Edge> adj(int v) {// список ребер смежн с вершиной v
		return adj[v];
	}
	public Collection<Edge> edges() {// список всех ребер
		LinkedList<Edge> l=new LinkedList<Edge>();
		for (int v = 0; v < V; v++) {
			for (Edge edge : adj[v]) {
				if(edge.other(v)>v) l.add(edge);
			}
		}
		return l;
	}
	@Override
	public String toString() {
		for (Edge e: edges()) {
			System.out.println(e.toString());
		}
        return null;

	}


}
