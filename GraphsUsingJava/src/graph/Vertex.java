package graph;

public class Vertex 
{
	String label;
	boolean visited=false;
	
	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	Vertex(String label)
	{
		this.label=label;
	}

	@Override
	public String toString() {
		return "Vertex [label=" + label + "]";
	}


}
