package greedy;


import java.util.*;

public class APadjacencyList {
    private List<List<Integer>> adjacencyList;
    private int vertices;

    public APadjacencyList(int vertices) {
        this.vertices = vertices;
        adjacencyList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v) {
        adjacencyList.get(u).add(v);
        if (u != v) {
            adjacencyList.get(v).add(u);  
        }
    }

    public void displayAdjacencyList() {
        for (int i = 0; i < vertices; i++) {
            System.out.print(i + ": ");
            for (int j : adjacencyList.get(i)) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int V = scanner.nextInt();
        int E = scanner.nextInt();

        APadjacencyList graph = new APadjacencyList(V);

        for (int i = 0; i < E; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            graph.addEdge(u, v);
        }

        graph.displayAdjacencyList();
    }
}
/*You are given a graph with V vertices and E edges. 
Your task is to represent this graph using an adjacency list. 
In this representation, each vertex has a list of adjacent vertices, showing which vertices it is connected to.

The graph is undirected, meaning if there is an edge between vertex u and vertex v, then both u is connected to v and v is connected to u.

Input Format:
-------------
Line-1: An integer V representing the number of vertices.
Line-2: An integer E representing the number of edges.
Next E Lines: The next E lines each contain two integers u and v representing an edge between vertices u and v.

Output Format:
--------------
Print the adjacency list of the graph, where each vertex's adjacent vertices are space-separated.

Constraints:
------------
*2 <= V <= 1000 (The number of vertices)
*0 <= u, v < V (Valid vertices indices)
*0 <= E <= V*(V-1)/2 (Maximum number of edges for an undirected graph)

Sample Input-1:
---------------
5
4
0 1
0 2
1 3
3 4

Sample Output-1:
----------------
0: 1 2
1: 0 3
2: 0
3: 1 4
4: 3

Explanation:
------------
Vertex 0 is connected to vertices 1 and 2.
Vertex 1 is connected to vertices 0 and 3.
Vertex 2 is connected to vertex 0.
Vertex 3 is connected to vertices 1 and 4.
Vertex 4 is connected to vertex 3.

Sample Input-2:
---------------
3
2
0 1
2 1

Sample Output-2:
---------------
0: 1
1: 0 2
2: 1 */
