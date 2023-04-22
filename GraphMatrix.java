package GraphTheory;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
*2. Write a java program that accepts an adjacency matrix of a graph. The program should list the edges of this graph and give
the number of times each edge appears.
*/

public class GraphMatrix {

	public static void main(String[] args) {
		// made by me Mr.Clyde Allen Yu :D
		
		Scanner input = new Scanner(System.in);
		
		//input for the amount of vertices
		System.out.print("Enter the number of vertices for the Graph: ");
		int vertices = input.nextInt();
		
		//creating a matrix with the size of the vertices
		int[][] matrix = new int[vertices][vertices];
		
		//asking for the input for the matrix
		System.out.println("Enter the matrix of the graph: ");
		for(int i = 0; i < vertices; i++) {
			for(int j = 0; j< vertices; j++) {
				matrix[i][j] = input.nextInt();
			}
		}
		
		// create a map to store the frequency of each edge
        Map<String, Integer> frequency = new HashMap<>();
        
        // loop through the adjacency matrix to find edges and their frequencies
        for (int i = 0; i < vertices; i++) {
            for (int j = i; j < vertices; j++) {
                if (matrix[i][j] == 1) {
                    String edge = "(" + (i + 1) + ", " + (j + 1) + ")";
                    //updates the hashmap with the current edge and for the integers
                    /*
                     * it uses the getorDefault method to check if the current edge is present in the map and adds 1 on it
                     * otherwise it would return with the default value which is 0 and add by 1	
                     */
                    frequency.put(edge, frequency.getOrDefault(edge, 0) + 1); 
                }
            }
        }
     
        // print out the edges and their frequencies
        System.out.println("Edges of the graph and their frequencies:");
        //for each loop that iterates to through each key in the map
        for (String edge : frequency.keySet()) {
            System.out.println(edge + ": " + frequency.get(edge));
        }

   }
}
