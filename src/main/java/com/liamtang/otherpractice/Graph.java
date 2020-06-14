package com.liamtang.otherpractice;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Graph
{
	private final int V;
	private final List<LinkedList<Integer>> adj;
	private int count = 0;
	
	public Graph(int V) {
		this.V = V;
		adj = new ArrayList<LinkedList<Integer>>(V);
		
        for (int i = 0; i < V; i++) 
            adj.add(new LinkedList<>());
		
	}
	
	private boolean isCyclicUtil(int i, boolean[] visited, boolean[] recStack) {
		System.out.println(++count + ", current vertex = " + i);
        if (recStack[i]) 
            return true; 
        
        if (visited[i]) 
            return false; 
        
        visited[i] = true; 
        
        recStack[i] = true; 
        
        List<Integer> children = adj.get(i);
        
        for (Integer c: children) 
            if (isCyclicUtil(c, visited, recStack)) 
                return true; 
        
        recStack[i] = false; 
        
        return false; 
	}
	
    private void addEdge(int source, int dest) { 
        adj.get(source).add(dest); 
    } 
    
    // Returns true if the graph contains a  
    // cycle, else false. 
    // This function is a variation of DFS() in  
    // https://www.geeksforgeeks.org/archives/18212 
    private boolean isCyclic()  
    { 
          
        // Mark all the vertices as not visited and 
        // not part of recursion stack 
        boolean[] visited = new boolean[V]; 
        boolean[] recStack = new boolean[V]; 
          
          
        // Call the recursive helper function to 
        // detect cycle in different DFS trees 
        for (int i = 0; i < V; i++) 
            if (isCyclicUtil(i, visited, recStack)) 
                return true; 
  
        return false; 
    } 
	
	
	
	
    public static void main (String[] args) throws java.lang.Exception
    {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int nodes_range = Integer.parseInt(br.readLine());         
        Graph graph = new Graph(8);
        
//        String input = null;
//        Integer currentNode = 0;
//        String[] enFromAndEnTo;
//        Boolean hasCycle = false;
//        while ((null != (input = br.readLine()))) {
//
//        }

        
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 6);
        graph.addEdge(6, 3);


        
//        graph.addEdge(0, 2); 
//        graph.addEdge(1, 2); 
//        graph.addEdge(2, 0); 
//        graph.addEdge(2, 3); 
//        graph.addEdge(3, 3); 
          
//        if(graph.isCyclic()) 
//            System.out.println("Graph contains cycle"); 
//        else
//            System.out.println("Graph doesn't "
//                                    + "contain cycle"); 
////        
        System.out.println(graph.isCyclic());
    }
    
    
}
