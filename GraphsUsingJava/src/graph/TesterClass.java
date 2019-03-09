package graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TesterClass {

public static void main(String args[])
{
	Scanner in = new Scanner(System.in);
	int numberOfVertices = 0;
	Map<Vertex,List<Vertex>> adjVertices = new HashMap<Vertex,List<Vertex>>();
	System.out.println("Enter the number of vertices :" );
	numberOfVertices= in.nextInt();
	for(int k=0;k<numberOfVertices;k++)
	{
		System.out.println("Enter the name of vertex :");
		String vertexName = in.next();
		Vertex next = new Vertex(vertexName);
		List<Vertex> value = new LinkedList<Vertex>();
		adjVertices.putIfAbsent(next, value);	
	}
	UndirectedGraph graph = new UndirectedGraph(adjVertices);
	//graph.printGraph();
	System.out.println("Enter the function to be performed : \n 1. Add edge\n 2. Add vertex\n 3. DFS\n 4. BFS\n 5. Exit\n " );
	int option=in.nextInt();
	while(option!=5)
	{
		if(option==1)
		{
			System.out.println("Enter the source and destination vertices : " );
			String source=in.next();
			String destination=in.next();
			graph.addEdge(source, destination);

		}
		if(option==2)
		{
			System.out.println("Enter the vertex : " );
			String vertexNew=in.next();
			graph.addVertex(vertexNew);
		}
		if(option==2)
		{
			System.out.println("Enter the vertex : " );
			String vertexNew=in.next();
			graph.addVertex(vertexNew);
		}
		if(option==3)
		{
			System.out.println("Enter the start vertex : " );
			String vertexNew=in.next();
			graph.depthFirstSearch(vertexNew);
			graph.resetGraphVertices();
		}
		if(option==4)
		{
			System.out.println("Enter the start vertex : " );
			String vertexNew=in.next();
			graph.breathFirstSearch(vertexNew);
			graph.resetGraphVertices();
		}
		System.out.println("Enter the function to be performed : \n 1. Add edge\n 2. Add vertex\n 3. DFS\n 4. BFS\n 5. Exit\n " );
		option=in.nextInt();
	}
	
}

}
