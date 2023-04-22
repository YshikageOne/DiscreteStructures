package GraphTheory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class GraphDegree {

	public static void main(String[] args) {
		//initializes the map to store the degree the of vertices
		Map<Integer,Integer> degreeMap = new HashMap<>();
		
		//initialized an list of edges to store the edges
		List<int[]> edges = new ArrayList<>();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter edges as pairs of vertices separated by a space. Type 'done' when finished.");
		
		//while loop that continues as long as there is more input to read
		while(true) {
			String line = scan.nextLine();
			if(line.equals("done")) {
				break;
			}
			String [] tokens = line.split("\\s+"); //splitting the input line into an array os strings
			int u = Integer.parseInt(tokens[0]);
			int v = Integer.parseInt(tokens[1]);
			
			edges.add(new int[] {u, v});//adding both vertices as a single array to the edges list
		}
			
		//calculate the degree of each vertex
			for(int[] edge : edges) {
				int start = edge[0];
				int end  = edge[1];
				degreeMap.put(start, degreeMap.getOrDefault(start, 0) + 1);
				degreeMap.put(end, degreeMap.getOrDefault(end, 0) + 1);
				
			}
			
		// display the degree of the vertex
			//for each loop that iterates over each key in the map
			for(int vertex : degreeMap.keySet()) {
				int degree = degreeMap.get(vertex);
				System.out.println("Vertex "+ vertex + " = " + degree);
			}
		

	}

}
