package GraphTheory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class GraphBipartite {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		//initializes the map to store the adjacent list of the graph
	    Map<Integer, List<Integer>> graph = new HashMap<>();
	    
	    //input for the amount of vertices
	    System.out.print("Enter the number of vertices: ");
	    int vertex = scan.nextInt();
	    
	    //for loop that inserts an empty list for each vertices
	    for(int i = 1; i <= vertex; i++) {
	    	graph.put(i, new ArrayList<>());
	    }
	    
	    //input for the edges
	    System.out.println("Enter the edges in the format 'u v' (-1 to stop): ");
	    
	    while(true) {
	    	int u = scan.nextInt();
	    	
	    	//sentinel value active
	    	if(u == -1) {
	    		break;
	    	}
	    	int v = scan.nextInt();
	    	graph.get(u).add(v);
	    	graph.get(v).add(u);	
	    }
	    
	    boolean isBipartite = isBipartite(graph);
	    if (isBipartite) {
            System.out.println("The graph is bipartite.");
        } else {
            System.out.println("The graph is not bipartite.");
        }
	}
	
	//method to check if its a bipartite graph
    public static boolean isBipartite(Map<Integer, List<Integer>> graph) {
    	//initialize a map that stores the 2 different groups in a bipartite graph
    	Map<Integer, Integer> diffGroup = new HashMap<>();
    	
    	//initialize a queue list to person the BFS(Breath-First search)
    	Queue<Integer> queue = new LinkedList<>();
    	
    	//for each loop that iterates through each key in the map
    	for(int vertex : graph.keySet()) {
    		//if the chosen vertex hasn't been assigned, it'll be assigned to group 0 and added to the queue
    		if(!diffGroup.containsKey(vertex)) {
    			diffGroup.put(vertex, 0);
    			queue.offer(vertex);
    			
    			//BFS algorithm 
    			while(!queue.isEmpty()) {
    				int u = queue.poll();
    				int c = diffGroup.get(u);
    				
    			  //assigned the rest of the neigboring vertices with the other group
    				for(int v : graph.get(u)) {
    					if(!diffGroup.containsKey(v)) {
    						diffGroup.put(v, 1 - c);
    						queue.offer(v);
    					}
    					
    					// if a neighbor vertex is on the same group, the graph is not bipartite
    					else if(diffGroup.get(v) == c) {
    						return false;
    					}
    				}
    			}
    		}
    	}
    	// if the graph passed, then the graph is a bipartite
    	return true;
    }

}
