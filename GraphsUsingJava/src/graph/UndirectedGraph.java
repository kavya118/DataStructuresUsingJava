package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class UndirectedGraph {
	
	Map<Vertex,List<Vertex>> adjVertices = new HashMap<Vertex,List<Vertex>>();
	
	
public Map<Vertex, List<Vertex>> getAdjVertices() {
		return adjVertices;
	}

public void setAdjVertices(Map<Vertex, List<Vertex>> adjVertices) {
		this.adjVertices = adjVertices;
	}

public UndirectedGraph(Map<Vertex, List<Vertex>> adjVertices) {
		super();
		this.adjVertices = adjVertices;
	}

public void addVertex(String label)
{
	adjVertices.putIfAbsent(new Vertex(label), new LinkedList<Vertex>());
}

public void removeVertex(String label)
{
	adjVertices.remove(new Vertex(label));
}

public void resetGraphVertices()
{
	Set<Vertex> setOfVertices = adjVertices.keySet();
	for(Vertex v:setOfVertices)
	{
		v.setVisited(false);
	}
}

public void addEdge(String vertexSource,String vertexDestination)
{
	Set<Vertex> setOfVertices = adjVertices.keySet();
	Vertex source = null,destination = null;
	for(Vertex v:setOfVertices)
	{
		if(v.label.equals(vertexSource))
			source=v;
		if(v.label.equals(vertexDestination))
			destination=v;	
	}
	List<Vertex> adjacentVerticesOfSource=  adjVertices.get(source);
	adjacentVerticesOfSource.add(destination);
	//Uncomment below statements to create undirected graph
	/*List<Vertex> adjacentVerticesOfDestination=  adjVertices.get(destination);
	adjacentVerticesOfDestination.add(source);*/
}

public void removeEdge(String vertexSource,String vertexDestination)
{
	ListIterator<Vertex> iterator = (ListIterator) adjVertices.get(vertexSource).iterator();
	while(iterator.hasNext())
	{
		if(iterator.next().label.equals(vertexDestination))
		{
			iterator.remove();
			break;
		}
	}
}

public void depthFirstSearch(String start)
{
	Set<Vertex> setOfVertices = adjVertices.keySet();
	Vertex startVertex = null;
	for(Vertex v:setOfVertices)
	{
		if(v.label.equals(start))
		{
			startVertex=v;
			break;
		}
	}
	Stack<Vertex> stackOfVertices = new Stack<Vertex>();
	DFSHelper(startVertex,stackOfVertices);
}


private void DFSHelper(Vertex vertexVisit,Stack stackOfVertices )
{
	System.out.println(vertexVisit);
	vertexVisit.setVisited(true);
	stackOfVertices.push(vertexVisit);
	List<Vertex> adjacentVertices = adjVertices.get(vertexVisit);
	ListIterator<Vertex> listOfVertices = adjacentVertices.listIterator();
	while(listOfVertices.hasNext())
	{
		Vertex next=listOfVertices.next();
		if(!next.isVisited())
		{
			DFSHelper(next,stackOfVertices);
		}
	}
	stackOfVertices.pop();
}

public void breathFirstSearch(String start)
{
	Set<Vertex> setOfVertices = adjVertices.keySet();
	Vertex startVertex = null;
	for(Vertex v:setOfVertices)
	{
		if(v.label.equals(start))
		{
			startVertex=v;
			break;
		}
	}
	LinkedList<Vertex> queueOfVertices=new LinkedList<Vertex>();
	BFSHelper(startVertex,queueOfVertices);
	
}

private void BFSHelper(Vertex vertexVisit,Queue<Vertex> queueOfVertices )
{
	System.out.println(vertexVisit);
	vertexVisit.setVisited(true);
	List<Vertex> adjacentVertices = adjVertices.get(vertexVisit);
	ListIterator<Vertex> listOfVertices = adjacentVertices.listIterator();
	while(listOfVertices.hasNext())
	{
		Vertex next=listOfVertices.next();
		if(!next.isVisited() && !queueOfVertices.contains(next))
		{
			queueOfVertices.add(next);
		}
	}
	if(!queueOfVertices.isEmpty())
		BFSHelper(queueOfVertices.remove(),queueOfVertices);
}


}
