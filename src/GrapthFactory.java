import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;



public class GrapthFactory {
	public static WeightedGraph createGraph(String path) {
		WeightedGraph gr=null;
		String len;
		int v, w;
		double weight;
		try (   InputStream in=new FileInputStream(path);
				BufferedReader r=new BufferedReader(new InputStreamReader(in));
				){
			len=r.readLine();
			gr= new WeightedGraph(Integer.parseInt(len));
			while((len=r.readLine()) != null){
				String[] vertexes=len.split("-");
				v=Integer.parseInt(vertexes[0]);
				vertexes=vertexes[1].split(" ");
				w=Integer.parseInt(vertexes[0]);
				weight=Double.parseDouble(vertexes[1]);	
				gr.addEdge(new Edge(v, w, weight));
			}
				
		}
		catch(IOException e){
			e.printStackTrace();
		}
		return gr;
	}
	public static void main(String[] args) {
		createGraph("graph.txt").print();
		System.out.println();
		KruskalMST kr=new KruskalMST(createGraph("graph.txt"));
		kr.print();
	}
}
