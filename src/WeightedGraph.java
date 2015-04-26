import java.util.LinkedList;


public class WeightedGraph {
    private final int V;// ���-�� ����
    private int E; // ���-�� �����
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
	public Iterable<Edge> adj(int v) {// ������ ����� ����� � �������� v
		return adj[v];
	}
	public Iterable<Edge> edges() {// ������ ���� �����
		LinkedList<Edge> l=new LinkedList<Edge>();
		for (int v = 0; v < V; v++) {
			for (Edge edge : l) {
				if(edge.other(v)>v) l.add(edge);
			}
		}
		return l;
	}
 
    
}
