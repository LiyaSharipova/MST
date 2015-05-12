import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;


public class KruskalMST {
	private List<Edge>  mst ;// все ребра МОД хранятся здесь
	public KruskalMST(WeightedGraph G){
	    MST(G);
	}
	private void MST(WeightedGraph G) {
		mst= new LinkedList<Edge>();
		PriorityQueue<Edge> pq= new PriorityQueue<Edge>(G.edges());
		    //приоритетная очередь 
		    // заполняется всеми ребрами и сортируется по возрастанию
		TreeDisjointUnity vertexUnity= new TreeDisjointUnity(G.V());
		   //создаем непересек мн-ва
		   //по кол-ву вершин графа=
		while(!pq.isEmpty()&& mst.size()<G.V()-1){
			   //перебирает все ребра графа пр. очереди
			   // пока она не опустеет и МОД содержит меньше N-1 ребер
			Edge e=pq.poll();// извлекает 1й(мин) элемент пр. очереди
			int v=e.either(), w=e.other(v);// 
			if(vertexUnity.connected(v, w)) continue;//если вершины v и w принадлежат одному 
			   //множеству, то ребро игнорируется (при их соед-и обр-ся цикл). 
			vertexUnity.union(v, w);// Иначе множества сод-е вершины v и w объединяются
			mst.add(e);
			   // добавляет ребро к МОД
		}
	}
	public Iterable<Edge> edges(){
		return mst;
	}
	public double weight() {
		double weight=0;
		for (Edge edge : mst) {
			weight+=edge.weight();
		}
		return weight;
	}
	@Override
	public String toString() {
		for (Edge edge : mst) {
			System.out.println(edge.toString());
		}
		return Double.toString(weight());
	}

}
