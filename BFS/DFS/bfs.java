
import java.io.*;
import java.util.*;

class Graph{
    private int vertices;
    private List<Integer>[] adjList ;
    // here it can be Arraylist or linked list
    
    public Graph(int vertices){
        this.vertices = vertices ;
        adjList = new LinkedList[vertices];
        for(int i = 0 ; i < vertices ; i++){
            adjList[i] = new LinkedList<>();
        }
    }
    public void addEdge(int src,int dest){
        adjList[src].add(dest);
    }
    public void BFS(int start){
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true ;
        queue.add(start);
        while(!queue.isEmpty()){
            int currentVertex = queue.poll();
            System.out.print(currentVertex+" ");
            for(int neighbour:adjList[currentVertex]){
                if(!visited[neighbour]){
                    visited[neighbour] = true ;
                    queue.add(neighbour);
                }
            }
        }
    }
}

class bfs{
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        int  v = scn.nextInt();
        int  e = scn.nextInt();
        Graph graph = new Graph(v);
        for(int i = 0 ; i < e ; i++){
            int x = scn.nextInt();
            int y = scn.nextInt();
            graph.addEdge(x,y);
            graph.addEdge(y,x);
        }
        int start = scn.nextInt();
        graph.BFS(start);
    }
    
    
}/*You are given an undirected graph represented by vertices and edges. 
Your task is to implement Breadth-First Search (BFS) traversal from a given starting vertex. 
The graph is represented using an adjacency list, and you need to traverse the graph starting from a specified vertex.

Input Format:
--------------
Line-1: An integer V, the number of vertices.
Line-2: An integer E, the number of edges.
Line-3 to E: The next E lines contain two integers source and destination, representing an edge between the two vertices in the graph.
Line-E+1: The starting vertex S from which BFS traversal should begin.

Output Format:
---------------
Line-1: Print the vertices visited in BFS order starting from the given vertex S.

Constraints:
------------
*1 ≤ V ≤ 100
*0 ≤ E ≤ V * (V - 1)
*0 ≤ source, destination, S < V

Sample Input-1:
---------------
5
8
0 1
0 4
1 0
1 2
1 3
1 4
2 3
3 4
0

Sample Output-1:
-----------------
0 1 4 2 3 

Sample Input-1:
---------------
4
4
0 1
0 2
1 3
2 3
2

Sample Output-2:
----------------
2 0 3 1 
 */
