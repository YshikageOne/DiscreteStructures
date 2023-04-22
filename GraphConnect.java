package GraphTheory;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/*1. Write a java program that receives a list of edges of a simple graph, the program should determine whether it is connected
*and find the number of connected components if it is not connected.
*/

public class GraphConnect {
	        //initialize V as a variable for vertices
	        private int V;
			//intialize a list of a list of integers as The adjacent List
			private LinkedList <Integer>[] adjacentList;

			
	//constructor for the adjacent list (default: empty)
	public GraphConnect(int x) {
		V = x;
		adjacentList = new LinkedList[x];
		for(int i = 0; i < x; i++) {
			adjacentList[i] = new LinkedList();
		}
	}
	
	//Method for adding an undirected edge between vertices x and y
	public void addEdge(int x, int y) {
		adjacentList[x].add(y);
		adjacentList[y].add(x);
	}
	
	//main algorithm Depth-first Search to check and mark the neighboring vertices as  Marked
	public void DFSalgorithm(int x, boolean[] visited) {
		visited[x] = true; //marks the visted vertex as visited
		Iterator<Integer> i = adjacentList[x].listIterator(); //iterates through each neighboring vertices
		//while loop that checks on other vertex in list if it hasn't been visited
		while(i.hasNext()) {
			int n = i.next();
			if(!visited[n]) {
				DFSalgorithm(n, visited);
			}
		}
	}
	
	//kickstarts the Depth-first search
    public void startDFS(int x, boolean[] visited) {
       DFSalgorithm(x,visited);
    }
			
	public static void main(String[] args) {
		// made by me Mr.Clyde Allen Yu :D
		
		Scanner scan = new Scanner(System.in);
		
		//getting the vertices and edges as input
		System.out.print("Enter the amount of vertices?: ");
		int vertices = scan.nextInt();
		System.out.print("Enter the amount of edges?: ");
		int edges = scan.nextInt();
		
		//calls in the GraphConnect class with vertices = V
		GraphConnect g = new GraphConnect(vertices);
		
		/*for loop that goes through each edges and reads the endpoints u and v
		 * and add the edge to the graph with addEdge method
		*/
		for(int i = 0; i < edges; i++) { 
			int u = scan.nextInt();
			int v = scan.nextInt();
			g.addEdge(u, v);
		}
		
		int count = 0; // number of counted components if the graph isn't fully connected
		boolean[] visited = new boolean[vertices]; //basically a log to check which vertices has been visited
		
		/*loop through all vertices to check which one hasn't been visited yet
		 * if the vertex has not been visited it runs to the startDFS method
		 * after running it would increment the count by 1 since the count is for the amount of connected components
		 * after all of that and the count is at 1 then would be connected since the whole graph is a one big connected component
		 */
		for(int i = 0; i < vertices; i++) {
			if(!visited[i]) {
				g.startDFS(i,visited);
				count++;
			}
		}
		
		if(count == 1) {
			System.out.println("The given graph is connected.");
		}else {
			System.out.println("The graph is not connected.");
            System.out.println("Number of connected components: " + count);
		}
	}
}
