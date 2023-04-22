package GraphTheory;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

//3. Write a java program that will determine if a graph has a cycle or not.


public class GraphCycle {
	//initialize V as a variable for vertices
    private int V;
	//intialize a list of a list of integers as The adjacent List
	private LinkedList <Integer>[] adjacentList;


    ///constructor for the adjacent list (default: empty)
	public GraphCycle(int x) {
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
		
	
    // DFS method to detect cycle in the graph
    public boolean hasCycle() {
        boolean[] visited = new boolean[V]; // keeping track of the visited vertices
        
        for (int i = 0; i < V; i++) { //for loops that iterates through each vertex in the graph
            if (!visited[i]) { // start DFS for each unvisited vertex
                if (hasCycleUtil(i, visited, -1)) { // check for cycle
                    return true; // cycle detected
                }
            }
        }
        return false; // no cycle found
    }

    // helper method for DFS
    private boolean hasCycleUtil(int v, boolean[] visited, int parent) {
        visited[v] = true; // mark vertex as visited

        // iterate over neighbors of v
        Iterator<Integer> iter = adjacentList[v].listIterator();
        while (iter.hasNext()) {
            int neighbor = iter.next();
            if (!visited[neighbor]) { // if neighbor is unvisited, visit it
                if (hasCycleUtil(neighbor, visited, v)) { // recursively check for cycle
                    return true; // cycle detected
                }
            } else if (neighbor != parent) {
                // if neighbor is visited and not equal to parent, then a cycle is detected
                return true;
            }
        }
        return false; // no cycle detected
    }

    // main method to test the program
    public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
        
        
      //getting the vertices and edges as input
      System.out.print("Enter the amount of vertices?: ");
      int vertices = scan.nextInt();
      System.out.print("Enter the amount of edges?: ");
      int edges = scan.nextInt();

        GraphCycle graph = new GraphCycle(vertices);

        // add edges to the graph
        for (int i = 0; i < edges; i++) {
            System.out.print("Enter edge " + (i+1) + " (v w): ");
            int v = scan.nextInt();
            int w = scan.nextInt();
            graph.addEdge(v, w);
        }

        // check if graph has cycle
        if (graph.hasCycle()) {
            System.out.println("The graph has a cycle.");
        } else {
            System.out.println("The graph does not have a cycle.");
        }
    }
}
